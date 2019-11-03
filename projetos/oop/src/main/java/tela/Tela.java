package tela;

import java.util.Scanner;

public class Tela {

    public void imprime(){
        this.exibeMenu();
    }

    public void exibeMenu(){
        System.out.println("Menu Correntista");
        System.out.println("Escolha uma opção: ");
        System.out.println(" 1 - Criar Correntista");
        System.out.println(" 2 - Listar Correntistas");

        int opcao = new Scanner(System.in).nextInt();
        if( opcao == 1){
            exibeMenuCriarCorrentista();
        }

    }

    private void exibeMenuCriarCorrentista() {
        System.out.println("Informe o nome do correntista: ");

        String nome = new Scanner(System.in).nextLine();
    }

}
