package hahmot;

import logiikka.Hahmo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Hahmo p;

    @Before
    public void setUp() {
        //ALKU KOORDINAATIT (400,300)
        this.p = new Pelaaja();
    }

    @Test
    public void pelaajallaAloitusKoordinaatit() {
        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }

    @Test
    public void pelaajaLiikkuuOikein() {
        p.siirra(25, 25);

        assertEquals(425, p.getX());
        assertEquals(325, p.getY());
    }

    @Test
    public void pelaajaPysyyPelikentanSisalla() {
        p.siirra(1000, 0);
        p.siirra(0, 1000);

        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }

    @Test
    public void pelaajaPysyyPelikentanSisalla2() {
        p.siirra(-1000, 0);
        p.siirra(0, -1000);

        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }
    
    @Test
    public void pelaajaPysyyPelikentanSisalla3(){
        for (int i = 0; i < 1000; i++) {
            p.siirra(-25,0);
        }
        
        assertEquals(0, p.getX());
        assertEquals(300, p.getY());
        
        for (int i = 0; i < 1000; i++) {
            p.siirra(0, -25);
        }
        
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        
        for (int i = 0; i < 1000; i++) {
            p.siirra(25, 0);
        }
        
        assertEquals(775, p.getX());
        assertEquals(0, p.getY());
        
        for (int i = 0; i < 1000; i++) {
            p.siirra(0, 25);
        }
        
        assertEquals(775, p.getX());
        assertEquals(575, p.getY());
    }
}