package com.parquimetro.api.repository;

import com.parquimetro.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    boolean existsByPlaca(String placa);

    Veiculo findByPlaca(String placa);
}
