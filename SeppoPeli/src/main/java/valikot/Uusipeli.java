package valikot;

import java.awt.BorderLayout;
import java.awt.Color;
import kuuntelijat.Alkukuuntelija;
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
 * Pelin käynnistyksen yhteydessä aukeava valikko.
 * 
 * Mahdollisuus aloittaa peli, lukea Sepon tarina tai
 * lukea pelin ohjeet.
 */
public class Uusipeli implements Runnable {
    
    private JFrame frame;
    
    /**
     * Luo valikon sekä kaikki sen ominaisuudet.
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
        
        frame.getContentPane().setBackground(Color.black);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo valikon komponentit.
     * 
     * @param container 
     */
    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JPanel paneeli= new JPanel(new GridLayout(5, 1));
        
        JLabel info = new JLabel("                        SEPPO PELI 1.0");
        info.setBackground(Color.BLACK);
        info.setForeground(Color.WHITE);
        info.setOpaque(true);
        
        JLabel tyhja = new JLabel("");
        tyhja.setBackground(Color.BLACK);
        tyhja.setOpaque(true);
        
        JButton uusi = new JButton("Aloita peli");
        uusi.setBackground(Color.BLACK);
        uusi.setForeground(Color.WHITE);
        uusi.setOpaque(true);
        
        JButton tarina = new JButton("Sepon tarina");
        tarina.setBackground(Color.BLACK);
        tarina.setForeground(Color.WHITE);
        tarina.setOpaque(true);
        
        JButton ohjeet = new JButton("Ohjeet");
        ohjeet.setBackground(Color.BLACK);
        ohjeet.setForeground(Color.WHITE);
        ohjeet.setOpaque(true);
        
        paneeli.add(info);
        paneeli.add(tyhja);
        paneeli.add(uusi);
        paneeli.add(tarina);
        paneeli.add(ohjeet);
        
        container.add(paneeli, BorderLayout.CENTER);

        Alkukuuntelija kuuntelija = new Alkukuuntelija(frame, uusi, tarina, ohjeet);
        uusi.addActionListener(kuuntelija);
        tarina.addActionListener(kuuntelija);
        ohjeet.addActionListener(kuuntelija);
    }
}
