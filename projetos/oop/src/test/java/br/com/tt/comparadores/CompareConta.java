package br.com.tt.comparadores;

import br.com.tt.model.Conta;

import java.util.Comparator;

public class CompareConta implements Comparator<Conta> {


    @Override
    public int compare(Conta o1, Conta o2) {

        if(! o1.getDescricao().equals(o2.getDescricao())){
            return 1;
        }

        return 0;
    }
}
