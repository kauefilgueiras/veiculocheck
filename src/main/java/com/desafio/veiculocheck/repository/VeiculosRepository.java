package com.desafio.veiculocheck.repository;

import com.desafio.veiculocheck.domain.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculo, Long> {

    Veiculo save(Veiculo veiculo);

    Veiculo findByPlaca(String placa);

    Veiculo findByChassi(String chassi);

    Veiculo findByCpf(String cpf);
}
