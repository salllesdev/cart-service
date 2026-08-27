package dev.salllesdev.cartservice.service;

import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import dev.salllesdev.cartservice.client.StoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreClient storeClient;

    public List<ClientProductResponse> getAll() {
        return storeClient.getAllProducts();
    }

    public ClientProductResponse getById(Long id) {
        return storeClient.getProductById(id);
    }
}
