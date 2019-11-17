package br.com.tt.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrentistaPfTest {

    @Test
    void deveriaRetoenarDescricaoComDadosDaConta() {
        Conta conta = new Conta(01,1020);

        CorrentistaPf correntistaPf = new CorrentistaPf("Roberto Ramos",conta, "CPF",
                "00271811706");

        String esperado =
           "Nome: Roberto. Conta: [Agência: 1 - Número: 1020] Tipo Documento: CPF Documento: 00271811706";

        assertEquals(esperado, correntistaPf.getDescricao());

    }
}