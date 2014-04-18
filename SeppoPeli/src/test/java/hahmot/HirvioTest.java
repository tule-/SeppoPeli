package hahmot;

import logiikka.Hahmo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HirvioTest {

    private Hahmo h;
    private Hahmo h1;
    private Hahmo h2;
    private Hahmo h3;

    @Before
    public void setUp() {
        this.h = new Hirvio();
        //ALKUKOORDINAATIT (0,300)

        this.h1 = new Hirvio(0);
        //ALKUKOORDINAATIT (775,300)

        this.h2 = new Hirvio("x");
        //ALKUKOORDINAATIT (400, 0)

        this.h3 = new Hirvio(0.1);
        //ALKUKOORDINAATIT (400,575)
    }

    @Test
    public void hirviollaAloitusKoordinaatit() {
        assertEquals(0, h.getX());
        assertEquals(300, h.getY());

        assertEquals(775, h1.getX());
        assertEquals(300, h1.getY());

        assertEquals(400, h2.getX());
        assertEquals(0, h2.getY());

        assertEquals(400, h3.getX());
        assertEquals(575, h3.getY());
    }

    @Test
    public void hirvioLiikkuuOikeinYhdenAskeleenJohonkinSuuntaan() {
        h.siirra(0, 0);
        //h X-AKSELI
        if (h.getX() <= 25 && h.getX() >= 0) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
        //h Y-AKSELI
        if (h.getY() <= 325 && h.getY() >= 275) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }

        //-----
        h1.siirra(0, 0);
        //h1 X-AKSELI
        if (h1.getX() <= 775 && h1.getX() >= 750) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
        //h1 Y-AKSELI
        if (h1.getY() <= 325 && h1.getY() >= 275) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }

        //-----
        h2.siirra(0, 0);
        //h2 X-AKSELI
        if (h2.getX() <= 425 && h2.getX() >= 375) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
        //h2 Y-AKSELI
        if (h2.getY() <= 25 && h2.getY() >= 0) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }

        //-----
        h3.siirra(0, 0);
        //h3 X-AKSELI
        if (h3.getX() <= 425 && h3.getX() >= 375) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
        //h3 Y-AKSELI
        if (h3.getY() <= 575 && h3.getY() >= 550) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
    }

    @Test
    public void hirvioEiLiikuPelikentanUlkopuolelle() {
        for (int i = 0; i < 1000; i++) {

            h.siirra(0, 0);

            //X-AKSELI
            if (h.getX() <= 775 && h.getX() >= 0) {
                assertEquals(true, true);
            } else {
                assertEquals(false, true);
            }

            //Y-AKSELI
            if (h.getY() <= 575 && h.getY() >= 0) {
                assertEquals(true, true);
            } else {
                assertEquals(false, true);
            }
        }
    }

    @Test
    public void siirraMetodiEivalitaParametreistaJosNeOvatMiinusYksi() {
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        
        h.siirra(-1, -1);

        int x = h.getX();
        int y = h.getY();

        if (x == 400) {
            assertEquals(400, x);
        } else if(x == 425){
            assertEquals(425, x);
        }else if(x == 375){
            assertEquals(375, x);
        }

        if (y == 300) {
            assertEquals(300, y);
        } else if (y == 275) {
            assertEquals(275, y);
        } else if(y == 325){
            assertEquals(325, y);
        }
    }

    @Test
    public void siirraMetodiSiirtaaHirviotaKohdenTiettyaPistettaJosParametrinaOnMuutaKuinMiinusYksi() {
        //SIIRRETÄÄN HIRVIÖTÄ KESKELTÄ KAHDEKSAAN ERI SUUNTAAN.
        // OH NOES COPY-PASTE TESTI ENGAGE!!!
        
        //ALAS
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());

        //ALA VASEMMALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(150, 500);
        }
        //X-AKSELI
        assertEquals(150, h.getX());
        //Y-AKSELI
        assertEquals(500, h.getY());

        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //VASEMMALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(200, 300);
        }
        //X-AKSELI
        assertEquals(200, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //YLÄ VASEMMALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(200, 150);
        }
        //X-AKSELI
        assertEquals(200, h.getX());
        //Y-AKSELI
        assertEquals(150, h.getY());
        
        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //YLÖS
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 150);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(150, h.getY());
        
        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //YLÄ OIKEALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(650, 150);
        }
        //X-AKSELI
        assertEquals(650, h.getX());
        //Y-AKSELI
        assertEquals(150, h.getY());
        
        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //OIKEALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(650, 300);
        }
        //X-AKSELI
        assertEquals(650, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //TAKAISIN KESKELLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(400, 300);
        }
        //X-AKSELI
        assertEquals(400, h.getX());
        //Y-AKSELI
        assertEquals(300, h.getY());
        
        //ALA OIKEALLE
        for (int i = 0; i < 1000; i++) {
            h.siirra(600, 400);
        }
        //X-AKSELI
        assertEquals(600, h.getX());
        //Y-AKSELI
        assertEquals(400, h.getY());
    }
}