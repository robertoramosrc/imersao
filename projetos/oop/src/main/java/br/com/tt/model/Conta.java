package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;

public class Conta extends ObjetoBanco {
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

        if(this.getAgencia() == 0 || this.getNumero() == 0){
            return null;
        };

        return new StringBuffer().append("Agência: ")
                .append(this.getAgencia())
                .append(" - Número: ")
                .append(this.getNumero()).toString();
    }

    public void adicionarMovimento(Movimento movimento) {
        movimentos.add(movimento);
    }

    public List<Movimento> listarMovimentos() {
        return movimentos;
    }

}




