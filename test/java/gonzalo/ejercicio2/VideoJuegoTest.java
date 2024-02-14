package gonzalo.ejercicio2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoJuegoTest {

    private Videojuego videojuego;

    @BeforeEach
    void setUp() {
        videojuego = new Videojuego("The Witcher 3", 80, "RPG", "CD Projekt");
    }

    @AfterEach
    void tearDown() {
        videojuego = null;
    }

    @Test
    void testEntregar() {
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
    }

    @Test
    void testDevolver() {
        videojuego.devolver();
        assertFalse(videojuego.isEntregado());
    }

    @Test
    void testCompareToMayor() {
        Videojuego otroVideojuego = new Videojuego("Cyberpunk 2077", 150, "Action RPG", "CD Projekt");
        assertEquals(Videojuego.MENOR, videojuego.compareTo(otroVideojuego));
    }

    @Test
    void testCompareToIgual() {
        Videojuego mismoVideojuego = new Videojuego("The Witcher 3", 80, "RPG", "CD Projekt");
        assertEquals(Videojuego.IGUAL, videojuego.compareTo(mismoVideojuego));
    }

    @Test
    void testCompareToMenor() {
        Videojuego otroVideojuego = new Videojuego("Assassin's Creed Valhalla", 60, "Action-Adventure", "Ubisoft");
        assertEquals(Videojuego.MAYOR, videojuego.compareTo(otroVideojuego));
    }

    @Test
    void testToString() {
        String expectedString = "Informacion del videojuego: \n" +
                                "\tTitulo: The Witcher 3\n" +
                                "\tHoras estimadas: 80\n" +
                                "\tGenero: RPG\n" +
                                "\tcompañia: CD Projekt";
        assertEquals(expectedString, videojuego.toString());
    }

    @Test
    void testEqualsIguales() {
        Videojuego mismoVideojuego = new Videojuego("The Witcher 3", 80, "RPG", "CD Projekt");
        assertTrue(videojuego.equals(mismoVideojuego));
    }

    @Test
    void testEqualsDiferentes() {
        Videojuego otroVideojuego = new Videojuego("Assassin's Creed Valhalla", 60, "Action-Adventure", "Ubisoft");
        assertFalse(videojuego.equals(otroVideojuego));
    }
}
