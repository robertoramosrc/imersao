package programa;

import dao.BancoDao;
import tela.TelaConta;
import tela.TelaCorrentista;

import java.util.Scanner;

public class Programa {

    private static BancoDao bancoDao = new BancoDao();
    private static Scanner scanner = new Scanner(System.in);

    private static TelaCorrentista telaCorrentista;
    private static TelaConta telaConta;

    public static void main(String[] args) {

        telaCorrentista = new TelaCorrentista(bancoDao, scanner);
        telaConta = new TelaConta(bancoDao, scanner);

        boolean pararPrograma;

        do {
            pararPrograma = exibeMenuPrincipal();
        } while (!pararPrograma);

    }

    public static boolean exibeMenuPrincipal() {

        System.out.println(">> Menu Principal");
        System.out.println("Escolha uma opção: ");
        System.out.println(" 1 - Correntista  ");
        System.out.println(" 2 - Conta  ");
        System.out.println(" 3 - Movimento ");
        System.out.println(" 0 - Out ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {

            telaCorrentista.exibeMenu();

        } else if (opcao == 2) {
            telaConta.exibeMenu();

        } else if (opcao == 0) {
            return true;
        }


        return false;
    }

}
