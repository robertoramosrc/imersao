package br.com.tt.exemplos;

import java.io.*;
import java.util.Scanner;

public class ExercicioArquivo {
    public static void main(String args[]) throws IOException {

        //arquivoSimples();

        escritaSimples();
        leituraSimples();
        leituraBuffer();

    }

    private static void leituraBuffer() throws IOException {
        File file = new File("C:\\temp\\arquivo2.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        while( true ){

            String line = bufferedReader.readLine();

            if( line == null ){
                break;
            }

            System.out.println(line);
        }


    }

    private static void escritaSimples() throws IOException {

        File file = new File("C:\\temp\\arquivo2.txt");
        FileWriter writer = new FileWriter(file);

        BufferedWriter buffered = new BufferedWriter(writer);

        buffered.write("Linha 1\r\n");
        buffered.write("Linha 2\r\n");

        buffered.flush();
    }


    private static void leituraSimples() throws FileNotFoundException {
        Scanner scanner = new Scanner( new File("C:\\temp\\arquivo2.txt"));

        while( scanner.hasNextLine() ){
            String linha = scanner.nextLine();
            System.out.println(linha);
        }
    }

    private static void arquivoSimples() throws IOException {

        File arquivo = new File("C:\\temp\\arquivo1.txt");

        System.out.println(arquivo.exists());

        if(arquivo.exists()){
            arquivo.delete();
        }else{
            arquivo.createNewFile();
        }

        System.out.println(arquivo.exists());
    }
}
