package dev.salllesdev.cartservice.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BasketRequest(

        @NotNull
        Long clientId,

        @Valid
        List<ProductRequest> products
) {}
