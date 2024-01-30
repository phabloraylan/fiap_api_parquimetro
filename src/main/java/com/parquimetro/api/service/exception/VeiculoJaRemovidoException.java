package com.parquimetro.api.service.exception;

public class VeiculoJaRemovidoException extends Exception {

    public VeiculoJaRemovidoException() {
        super("Veículo já removido");
    }
}
