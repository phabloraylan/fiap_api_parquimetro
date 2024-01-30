package com.parquimetro.api.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateFaturaRequest(
        @NotBlank
        @Size(max = 8)
        String placa
) {
}
