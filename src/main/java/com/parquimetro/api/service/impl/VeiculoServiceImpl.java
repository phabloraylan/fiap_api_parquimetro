package com.parquimetro.api.service.impl;

import com.parquimetro.api.model.Veiculo;
import com.parquimetro.api.repository.VeiculoRepository;
import com.parquimetro.api.service.VeiculoService;
import com.parquimetro.api.service.dto.AdicionarVeiculoDto;
import com.parquimetro.api.service.exception.VeiculoJaExisteException;
import com.parquimetro.api.util.TicketGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo adicionar(AdicionarVeiculoDto adicionarVeiculoDto) throws VeiculoJaExisteException {
        if (veiculoRepository.existsByPlaca(adicionarVeiculoDto.placa())) {
            throw new VeiculoJaExisteException();
        }

        String parquimetroId = "AB12";

        var veiculo = new Veiculo();
        veiculo.setPlaca(adicionarVeiculoDto.placa());
        veiculo.setTicket(TicketGenerator.generateTicketNumber(parquimetroId));
        return veiculoRepository.save(
                veiculo
        );
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    @Override
    public Veiculo gerarFatura(String placa) throws VeiculoJaExisteException {
        var veiculo = veiculoRepository.findByPlaca(placa);
        if (veiculo == null) {
            throw new VeiculoJaExisteException();
        }

        var dataDeEntrada = veiculo.getCreatedAt();
        LocalDateTime dataAtual = LocalDateTime.now();

        // Calculate the duration between the two LocalDateTime objects
        Duration duration = Duration.between(dataDeEntrada, dataAtual);

        // Get the difference in minutes
        long diferencaEmMinutos = duration.toMinutes();

        var valorPago = diferencaEmMinutos * 0.05;
        veiculo.setValorPago(
                BigDecimal.valueOf(valorPago)
        );

        return veiculoRepository.save(veiculo);

    }
}
