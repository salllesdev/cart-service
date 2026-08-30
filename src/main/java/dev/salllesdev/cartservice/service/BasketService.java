package dev.salllesdev.cartservice.service;

import dev.salllesdev.cartservice.DTO.BasketRequest;
import dev.salllesdev.cartservice.DTO.ClientProductResponse;
import dev.salllesdev.cartservice.DTO.PaymentMethodRequest;
import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.entity.PaymentMethod;
import dev.salllesdev.cartservice.entity.Product;
import dev.salllesdev.cartservice.entity.Status;
import dev.salllesdev.cartservice.exceptions.DataNotFoundException;
import dev.salllesdev.cartservice.repository.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository repository;
    private final ProductService productService;

    public Basket getBasket(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("cesta não encontrada"));
    }

    public Basket createBasket(BasketRequest request) {
        repository.findByClientIdAndStatus(request.clientId(), Status.OPEN)
                .ifPresent(Basket -> {
                    throw new IllegalArgumentException("ja existe uma cesta aberta para esse cliente");
                });

        List<Product> products = productService.getProductsById(request.products());

        Basket basket = Basket.builder()
                .Client(request.clientId())
                .products(products)
                .status(Status.OPEN)
                .build();

        basket.calculateTotalPrice();
        return repository.save(basket);
    }

    public Basket updateById(String id, BasketRequest request) {
        Basket basket = getBasket(id);

        if (basket.getStatus() != Status.OPEN) {
            throw new IllegalArgumentException("a cesta precisa estar com o status \"aberto\" para ser atualizada");
        }

        List<Product> products = productService.getProductsById(request.products());

        basket.setProducts(products);
        basket.calculateTotalPrice();
        return repository.save(basket);
    }

    public Basket payBasket(String id, PaymentMethodRequest method) {
        Basket basket = getBasket(id);
        if (basket.getStatus() != Status.OPEN) {
            throw new IllegalArgumentException("a cesta precisa estar com o status \"aberto\" para ser paga");
        }

        basket.setPaymentMethod(method.method());
        basket.setStatus(Status.SOLD);
        return repository.save(basket);
    }

    public Basket cancelBasket(String id) {
        Basket basket = getBasket(id);
        if (basket.getStatus() != Status.OPEN) {
            throw new IllegalArgumentException("a cesta precisa estar com o status \"aberto\" para ser cancelada");
        }
        basket.setStatus(Status.CANCELED);
        return repository.save(basket);
    }
}
