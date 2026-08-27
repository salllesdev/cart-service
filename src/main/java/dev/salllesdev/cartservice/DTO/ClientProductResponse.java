package dev.salllesdev.cartservice.DTO;

import java.math.BigDecimal;

public record ClientProductResponse(Long id, String title, BigDecimal price) {
}
