package dev.salllesdev.cartservice.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(

        @NotNull
        Long id,

        @Positive
        Integer quantity
) {}
