package tela;

import dao.BancoDao;
import model.Conta;
import model.Correntista;
import model.CorrentistaPf;
import model.CorrentistaPj;
import util.ScannerInterface;
import util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaCorrentista implements Tela {

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaCorrentista(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    public void imprime() {
        this.exibeMenu();
    }

    @Override
    public void exibeMenu() {
        this.usuarioUtil.exibeMensagem(new StringBuffer()
                .append("\nMenu Correntista\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Criar Correntista Pessoa Jurídica\n")
                .append(" 2 - Criar Correntista Pessoa Física\n")
                .append(" 3 - Listar Correntistas\n").toString());

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarCorrentista(new CorrentistaPf());

        } else if (opcao == 2) {
            exibeMenuCriarCorrentista(new CorrentistaPj());

        } else if (opcao == 3) {
            exibeMenuListaCorrentista();
        }

    }

    private void exibeMenuCriarCorrentista(Correntista correntista) {

        this.usuarioUtil.exibeMensagem("Informe o nome do correntista: ");
        String nome = this.scanner.nextLine();

        this.usuarioUtil.exibeMensagem("Informe uma das contas abaixo para associar ao Correntista: ");

        List<Conta> contas = bancoDao.listarContas();
        for (int opcaoConta = 0; opcaoConta < contas.size(); opcaoConta++) {

            this.usuarioUtil.exibeMensagem(new StringBuffer()
                    .append(opcaoConta)
                    .append(" - ")
                    .append(contas.get(opcaoConta).getDescricao())
                    .toString());
        }


        int numero = Integer.parseInt(this.scanner.nextLine());

        if ((contas.get(numero) == null)) {
            this.usuarioUtil.exibeMensagem("Conta inválida, correntista não cadastrado");
            return;
        }

        correntista.setNome(nome);
        correntista.setConta(contas.get(numero));

        bancoDao.adicionarCorrentista(correntista);
        this.usuarioUtil.exibeMensagem("Correntista cadastrado com sucesso!");
    }

    private void exibeMenuListaCorrentista() {

        this.usuarioUtil.exibeMensagem("<<Lista de Correntistas>>");
        for (Correntista correntista : bancoDao.listarCorrentistas()) {
            this.usuarioUtil.exibeMensagem(correntista.getDescricao());
        }

    }

}
