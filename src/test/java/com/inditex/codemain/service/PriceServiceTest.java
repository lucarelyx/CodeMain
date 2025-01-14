package com.inditex.codemain.service;

import com.inditex.codemain.model.Price;
import com.inditex.codemain.model.PriceDTO;
import com.inditex.codemain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {


    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testGetPrice() {
        //Data entry
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);



        //Repository Sim
        Price mockPrice = new Price();
        mockPrice.setPrice(35.50);
        mockPrice.setBrandId(1);
        mockPrice.setProductId(35455);
        mockPrice.setCurr("EUR");
        mockPrice.setPriority(1);
        mockPrice.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        mockPrice.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        when(priceRepository.findApplicablePrices(brandId, productId, applicationDate))
                .thenReturn(List.of(mockPrice));

        //Call Service
        PriceDTO result = priceService.getPrice(applicationDate, productId, brandId);

        //Verify result is correct
        assertNotNull(result);
        assertEquals(35455, result.getProductId());
        assertEquals(35.50,result.getPrice());
    }
}
