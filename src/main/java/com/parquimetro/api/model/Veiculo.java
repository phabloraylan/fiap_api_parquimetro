package com.parquimetro.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 8, nullable = false)
    private String placa;

    @Column(length = 255, nullable = false, unique = true)
    private String ticket;

    @Column(name = "duracao_min", nullable = false)
    private Integer duracaoMin;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // Hibernate annotation for creation timestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp  // Hibernate annotation for update timestamp
    private LocalDateTime updatedAt;

    // Outras lógicas de negócio, métodos auxiliares, etc.
}
