package programa;

import tela.Tela;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        boolean pararPrograma;

        do {
           pararPrograma = exibeMenuPrincipal();
        } while (!pararPrograma);


    }

    public static boolean exibeMenuPrincipal(){

        System.out.println(">> Menu Principal");
        System.out.println("Escolha uma opção: ");
        System.out.println(" 1 - Correntista  ");
        System.out.println(" 2 - Conta  ");
        System.out.println(" 3 - Movimento ");
        System.out.println(" 0 - Out ");


        int opcao = new Scanner(System.in).nextInt();

        if(opcao == 1){

            Tela tela = new Tela();
            tela.imprime();

        }else if(opcao == 0){
            return false;
        }

        return true;
    }

}
