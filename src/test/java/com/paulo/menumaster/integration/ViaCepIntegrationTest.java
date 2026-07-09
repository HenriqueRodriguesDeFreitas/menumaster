package com.paulo.menumaster.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulo.menumaster.dto.response.ViaCepResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(MockitoExtension.class)
class ViaCepIntegrationTest {

    private ViaCepIntegration viaCepIntegration;
    private MockRestServiceServer mockServer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void searchCep() {
        // Criamos um builder real para o RestClient
        RestClient.Builder builder = RestClient.builder();

        // Criamos o servidor mock vinculado a esse builder
        mockServer = MockRestServiceServer.bindTo(builder).build();

        // Passamos o builder para a nossa classe
        viaCepIntegration = new ViaCepIntegration(builder);
    }

    @Test
    void returnViaCepResponseDtoIfValid() throws Exception {
        String cepValid = "03918010";

        ViaCepResponseDto mockResponse = new ViaCepResponseDto(
            "03918-010", "Rua dos Financeiros", "Vila Bancárioa", "São Paulo", "São Paulo"
        );

        // Preparamos o servidor mock para responder quando a URL for chamada
        mockServer.expect(requestTo("https://viacep.com.br/ws/" + cepValid + "/json"))
            .andRespond(withSuccess(objectMapper.writeValueAsString(mockResponse), MediaType.APPLICATION_JSON));

        // Act (Executa o método sem bater na internet)
        ViaCepResponseDto result = viaCepIntegration.searchCep(cepValid);

        // Assert
        assertNotNull(result);
        assertEquals("São Paulo", result.localidade());

        // Garante que a URL correta foi de fato chamada
        mockServer.verify();
    }
}
