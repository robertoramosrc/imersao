package br.com.tt.financeira;

import br.com.tt.exceptions.SalarioInvalidoException;

import java.math.BigDecimal;
import java.util.Scanner;

import static br.com.tt.financeira.TipoCartao.*;

public class Financeira {

    public static void main(String[] args) throws SalarioInvalidoException {

        System.out.println("Indique o salário para a solicitacao do cartao: ");

        System.out.println(
                 identificaTipoCartao(new Scanner(System.in).nextBigDecimal()).toString());

    }

    public static TipoCartao identificaTipoCartao(BigDecimal salario) throws SalarioInvalidoException {

        final BigDecimal VALOR_MINIMO_PARA_CARTAO_STANDARD = BigDecimal.ZERO;
        final BigDecimal VALOR_MAXIMO_PARA_CARTAO_STANDARD = BigDecimal.valueOf(1000.00);

        final BigDecimal VALOR_MINIMO_PARA_CARTAO_GOLD = BigDecimal.valueOf(1000.01);
        final BigDecimal VALOR_MAXIMO_PARA_CARTAO_GOLD = BigDecimal.valueOf(7000.00);

        final BigDecimal VALOR_MINIMO_PARA_CARTAO_BLACK = BigDecimal.valueOf(7000.01);
        final BigDecimal VALOR_MAXIMO_PARA_CARTAO_BLACK = BigDecimal.valueOf(10000.00);

        final BigDecimal VALOR_MINIMO_PARA_CARTAO_PLATINUM = BigDecimal.valueOf(10000.01);
        final BigDecimal VALOR_MAXIMO_PARA_CARTAO_PLATINUM = BigDecimal.valueOf(100000.00);

        final BigDecimal VALOR_MINIMO_PARA_CARTAO_PREMIUM = BigDecimal.valueOf(100000.01);
        final BigDecimal VALOR_MAXIMO_PARA_CARTAO_PREMIUM = BigDecimal.valueOf(1000000.00);


        if (salario.compareTo(VALOR_MINIMO_PARA_CARTAO_STANDARD) >= 0 &&
                salario.compareTo(VALOR_MAXIMO_PARA_CARTAO_STANDARD) <= 0) {
            return STANDARD;

        } else if (salario.compareTo(VALOR_MINIMO_PARA_CARTAO_GOLD) >= 0 &&
                salario.compareTo(VALOR_MAXIMO_PARA_CARTAO_GOLD) <= 0) {
            return GOLD;

        } else if (salario.compareTo(VALOR_MINIMO_PARA_CARTAO_BLACK) >= 0 &&
                salario.compareTo(VALOR_MAXIMO_PARA_CARTAO_BLACK) <= 0) {
            return BLACK;

        } else if (salario.compareTo(VALOR_MINIMO_PARA_CARTAO_PLATINUM) >= 0 &&
                salario.compareTo(VALOR_MAXIMO_PARA_CARTAO_PLATINUM) <= 0) {
            return PLATINUM;

        } else if (salario.compareTo(VALOR_MINIMO_PARA_CARTAO_PREMIUM) >= 0 &&
                salario.compareTo(VALOR_MAXIMO_PARA_CARTAO_PREMIUM) <= 0) {
            return PREMIUM;

        } else if (salario == null){
            return null;

        }else {
            throw new SalarioInvalidoException();

        }
    }

}