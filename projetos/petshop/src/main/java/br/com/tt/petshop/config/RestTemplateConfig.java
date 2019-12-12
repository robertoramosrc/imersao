package br.com.tt.petshop.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@Order(1) Prioriza um bean durante a leitura dos packages pelo spring
public class RestTemplateConfig {


    @Bean
    //o resttemplatebuilder já é um bean do spring, por isso estamos injetando aqui
    //caso atípico
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
