package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Animalservice {

    //temporário, até criar o repository
    //List<Animal> animais = new ArrayList<Animal>();

    private final AnimalRepository animalRepository;

    public Animalservice(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void salvar(Animal animal) throws NegocioException {

        validarDataDeNascimento(animal);
        this.animalRepository.save(animal);

    }

    public List<Animal> listar(){
        return this.animalRepository.findAll();
    }

    public Animal buscarPorId(Long id){
        return this.animalRepository.findById(id)
                .orElseThrow(()-> new RegistroNaoExisteException("Animal não encontrado"));
    }

    public void excluir(Long Id){
        this.animalRepository.delete(this.buscarPorId(Id));
    }


    private void validarDataDeNascimento(Animal animal) throws NegocioException {

        if( animal.getDataNascimento().isAfter(LocalDate.now()) ) {
            throw new NegocioException("A data de nascimento do animal não pode ser maior que hoje");
        }

    }

}
