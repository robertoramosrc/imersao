package br.com.tt.model;

import java.math.BigDecimal;

public class Movimento extends ObjetoBanco{

    private TipoMovimento tipoMovimento;
    private BigDecimal valor;
    private String descricao;

    public void Movimento(TipoMovimento tipoMovimento, BigDecimal Valor, String descricao){
        this.tipoMovimento = tipoMovimento;
        this.valor = valor;
        this.descricao = descricao;
    }

}
