package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.dubles.ScannerDuble;
import br.com.tt.dubles.UsuarioUtilDuble;
import br.com.tt.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TelaContaSemMockTest {

    @Test
    void deveriaCriarUmaContaComSucesso(){
        BancoDao bancoDao = new BancoDao();

        TelaConta telaConta = new TelaConta(bancoDao, new ScannerDuble(), new UsuarioUtilDuble());

        telaConta.exibeMenuCriarConta();

        Assertions.assertEquals(1,bancoDao.listarContas().size());

    }
}