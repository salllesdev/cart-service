package dev.salllesdev.cartservice.controller;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.DTO.BasketResponse;
import dev.salllesdev.cartservice.DTO.PaymentMethodRequest;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.mapper.BasketMapper;
import dev.salllesdev.cartservice.service.BasketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;
    private final BasketMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<BasketResponse> getBasket(@PathVariable String id) {
        Basket basket = service.getBasket(id);
        BasketResponse response = mapper.map(basket);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<BasketResponse> createBasket(@RequestBody @Valid BasketRequest request) {
        Basket basket = service.createBasket(request);
        BasketResponse response = mapper.map(basket);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasketResponse> updateById(@PathVariable String id, @RequestBody @Valid BasketRequest request) {
        Basket basket = service.updateById(id, request);
        BasketResponse response = mapper.map(basket);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<BasketResponse> payBasket(@PathVariable String id, @RequestBody @Valid PaymentMethodRequest method) {
        Basket basket = service.payBasket(id, method);
        BasketResponse response = mapper.map(basket);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BasketResponse> cancelBasket(@PathVariable String id) {
        Basket basket = service.cancelBasket(id);
        BasketResponse response = mapper.map(basket);
        return ResponseEntity.ok(response);
    }
}
