package com.paulo.menumaster.integration;

import com.paulo.menumaster.dto.response.ViaCepResponseDto;
import com.paulo.menumaster.exception.custom.CepNotReturnedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ViaCepClient {

    private final RestClient restClient;
    private static final Logger log = LoggerFactory.getLogger(ViaCepClient.class);

    public ViaCepClient() {
        this.restClient = RestClient.builder()
            .baseUrl("https://viacep.com.br/ws")
            .build();
    }

    public ViaCepResponseDto searchCep(String cep) {
        String cleanedCep = cep.replaceAll("\\D", "");
        log.info("Start search cep: {}", cleanedCep);

        ViaCepResponseDto response = null;

        if (cleanedCep.length() != 8)
            throw new IllegalArgumentException("The postal code must contain exactly 8 digits.");

        try {
            response = restClient.get()
                .uri("/{cep}/json", cleanedCep)
                .retrieve()
                .body(ViaCepResponseDto.class);
            log.info("Search returned: {}", response);
        } catch (Exception e) {
            log.error("Erro ao conectar com a API: {}", e.getMessage());
        }
        if (response == null || response.logradouro() == null) {
            throw new CepNotReturnedException("CEP: " + cleanedCep + " not returned.");
        }
        log.info("Returned successfully to service!");
        return response;

    }
}
