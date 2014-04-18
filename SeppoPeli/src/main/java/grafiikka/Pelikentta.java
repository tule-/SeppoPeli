package grafiikka;

import hahmot.Hirvio;
import hahmot.Pelaaja;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;

/**
 * Luo pelikentän.
 */
public class Pelikentta extends JPanel {

    private Pelaaja p;
    private HirvioGeneraattori hg;
    private Voimakentta vk;
    private LuolanSuuaukko ls;

    /**
     * Valitsee pelikentän koon sekä sinne luotavat komponentit.
     *
     * @param p pelaaja
     * @param hg hirviö
     * @param vk pelaajan voimakenttä
     */
    public Pelikentta(Pelaaja p, HirvioGeneraattori hg, Voimakentta vk) {
        this.p = p;
        this.hg = hg;
        this.vk = vk;

        this.ls = new LuolanSuuaukko();

        super.setBackground(Color.BLACK);
        super.setPreferredSize(new Dimension(800, 600));
    }

    /**
     * Piirtää pelikentän sekä komponentit.
     *
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        p.piirra(graphics);
        vk.piirra(graphics);

        ls.getLuolanSuuaukko(graphics);

        for (Hirvio h1 : hg.getLista()) {
            h1.piirra(graphics);
        }
    }
}
