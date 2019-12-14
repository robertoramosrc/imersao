package br.com.tt.petshop.endpoint;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("desenvolvimento")

public class UnidadeControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql(value = "classpath:sql/insere_dados_base.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void deveriaRetornarUmaUnidade() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/unidades?nome=Matriz"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(jsonPath("[0].id").value(CoreMatchers.is(1)))
                .andExpect(jsonPath("[0].nome").value(CoreMatchers.is("Matriz")))
                .andExpect(jsonPath("[0].endereco").value(CoreMatchers.is("Rua Cristovao Colombo")))
                .andExpect(jsonPath("[0].telefone").value(CoreMatchers.is("051 993939")))
                .andExpect(jsonPath("[0].cnpj").value(CoreMatchers.is("8289289289")))
        ;
    }

}
