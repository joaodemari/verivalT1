package com.t1verival;

import java.time.LocalDateTime;
import java.time.Duration;

public class Estacionamento {
    private boolean clienteVIP;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    // Construtor
    public Estacionamento(LocalDateTime entrada, LocalDateTime saida, boolean clienteVIP) {
        this.entrada = entrada;
        this.saida = saida;
        this.clienteVIP = clienteVIP;
    }

    public double calcularValor() {
        Duration duracao = Duration.between(entrada, saida);
        long minutos = duracao.toMinutes();

        if (minutos <= 15) {
            return 0.0;
        }

        double valor = 0.0;

        int noites = 0;

        if (saida.toLocalDate().isAfter(entrada.toLocalDate())) {
            noites = (saida.toLocalDate().getDayOfYear() - entrada.toLocalDate().getDayOfYear());
        }

        if (noites > 0) {
            valor = noites * 50.0;
        } else {
            if (minutos <= 60) {
                valor = 5.90;
            } else {
                valor = 5.90 + (((double)minutos - 60.0) / 60.0) * 2.50;
            }
        }

        if (clienteVIP) {
            valor *= 0.5;
        }

        return valor;
    }
}
