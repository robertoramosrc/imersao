import br.com.tt.vacinas.TipoIdade;
import br.com.tt.vacinas.Tipovacina;
import br.com.tt.vacinas.Vacinacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class VacinacaoTest {

    @Test
    @DisplayName("Vacinas de adultos")
    public void deveIdentificarVacinasDeAdulto() {

        //given

        //when
        Tipovacina[] vacinas = Vacinacao.identificaVacinas(TipoIdade.ADULTO);

        Tipovacina[] vacinasEsperadas =
                new Tipovacina[]{Tipovacina.HEPATITE_B,
                                Tipovacina.INFLUENZA,
                                Tipovacina.FEBRE_AMARELA};

        //then
        assertArrayEquals(vacinasEsperadas, vacinas,
                "As vacinas de addultos deveria ser ....");
        //assertArrayEquals(null, vacinas);
    }

    @Test
    @DisplayName("Vacinas de adolecentes")
    public void deveIdentificarVacinasDeAdolecentes() {

        //given

        //when
        Tipovacina[] vacinas = Vacinacao.identificaVacinas(TipoIdade.ADOLECENTE);

        Tipovacina[] vacinasEsperadas =
                new Tipovacina[]{Tipovacina.HPV, Tipovacina.SARAMPO, Tipovacina.INFLUENZA};

        //then
        assertArrayEquals(vacinasEsperadas, vacinas, "As vacinas de adolecente deveria ser ....");
        //assertArrayEquals(null, vacinas);
    }


    @Test
    public void deveIdentificarVacinasDeCrianca(){

        //arrange   - Given


        //act       - When
        Tipovacina[] vacinas = Vacinacao.identificaVacinas(TipoIdade.CRIANCA);


        //assert    - then
        Tipovacina[] vacinasEsperadas;
        vacinasEsperadas = new Tipovacina[]{Tipovacina.POLIOMELITE, Tipovacina.PENTA};

        assertArrayEquals(vacinasEsperadas, vacinas);

    }

}
