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
 * Pelaaja voi lukea Sepon sydäntä särkevän tarinan.
 * 
 * Ruudun alalaidassa on painike jolla pelaaja voi siirtyä
 * takaisin päävalikkoon.
 */
public class Sepontarina  implements Runnable{
    
    private JFrame frame;
    
    /**
     * Luo ruudun, asettaa sen dimensiot sekä lisää komponentit.
     */
    @Override
    public void run() {
        this.frame = new JFrame("Seppon tarina");
        
        frame.setPreferredSize(new Dimension(340, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo valikkoon lisättävät komponentit.
     * 
     * Sisältää pääasiassa tekstiä.
     * 
     * @param container 
     */
    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JPanel paneeli= new JPanel(new GridLayout(14, 1));
        
        JLabel info = new JLabel("Eräänä iltana tavalliseen tapaansa Seppo lensi");
        varitaLabeli(info);
        JLabel info2 = new JLabel("ulos kantabaaristaan ja ryömi tuttuun katuojaan.");
        varitaLabeli(info2);
        JLabel info3 = new JLabel("Hän päätti ottaa pienet nokoset kotoisassa");
        varitaLabeli(info3);
        JLabel info4 = new JLabel("viemärivedessä.");
        varitaLabeli(info4);
        JLabel info5 = new JLabel(" ");
        varitaLabeli(info5);
        JLabel info6 = new JLabel("Herättyään Seppo hieraisi silmiään ja katsoi ympärilleen.");
        varitaLabeli(info6);
        JLabel info7 = new JLabel("Hän huomasi olevansa keskellä mitä voisi vain kuvailla");
        varitaLabeli(info7);
        JLabel info8 = new JLabel("areenaksi. Seppo näkee seinillä suuaukkoja, joista hänen");
        varitaLabeli(info8);
        JLabel info9 = new JLabel("kauhukseen kantautuu pahaenteistä murinaa.");
        varitaLabeli(info9);
        JLabel info10 = new JLabel(" ");
        varitaLabeli(info10);
        JLabel info11 = new JLabel("Onko tämä kaikkien aikojen pahin liskojen yö");
        varitaLabeli(info11);
        JLabel info12 = new JLabel("vai onko Seppo oikeasti kiipelissä?");
        varitaLabeli(info12);
        JLabel info13 = new JLabel("Se jää vain nähtäväksi.");
        varitaLabeli(info13);
        JButton takaisin = new JButton("Takaisin");
        varitaNappi(takaisin);
        
        paneeli.add(info);
        paneeli.add(info2);
        paneeli.add(info3);
        paneeli.add(info4);
        paneeli.add(info5);
        paneeli.add(info6);
        paneeli.add(info7);
        paneeli.add(info8);
        paneeli.add(info9);
        paneeli.add(info10);
        paneeli.add(info11);
        paneeli.add(info12);
        paneeli.add(info13);
        paneeli.add(takaisin);
        
        container.add(paneeli, BorderLayout.CENTER);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, takaisin);
        takaisin.addActionListener(kuuntelija);
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
