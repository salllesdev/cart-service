package dev.salllesdev.cartservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.salllesdev.cartservice.entity.PaymentMethod;
import dev.salllesdev.cartservice.entity.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record BasketResponse(
        String id,
        Long Client,
        BigDecimal totalPrice,
        List<ProductResponse> products,
        Status status,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        PaymentMethod paymentMethod
) {}
