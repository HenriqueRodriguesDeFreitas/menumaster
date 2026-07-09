package com.paulo.menumaster.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerRequestDto(
    @Size(max = 255) @NotBlank(message = "Obrigatório o preenchimento de nome.") String name,
    @NotBlank(message = "Obrigatório o preenchimento de cpf") @Size(min = 11, max = 14) String cpf,
    @NotBlank(message = "Obrigatório o preenchimento do número de telefone") @Size(min = 11, max = 14) String mobilePhone,
    @NotNull AddressRequestDto address) {
}
