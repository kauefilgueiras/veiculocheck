package com.desafio.veiculocheck.client;

import com.desafio.veiculocheck.domain.dto.VeiculoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VeiculoApiClient {
    private static final String API_URL = "https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa={placa}";

    @Autowired
    private WebClient webClient;

    public VeiculoApiResponse buscarPorPlaca(String placa) {
        Mono<VeiculoApiResponse> veiculoMono = webClient.get()
                .uri(API_URL, placa)
                .retrieve()
                .bodyToMono(VeiculoApiResponse.class);
        return veiculoMono.block();
    }
}