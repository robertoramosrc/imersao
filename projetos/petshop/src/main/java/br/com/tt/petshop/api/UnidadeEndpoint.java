package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeInDTO;
import br.com.tt.petshop.dto.UnidadeOutDTO;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unidades")
@Api("API de unidades")
public class UnidadeEndpoint {

    private final UnidadeService unidadeService;
    private final ModelMapper mapper;

    public UnidadeEndpoint(UnidadeService unidadeService, ModelMapper mapper) {
        this.unidadeService = unidadeService;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation("busca as unidades")
    public ResponseEntity<List<UnidadeOutDTO>> buscar(){

        List<UnidadeOutDTO> unidades = this.unidadeService.listar()
                  .stream()
                  .map((u) -> mapper.map(u, UnidadeOutDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(unidades);
    }

    @GetMapping("/{id}")
    @ApiOperation("busca a unidade por chave de pesquisa")
    public ResponseEntity<UnidadeOutDTO> buscarPorId(
            @ApiParam("código da unidade")
            @PathVariable Long id){

        return ResponseEntity.ok(
                mapper.map(this.unidadeService.buscarPorId(id), UnidadeOutDTO.class));

    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody UnidadeInDTO dto){
        Unidade unidade = mapper.map(dto, Unidade.class);
        Unidade unidadeSalva = unidadeService.salvar(unidade);

        //complementar em casa, colocar o id...

        URI location = URI.create("/unidades/");
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        this.unidadeService.deletar(id);
        return ResponseEntity.noContent().build();

        //anotações
        //ResponseEntity.status(200).header("www").build();
        //ResponseEntity.status(HttpStatus.OK).header("www").build();
    }

}
