package br.com.tt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContaTest {

    @Test
    void deveriaRetornarDescricaoCompleta() {
        Conta conta = new Conta(05, 203040);

        String esperado = "Agência: 5 - Número: 203040";

        Assertions.assertEquals(esperado , conta.getDescricao());
    }

    @Test
    void deveriaRetornarDescricaoNulaSeContaZerada(){
        Conta conta = new Conta(1245, 0);

        Assertions.assertNull(conta.getDescricao());
    }

    @Test
    void deveriaRetornarDescricaoNulaSeAgenciaZerada(){
        Conta conta = new Conta(0, 454589);

        Assertions.assertNull(conta.getDescricao());
    }

}