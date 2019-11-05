package tela;

import dao.BancoDao;
import model.Conta;
import model.Correntista;

import java.util.List;
import java.util.Scanner;

public class TelaCorrentista {

    private BancoDao bancoDao;
    private Scanner scanner;

    public TelaCorrentista(BancoDao bancoDao, Scanner scanner){
        this.bancoDao = bancoDao;
        this.scanner = scanner;
    }

    public void imprime() {
        this.exibeMenu();
    }

    public void exibeMenu() {
        System.out.println("Menu Correntista");
        System.out.println("Escolha uma opção: ");
        System.out.println(" 1 - Criar Correntista");
        System.out.println(" 2 - Listar Correntistas");

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarCorrentista();

        } else if (opcao == 2) {
            exibeMenuListaCorrentista();
        }

    }

    private void exibeMenuCriarCorrentista() {

        System.out.println("Informe o nome do correntista: ");
        String nome = this.scanner.nextLine();

        System.out.println("Informe uma das contas abaixo para associar ao Correntista: ");

        List<Conta> contas = bancoDao.listarContas();
        for(int opcaoConta = 0; opcaoConta < contas.size(); opcaoConta++) {

            System.out.println(new StringBuffer()
                    .append(opcaoConta)
                    .append(contas.get(opcaoConta).getDescricao())
                    .toString());
        }

        int numero = Integer.parseInt(this.scanner.nextLine());

        if ((contas.get(numero) == null)) {
            System.out.println("Conta inválida, correntista não cadastrado");
            return;
        }

        bancoDao.adicionarCorrentista(new Correntista(nome , contas.get(numero)));
        System.out.println("Correntista cadastrado com sucesso!");
    }

    private void exibeMenuListaCorrentista() {

        System.out.println("<<Lista de Correntistas>>");
        for (Correntista correntista : bancoDao.listarCorrentistas()) {
            System.out.println(correntista.getDescricao());
        }

    }

}
