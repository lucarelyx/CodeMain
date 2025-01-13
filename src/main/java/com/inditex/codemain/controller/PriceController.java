package com.inditex.codemain.controller;

import com.inditex.codemain.model.PriceDTO;
import com.inditex.codemain.service.PriceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    private final PriceServiceImpl priceService;

    public PriceController(PriceServiceImpl priceService){
        this.priceService = priceService;
    }

    @GetMapping
    public PriceDTO getPrice(@RequestParam Integer brandId,
                             @RequestParam Integer productId,
                             @RequestParam String applicationDate) {
        // Convert the applicationDate string to LocalDateTime
        LocalDateTime date = LocalDateTime.parse(applicationDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        // Use the priceService to get the applicable price
        return priceService.getPrice(date, productId, brandId);
    }



}
