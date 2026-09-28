package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    SearchHistory findFirstByCode(String code);
}
