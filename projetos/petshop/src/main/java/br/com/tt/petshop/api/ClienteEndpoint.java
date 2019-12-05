package br.com.tt.petshop.api;


import br.com.tt.petshop.dto.ClienteOutDTO;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteEndpoint {

    private final ClienteService clienteService;
    private final ModelMapper mapper;

    public ClienteEndpoint(ClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.mapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteOutDTO>> listar(
            @RequestParam("nome") Optional<String> nome,
            @RequestParam(value = "cpf")  Optional<String> cpf ) {

        List<ClienteOutDTO> clientes = this.clienteService.listar(nome, cpf).stream()
            .map(c -> this.mapper.map(c, ClienteOutDTO.class))
            .collect(Collectors.toList());

        return ResponseEntity.ok(clientes);

    }

}
