package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;

public class Conta {
    private int agencia;
    private int numero;
    private BigDecimal saldo;

    private List<Movimento> movimentos;

    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getDescricao() {
        return new StringBuffer().append("Agência: ")
                .append(this.getAgencia())
                .append(" - Número: ")
                .append(this.getNumero()).toString();
    }


}


