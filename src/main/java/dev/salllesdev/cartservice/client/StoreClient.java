package dev.salllesdev.cartservice.client;

import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FakeStoreAPI", url = "${products.client.API")
public interface StoreClient {

    @GetMapping("products/")
    public List<ClientProductResponse> getAllProducts();

    @GetMapping("products/{id}")
    public ClientProductResponse getProductById(@PathVariable Long id);

}
