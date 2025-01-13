package com.inditex.codemain.service;

import com.inditex.codemain.model.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {
    PriceDTO getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
