package br.com.tt.util;

import javax.swing.*;

public class MasterUsuarioUtil extends UsuarioUtil implements ScannerInterface {

    @Override
    public UsuarioUtil exibeMensagem(String mensagem) {
        super.exibeMensagem(mensagem);
        JOptionPane.showMessageDialog(null, mensagem);
        return this;
    }

    @Override
    public String nextLine() {

        return JOptionPane.showInputDialog("Informe o valor:");
    }

    public Integer nextInt() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o valor:"));
    }


}
