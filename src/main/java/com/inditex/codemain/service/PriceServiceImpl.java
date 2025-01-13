package com.inditex.codemain.service;

import com.inditex.codemain.model.Price;
import com.inditex.codemain.model.PriceDTO;
import com.inditex.codemain.repository.PriceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * This method retrieves the applicable price for a product and brand at a given application date.
     * It queries the repository to find matching prices and returns the first one found (based on priority).
     * If no matching price is found, an exception is thrown.
     *
     * @param applicationDate Date and time when the price should be applied
     * @param productId      ID of the product
     * @param brandId        ID of the brand
     * @return PriceDTO object containing the price details
     */
    @Override
    public PriceDTO getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        // Query the repository for applicable prices and return the first one based on priority
        return priceRepository.findApplicablePrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(this::mapToDTO)
                // If no price is found, throw an exception with a not found status
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
