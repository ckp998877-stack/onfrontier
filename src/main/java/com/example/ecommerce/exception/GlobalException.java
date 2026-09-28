package com.example.ecommerce.exception;

import com.example.ecommerce.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Global exception handler for all REST controllers.
 *
 * <p>Every handler returns a consistent {@link ErrorResponse} payload so API
 * clients can rely on a single error shape.
 */
@RestControllerAdvice
public class GlobalException {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    // ---------------------------------------------------------------------
    // Client errors - 400 Bad Request
    // ---------------------------------------------------------------------

    /**
     * Services across this application signal "not found" and other invalid
     * input with {@code IllegalArgumentException}, which has always been
     * reported as 400. That mapping is preserved here intentionally.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler({
            InvalidRequestException.class,
            ValidationException.class,
            ImportException.class,
            ExportException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex, WebRequest request) {
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler({
            BusinessException.class,
            OrderException.class,
            PaymentException.class,
            InventoryException.class,
            ProductException.class,
            CustomerException.class,
            ReportException.class
    })
    public ResponseEntity<ErrorResponse> handleBusiness(RuntimeException ex, WebRequest request) {
        return build(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), request);
    }

    // ---------------------------------------------------------------------
    // Not found / conflict
    // ---------------------------------------------------------------------

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex, WebRequest request) {
        return build(HttpStatus.CONFLICT, ex.getMessage(), request);
    }

    /**
     * Raised when an order cannot be cancelled because it has already shipped
     * or was cancelled previously - a conflict with the order's current state.
     */
    @ExceptionHandler(OrderCancellationException.class)
    public ResponseEntity<ErrorResponse> handleOrderCancellation(OrderCancellationException ex,
                                                                 WebRequest request) {
        return build(HttpStatus.CONFLICT, ex.getMessage(), request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex, WebRequest request) {
        log.warn("Data integrity violation: {}", ex.getMessage());
        return build(HttpStatus.CONFLICT, "Request violates a data integrity constraint", request);
    }

    // ---------------------------------------------------------------------
    // Validation
    // ---------------------------------------------------------------------

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                      WebRequest request) {
        Map<String, String> fieldErrors = new LinkedHashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.putIfAbsent(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorResponse body = response(HttpStatus.BAD_REQUEST, "Validation failed for one or more fields", request);
        body.setFieldErrors(fieldErrors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex,
                                                                   WebRequest request) {
        Map<String, String> violations = new LinkedHashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            violations.putIfAbsent(String.valueOf(violation.getPropertyPath()), violation.getMessage());
        }
        ErrorResponse body = response(HttpStatus.BAD_REQUEST, "Validation failed for one or more fields", request);
        body.setFieldErrors(violations);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // ---------------------------------------------------------------------
    // Malformed requests
    // ---------------------------------------------------------------------

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        return build(HttpStatus.BAD_REQUEST, "Malformed or unreadable request body", request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                            WebRequest request) {
        String required = ex.getRequiredType() == null ? "expected type" : ex.getRequiredType().getSimpleName();
        String message = String.format("Parameter '%s' must be a valid %s", ex.getName(), required);
        return build(HttpStatus.BAD_REQUEST, message, request);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParam(MissingServletRequestParameterException ex,
                                                            WebRequest request) {
        return build(HttpStatus.BAD_REQUEST,
                String.format("Required parameter '%s' is missing", ex.getParameterName()), request);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandler(NoHandlerFoundException ex, WebRequest request) {
        return build(HttpStatus.NOT_FOUND, "No endpoint found for the requested URL", request);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                  WebRequest request) {
        return build(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), request);
    }

    // ---------------------------------------------------------------------
    // Server errors - 500
    // ---------------------------------------------------------------------

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabase(DatabaseException ex, WebRequest request) {
        log.error("Database error", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
    }

    /**
     * Catch-all. The exception detail is logged but deliberately not echoed to
     * the client, so internal errors never leak implementation details.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex, WebRequest request) {
        log.error("Unhandled exception", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", request);
    }

    // ---------------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------------

    private ResponseEntity<ErrorResponse> build(HttpStatus status, String message, WebRequest request) {
        return new ResponseEntity<>(response(status, message, request), status);
    }

    private ErrorResponse response(HttpStatus status, String message, WebRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message == null ? status.getReasonPhrase() : message,
                path(request));
    }

    private String path(WebRequest request) {
        String description = request.getDescription(false);
        return description.startsWith("uri=") ? description.substring(4) : description;
    }
}
