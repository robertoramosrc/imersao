package br.com.tt.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExercicioExcecoesTest {

    @Test
    void deveriaExibirNomeCidadePortoAlegre() throws PosicaoInvalidaException {
        Assertions.assertEquals("Porto Alegre", new ExercicioExcecoes().buscaNomeCidade(0));
    }

    @Test
    void deveriaExibirNomeCidadeCuritiba() throws PosicaoInvalidaException {
        Assertions.assertEquals("Curitiba", new ExercicioExcecoes().buscaNomeCidade(1));
    }

}
