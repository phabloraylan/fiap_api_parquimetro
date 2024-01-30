package com.parquimetro.api.controller;


import com.parquimetro.api.controller.request.CreateFaturaRequest;
import com.parquimetro.api.service.VeiculoService;
import com.parquimetro.api.service.exception.VeiculoJaExisteException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerar-fatura")
public class GerarFaturaController {
    final VeiculoService veiculoService;

    public GerarFaturaController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Object> create(
            @RequestBody @Valid CreateFaturaRequest createFaturaRequest
    ) {
        try {
            var veiculo = veiculoService.gerarFatura(createFaturaRequest.placa());
            return ResponseEntity.ok(veiculo);
        } catch (VeiculoJaExisteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
