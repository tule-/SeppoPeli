package logiikka;

/**
 * Pistelaskuri hoitaan pisteiden laskemisen.
 * 
 * Se voi lisätä pisteitä ja näyttää ne.
 */
public class Pistelaskuri {
    private int pisteet;
    
    public Pistelaskuri(){
        /**
         * Asettaa pisteet aluksi nollaan.
         */
        this.pisteet = 0;
    }
    
    /**
     * Lisää 10 pistettä.
     */
    public void lisaa(){
        this.pisteet += 10;
    }
    
    public int getPisteet(){
        return pisteet;
    }
}
