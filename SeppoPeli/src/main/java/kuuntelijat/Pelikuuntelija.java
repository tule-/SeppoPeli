package kuuntelijat;

import valikot.Peliloppu;
import hahmot.Hirvio;
import hahmot.Pelaaja;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import logiikka.HirvioGeneraattori;
import logiikka.Kuolema;
import logiikka.Pistelaskuri;
import logiikka.Voimakentta;

/**
 * Pelikuuntelija vastaa pelin pyörittämisestä.
 *
 * Se kuuntelee napin painalluksia sekä piirtää komponentit ruudulle uudelleen
 * joka painalluksen jälkeen.
 */
public class Pelikuuntelija implements KeyListener {

    private Component Component;
    /**
     * The hero of the game.
     */
    private Pelaaja pelaaja;
    /**
     * Hoitaa hirviöiden lisäämisen ja poistamisen.
     */
    private HirvioGeneraattori hirvioGen;
    /**
     * Pelaajan Voimakenttä.
     */
    private Voimakentta voimaKentta;
    /**
     * Laskee pelaajan pisteet.
     */
    private Pistelaskuri pisteLaskuri;
    /**
     * Tappaa pelaajan tai hirviön.
     */
    private Kuolema kuolema;
    /**
     * Pelin loputtua avautuva valikko.
     */
    private Peliloppu loppu;
    /**
     * Laskuri joka hoitaa uuden hirviön spawnaamisen.
     */
    private int laskuri = 11;
    /**
     * Tarkastaja toimii pelaajan kuolema ilmaiseimena
     * kellon sisällä.
     */
    private int tarkistaja = 1;
    /**
     * Jos vihamoodi on 1 tulevat hirviöt vihaisiksi ja
     * alkavat jahtaamaan pelaajaa. Vihamoodi kestää 
     * siihen asti kunnes yksi hirviö tapetaan.
     */
    private int vihamoodi = 0;
    /**
     * Inforuutu joka näyttää pelaajan pisteet.
     */
    private JLabel infoPisteet;
    /**
     * Inforuutu joka indikoi jos hirviöt ovat vihamoodissa.
     */
    private JLabel infoVihaisetHirviot;
    /**
     * Inforuutu joka ilmoittaa milloin uusi hirviö ilmestyy.
     */
    private JLabel infoUusiHirvio;
    /**
     * Kellon muuttuja.
     */
    private Timer timer;

