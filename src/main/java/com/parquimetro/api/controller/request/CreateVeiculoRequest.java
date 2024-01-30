package com.parquimetro.api.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateVeiculoRequest(
        @NotBlank
        @Size(max = 8)
        String placa
) {
}
