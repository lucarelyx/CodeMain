package com.inditex.codemain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PriceDTO {
    // Getters only (immutable class)
    private final Integer productId;
    private final Integer brandId;
    private final Integer priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Double price;

    // Private constructor to force the use of Builder
    private PriceDTO(Builder builder) {
        this.productId = builder.productId;
        this.brandId = builder.brandId;
        this.priceList = builder.priceList;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.price = builder.price;
    }

    // Static Builder
    public static class Builder {
        private Integer productId;
        private Integer brandId;
        private Integer priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Double price;

        public Builder productId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder brandId(Integer brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder priceList(Integer priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public PriceDTO build() {
            return new PriceDTO(this);
        }
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", priceList=" + priceList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
