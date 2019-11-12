package br.com.tt.dubles;

import br.com.tt.util.ScannerInterface;

public class ScannerDuble implements ScannerInterface {

    private int numeroChamadas = 0;

    @Override
    public String nextLine() {
        numeroChamadas++;
        return "10";
    }

    public int getNumeroChamadas(){
        return this.numeroChamadas;
    }

}
