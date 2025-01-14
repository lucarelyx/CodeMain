package com.inditex.codemain.controller;

import com.inditex.codemain.model.PriceDTO;
import com.inditex.codemain.service.PriceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        try{
            // Convert the applicationDate string to LocalDateTime
            LocalDateTime date = LocalDateTime.parse(applicationDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            // Use the priceService to get the applicable price
            return priceService.getPrice(date, productId, brandId);
        } catch (DateTimeParseException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Expected format: yyyy-MM-dd'T'HH:mm:ss", e);
        }
    }



}
