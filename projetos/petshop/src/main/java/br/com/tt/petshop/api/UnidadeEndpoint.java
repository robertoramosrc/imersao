package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/id")
    public ResponseEntity<List<Unidade>> buscar(@PathVariable Long id){
        return ResponseEntity.ok(null);
    }

    @PostMapping()
    public ResponseEntity<List<Unidade>> salvar(@RequestBody Unidade unidade){
        Unidade unidadeSalva = unidadeService.salvar(unidade);
        Long idCriado = unidadeSalva.getId();

        URI location = URI.create(String.format("/unidade/%d", idCriado));
        return ResponseEntity.created(null).build();
    }

}
