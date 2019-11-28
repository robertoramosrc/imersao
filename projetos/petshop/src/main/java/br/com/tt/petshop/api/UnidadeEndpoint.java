package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeEndpoint {

    private final UnidadeService unidadeService;
    public UnidadeEndpoint(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> buscar(){
        return ResponseEntity.ok(this.unidadeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(this.unidadeService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<List<Unidade>> salvar(@RequestBody Unidade unidade){
        unidadeService.salvar(unidade);

        URI location = URI.create("/unidades/");
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Unidade>> deletar(@PathVariable Long id) {

        this.unidadeService.deletar(id);
        return ResponseEntity.noContent().build();

        //anotações
        //ResponseEntity.status(200).header("www").build();
        //ResponseEntity.status(HttpStatus.OK).header("www").build();
    }

}
