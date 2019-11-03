import br.com.tt.exceptions.SalarioInvalidoException;
import br.com.tt.financeira.Financeira;
import br.com.tt.financeira.TipoCartao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanceiraTest {

    @Test
    public void naoDeveriaRetornarGoldUsandoValorIntermediarioStandard() {

        Assertions.assertNotEquals(TipoCartao.GOLD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(800.00)));
    }

    @Test
    public void deveriaRetornarNullSeSalarioNull(){

        Assertions.assertNull(null);
    }

    @Test
    public void deveriaRetornarNullParaSalarioNegativo(){

        try {
            Financeira.identificaTipoCartao(BigDecimal.valueOf(-800.00));
        }
        catch( SalarioInvalidoException e ){
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void deveriaRetornarStandardValorMinimo(){
        assertEquals(TipoCartao.STANDARD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(0.00)));
    }

    @Test
    public void deveriaRetornarStandardValorIntermediario(){
        assertEquals(TipoCartao.STANDARD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(800.00)));
    }

    @Test
    public void deveriaRetornarStandardValorMaximo(){
        assertEquals(TipoCartao.STANDARD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(1000.00)));
    }

    @Test
    public void deveriaRetornarGoldValorMinimo(){
        assertEquals(TipoCartao.GOLD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(1000.01)));
    }

    @Test
    public void deveriaRetornarGoldValorIntermediario(){
        assertEquals(TipoCartao.GOLD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(6000.00)));
    }

    @Test
    public void deveriaRetornarGoldValorMaximo(){
        assertEquals(TipoCartao.GOLD,
                Financeira.identificaTipoCartao(BigDecimal.valueOf(7000.00)));
    }

}
