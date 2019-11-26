package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> listar(){
        return this.unidadeRepository.findAll();
    }

    public Unidade salvar(Unidade unidade)  {
        return this.unidadeRepository.save(unidade);  //hibernate faz automaticamente a atribuição do ID
    }

}

