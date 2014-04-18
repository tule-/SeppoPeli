package logiikka;

import hahmot.Hirvio;
import java.util.ArrayList;
import java.util.Random;

/**
 * Hirviögeneraattori hoitaa hirviöiden luomisen
 * ja poistamisen listan avulla.
 */
public class HirvioGeneraattori {
    /**
     * Lista johon hirviöt talletetaan
     */
    private ArrayList<Hirvio> hirviot;

    public HirvioGeneraattori() {
        this.hirviot = new ArrayList<>();
    }

    /**
     * Lisää hirviön listaan. 
     * 
     * Lisättävän hirviön paikka
     * pelikentällä määräytyy sattumanvaraisesti.
     * 
     * @param maara lisättävien hirviöiden määrä
     * 
     * @return lista joka sisältää uudet hirviöt
     */
    public ArrayList<Hirvio> lisaa(int maara) {
        for (int i = 0; i <= Math.abs(maara); i++) {

            Random rndm = new Random();
            int hirvioarpa = rndm.nextInt(4);

            if (hirvioarpa == 0) {
                hirviot.add(new Hirvio());

            } else if (hirvioarpa == 1) {
                hirviot.add(new Hirvio(0));

            } else if (hirvioarpa == 2) {
                hirviot.add(new Hirvio("uusi"));

            } else {
                hirviot.add(new Hirvio(1.1));
            }

        }
        return hirviot;
    }

    public ArrayList<Hirvio> getLista() {
        return hirviot;
    }

    /**
     * Metodi poistaa parametria vastaavan hirviön
     * listalta.
     * 
     * @param i määrää poistettavan hirviön.
     */
    public void tapaHirvio(int i) {
        hirviot.remove(i);
    }
}
