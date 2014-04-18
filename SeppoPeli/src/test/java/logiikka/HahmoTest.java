package logiikka;

import java.awt.Graphics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {

    private Hahmo h;

    @Before
    public void setUp() {
        this.h = new Hahmo(1, 2) {
            @Override
            public void piirra(Graphics graphics) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    @Test
    public void KonstruktoriAsettaaKoordinaatit() {
        assertEquals(1, h.getX());
        assertEquals(2, h.getY());
    }
    
    @Test
    public void siirraMetodiMuuttaaKoordinaatitOikein(){
        h.siirra(2, 3);
        assertEquals(3, h.getX());
        assertEquals(5, h.getY());
    }
    
    @Test
    public void siirraMetodiToimiiMontaKertaaPerakkain(){
        for (int i = 0; i < 10; i++) {
            h.siirra(1, 1);
        }
        assertEquals(11, h.getX());
        assertEquals(12, h.getY());
    }
    
    @Test
    public void siirraMetodiToimiiNollalleJaNegatiivisilleLuvuille(){
        h.siirra(0, -1);
        
        assertEquals(1, h.getX());
        assertEquals(1, h.getY());
    }
    
    @Test public void siirraMetodiToimiiNollalleJaNegatiivisilleLuvuille2(){
        h.siirra(-1, 0);
        
        assertEquals(0, h.getX());
        assertEquals(2, h.getY());
    }
}