CREATE TABLE veiculos
(
    id          SERIAL PRIMARY KEY,
    placa       VARCHAR(8)   NOT NULL,
    ticket      VARCHAR(255) NOT NULL UNIQUE,
    duracao_min INT          NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT NULL
);