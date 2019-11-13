package br.com.tt.dubles;

import br.com.tt.util.UsuarioUtil;

public class UsuarioUtilDuble extends UsuarioUtil {

    @Override
    public UsuarioUtil exibeMensagem(String mensagem) {
        System.out.println(new StringBuffer()
                .append("Dado de teste: ")
                .append(this.nextInt())
                .toString());
        return this;
    }

    @Override
    public Integer nextInt() {
        return 10;
    }



}
