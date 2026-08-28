package dev.salllesdev.cartservice.DTO;

import java.util.List;

public record BasketRequest(Long clientId, List<ProductRequest> products) {
}
