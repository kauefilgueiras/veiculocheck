package com.desafio.veiculocheck.controllers;

import com.desafio.veiculocheck.domain.entity.Veiculo;
import com.desafio.veiculocheck.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> salvarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            Veiculo salvo = veiculoService.salvarVeiculo(veiculo);
            // 201 CREATED, retorna o veiculo salvo
            return ResponseEntity.status(201).body(salvo);
        } catch (RuntimeException e) {
            // 400 BAD REQUEST, com mensagem de erro
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        try {
            Veiculo veiculo = veiculoService.buscarPorId(id);
            return ResponseEntity.ok(veiculo);
        } catch (RuntimeException e) {
            // 404 NOT FOUND, com mensagem de erro
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity.ok(veiculoService.buscarTodos());
        } catch (RuntimeException e) {
            // 500 INTERNAL SERVER ERROR, com mensagem de erro
            return ResponseEntity.status(500).body("Erro ao buscar veículos: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        try {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.noContent().build(); // 204 NO CONTENT
        } catch (RuntimeException e) {
            // 404 NOT FOUND, com mensagem de erro
            return ResponseEntity.notFound().build();
        }
    }
}