    /**
     * Alustaa pelaajan, hirviögeneraattorin, voimakentän sekä inforuudun.
     *
     * @param component
     * @param p pelaaja
     * @param hg hirviögeneraattori
     * @param vk voimakenttä
     * @param infoPisteet näyttää pelaajan pisteet
     * @param infoVihaisetHirviot indikoi ovatko hirviöt vihaisia
     * @param infoUusiHirvio näyttää milloin uusi hirviö ilmestyy
     */
    public Pelikuuntelija(Component component, Pelaaja p, HirvioGeneraattori hg, Voimakentta vk, JLabel infoPisteet,JLabel infoVihaisetHirviot, JLabel infoUusiHirvio) {
        this.Component = component;
        
        this.pelaaja = p;
        this.hirvioGen = hg;
        
        this.voimaKentta = vk;
        this.pisteLaskuri = new Pistelaskuri();
        this.kuolema = new Kuolema();
        this.loppu = new Peliloppu();

        this.infoPisteet = infoPisteet;
        this.infoVihaisetHirviot = infoVihaisetHirviot;
        this.infoUusiHirvio = infoUusiHirvio;
        
        this.timer = new Timer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Kuuntelee napin painalluksia.
     *
     * @param e painettu nappi.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        /**
         * Nollataan voimakenttä.
         */
        voimaKentta.nollaa();


        /**
         * Pelaajan liike.
         */
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.siirra(0, -25);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.siirra(0, 25);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.siirra(-25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.siirra(25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            voimaKentta.hyokkaa(pelaaja.getX(), pelaaja.getY());
        }


        /**
         * Kello jonka mukaan hirviöt liikkuvat.
         */
        if (laskuri == 11) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    /**
                     * Hirviöiden liike.
                     */
                    for (Hirvio h1 : hirvioGen.getLista()) {

                        /**
                         * Vihamoodi käynnistyy jos vihamoodi-muuttuja on 1.
                         * Vihamoodissa hirviöt jahtaavat pelaajaa. Muuten hirviöt 
                         * liikkuvat randomisti.
                         */
                        if (vihamoodi == 1) {
                            h1.siirra(pelaaja.getX(), pelaaja.getY());
                        } else {
                            h1.siirra(-1, -1);
                        }

                        /**
                         * Kuolema tarkistus pelaajalle kellon sisällä.
                         */
                        if (kuolema.pelaajakuollut(pelaaja.getX(), pelaaja.getY(), h1.getX(), h1.getY()) == true) {
                            tarkistaja = 0;
                        }
                    }
                    Component.repaint();
                }
            };
            /**
             * Asettaa intervallin jolla hirviöt liikkuvat.
             * Normiasetus on 0.45s välein.
             */
            timer.schedule(task, java.util.Calendar.getInstance().getTime(), 450);
        }


        /**
         * Kuolema tarkistus pelaajalle.
         */
        if (tarkistaja == 0) {
            loppu.getPisteet(pisteLaskuri.getPisteet());
            loppu.run();
            Component.setVisible(false);
        } else {
            for (Hirvio h1 : hirvioGen.getLista()) {
                if (kuolema.pelaajakuollut(pelaaja.getX(), pelaaja.getY(), h1.getX(), h1.getY()) == true) {
                    loppu.getPisteet(pisteLaskuri.getPisteet());
                    loppu.run();
                    Component.setVisible(false);
                }
            }
        }


        /**
         * Kuolema tarkistus hirviölle.
         */
        for (int i = 0; i < hirvioGen.getLista().size(); i++) {
            if (kuolema.hirviokuollut(hirvioGen.getLista().get(i).getX(), hirvioGen.getLista().get(i).getY(), voimaKentta) == true) {
                hirvioGen.tapaHirvio(i);
                pisteLaskuri.lisaa();
                /**
                 * Nollataan vihamoodi.
                 */
                vihamoodi = 0;
            }
        }


        /**
         * Kellon alustus.
         */
        if (laskuri == 11) {
            laskuri = 10;
        }


        /**
         * Uusi hirviö joka 10. kierros.
         */
        laskuri--;
        if (laskuri == 0) {
            hirvioGen.lisaa(0);
            laskuri = 10;
        }
        

        /**
         * Vihamoodin kokeilu.
         * Vihamoodilla on 5% mahdollisuus laueta jos se ei
         * ole päällä.
         */
        if(vihamoodi != 1){
            Random rndm = new Random();
            vihamoodi = rndm.nextInt(19);
        }


        /**
         * Inforuuduilla näkyvät tiedot.
         */
        infoPisteet.setText("Pisteet: " + pisteLaskuri.getPisteet());
        infoUusiHirvio.setText("Uusi hirviö: " + laskuri);

        /**
         * Jos vihamoodi on päällä, se indikoidaan punaisella pelikentän
         * ylälaitaan.
         */
        if (vihamoodi == 1) {
            infoVihaisetHirviot.setText("Hirviöt ovat ERITTÄIN vihaisia!");
        }else{
            infoVihaisetHirviot.setText("");
        }


        Component.repaint();
    }

    /**
     * Kuuntelee irroitettuja nappeja.
     *
     * @param e irroitettu nappi
     */
    @Override
    public void keyReleased(KeyEvent e) {
        /**
         * Nollaa voimakentän sen jälkeen kun se on laukaistu.
         */
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            voimaKentta.nollaa();
        }
        Component.repaint();
    }
}
