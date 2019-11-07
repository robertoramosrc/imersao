package model;

public abstract class Correntista {
    private String nome;
    private Conta conta;

    public Correntista() {
        this.nome = null;
        this.conta = null;
    }

    public Correntista(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){

        if (conta == null) {
            return "Nome: ".concat(this.getNome());
        } else {
            return new StringBuffer().append("Nome: ")
                    .append(this.getNome())
                    .append(" Conta: ")
                    .append(this.getConta().getDescricao())
                    .toString();
        }

    }

}
