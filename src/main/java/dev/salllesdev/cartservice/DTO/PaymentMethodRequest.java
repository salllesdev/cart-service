package dev.salllesdev.cartservice.DTO;

import dev.salllesdev.cartservice.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;

public record PaymentMethodRequest(
        @NotBlank
        PaymentMethod method
) {}
