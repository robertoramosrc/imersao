package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteServiceTest {
    private ClienteService clienteService;
    private Cliente clienteFulanoDaSilva;

    @BeforeEach
    public void inicia(){
        clienteService = new ClienteService();

        clienteFulanoDaSilva = new Cliente();
        clienteFulanoDaSilva.setNome("Fulano da Silva");
        clienteFulanoDaSilva.setCpf("123.123.123-10");

    }

    @Test
    public void deveriaSalvarComSucesso() throws NegocioException {
        this.clienteService.salvar(this.clienteFulanoDaSilva);

    }

    @Test
    public void deveriaFalharComNomeSobrenome(){
        String nome = "Fulano";

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class,
                ()-> clienteService.salvar(cliente));

        Assertions.assertEquals(
                "O nome da pessoa deve ser composto de no mínimo 2 partes.",
                e.getMessage());

    }

    @Test
    public void deveriaFalharComCpfMenorQue11(){
        String cpf = "123.123.123-1";
        this.clienteFulanoDaSilva.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(this.clienteFulanoDaSilva));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());
    }

    @Test
    public void deveriaFalharComCpfMaiorQue11(){
        String cpf = "123.123.123-011";
        this.clienteFulanoDaSilva.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(this.clienteFulanoDaSilva));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());
    }

    @Test
    public void deveriaFalharConsiderandoFormatacao(){
        String cpf = "123.123.123";
        this.clienteFulanoDaSilva.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(this.clienteFulanoDaSilva));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());

    }

    @Test
    public void deveriaFalharNomeComParticularMenorQue2(){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Fulano F Silva");

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "Informe seu nome sem abreviações!.",
                e.getMessage());

    }



    }