package com.parquimetro.api.service.impl;

import com.parquimetro.api.model.Veiculo;
import com.parquimetro.api.repository.VeiculoRepository;
import com.parquimetro.api.service.VeiculoService;
import com.parquimetro.api.service.dto.AdicionarVeiculoDto;
import com.parquimetro.api.service.exception.VeiculoJaExisteException;
import com.parquimetro.api.util.TicketGenerator;
import org.springframework.stereotype.Service;

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
}
