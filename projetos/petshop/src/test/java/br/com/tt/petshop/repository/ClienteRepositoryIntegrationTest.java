package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//ctr + shift + T para criar o teste da melhor maneira

@DataJpaTest    //esse cara que faz a mágica de subir apenas o repository
@ExtendWith(SpringExtension.class)
@Sql(value="classpath:sql/limpa_base.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Sql(value="classpath:sql/insere_dados_base.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

class ClienteRepositoryIntegrationTest{

    @Autowired  //para injetar num teste de integração, porque o jUnit precisa
    // de um construtor padrão sem parametros
    private ClienteRepository clienteRepository;


    @Test
    public void deveriaBuscarPorNome(){

        List<Cliente> clientes = this.clienteRepository.findByNome("Fulano");
        Cliente fulano = clientes.get(0);

        Assertions.assertEquals("Fulano", fulano.getNome());

    }

    @Test
    public void deveriaRetornarVazio(){

        List<Cliente> clientes = this.clienteRepository.findByNome("");
        Assertions.assertEquals(0,clientes.size());

    }



}


