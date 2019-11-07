package tela;

import model.Conta;
import dao.BancoDao;
import util.ScannerInterface;
import util.UsuarioUtil;

import java.util.List;

public class TelaConta implements Tela {

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaConta(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    @Override
    public void exibeMenu() {

        this.usuarioUtil.exibeMensagem(new StringBuffer()
                .append("\nMenu Conta\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Criar Conta\n")
                .append(" 2 - Listar Contas\n").toString());

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarConta();

        } else if (opcao == 2) {
            exibeMenuListaContas();
        }

    }

    private void exibeMenuListaContas() {
        List<Conta> lista = this.bancoDao.listarContas();
        this.usuarioUtil.exibeMensagem("Lista de Contas: ");

        for (Conta conta : lista) {
            this.usuarioUtil.exibeMensagem(conta.getDescricao());
        }
    }

    private void exibeMenuCriarConta() {

        this.usuarioUtil.exibeMensagem("Informe o número da agência:");
        int agencia = Integer.parseInt(this.scanner.nextLine());;

        this.usuarioUtil.exibeMensagem("Informe o número da conta:");
        int numero = Integer.parseInt(this.scanner.nextLine());;

        this.bancoDao.adicionarConta(new Conta(agencia, numero));

    }
}
