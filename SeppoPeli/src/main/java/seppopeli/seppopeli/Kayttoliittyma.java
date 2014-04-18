package seppopeli.seppopeli;

import grafiikka.Pelikentta;
import hahmot.Pelaaja;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import logiikka.HirvioGeneraattori;
import kuuntelijat.Pelikuuntelija;
import logiikka.Voimakentta;

/**
 * Vastaa pelikentän, pelaajan, hirviögeneraattorin ja voimakentän lisäämisen
 * sekä alustaa kuuntelijat.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelaaja pelaaja;
    private HirvioGeneraattori hirvioGen;
    private Voimakentta voimakentta;
    /**
     * Kolme inforuutua pelikentälle.
     */
    private JLabel infoPisteet;
    private JLabel infoVihaisetHirviot;
    private JLabel infoUusiHirvio;

    /**
     * Alustaa pelaajan, hirviögeneraattorin ja voimakentän.
     *
     * Lisää myös inforuuduille värin ja aloitusviestin.
     *
     * @param p pelaaja
     * @param hg hirviögeneraattori
     * @param vk voimakenttä
     */
    public Kayttoliittyma(Pelaaja p, HirvioGeneraattori hg, Voimakentta vk) {
        this.pelaaja = p;
        this.hirvioGen = hg;
        this.voimakentta = vk;
        /**
         * Ensimmäinen inforuutu ja sen väri.
         */
        this.infoPisteet = new JLabel("Peli alkoi!");
        infoPisteet.setBackground(Color.BLACK);
        infoPisteet.setForeground(Color.GRAY);
        infoPisteet.setOpaque(true);
        /**
         * Toinen inforuutu ja sen väri.
         */
        this.infoVihaisetHirviot = new JLabel();
        infoVihaisetHirviot.setBackground(Color.BLACK);
        infoVihaisetHirviot.setForeground(Color.RED);
        infoVihaisetHirviot.setOpaque(true);
        /**
         * Kolmas inforuutu ja sen väri.
         */
        this.infoUusiHirvio = new JLabel();
        infoUusiHirvio.setBackground(Color.BLACK);
        infoUusiHirvio.setForeground(Color.GRAY);
        infoUusiHirvio.setOpaque(true);
    }

    /**
     * Rakentaa pelin ja näyttää sen.
     *
     * Määrätään myös pelikentän paikan näytöllä.
     */
    @Override
    public void run() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 4, screenSize.height / 4);

        luoKomponentit(frame.getContentPane());

        lisaaKuuntelija();

        /**
         * Alustetaan hirviö.
         */
        hirvioGen.lisaa(0);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo komponentit.
     *
     * Sisältää pelikentän sekä inforuudun.
     *
     * @param container
     */
    public void luoKomponentit(Container container) {
        Pelikentta pk = new Pelikentta(pelaaja, hirvioGen, voimakentta);
        container.add(pk);

        JPanel paneeli = new JPanel(new GridLayout(1, 3));
        paneeli.add(infoPisteet);
        paneeli.add(infoVihaisetHirviot);
        paneeli.add(infoUusiHirvio);
        container.add(paneeli, BorderLayout.NORTH);
    }

    /**
     * Lisää Pelikuuntelijan.
     *
     * Pelikuuntelija pyörittää peliä.
     */
    public void lisaaKuuntelija() {
        frame.addKeyListener(new Pelikuuntelija(frame, pelaaja, hirvioGen, voimakentta, infoPisteet, infoVihaisetHirviot, infoUusiHirvio));
    }

    public JFrame getFrame() {
        return frame;
    }
}
