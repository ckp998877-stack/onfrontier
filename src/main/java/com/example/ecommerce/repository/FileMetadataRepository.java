package com.example.ecommerce.repository;

import com.example.ecommerce.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
    FileMetadata findFirstByCode(String code);
}
