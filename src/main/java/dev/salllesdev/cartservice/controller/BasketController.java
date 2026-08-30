package dev.salllesdev.cartservice.controller;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.DTO.PaymentMethodRequest;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @GetMapping("/{id}")
    public Basket getBasket(@PathVariable String id) {
        return service.getBasket(id);
    }

    @PostMapping("/")
    public Basket createBasket(@RequestBody BasketRequest request) {
        return service.createBasket(request);
    }

    @PutMapping("/{id}")
    public Basket updateById(@PathVariable String id, @RequestBody BasketRequest request) {
        return service.updateById(id, request);
    }

    @PutMapping("/{id}/payment")
    public Basket payBasket(@PathVariable String id, @RequestBody PaymentMethodRequest method) {
        return service.payBasket(id, method);
    }

    @PutMapping("/{id}/cancel")
    public Basket cancelBasket(@PathVariable String id) {
        return service.cancelBasket(id);
    }
}
