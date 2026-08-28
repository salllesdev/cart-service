package dev.salllesdev.cartservice.service;

import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import dev.salllesdev.cartservice.client.StoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreClient storeClient;

    @Cacheable(value = "products")
    public List<ClientProductResponse> getAll() {
        return storeClient.getAllProducts();
    }

    @Cacheable(value = "products", key = "#productId")
    public ClientProductResponse getById(Long productId) {
        return storeClient.getProductById(productId);
    }
}
