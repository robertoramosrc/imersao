package br.com.tt.petshop.repository;


import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Sql(value="classpath:sql/insere_dados_base.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value="classpath:sql/limpa_base.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class UnidadeRepositoryIntegrationTest {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Test
    public void deveriaBuscarPorNome(){

        List<Unidade> unidades = this.unidadeRepository.findByNome("Matriz");
        Unidade matriz = unidades.get(0);

        Assertions.assertEquals("Matriz", matriz.getNome());

    }

    @Test
    public void deveriaNaoEncontrarNomeNaoCadastrado(){

        List<Unidade> unidades = this.unidadeRepository.findByNome("Matrizz");
        Assertions.assertEquals(0, unidades.size());

    }

}
