package com.parquimetro.api.service.exception;

public class VeiculoNaoEncontradoException extends Exception {

    public VeiculoNaoEncontradoException() {
        super("Veículo não encontrado");
    }
}
