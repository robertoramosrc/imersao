package br.com.tt.colecoes;

/*
Para cada método abaixo, leia o arquivo input.csv e retorne o pedido:
- Crie um método que retorne todos os nomes ordenados, independente de repetição
- Crie um método que lista todos os nomes, mas não contem repetições
- Crie um método que retorna todos os campos de cada linha em
    um hashmap com as chaves (nome, sobrenome, telefone, salario)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ExercicoColecoesArquivo {

    public static void main(String[] args) throws FileNotFoundException {

        //listarTodosOsNomesOrdenados();
        listarTodosOsNomesSemRepeticao( listarTodosOsNomesOrdenados() );

        //listarTodosOsCamposUsandoHashMap();

    }

    private static void listarTodosOsNomesSemRepeticao(List<String> contatos) {

        Set<String> contatosUnicos = new TreeSet<>(contatos);

        Iterator<String> contato = contatosUnicos.iterator();
        while(contato.hasNext()){
            System.out.println(contato.next());
        }


    }

    private static List listarTodosOsNomesOrdenados() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:\\betaum\\arquivo\\input.csv"));

        List<String> contatos = new LinkedList<>();

        while (scanner.hasNextLine()){
            contatos.add(scanner.nextLine().split(",")[0]);
        }

        Iterator<String> contato = contatos.iterator();
        while(contato.hasNext()){
            System.out.println(contato.next());
        }

        return contatos;

    }

}
