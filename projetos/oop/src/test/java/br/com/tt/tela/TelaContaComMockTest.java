package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.dubles.ScannerDuble;
import br.com.tt.model.Conta;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class TelaContaComMockTest {

    @Mock
    private BancoDao bancoDao;

    @Mock
    private UsuarioUtil usuarioUtil;

    @Mock
    private ScannerInterface scanner;

    @Test
    public void deveriaExibirMenuCriarContaComSucesso() {

        //Arrange
        doReturn(usuarioUtil).when(usuarioUtil)
                .exibeMensagem("Informe o número da agência:");

        doReturn(usuarioUtil).when(usuarioUtil)
                .exibeMensagem("Informe o número da conta:");

        doReturn(10).when(usuarioUtil).nextInt();


        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil)
            .exibeMenuCriarConta();

        verify(usuarioUtil).exibeMensagem("Informe o número da agência:");
        verify(usuarioUtil).exibeMensagem("Informe o número da conta:");

        verify(usuarioUtil, times(2)).nextInt();

        verify(bancoDao).adicionarConta(new Conta(10,10));

    }

    @Test
    public void deveriaExibirMenuListarContas(){

        //Arrange
        Conta conta1 = new Conta(10,10);
        Conta conta2 = new Conta(20,0);

        List<Conta> listaToBeReturned;

        listaToBeReturned = Arrays.asList(conta1, conta2);

        doReturn(listaToBeReturned).when(bancoDao).listarContas();

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenuListaContas();

        //assert
        verify(usuarioUtil).exibeMensagem("Lista de Contas: ");
        verify(usuarioUtil).exibeMensagem(conta1.getDescricao());
        verify(usuarioUtil).exibeMensagem(conta2.getDescricao());

        //to do: testes de limite...com lista vazia e com um elemento

    }

    @Test
    void deveriaExibirMenuPrincipal(){

        //arrange
        doReturn("3").when(scanner).nextLine();

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenu();

        //assert
        verify(usuarioUtil).exibeMensagem(new StringBuffer()
                .append("\nMenu Conta\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Criar Conta\n")
                .append(" 2 - Listar Contas\n").toString());

    }

    @Test
    void deveriaExibirOMenuCriarContaAPartirDoMenuPrincipal (){

        //arrange
        doReturn("1").when(scanner).nextLine();

        doReturn(usuarioUtil).when(usuarioUtil)
                .exibeMensagem(anyString());

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenu();

        //assert
        verify(usuarioUtil).exibeMensagem("Informe o número da agência:");

    }

    @Test
    void deveriaExibirOMenuListarContaAPartirDoMenuPrincipal (){

        //arrange
        doReturn("2").when(scanner).nextLine();

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenu();

        //assert
        verify(usuarioUtil).exibeMensagem("Lista de Contas: ");

    }

}
