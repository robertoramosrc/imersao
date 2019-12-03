package br.com.tt.petshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class AnimalInDTO {

    @NotBlank(message = "Informe o nome")
    private String nome;

    @PastOrPresent(message="(fromcontroller) Data de nascimento deve ser informada")
    @NotNull(message = "Informe a data de nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = "Informe o código da unidade")
    private Long unidade;

    @NotNull(message = "Informe o código do cliente")
    @Min(1)
    private Long cliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getUnidade() {
        return unidade;
    }

    public void setUnidade(Long unidade) {
        this.unidade = unidade;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

}
