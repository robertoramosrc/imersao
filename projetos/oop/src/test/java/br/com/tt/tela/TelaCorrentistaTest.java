package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.CorrentistaPj;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class TelaCorrentistaTest {

    @Mock
    private BancoDao bancoDao;

    @Mock
    private ScannerInterface scannerInterface;

    @Mock
    private UsuarioUtil usuarioUtil;

    @BeforeEach
    void iniciarOBuilderRetornadoBaExibeMensagem() {
        doReturn(usuarioUtil).when(usuarioUtil).exibeMensagem(anyString());
    }

    @Test
    public void deveriaExibirMenuPrincipal() {

        //arrange
        doReturn(0).when(usuarioUtil).nextInt();

        String mensagemMenuPrincipal = new StringBuffer()
                .append("\nMenu Correntista\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Criar Correntista\n")
                .append(" 2 - Listar Correntistas\n").toString();

        //act
        new TelaCorrentista(bancoDao, scannerInterface, usuarioUtil)
                .exibeMenu();

        //assert
        verify(usuarioUtil, times(1)).exibeMensagem(mensagemMenuPrincipal);

    }

    @Test
    public void deveriaExecutarOpcaoCriarCorrentista() {

        //arrange
        Conta conta1 = new Conta(1045,124507);
        Conta conta2 = new Conta(2064,487154);

        List<Conta> contas = Arrays.asList(conta1, conta2);

        doReturn(1).when(usuarioUtil).nextInt();

        doReturn("Roberto Ramos").
                when(usuarioUtil).nextLine();

        doReturn(contas).when(bancoDao).listarContas();

        doReturn("0", "PJ").when(scannerInterface).nextLine();

        //act
        new TelaCorrentista(bancoDao, scannerInterface, usuarioUtil)
                .exibeMenu();

        //assert
        verify(usuarioUtil).exibeMensagem("Escolha um tipo de conta: PF / PJ");

        verify(usuarioUtil, times(1))
                .exibeMensagem("Correntista cadastrado com sucesso!");

    }

    @Test
    void deveriaExecutarMenuListarCorrentistas(){

    //arrange
    Conta   conta = new Conta(10,10);
    Correntista correntista = new CorrentistaPj("Empresa1",conta);

    List<Correntista> correntistas = new ArrayList<Correntista>();
    correntistas.add(correntista);

    doReturn(2).when(usuarioUtil).nextInt();
    doReturn(correntistas).when(bancoDao).listarCorrentistas();

    //act
    new TelaCorrentista(bancoDao, scannerInterface, usuarioUtil)
            .exibeMenu();

    //assert
    verify(usuarioUtil).exibeMensagem("<<Lista de Correntistas>>");

    }


}
