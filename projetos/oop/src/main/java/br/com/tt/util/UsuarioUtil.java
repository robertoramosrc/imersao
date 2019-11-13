package br.com.tt.util;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class UsuarioUtil implements ScannerInterface {

    public UsuarioUtil exibeMensagem(String mensagem) {
        System.out.println(mensagem);
        return this;

    }

    public Integer buscaOpcaoEscolhida() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public Integer nextInt() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public BigDecimal nextDecimal() {
        return BigDecimal.valueOf(Long.parseLong(new Scanner(System.in).nextLine()));
    }

    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }
}
