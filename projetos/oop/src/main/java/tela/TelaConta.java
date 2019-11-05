package tela;

import model.Conta;
import model.Correntista;
import dao.BancoDao;

import java.util.List;
import java.util.Scanner;

public class TelaConta {

    private BancoDao bancoDao;
    private Scanner scanner;

    public TelaConta(BancoDao bancoDao, Scanner scanner) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
    }

    public void exibeMenu() {

        System.out.println("Menu Conta");
        System.out.println("Escolha uma opção: ");
        System.out.println(" 1 - Criar Conta");
        System.out.println(" 2 - Listar Contas");

        int opcao = this.scanner.nextInt();

        if (opcao == 1) {
            exibeMenuCriarConta();

        } else if (opcao == 2) {
            exibeMenuListaContas();
        }

    }

    private void exibeMenuListaContas() {
        List<Conta> lista = this.bancoDao.listarContas();
        System.out.println("Lista de Contas: ");

        for (Conta conta : lista) {
            System.out.println(conta.getDescricao());
        }
    }

    private void exibeMenuCriarConta() {

        System.out.println("Informe o número da agência:");
        int agencia = this.scanner.nextInt();

        System.out.println("Informe o número da conta:");
        int numero = this.scanner.nextInt();

        this.bancoDao.adicionarConta(new Conta(agencia, numero));

    }
}
