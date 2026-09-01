package dev.salllesdev.cartservice.controller;

import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import dev.salllesdev.cartservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/")
    public ResponseEntity<List<ClientProductResponse>> getAll() {
        List<ClientProductResponse> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientProductResponse> getById(@PathVariable Long id) {
        ClientProductResponse product = service.getById(id);
        return ResponseEntity.ok(product);
    }
}
