package com.paulo.menumaster.dto.response;

public record AddressResponseDto(String state, String city, String neighborhood, String street, int addressNumber,
                                 String complement) {
}
