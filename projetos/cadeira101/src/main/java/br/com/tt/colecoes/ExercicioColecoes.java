package br.com.tt.colecoes;

import java.util.*;

public class ExercicioColecoes {

    public static void main(String args[]){

        analisePerformance();

    }

    private static void analisePerformance() {

//        List<Integer> numeros = new ArrayList<>(); //ordered - 459 (FOREACH 251)
//        List<Integer> numeros = new LinkedList<>(); //ordered - 264 (FOREACH 250)

//        Set<Integer> numeros = new HashSet<>();    //ordered - 283 (FOREACH 276 )

          Set<Integer> numeros = new TreeSet<>();    //auto sorted - 224 (FOREACH 310)

//        Set<Integer> numeros = new LinkedHashSet<>(); //ordered - 224 (FOREACH 287)

        long inicio = System.currentTimeMillis();

        for(int index = 0; index <= 50000; index++){
            numeros.add(index);
        }

        System.out.println("\n\n Iterator");
        /*Iterator<Integer> iterator = numeros.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        for(int elemento: numeros){
            System.out.print(elemento);
        }

        long fim = System.currentTimeMillis();
        System.out.println("\nTempo de execução: " + (fim - inicio));

    }

}
