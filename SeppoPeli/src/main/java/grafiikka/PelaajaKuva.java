package grafiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Piirtää pelaajan.
 */
public class PelaajaKuva {

    /**
     * Piirtää kuvan.
     * 
     * @param graphics
     * @param x pelaajan x-koordinaatti
     * @param y pelaajan y-koordinaatti
     */
    public void getPelaaja(Graphics graphics, int x, int y) {
        //PELAAJA VARAA 25X25 ALUEEN KENTÄLTÄ
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 25, 25);

        //PÄÄ
        graphics.setColor(Color.PINK);
        graphics.fillRect(x + 10, y + 2, 5, 3);
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x + 10, y, 5, 2);

        //PAITA
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y + 5, 25, 5);
        graphics.fillRect(x + 10, y + 10, 5, 5);

        //KÄDET
        graphics.setColor(Color.PINK);
        graphics.fillRect(x, y + 10, 5, 5);
        graphics.fillRect(x + 20, y + 10, 5, 5);

        //JALAT
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(x + 5, y + 15, 15, 5);
        graphics.fillRect(x + 5, y + 20, 5, 5);
        graphics.fillRect(x + 15, y + 20, 5, 5);
    }
}
