package com.paulo.menumaster.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequestDto(
    @NotBlank(message = "Obrigatório o preenchimento do cep") @Size(min = 8, max = 9) String cep,
    int addressNumber, @Size(max = 200) String complement) {
}
