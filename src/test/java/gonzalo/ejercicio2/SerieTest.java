package gonzalo.ejercicio2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SerieTest {

    private Serie serie;

    @BeforeEach
    void setUp() {
        serie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
    }

    @AfterEach
    void tearDown() {
        serie = null;
    }

    @Test
    void testEntregar() {
        serie.entregar();
        assertTrue(serie.isEntregado());
    }

    @Test
    void testDevolver() {
        serie.devolver();
        assertFalse(serie.isEntregado());
    }

    @Test
    void testCompareToMayor() {
        Serie otraSerie = new Serie("Game of Thrones", 8, "Fantasy", "David Benioff");
        assertEquals(Serie.MENOR, serie.compareTo(otraSerie));
    }

    @Test
    void testCompareToIgual() {
        Serie mismaSerie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        assertEquals(Serie.IGUAL, serie.compareTo(mismaSerie));
    }

    @Test
    void testCompareToMenor() {
        Serie otraSerie = new Serie("Stranger Things", 3, "Sci-Fi", "Duffer Brothers");
        assertEquals(Serie.MAYOR, serie.compareTo(otraSerie));
    }

    @Test
    void testToString() {
        String expectedString = "Informacion de la Serie: \n" +
                                "\tTitulo: Breaking Bad\n" +
                                "\tNumero de temporadas: 5\n" +
                                "\tGenero: Drama\n" +
                                "\tCreador: Vince Gilligan";
        assertEquals(expectedString, serie.toString());
    }

    @Test
    void testEqualsIguales() {
        Serie mismaSerie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        assertTrue(serie.equals(mismaSerie));
    }

    @Test
    void testEqualsDiferentes() {
        Serie otraSerie = new Serie("Stranger Things", 3, "Sci-Fi", "Duffer Brothers");
        assertFalse(serie.equals(otraSerie));
    }
}