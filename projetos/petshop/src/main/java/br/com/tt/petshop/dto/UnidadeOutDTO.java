package br.com.tt.petshop.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UnidadeOutDTO {

    private Long Id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;

    //alternativa ao ModelMapper....também poderia ser um  Builder, mais elegante
//    public UnidadeOutDTO(Long id, String nome, String endereco, String telefone, String cnpj) {
//        Id = id;
//        this.nome = nome;
//        this.endereco = endereco;
//        this.telefone = telefone;
//        this.cnpj = cnpj;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
