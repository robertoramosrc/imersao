package br.com.tt.exemplos;

public class ExercicioIntroducao {

    public static void main(String[] args) {

        //imprimeNumerosEntre150e300();
        //imprimeSomaEntre1e1000();
        //imprimeMultiplosDe3Entre1e1000();
        //imprimeMenorNumeroDeUmaLista();
        //imprimeNumerosFatoriasDe1a10();
        imprimeFibonacci(30);
    }

    public static void imprimeFibonacci(int valorReferencia) {

        int somaAnteriores = 0;
        int listaNumeros[] = new int[valorReferencia];

        //    cria a lista de fatoriais
        for (int index = 0; index < listaNumeros.length; index++) {

            switch (index) {

                case 1:
                case 0:
                    listaNumeros[index] = 1;
                    break;

                default:
                    listaNumeros[index] = listaNumeros[index - 2] + listaNumeros[index - 1];
            }
        }

        System.out.println("o fibonacci de " + valorReferencia + " é :" +
                listaNumeros[listaNumeros.length - 1]);

    }

        public static void imprimeNumerosFatoriasDe1a10() {

        long    valorFatorial;
        int     listaNumeros[] = {1,2,3,4,5,6,7,8,9,10};


        valorFatorial = 1;

        for (int pos = 0; pos < listaNumeros.length; pos++ ){

            System.out.println("O fatorial de " + listaNumeros[pos] + " é " +
                    ( listaNumeros[pos] * valorFatorial) );

            valorFatorial *= listaNumeros[pos];
        }

    }

    public static void imprimeMenorNumeroDeUmaLista() {

        long listaNumeros[] = {88,7,0,-1,45,3,92,300000001, 12, 23567};
        long menorNumero;

        menorNumero = listaNumeros[0];

        for ( long elemento : listaNumeros ){

            if(elemento < menorNumero){
                menorNumero = elemento;
            }
        }

        System.out.println("O menor numero da lista é " + menorNumero );

    }


    public static void imprimeNumerosEntre150e300() {
        int index;

        index = 150;

        while( index <= 300){
            System.out.println("Numero :" + index );
            index ++;
        }

    }

    public static void imprimeSomaEntre1e1000() {

        int valorSoma = 0;

        for( int index = 1; index <= 1000; index++){
            valorSoma += index;
        }

        System.out.println("Soma entre 1 e 1000 : " + valorSoma );

    }

    public static void imprimeMultiplosDe3Entre1e1000() {

        int quantidadeTotalDeMultiplosDe3 = 0;

        for( int index = 1; index <= 1000; index++){

            if( index % 3 == 0 ){
                quantidadeTotalDeMultiplosDe3++;
                System.out.println("O número : " + index + " é múltiplo de 3" );
            }

        }

        System.out.println("");
        System.out.println("O Total de número multiplos de 3 entre 1 e 1000 é: " + quantidadeTotalDeMultiplosDe3);



    }


}
