package com.parquimetro.api.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketGeneratorTest {

    @Test
    void generateTicketNumber() {
        // Testa a geração do número do ticket
        String parquimetroId = "AB12";
        String ticketNumber = TicketGenerator.generateTicketNumber(parquimetroId);

        // Verifica se o número do ticket não é nulo e segue o padrão esperado
        assertNotNull(ticketNumber, "O número do ticket não deve ser nulo");
        assertTrue(ticketNumber.matches("\\d{8}-\\d{4}-AB12"), "O número do ticket deve seguir o padrão 'yyyyMMdd-NNNN-AB12'");
    }
}