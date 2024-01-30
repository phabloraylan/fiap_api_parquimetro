package com.parquimetro.api.controller;

import com.parquimetro.api.controller.request.CreateVeiculoRequest;
import com.parquimetro.api.model.Veiculo;
import com.parquimetro.api.service.VeiculoService;
import com.parquimetro.api.service.dto.AdicionarVeiculoDto;
import com.parquimetro.api.service.exception.VeiculoJaExisteException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Object> create(
            @RequestBody @Valid CreateVeiculoRequest createVeiculoRequest
    ) {

        Veiculo veiculo;
        try {
            veiculo = veiculoService.adicionar(
                    new AdicionarVeiculoDto(
                            createVeiculoRequest.placa())
            );

            return ResponseEntity.ok(veiculo);
        } catch (VeiculoJaExisteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
