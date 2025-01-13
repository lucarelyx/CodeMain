package com.inditex.codemain.repository;

import com.inditex.codemain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    // Method to find the applicable prices for a specific product, brand and date
    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<Price> findApplicablePrices(@Param("brandId") Integer brandId, @Param("productId") Integer productId, @Param("applicationDate") LocalDateTime applicationDate);
}
