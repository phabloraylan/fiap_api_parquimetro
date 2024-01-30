CREATE TABLE veiculos
(
    id          SERIAL PRIMARY KEY,
    placa       VARCHAR(8)   NOT NULL,
    ticket      VARCHAR(255) NOT NULL UNIQUE,
    valor_pago  DECIMAL(10, 2) DEFAULT NULL,
    data_remocao TIMESTAMP DEFAULT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT NULL
);