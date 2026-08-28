package dev.salllesdev.cartservice.controller;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @PostMapping
    public Basket createBasket(@RequestBody BasketRequest request) {
        return service.createBasket(request);
    }

}
