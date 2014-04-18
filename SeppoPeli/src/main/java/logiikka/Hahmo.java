package logiikka;

import java.awt.Graphics;

/**
 * Luokka muodostaa hahmon joka on perusrakenne
 * pelaajalle ja hirviölle. 
 * Hahmoa voidaan siirtää ja se voidaan piirtää.
 */
public abstract class Hahmo {

    private int X;
    private int Y;
    
    public Hahmo(int x, int y) {
        this.X = x;
        this.Y = y;
    }
/**
 * Metodi muuttaa hahmon koordinaatteja niin, että
 * niihin lisätään parametreina annetut arvot.
 * 
 * @param dx x-akselin haluttu muutos
 * 
 * @param dy y-akselin haluttu muutos
 */
    public void siirra(int dx, int dy) {
        X += dx;
        Y += dy;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public abstract void piirra(Graphics graphics);
}
