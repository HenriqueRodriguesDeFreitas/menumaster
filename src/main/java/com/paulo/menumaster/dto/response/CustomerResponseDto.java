package com.paulo.menumaster.dto.response;

import java.util.UUID;

public record CustomerResponseDto(UUID id, String name, String cpf, String mobilePhone, AddressResponseDto address) {
}
