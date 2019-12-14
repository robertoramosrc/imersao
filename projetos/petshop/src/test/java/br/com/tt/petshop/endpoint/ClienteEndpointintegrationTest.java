package br.com.tt.petshop.endpoint;


import br.com.tt.petshop.api.ClienteEndpoint;
import br.com.tt.petshop.config.ModelMappingConfig;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(controllers = ClienteEndpoint.class)
@ExtendWith(SpringExtension.class)
@Import(ModelMappingConfig.class)  //não mockado por ser complexo
@ActiveProfiles("test") //alternativa ao -D... como parametro na inicialização da VM

public class ClienteEndpointintegrationTest {

    public static final Matcher<String> IS_JOAZINHO = CoreMatchers.is("Joaozinho");
    public static final ResultMatcher HTTP_STATUS_OK = MockMvcResultMatchers.status()
            .is(200);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void deveriaRetornarListaClientesVazia() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders.get("/clientes"))
                .andExpect(MockMvcResultMatchers.status()
                        .is(200))
                .andExpect((MockMvcResultMatchers.content())
                        .string("[]"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void deveriaRetornarJoazinho() throws Exception {

        Cliente cliente = new Cliente();
        cliente.setNome("Joaozinho");
        cliente.setCpf("111.22.333-44");

        Mockito.doReturn(Arrays.asList(cliente))
                .when(this.clienteService).listar(Optional.empty(),
                                                 Optional.empty());
        mockMvc
                .perform(MockMvcRequestBuilders.get("/clientes"))
                .andExpect(HTTP_STATUS_OK)
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome",
                        IS_JOAZINHO))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cpf",
                        CoreMatchers.is("111.22.333-44")))
                .andDo(MockMvcResultHandlers.print());

    }

}
