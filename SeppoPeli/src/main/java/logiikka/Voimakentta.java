package logiikka;

import grafiikka.VoimakenttaKuva;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Voimakenttä luokka määrää voimakentän toiminnan pelikentällä.
 *
 * Voimakenttä on joko pelikentän ulkopuolella tai pelaajan ympärillä.
 *
 * Voimakenttä on aluksi pelikentän ulkopuolella.
 */
public class Voimakentta {

    ArrayList<Integer> voimakentta;

    public Voimakentta() {
        this.voimakentta = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            voimakentta.add(10000);
        }
    }

    /**
     * Metodi nollaa voimakentän eli asettaa sen arvot pelikentän pelikentän
     * ulkopuolelle.
     */
    public void nollaa() {
        voimakentta.clear();

        for (int i = 0; i <= 7; i++) {
            voimakentta.add(10000);
        }
    }

    /**
     * Metodi asettaa voimakentän pelikentälle.
     *
     * Parametreinä se saa pelaajan koordinaatit ja se vaikuttaa pelaajasta
     * yhden koordinaatin verran ylös, alas, vasemmalle ja oikealle.
     *
     * @param x pelaajan x-koordinaatti
     *
     * @param y pelaajan y-koordinaatti
     */
    public void hyokkaa(int x, int y) {
        voimakentta.clear();

        for (int i = 0; i <= 7; i++) {
            if (i == 0) {
                voimakentta.add(x + 25);
            } else if (i == 1) {
                voimakentta.add(y);
            } else if (i == 2) {
                voimakentta.add(x - 25);
            } else if (i == 3) {
                voimakentta.add(y);
            } else if (i == 4) {
                voimakentta.add(x);
            } else if (i == 5) {
                voimakentta.add(y + 25);
            } else if (i == 6) {
                voimakentta.add(x);
            } else if (i == 7) {
                voimakentta.add(y - 25);
            }
        }
    }

    public ArrayList<Integer> getVoimakentta() {
        return voimakentta;
    }

    /**
     * Piirtää voimakentän pelikentälle.
     *
     * @param graphics
     */
    public void piirra(Graphics graphics) {
        VoimakenttaKuva kuva = new VoimakenttaKuva();

        kuva.getVoimakentta(graphics, voimakentta.get(0), voimakentta.get(1));
        kuva.getVoimakentta(graphics, voimakentta.get(2), voimakentta.get(3));
        kuva.getVoimakentta(graphics, voimakentta.get(4), voimakentta.get(5));
        kuva.getVoimakentta(graphics, voimakentta.get(6), voimakentta.get(7));
    }
}
