package grafiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Piirtää voimakentän kuvan.
 */
public class VoimakenttaKuva {

    /**
     * Piirtää kuvan.
     * 
     * @param graphics
     * @param x voimakentän x-koordinaatti
     * @param y voimakentän y-koordinaatti
     */
    public void getVoimakentta(Graphics graphics, int x, int y) {
        //VOIMAKENTTA VARAA 25x25 ALUEEN KENTÄLTÄ
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 25, 25);
        
        //VOIMAKENTTÄ
        graphics.setColor(Color.RED);
        graphics.fillRect(x + 10, y, 5, 5);
        graphics.fillRect(x + 5, y + 5, 5, 5);
        graphics.fillRect(x + 15, y + 5, 5, 5);
        graphics.fillRect(x, y + 10, 5, 5);
        graphics.fillRect(x + 10, y + 10, 5, 5);
        graphics.fillRect(x + 20, y + 10, 5, 5);
        graphics.fillRect(x + 5, y + 15, 5, 5);
        graphics.fillRect(x + 15, y + 15, 5, 5);
        graphics.fillRect(x + 10, y + 20, 5, 5);
        
    }
}
