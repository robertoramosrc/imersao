package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.service.Animalservice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private final Animalservice animalservice;
    private final ModelMapper mapper;

    public AnimalEndpoint(Animalservice animalservice, ModelMapper mapper) {
        this.animalservice = animalservice;
        this.mapper = mapper;
    }

    @GetMapping("/{Id}")
    @ApiOperation("Realiza a busca pelo código do animal")
    public AnimalOutDTO buscarPorId(
            @ApiParam("Código do animal")
            @PathVariable Long Id) {

        return this.mapper.map(this.animalservice.buscarPorId(Id), AnimalOutDTO.class);

    }

    @GetMapping
    @ApiOperation("Retorna a lista de animais")
    public List<AnimalOutDTO> buscar() {
        return this.animalservice.listar()
                .stream()
                .map((animal) -> mapper.map(animal, AnimalOutDTO.class))
                .collect(Collectors.toList());
    }

}
