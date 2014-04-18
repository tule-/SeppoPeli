package kuuntelijat;

import hahmot.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;
import seppopeli.seppopeli.Kayttoliittyma;
import valikot.Ohjeet;
import valikot.Sepontarina;

/**
 * Pelin aloitus kuuntelija.
 * 
 * Voidaan valita aloitetaanko uusi peli vai
 * luetaanko Sepon tarina.
 */
public class Alkukuuntelija implements ActionListener {

    private JFrame frame;
    /**
     * Uuden pelin aloittava nappi.
     */
    private JButton uusi;
    /**
     * Sepon tarinan avaava nappi.
     */
    private JButton tarina;
    /**
     * Ohjeet valikon avaava nappi.
     */
    private JButton ohjeet;

    /**
     * Kuuntelijalle tuodaan tarvittavat komponentit.
     * 
     * @param frame
     * @param uusipeli uuden pelin aloittava nappi
     * @param sepontarina Sepontarinan käynnistävä nappi
     * @param ohjeet Ohjeet käynnistävä nappi
     */
    public Alkukuuntelija(JFrame frame, JButton uusipeli, JButton sepontarina, JButton ohjeet) {
        this.frame = frame;
        this.uusi = uusipeli;
        this.tarina = sepontarina;
        this.ohjeet = ohjeet;
    }

    /**
     * Kuuntelee mitä nappia painetaan.
     * @param e painettu nappi
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Pelaaja(), new HirvioGeneraattori(), new Voimakentta());
        Sepontarina sepontarina = new Sepontarina();
        Ohjeet ohje = new Ohjeet();
        
        if (e.getSource() == uusi) {
            kayttoliittyma.run();
            frame.dispose();
        }
        if (e.getSource() == tarina) {
            sepontarina.run();
            frame.dispose();
        }
        if(e.getSource() == ohjeet){
            ohje.run();
            frame.dispose();
        }
    }
}
