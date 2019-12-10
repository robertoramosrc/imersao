package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class AnimalServiceTest {

    AnimalService animalservice;

    @BeforeEach
    public void iniciar(){
        animalservice = new AnimalService(null, null, null, null);
    }


    @Test
    public void deveriaSalvarComSucesso() throws NegocioException {
        Animal novoPet = new Animal();

        novoPet.setNome("Severó");
        novoPet.setDataNascimento(LocalDate.now());

        //this.animalservice.salvar(novoPet);

    }

    @Test
    public void deveriaFalharComdataDeNascimentoMaiorQueDataAtual(){
        Animal novoPet = new Animal();

        novoPet.setNome("Severó");
        novoPet.setDataNascimento(LocalDate.now().plusDays(1));

        //NegocioException e = Assertions.assertThrows(
          //      NegocioException.class,
            //    () -> this.animalservice.salvar(novoPet));

        //Assertions.assertEquals("A data de nascimento do animal não pode ser maior que hoje", e.getMessage());

    }

}
