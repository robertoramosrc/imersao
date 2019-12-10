package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalInDTO;
import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.service.AnimalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private final AnimalService animalservice;
    private final ModelMapper mapper;

    public AnimalEndpoint(AnimalService animalservice, ModelMapper mapper) {
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
    public ResponseEntity<List<AnimalOutDTO>> buscar(
            //@RequestParam(required = false) String nome
            @RequestParam("nome") Optional<String> nome,
            @RequestParam("idUnidade") Optional<Long> idUnidade,
            @RequestParam("idCliente") Optional<Long> idCliente,
            @RequestParam("nomeLike") Optional<String> nomeLike) {

        List<AnimalOutDTO> animais = this.animalservice.listar(nome, idUnidade, idCliente, nomeLike)
                .stream()
                .map((animal) -> mapper.map(animal, AnimalOutDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(animais);

    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody List<AnimalInDTO> animalInDTOLista) {

        animalInDTOLista.stream()
                .forEach(dto -> this.animalservice.salvar(dto));

        //Animal animal = this.animalservice.salvar(animalInDTO);
        //URI locationOfNewAnimalCreated = URI.create(String.format("animais/%d", animal.getId()));
        URI locationOfNewAnimalCreated = URI.create(String.format("animais/"));
        return ResponseEntity.created(locationOfNewAnimalCreated).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {

        this.animalservice.excluir(id);
        return ResponseEntity.noContent().build();

    }

}
