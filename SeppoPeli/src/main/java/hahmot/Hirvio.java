package hahmot;

import grafiikka.HirvioKuva;
import java.awt.Graphics;
import java.util.Random;
import logiikka.Hahmo;

/**
 * Luokka luo hirviön. Hirviö voi liikkua ja se voidaan piirtää.
 *
 * Luokka määrittelee neljä erilaista hirviötä. Hirviöillä on eri aloitus
 * koordinaatit.
 *
 * Luokka perii luokan hahmo ominaisuudet.
 */
public class Hirvio extends Hahmo {

    /**
     * Pelaajan x-koordinaatti.
     */
    private int pelaajaX;
    /**
     * Pelaajan y-koordinaatti
     */
    private int palaajaY;

    /**
     * 1. hirviön aloituskoordinaatit.
     */
    public Hirvio() {
        super(0, 300);
    }

    /**
     * 2. hirviön aloituskoordinaatit.
     *
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(int x) {
        super(775, 300);
    }

    /**
     * 3. hirviön aloituskoordinaatit
     *
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(String x) {
        super(400, 0);
    }

    /**
     * 4. hirviön aloituskoordinaatit
     *
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(double x) {
        super(400, 575);
    }

    /**
     * Siirtää hirviötä pelikentän rajojen sisällä.
     *
     * Parameteinä annetaan -1 jos halutaan hirviön liikkuvan randomisti ja
     * pelaajan kooordinaatit jos halutaan hirviön seuraavan pelaajaa.
     *
     * @param dx x-akselin muutos
     *
     * @param dy y-akselin muutos
     */
    @Override
    public void siirra(int dx, int dy) {
        this.pelaajaX = dx;
        this.palaajaY = dy;

        Random r = new Random();
        int x = r.nextInt(3) - 1;
        int y = r.nextInt(3) - 1;

        if (dx == -1 && dy == -1) {
            /*
             * Varmistetaan, että hirviö pysyy pelikentän sisällä.
             */
            if (this.getX() + x <= 775 && this.getX() + x >= 0 && this.getY() + y <= 575 && this.getY() + y >= 0) {
                super.siirra(x * 25, y * 25);
            }

        } else {
            /*
             * hirviön alkeellinen teko-äly: se seuraa pelaajaa.
             */
            if (dx - this.getX() < 0 && dy - this.getY() < 0) {
                super.siirra(-25, -25);
            } else if (dx - this.getX() > 0 && dy - this.getY() > 0) {
                super.siirra(25, 25);
            } else if (dx - this.getX() > 0 && dy - this.getY() < 0) {
                super.siirra(25, -25);
            } else if (dx - this.getX() < 0 && dy - this.getY() > 0) {
                super.siirra(-25, 25);
            } else if (dx - this.getX() == 0 && dy - this.getY() > 0) {
                super.siirra(0, 25);
            } else if (dx - this.getX() == 0 && dy - this.getY() < 0) {
                super.siirra(0, -25);
            } else if (dx - this.getX() > 0 && dy - this.getY() == 0) {
                super.siirra(25, 0);
            } else if (dx - this.getX() < 0 && dy - this.getY() == 0) {
                super.siirra(-25, 0);
            }
        }
    }

    /**
     * Piirtää hirviön pelikentälle.
     *
     * @param graphics
     */
    @Override
    public void piirra(Graphics graphics) {
        HirvioKuva kuva = new HirvioKuva();
        /**
         * Piirretään joko vihainen tai normaali hirviö.
         */
        if (pelaajaX == -1 && palaajaY == -1) {
            kuva.getHirvio(graphics, this.getX(), this.getY());
        } else {
            kuva.getVihainenHirviö(graphics, this.getX(), this.getY());
        }
    }
}
