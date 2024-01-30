package com.parquimetro.api.controller;

import com.parquimetro.api.controller.request.RemoverVeiculoRequest;
import com.parquimetro.api.service.VeiculoService;
import com.parquimetro.api.service.exception.VeiculoJaRemovidoException;
import com.parquimetro.api.service.exception.VeiculoNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remover-veiculo")
public class RemoverVeiculoController {

    final VeiculoService veiculoService;

    public RemoverVeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Object> remover(
            @RequestBody @Valid RemoverVeiculoRequest removerVeiculoRequest
    ) {

        try {
            veiculoService.removerVeiculo(removerVeiculoRequest.placa());
            return ResponseEntity.ok().build();
        } catch (VeiculoNaoEncontradoException | VeiculoJaRemovidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
