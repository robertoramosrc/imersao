package br.com.tt.exemplos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExercicioString {

    public static void main(String args[]) {

        //concatenaString();
        //usoDoStringBuffer();
        //usoDoStringBuilder();
        conversaoDeString();

    }


    private static void conversaoDeString() {
        int numero = Integer.parseInt("123");
        System.out.println(numero);

        float numeroLongo = Float.parseFloat("123.45");
        System.out.println(numeroLongo);

        BigDecimal valor = new BigDecimal ( Double.parseDouble("123456.78")).setScale(2, RoundingMode.DOWN);
        System.out.println(valor);

        valor.pow(2); //potencia de

        BigDecimal multiplicao = valor.multiply(BigDecimal.valueOf(3));
        System.out.println(multiplicao);

        BigInteger inteiroGigante = new BigInteger( "12345694908234091824320928109234978");
        System.out.println(inteiroGigante);

        BigDecimal divisao = valor.divide(BigDecimal.valueOf(4), RoundingMode.DOWN);
        System.out.println(divisao);

        System.out.println(valor);

    }

    private static void usoDoStringBuilder() {
        String onde = "TargetTrust";
        int tempo = 4;

        String stringFinal = new StringBuilder()
                .append("Eu trabalho na ")
                .append(onde)
                .append(" há ")
                .append(tempo)
                .append(" anos.")
                .toString();

        System.out.println(stringFinal);

    }


    public static void concatenaString() {

        //"" + "" - evite
        "a".concat("B");
        new String("c").concat("b");
        String.valueOf("a").concat("b");

        String nome = "Fulano";
        System.out.println(String.format("Bem vindo %s!", nome));
    }

    public static void usoDoStringBuffer() {
        StringBuffer sb = new StringBuffer();

        String nome = "Gilberto";
        String profissao = "Dev";

        sb.append("Nome: ");
        sb.append(nome);

        sb.append(". Profissão: ");
        sb.append(profissao);

        System.out.println(sb.toString());

    }

}