package valikot;

import kuuntelijat.Uusipelikuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Pelin loppu valikko.
 *
 * Valikko tulee Sepon kuoleman jälkeen. Se näyttää pelaajan lopulliset pisteet
 * sekä antaa mahdollisuuden pelata uudelleen.
 */
public class Peliloppu implements Runnable {

    private JFrame frame;
    
    /**
     * Alustetaan pisteet.
     */
    private int pisteet = 0;

    /**
     * Haetaan pelaajan pisteet.
     *
     * @param pisteet pelaajan lopulliset pisteet
     */
    public void getPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    /**
     * Luo valikon, asettaa sen koon sekä lisää komponentit.
     */
    @Override
    public void run() {
        this.frame = new JFrame();

        frame.setPreferredSize(new Dimension(250, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo valikkoon sisällytettävät komponentit.
     * 
     * @param container 
     */
    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JPanel paneeli= new JPanel(new GridLayout(6, 1));

        JLabel loppu = new JLabel("Peli loppui, hirviöt saivat Sepon!");
        varitaLabeli(loppu);
        JLabel loppu2 = new JLabel("Seppo ei herää tästä painajaisesta.");
        varitaLabeli(loppu2);
        JLabel tyhja = new JLabel(" ");
        varitaLabeli(tyhja);
        JLabel piste = new JLabel("Pisteesi: " + pisteet);
        varitaLabeli(piste);
        JLabel tyhja2 = new JLabel();
        varitaLabeli(tyhja2);
        JButton uusi = new JButton("Pelaa uudelleen?");
        varitaNappi(uusi);
        uusi.doClick(500);

        paneeli.add(loppu);
        paneeli.add(loppu2);
        paneeli.add(tyhja);
        paneeli.add(piste);
        paneeli.add(tyhja2);
        paneeli.add(uusi);
        
        container.add(paneeli, BorderLayout.CENTER);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, uusi);
        uusi.addActionListener(kuuntelija);
    }
    
    /**
     * Värittää JLabelin.
     * 
     * @param labeli väritettävä labeli
     */
    public void varitaLabeli(JLabel labeli){
        labeli.setBackground(Color.BLACK);
        labeli.setForeground(Color.WHITE);
        labeli.setOpaque(true);
    }
    
    /**
     * Värittää JButtonin.
     * 
     * @param nappi väritettävä nappi
     */
    public void varitaNappi(JButton nappi){
        nappi.setBackground(Color.BLACK);
        nappi.setForeground(Color.WHITE);
        nappi.setOpaque(true);
    }
}
