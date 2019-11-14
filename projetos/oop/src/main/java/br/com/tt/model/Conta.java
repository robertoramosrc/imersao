package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Conta extends ObjetoBanco {
    private int agencia;
    private int numero;
    private BigDecimal saldo;

    private List<Movimento> movimentos;

    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia &&
                numero == conta.numero &&
                saldo.equals(conta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }

}




