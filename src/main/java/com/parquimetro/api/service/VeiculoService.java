package com.parquimetro.api.service;

import com.parquimetro.api.model.Veiculo;
import com.parquimetro.api.service.dto.AdicionarVeiculoDto;
import com.parquimetro.api.service.exception.VeiculoJaExisteException;
import com.parquimetro.api.service.exception.VeiculoJaRemovidoException;
import com.parquimetro.api.service.exception.VeiculoNaoEncontradoException;

public interface VeiculoService {
    Veiculo adicionar(AdicionarVeiculoDto adicionarVeiculoDto) throws VeiculoJaExisteException;

    Veiculo buscarPorPlaca(String placa);

    Veiculo gerarFatura(String placa) throws VeiculoNaoEncontradoException, VeiculoJaRemovidoException;

    void removerVeiculo(String placa) throws VeiculoNaoEncontradoException, VeiculoJaRemovidoException;

}
