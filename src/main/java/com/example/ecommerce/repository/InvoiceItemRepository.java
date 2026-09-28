package com.example.ecommerce.repository;

import com.example.ecommerce.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    InvoiceItem findFirstByCode(String code);
}
