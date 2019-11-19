package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    private List<String> clientes = Arrays.asList("Antonio","Paulo", "Júlia");

    public List<String> listar(){
        return clientes;
    }

    public void salvar(Cliente cliente) {
        clientes.add(cliente.getNome());
    }
}
