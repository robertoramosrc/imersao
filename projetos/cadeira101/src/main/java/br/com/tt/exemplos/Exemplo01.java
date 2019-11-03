package br.com.tt.exemplos;

import java.util.Scanner;

public class Exemplo01 {

    public static void main( String[] args ){

        System.out.println("Olá mundo");

        condicional();
        condicao2();
        caracteres();
        numerosLongos();
        //switchCase();
        lacos();
        //arrays();
        copiarArray();

    }

    public static void copiarArray() {

        int valor[] = {12,36,48};
        int valores[] = new int[3];

        for( int i = 0; i < valor.length; i++ ){

            valores[i] = valor[i];
        }

        for( int i = 0; i < valores.length; i++ ){

            System.out.println("Valores " + i + ": " + valores[i]);
        }


    }

    public static void arrays() {

        int valor[] = {12,36,48};

        System.out.println(valor[1]);
    }

    public static void lacos() {
            int valor = 10;

        while( valor < 20 ){

            if( valor == 15 ){
                valor++;
                continue;
            }

            System.out.println("Executou" + (valor+++1));
            //valor+=1;
        }

        do {
            System.out.println("-----------------");

            valor += 2;
            System.out.println("Do while: " + valor);

        } while ( valor < 30 );

    }

    public static void switchCase() {


        System.out.println("Digite um inteiro: ");
        int valorEntrada = new Scanner(System.in).nextInt();

        switch (valorEntrada){

            case 0:
                System.out.println("Valor inválido");

            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("Executada a opcao " + valorEntrada);
                break;

            default:
                System.out.println("Nenhuma opção informada");
        }


    }

    public static void numerosLongos() {

        int     quantidadeDeProdutos = 122;
        long    quantidadeEmEstoque  = 12222L;

        float   bonificacao         = 1222F;
        double  valorDeVendas       = 1222D;

        System.out.println(valorDeVendas);

    }


    public static void caracteres() {

            char letra = 'A';
        char letra2 = 65;
        char letra3 = '2';
        char letra4 = '2';
        char letra5 = '2';

        System.out.println(letra);
        System.out.println(letra2);
        System.out.println(letra3);
    }


    public static void condicional() {

        boolean condicao = (1==2);

        if ( condicao ){
            System.out.println("Entrou na condição");
        } else {
            System.out.println("Fora da condição");
        }

    }

    public static void condicao2() {

        short entrada = 3 ;

        if(entrada < 0){
            System.out.println("Entrada negativa");
        }else if (entrada < 10){
            System.out.println("Entrada menor que 10");
        }else {
            System.out.println("Valor acima de 10");
        }

    }

}
