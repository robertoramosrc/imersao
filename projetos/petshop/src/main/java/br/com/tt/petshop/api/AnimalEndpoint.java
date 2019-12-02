package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalInDTO;
import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.Animalservice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<AnimalOutDTO> buscarPorId(
            @ApiParam("Código do animal")
            @PathVariable Long Id) {

        AnimalOutDTO animalOutDTO = this.mapper.map(this.animalservice.buscarPorId(Id), AnimalOutDTO.class);

        return ResponseEntity.ok(animalOutDTO);

    }

    @GetMapping
    @ApiOperation("Retorna a lista de animais")
    public ResponseEntity<List<AnimalOutDTO>> buscar() {
        List<AnimalOutDTO> animais = this.animalservice.listar()
                .stream()
                .map((animal) -> mapper.map(animal, AnimalOutDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(animais);

    }


    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody AnimalInDTO animalInDTO){
        Animal animal = mapper.map(animalInDTO, Animal.class);

        this.animalservice.salvar(animal);


        URI locationOfNewAnimalCreated = URI.create(String.format("animais/%d", animal.getId()));

        return ResponseEntity.created(locationOfNewAnimalCreated).build();

    }


}
