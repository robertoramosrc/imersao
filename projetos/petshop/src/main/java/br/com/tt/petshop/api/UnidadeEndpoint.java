package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
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
    public ResponseEntity<Unidade> buscar(@PathVariable Long id){

        Optional<Unidade> unidade = this.unidadeService.listar(id);

        if( unidade.isPresent() ){
            return ResponseEntity.ok(unidade.get());
        }else{
            return ResponseEntity.ok(null);
        }

    }


    @PostMapping
    public ResponseEntity<List<Unidade>> salvar(@RequestBody List<Unidade> unidades){
        for( Unidade unidade : unidades){
            unidadeService.salvar(unidade);
        }

        URI location = URI.create("/unidades/");
        return ResponseEntity.created(location).build();
    }

}
