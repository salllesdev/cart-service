package dev.salllesdev.cartservice.mapper;

import dev.salllesdev.cartservice.DTO.ProductResponse;
import dev.salllesdev.cartservice.entity.Product;

public class ProductMapper {

    public static ProductResponse map(Product entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

}
