package br.com.tt.exemplos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExercicioBigDecimal {

    public static void main(String[] args) {


        conversaoDeString();
        somaBigDecimal();

    }

    private static void conversaoDeString() {

        BigDecimal valor = new BigDecimal (
                    Double.parseDouble("123456.78")).setScale(2, RoundingMode.DOWN);

        System.out.println(valor);

        valor.pow(2); //potencia de

        BigDecimal multiplicao = valor.multiply(BigDecimal.valueOf(3));
        System.out.println(multiplicao);

    }


    private static void somaBigDecimal() {
        BigDecimal soma = BigDecimal.valueOf(0.00);
        //BigDecimal soma2 = BigDecimal.ZERO;

        List<BigDecimal> lista = new ArrayList<BigDecimal>();

        lista.add(BigDecimal.valueOf(Double.parseDouble("8.25")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("5.18")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("8.25")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("3.15")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("4.17")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("3.39")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("2.79")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("7.18")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("9.69")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("3.83")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("8.74")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("8.32")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("9.68")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("1.29")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("2.23")));
        lista.add(BigDecimal.valueOf(Double.parseDouble("2.08")));

        //BigDecimal[] array2 = (BigDecimal[]) lista.toArray();

        for( BigDecimal bd : lista){
            soma = soma.add(bd);
            System.out.println(bd);
        }

        System.out.println( new StringBuffer()
                .append("O Resultado da soma eh: ")
                .append(soma));

    }

}
