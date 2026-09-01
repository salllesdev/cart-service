package dev.salllesdev.cartservice.controller;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.DTO.BasketResponse;
import dev.salllesdev.cartservice.DTO.PaymentMethodRequest;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.mapper.BasketMapper;
import dev.salllesdev.cartservice.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;
    private final BasketMapper mapper;

    @GetMapping("/{id}")
    public BasketResponse getBasket(@PathVariable String id) {
        Basket basket = service.getBasket(id);
        return mapper.map(basket);
    }

    @PostMapping("/")
    public BasketResponse createBasket(@RequestBody BasketRequest request) {
        Basket basket = service.createBasket(request);
        return mapper.map(basket);
    }

    @PutMapping("/{id}")
    public BasketResponse updateById(@PathVariable String id, @RequestBody BasketRequest request) {
        Basket basket = service.updateById(id, request);
        return mapper.map(basket);
    }

    @PutMapping("/{id}/payment")
    public BasketResponse payBasket(@PathVariable String id, @RequestBody PaymentMethodRequest method) {
        Basket basket = service.payBasket(id, method);
        return mapper.map(basket);
    }

    @PutMapping("/{id}/cancel")
    public BasketResponse cancelBasket(@PathVariable String id) {
        Basket basket = service.cancelBasket(id);
        return mapper.map(basket);
    }
}
