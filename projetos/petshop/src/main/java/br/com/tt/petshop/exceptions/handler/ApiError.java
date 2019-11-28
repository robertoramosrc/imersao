package br.com.tt.petshop.exceptions.handler;

public class ApiError {

    private String codigo;
    private String descricao;

    public ApiError(String codigo, String desricao) {
        this.codigo = codigo;
        this.descricao = desricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
