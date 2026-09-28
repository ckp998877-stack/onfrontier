-- PostgreSQL database bootstrap
CREATE TABLE IF NOT EXISTS app_health (
    id BIGSERIAL PRIMARY KEY,
    application_name VARCHAR(150) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
