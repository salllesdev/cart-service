package dev.salllesdev.cartservice.DTO;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Long id,
        String title,
        BigDecimal price,
        Integer quantity
) {}
