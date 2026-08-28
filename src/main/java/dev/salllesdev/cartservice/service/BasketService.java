package dev.salllesdev.cartservice.service;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.entity.Product;
import dev.salllesdev.cartservice.entity.Status;
import dev.salllesdev.cartservice.repository.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository repository;
    private final ProductService productService;

    public Basket getBasket(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cesta não encontrada"));
    }

    public Basket createBasket(BasketRequest request) {
        repository.findByClientIdAndStatus(request.clientId(), Status.OPEN)
                .ifPresent(Basket -> {
                    throw new IllegalArgumentException("ja existe uma cesta aberta para esse cliente");
                });

        List<Product> products = request.products().stream().map(p -> {
            ClientProductResponse clientProductResponse = productService.getById(p.id());

            return Product.builder()
                    .id(clientProductResponse.id())
                    .title(clientProductResponse.title())
                    .price(clientProductResponse.price())
                    .quantity(p.quantity())
                    .build();
        }).toList();

        Basket basket = Basket.builder()
                .Client(request.clientId())
                .products(products)
                .status(Status.OPEN)
                .build();

        basket.calculateTotalPrice();
        return repository.save(basket);
    }
}
