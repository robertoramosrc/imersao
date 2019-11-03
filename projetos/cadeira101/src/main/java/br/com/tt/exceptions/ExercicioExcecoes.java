package br.com.tt.exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ExercicioExcecoes {

    public static void main(String args[]) throws Exception {

            excecoesNumericas();
            nullPointerException();
            indexOfBounds();
            arquivoInexistente();
            erroDeConversao();
            disparoDeExcecao();

            testeNomeCidadesComExcecao();

    }

    public static void testeNomeCidadesComExcecao () {

        boolean finalizado = false;

        System.out.println("Digite um numero de 0-5 para exibir a cidade: ");

        do {

            try {

                System.out.println(buscaNomeCidade(new Scanner(System.in).nextInt()));

                finalizado = true;

            } catch (InputMismatchException i) {
                System.out.println("Você digitou algo dirente de numero!  :((  ");

            } catch (PosicaoInvalidaException e) {
                System.out.println("Você não digitou um numero valido!  :(  ");
            }

        }while( !finalizado );

    }


    public static String buscaNomeCidade (int id) throws PosicaoInvalidaException {

        List<String> cidades =
                Arrays.asList(  "Porto Alegre",
                                "Curitiba",
                                "São Paulo",
                                "Rio de Janeiro",
                                "Cuiabá",
                                "São Luís");

        if( (id < 0 ) || id >= cidades.size() ){
            throw new PosicaoInvalidaException();
        }

        return cidades.get(id);
    }

    private static void disparoDeExcecao() {
        try {
            throw new IllegalArgumentException();

        }catch (IllegalArgumentException e){
            System.out.println("Disparo de Exceção sem matar o main");
        }
    }

    private static void erroDeConversao() {
        String numeroASerConvertido = String.valueOf("zero");

        try {

            int num = Integer.parseInt(numeroASerConvertido);
            System.out.println(num);

        }catch (NumberFormatException e){
            System.out.println("Fomato invalido de numero...".concat(numeroASerConvertido));
        }

    }

    private static void arquivoInexistente() {
        File file = new File("E://arquivo.txt");

        try{
            FileReader fr = new FileReader(file);

        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado...".concat(file.getAbsolutePath()));
        }

    }

    private static void indexOfBounds() {
        String e = "Imersao Java";
        try {

            char f = e.charAt(29);

        }catch (StringIndexOutOfBoundsException ex){
            System.out.println("impossível resolver f");

        }finally {
            System.out.println(e);
        }

    }

    private static void nullPointerException() {
        String d = null;
        try{

            System.out.println(d.charAt(0));

        }catch (NullPointerException e){
            System.out.println("Objeto nulo");
        }

    }

    private static void excecoesNumericas() {
        int a = 30, b = 0;

        try{

            int c = a / b;
            System.out.println("Resultado = " + c);

        } catch (ArithmeticException e){
            System.out.println("Não é possível dividir por zero");
        }

    }

}
