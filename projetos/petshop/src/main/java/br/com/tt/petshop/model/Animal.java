package br.com.tt.petshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name="TB_ANIMAL", schema = "dbo")
@Table(name="TB_ANIMAL")
public class Animal {

    @Id
    @Column(name = "ID_ANIMAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    //Demarca que não é uma coluna, deve ser ignorado
    //mas por favor não usar, usem DTO
    //@Transient
    //private boolean flag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
