package dev.salllesdev.cartservice.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public record ClientProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
