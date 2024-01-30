package com.parquimetro.api.service.exception;

public class VeiculoJaExisteException extends Exception {

    public VeiculoJaExisteException() {
        super("Veículo já cadastrado");
    }
}
