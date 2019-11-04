package br.com.tt.colecoes;

import java.util.*;
import java.util.stream.Collectors;

public class ExemploColecoes {

    public static void main(String args[]){
        listaSimples();
        iteracaoArrayList();
        listaSemDuplicacaoes();
        mapSimples();

    }

    private static void mapSimples() {
        Map<Integer, String> mapa = new TreeMap<>();

        long inicio = System.currentTimeMillis();

        //Runtime.getRuntime().wait(1000);
        long fim = System.currentTimeMillis();

        mapa.put(1, "Porto Alegre");
        mapa.put(8, "Rio de janeiro");
        mapa.put(3, "São Paulo");

        System.out.println("\nmapa foreach");
        for(Map.Entry entry : mapa.entrySet()){
            System.out.println(String.format("Chave: %d - %s",
                                                    entry.getKey(),
                                                    entry.getValue()));
        }


        System.out.println("\nmapa foreach keyset");
        for( Integer key: mapa.keySet()){
            System.out.println(mapa.get(key));
        }

    }

    private static void listaSemDuplicacaoes() {
        Set<Integer> numeros = new TreeSet<>();
        numeros.add(2);
        numeros.add(4);
        numeros.add(8);
        numeros.add(1);

        System.out.println("\nForeach TreeSet");
        for( int numero: numeros ){
            System.out.println(numero);
        }

    }

    private static void iteracaoArrayList() {
        List<String> lista = new ArrayList<>();

        lista.add("Java");
        lista.add("PHP");
        lista.add("C#");
        lista.add("JS");

        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i));
        }

        Collections.sort(lista);
//        Collections.sort(lista, Collections.reverseOrder());
        lista.add("Zim");
        lista.add("PowerBuilder");

        System.out.println("\n\n FOREACH");
        for( String var: lista ){
            System.out.println(var);
        }


        System.out.println("\n\n Iterator");
        Iterator<String> iterator = lista.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        lista.sort(Collections.reverseOrder());

    }

    public static void listaSimples(){

        //ArrayList lista = new ArrayList();
        //List lista = new ArrayList();
        List lista = new LinkedList();
        lista.add("Java");

        System.out.println(lista.get(0));
        System.out.println(lista.size());

        System.out.println(lista.remove("Java"));
        System.out.println(lista.size());

        System.out.println(lista.remove("Java"));
    }


}
