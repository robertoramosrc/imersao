package br.com.tt.tela;

import br.com.tt.comparadores.CompareConta;
import br.com.tt.dao.BancoDao;
import br.com.tt.dubles.ScannerDuble;
import br.com.tt.dubles.UsuarioUtilDuble;
import br.com.tt.model.Conta;
import org.junit.jupiter.api.*;

class TelaContaSemMockTest {
    BancoDao bancoDao = new BancoDao();

    @BeforeEach
    void instanciarContaNumero10Agencia10() {
        TelaConta telaConta = new TelaConta(this.bancoDao, new ScannerDuble(), new UsuarioUtilDuble());
        telaConta.exibeMenuCriarConta();
    }

    @Test
    void deveriaCriarUmaContaComSucesso() {

        Assertions.assertEquals(1, this.bancoDao.listarContas().size());

    }

    @Test
    void deveriaCriarUmaContaDeNumero10DaAgencia10() {
        Conta contaEsperada = new Conta(10, 10);
        CompareConta compareConta = new CompareConta();


        Assertions.assertEquals(0,
                compareConta.compare(contaEsperada,
                        this.bancoDao.listarContas().get(0)));

    }



}
