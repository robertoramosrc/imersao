package br.com.tt.petshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TB_UNIDADE")
public class Unidade {

    @Id
    @Column(name = "ID_UNIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @Column
    private String cnpj;

    @OneToMany(mappedBy = "unidade")
    private List<Cliente> clientes;

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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
