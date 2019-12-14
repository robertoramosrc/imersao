package br.com.tt.petshop.service;

import br.com.tt.petshop.client.SituacaoCreditoClient;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ClienteServiceTest {

    private ClienteService clienteService;

    @Mock
    private ClienteRepository repository;

    @Mock
    private SituacaoCreditoClient situacaoCreditoClient;

    @BeforeEach
    public void inicia(){
        clienteService = new ClienteService(null, situacaoCreditoClient);

    }

    @Test
    public void deveriaSalvarComSucesso() throws NegocioException {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Fulano Silva");
        novoCliente.setCpf("123.123.123-11");

        this.clienteService.salvar(novoCliente);

    }

    @Test
    public void deveriaFalharComNomeSobrenome(){
        Cliente novoCliente = new Cliente();
        novoCliente.setCpf("123.123.123-11");
        novoCliente.setNome("Fulano");

        NegocioException e = Assertions.assertThrows(
                NegocioException.class,
                ()-> clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "O nome da pessoa deve ser composto de no mínimo 2 partes.",
                e.getMessage());

    }

    @Test
    public void deveriaFalharComCpfMenorQue11(){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Fulano Silva");

        String cpf = "123.123.123-1";
        novoCliente.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());
    }

    @Test
    public void deveriaFalharComCpfMaiorQue11(){
        Cliente novoCliente = new Cliente();

        novoCliente.setNome("Fulano Silva");
        String cpf = "123.123.123-011";
        novoCliente.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());
    }

    @Test
    public void deveriaFalharConsiderandoFormatacao(){
        Cliente novoCliente = new Cliente();

        novoCliente.setNome("Fulano Silva");
        String cpf = "123.123.123";
        novoCliente.setCpf(cpf);

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "O CPF deve conter 11 números.",
                e.getMessage());

    }

    @Test
    public void deveriaFalharNomeComParticularMenorQue2(){
        Cliente novoCliente = new Cliente();

        novoCliente.setNome("F. d Silva");
        novoCliente.setCpf("123.123.123-11");

        NegocioException e = Assertions.assertThrows(
                NegocioException.class, () -> this.clienteService.salvar(novoCliente));

        Assertions.assertEquals(
                "O primeiro nome deve ter no mínimo 2 letras.",
                e.getMessage());

    }



    }