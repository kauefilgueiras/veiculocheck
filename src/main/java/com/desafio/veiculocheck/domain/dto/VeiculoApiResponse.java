package com.desafio.veiculocheck.domain.dto;

public record VeiculoApiResponse(
        String marca,
        String modelo,
        Boolean licenciado,
        String chassi
) {}