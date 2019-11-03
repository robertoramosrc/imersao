package br.com.tt.vacinas;

public class Vacinacao {

    public static Tipovacina[] identificaVacinas(TipoIdade tipoIdade){

        /*switch (tipoIdade){
            case CRIANCA:
        }....fazer em casa */

        if( tipoIdade.equals(TipoIdade.CRIANCA)){
            return new Tipovacina[]{Tipovacina.POLIOMELITE, Tipovacina.PENTA};
        }

        if( tipoIdade.equals(TipoIdade.ADOLECENTE)){
            return new Tipovacina[]{Tipovacina.HPV,
                    Tipovacina.SARAMPO,
                    Tipovacina.INFLUENZA};
        }

        if( tipoIdade.equals(TipoIdade.ADULTO)){
            return new Tipovacina[]{Tipovacina.HEPATITE_B,
                                    Tipovacina.INFLUENZA,
                                    Tipovacina.FEBRE_AMARELA};
        }

        //return new br.com.tt.vacinas.Tipovacina[0];
        return null;
    }
}
