package com.desafio.veiculocheck.services;

import com.desafio.veiculocheck.client.VeiculoApiClient;
import com.desafio.veiculocheck.domain.dto.VeiculoApiResponse;
import com.desafio.veiculocheck.domain.entity.Veiculo;
import com.desafio.veiculocheck.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @Autowired
    private VeiculoApiClient veiculoApiClient;

    public Veiculo salvarVeiculo(Veiculo veiculo){
        Veiculo veiculoExistente = veiculosRepository.findByPlaca(veiculo.getPlaca());
        if (veiculoExistente != null) {
            throw new RuntimeException("Veículo já cadastrado com a placa: " + veiculo.getPlaca());
        }
        VeiculoApiResponse apiResponse = veiculoApiClient.buscarPorPlaca(veiculo.getPlaca());
        if (apiResponse == null) {
            throw new RuntimeException("Veículo não encontrado na API para a placa: " + veiculo.getPlaca());
        }
        veiculo.setMarca(apiResponse.marca());
        veiculo.setModelo(apiResponse.modelo());
        veiculo.setChassi(apiResponse.chassi());
        veiculo.setLicenciado(apiResponse.licenciado());

        return veiculosRepository.save(veiculo);
    }

    public List<Veiculo> buscarTodos(){
        return veiculosRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com o ID: " + id));
    }

    public void deletarVeiculo(Long id) {
        Veiculo veiculo = buscarPorId(id);
        veiculosRepository.delete(veiculo);
    }
}