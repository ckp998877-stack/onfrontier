package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SupportTicketComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketCommentRepository extends JpaRepository<SupportTicketComment, Long> {
    SupportTicketComment findFirstByCode(String code);
}
