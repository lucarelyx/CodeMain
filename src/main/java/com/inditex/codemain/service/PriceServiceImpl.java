package com.inditex.codemain.service;

import com.inditex.codemain.model.Price;
import com.inditex.codemain.model.PriceDTO;
import com.inditex.codemain.repository.PriceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDTO getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepository.findApplicablePrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No price found"));
    }

    private PriceDTO mapToDTO(Price price) {
        return new PriceDTO.Builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }
}
