/*
- Leia o arquivo input.csv.

- Concatene o Nome e o Sobrenome e telefone no formato: "Nome: {nome} {sobrenome}. Telefone: {telefone}", gerando uma lista de strings.
- Adicione a String resultante em um array de Strings.

- Intere com Foreach e imprima.
- Escrever no arquivo out.txt

*/
package br.com.tt.exemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExercicioArqCSV {

    public static void main(String args[]) throws IOException {


            imprimirArquivoFormatado();

    }

    private static void imprimirArquivoFormatado() throws IOException {

        File file = new File("C:\\betaum\\arquivo\\input.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while( true ){

            String line = bufferedReader.readLine();
            StringBuffer sb = new StringBuffer();

            if( line == null ){
                break;
            }

            String campos[] = line.split(",");

            System.out.println(sb.append("Nome: ")
                                    .append(campos[0])
                                    .append(" ")
                                    .append(campos[1])
                                    .append(", Telefone: ")
                                    .append(campos[2]) );


        }

    }


}
