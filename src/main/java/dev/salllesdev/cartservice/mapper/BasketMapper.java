package dev.salllesdev.cartservice.mapper;

import dev.salllesdev.cartservice.DTO.BasketResponse;
import dev.salllesdev.cartservice.DTO.ProductResponse;
import dev.salllesdev.cartservice.entity.Basket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasketMapper {

    public BasketResponse map(Basket entity) {

        List<ProductResponse> products = entity.getProducts()
                .stream()
                .map(ProductMapper::map)
                .toList();

        return BasketResponse.builder()
                .id(entity.getId())
                .Client(entity.getClient())
                .totalPrice(entity.getTotalPrice())
                .products(products)
                .status(entity.getStatus())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }

}
