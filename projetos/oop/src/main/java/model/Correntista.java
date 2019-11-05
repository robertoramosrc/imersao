package model;

public class Correntista {
    private String nome;
    private Conta conta;

    public Correntista(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){

        if (conta == null) {
            return new StringBuffer().append("Nome: ")
                    .append(this.getNome())
                    .append(" Conta: ")
                    .append(this.getConta().getDescricao())
                    .toString();
        } else {
            return "Nome: ".concat(this.getNome());
        }

    }

}
