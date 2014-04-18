package logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoimakenttaTest {
    private Voimakentta vk;

    @Before
    public void setUp() {
        this.vk = new Voimakentta();
    }

    @Test
    public void voimakentanKoordinaatitAluksiOutOfBounds() {
        for (Integer koordinaatti : vk.getVoimakentta()) {
            assertEquals(10000, koordinaatti.intValue());
        }
    }
    
    @Test
    public void hyokkaaKomentotoimii(){
        vk.hyokkaa(25, 25);
        
        assertEquals(50, vk.getVoimakentta().get(0).intValue());
        assertEquals(25, vk.getVoimakentta().get(1).intValue());
        
        assertEquals(0, vk.getVoimakentta().get(2).intValue());
        assertEquals(25, vk.getVoimakentta().get(3).intValue());
        
        assertEquals(25, vk.getVoimakentta().get(4).intValue());
        assertEquals(50, vk.getVoimakentta().get(5).intValue());
        
        assertEquals(25, vk.getVoimakentta().get(6).intValue());
        assertEquals(0, vk.getVoimakentta().get(7).intValue());
    }
    
    @Test
    public void nollaaKomentoAsettaaKoordinaatitOutOfBounds(){
        vk.hyokkaa(25, 25);
        vk.nollaa();
        
        for (Integer koordinaatti : vk.getVoimakentta()) {
            assertEquals(10000, koordinaatti.intValue());
        }
    }
    
    @Test
    public void getMetodiPalautettaaListan(){
        ArrayList<Integer> lista = vk.getVoimakentta();
        assertEquals(vk.getVoimakentta(), lista);
    }
    
    @Test
    public void nollaMetodiPalauttaa8PituisenListan(){
        vk.hyokkaa(25, 25);
        vk.nollaa();
        
        assertEquals(8, vk.getVoimakentta().size());
    }
    
    @Test
    public void konstruktorissaLuotuListaOn8Pituinen(){
        assertEquals(8, vk.getVoimakentta().size());
    }
}