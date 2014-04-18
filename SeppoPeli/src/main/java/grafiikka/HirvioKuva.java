package grafiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Piirtää hirviön kuvan.
 */
public class HirvioKuva {

    /**
     * Piirtää kuvan.
     * 
     * @param graphics 
     * @param x hirviön x-koordinaatti
     * @param y hirviön y-koordinaatti
     */
    public void getHirvio(Graphics graphics, int x, int y) {
        //HIRVIÖ VARAA 25X25 ALUEEN KENTÄLTÄ
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 25, 25);

        //SARVET
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x + 5, y, 5, 5);
        graphics.fillRect(x + 15, y, 5, 5);

        //KEHO
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x, y + 5, 5, 5);
        graphics.fillRect(x + 10, y + 5, 5, 5);
        graphics.fillRect(x + 20, y + 5, 5, 5);
        graphics.fillRect(x, y + 10, 25, 5);
        graphics.fillRect(x + 10, y + 15, 5, 5);

        //SILMÄT
        graphics.setColor(Color.RED);
        graphics.fillRect(x + 5, y + 5, 5, 5);
        graphics.fillRect(x + 15, y + 5, 5, 5);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x + 6, y + 6, 3, 3);
        graphics.fillRect(x + 16, y + 6, 3, 3);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x + 7, y + 7, 1, 1);
        graphics.fillRect(x + 17, y + 7, 1, 1);

        //JALAT
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x + 5, y + 15, 5, 10);
        graphics.fillRect(x + 15, y + 15, 5, 10);
        graphics.fillRect(x, y + 20, 5, 5);
        graphics.fillRect(x + 20, y + 20, 5, 5);
    }
    /**
     * Piirtää vihaisen hirviön kuvan
     * 
     * @param graphics
     * @param x hirviön x-koordinaatti
     * @param y hirviön y-koordinaatti
     */
    public void getVihainenHirviö(Graphics graphics, int x, int y){
        //VIHAINEN HIRVIÖ VARAA 25X25 ALUEEN KENTÄLTÄ
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 25, 25);

        //SARVET
        graphics.setColor(Color.RED);
        graphics.fillRect(x + 5, y, 5, 5);
        graphics.fillRect(x + 15, y, 5, 5);

        //KEHO
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y + 5, 5, 5);
        graphics.fillRect(x + 10, y + 5, 5, 5);
        graphics.fillRect(x + 20, y + 5, 5, 5);
        graphics.fillRect(x, y + 10, 25, 5);
        graphics.fillRect(x + 10, y + 15, 5, 5);

        //SILMÄT
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x + 5, y + 5, 5, 5);
        graphics.fillRect(x + 15, y + 5, 5, 5);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x + 6, y + 6, 3, 3);
        graphics.fillRect(x + 16, y + 6, 3, 3);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x + 7, y + 7, 1, 1);
        graphics.fillRect(x + 17, y + 7, 1, 1);

        //JALAT
        graphics.setColor(Color.RED);
        graphics.fillRect(x + 5, y + 15, 5, 10);
        graphics.fillRect(x + 15, y + 15, 5, 10);
        graphics.fillRect(x, y + 20, 5, 5);
        graphics.fillRect(x + 20, y + 20, 5, 5);
    }
}
