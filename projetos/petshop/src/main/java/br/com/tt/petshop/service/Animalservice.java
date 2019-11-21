package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Animal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Animalservice {

    //temporário, até criar o repository
    List<Animal> animais = new ArrayList<Animal>();

    public void salvar(Animal animal) throws NegocioException {

        validarDataDeNascimento(animal);
        animais.add(animal);

    }

    private void validarDataDeNascimento(Animal animal) throws NegocioException {

        if( animal.getDataNascimento().isAfter(LocalDate.now()) ) {
            throw new NegocioException("A data de nascimento do animal não pode ser maior que hoje");
        }

    }

}
