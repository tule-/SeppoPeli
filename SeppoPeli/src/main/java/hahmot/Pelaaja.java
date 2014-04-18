package hahmot;

import grafiikka.PelaajaKuva;
import java.awt.Graphics;
import logiikka.Hahmo;

/**
 * Luokka luo pelaajan. Pelaaja voi liikua ja
 * se voidaan piirtää.
 * 
 * Luokka perii luokan Hahmo ominaisuudet.
 */
public class Pelaaja extends Hahmo {

    /**
     * Pelaajan aloitus koordinaatit.
     */
    public Pelaaja() {
        super(400, 300);
    }
    
/**
 * Metodi siirtää pelaajan pelikentän rajojen sisällä
 * tiettyyn pisteeseen.
 * 
 * @param dx x-akselin muutos
 * 
 * @param dy y-akselin muutos
 */
    @Override
    public void siirra(int dx, int dy) {
        if (this.getX() + dx <= 775 && this.getX() + dx >= 0 && this.getY() + dy <= 575 && this.getY() + dy >= 0) {
            super.siirra(dx, dy);
        }
    }

    /**
     * Piirtää pelaajan pelikentälle.
     * 
     * @param graphics 
     */
    @Override
    public void piirra(Graphics graphics) {
        PelaajaKuva kuva = new PelaajaKuva();
        kuva.getPelaaja(graphics, this.getX(), this.getY());
    }
}
