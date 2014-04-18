package logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuolemaTest {
    private Kuolema k;
    private Voimakentta vk;
    
    @Before
    public void setUp() {
        this.k = new Kuolema();
        this.vk = new Voimakentta();
    }

    @Test
    public void palauttaatrueJosPelaajaOsuuHirvioon() {
        assertEquals(true, k.pelaajakuollut(25, 0, 25, 0));
    }
    
    @Test
    public void palauttaafalseJosPelaajaOnElossa(){
        assertEquals(false, k.pelaajakuollut(25, 0, 25, 25));
    }
    
    @Test
    public void testejaKoordinaateista(){
        assertEquals(true, k.pelaajakuollut(0, 25, 0, 25));
        assertEquals(false, k.pelaajakuollut(125, 150, 100, 125));
    }
    
    @Test
    public void palauttaatrueJosHirvioKuolee(){
        vk.hyokkaa(25, 25);
        
        assertEquals(true, k.hirviokuollut(50, 25, vk));
        assertEquals(true, k.hirviokuollut(0, 25, vk));
        assertEquals(true, k.hirviokuollut(25, 50, vk));
        assertEquals(true, k.hirviokuollut(25, 0, vk));
    }
    
    @Test
    public void palauttaafalseJosHirvioOnElossa(){
        vk.hyokkaa(25, 25);
        
        assertEquals(false, k.hirviokuollut(75, 25, vk));
        assertEquals(false, k.hirviokuollut(25, 25, vk));
        assertEquals(false, k.hirviokuollut(25, 75, vk));
        assertEquals(false, k.hirviokuollut(25, 100, vk));
        assertEquals(false, k.hirviokuollut(0, 50, vk));
    }
}