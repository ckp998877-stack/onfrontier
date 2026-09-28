package com.example.ecommerce.repository;

import com.example.ecommerce.entity.MediaAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaAssetRepository extends JpaRepository<MediaAsset, Long> {
    MediaAsset findFirstByCode(String code);
}
