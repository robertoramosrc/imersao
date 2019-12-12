package br.com.tt.petshop.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.com.tt.petshop.client.SituacaoCredito.*;

@JsonIgnoreProperties(ignoreUnknown = true) //deserializar apenas os campos definidos no dto
public class SituacaoCreditoDTO {

    @JsonProperty("situacao")   //pode ser usado para descartar nomes exdrúchulos no json
    private SituacaoCredito situacao;
    private Integer pontos;

    public SituacaoCredito getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCredito situacao) {
        this.situacao = situacao;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public boolean isRegular() {
        return NEGATIVADO.equals(situacao);

    }

}
