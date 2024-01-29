package com.parquimetro.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketGenerator {

    private static final AtomicInteger sequence = new AtomicInteger(0);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static String generateTicketNumber(String parquimetroId) {
        // Data atual no formato "yyyyMMdd"
        String datePart = dateFormat.format(new Date());

        // Número sequencial, incrementado a cada chamada
        int seqNumber = sequence.incrementAndGet();

        // Constrói o número do ticket
        return datePart + "-" + String.format("%04d", seqNumber) + "-" + parquimetroId;
    }
}
