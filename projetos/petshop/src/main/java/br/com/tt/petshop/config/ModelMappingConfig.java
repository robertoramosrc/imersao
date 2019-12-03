package br.com.tt.petshop.config;

import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.model.Animal;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

    @Bean
    public ModelMapper getModelMapping(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Animal.class, AnimalOutDTO.class)
                .addMapping((a) -> a.getUnidade().getNome(), AnimalOutDTO::setUnidade)
                .addMapping((c) -> c.getCliente().getNome(), AnimalOutDTO::setCliente);

                                                            //reference method
        return modelMapper;
    }

}
