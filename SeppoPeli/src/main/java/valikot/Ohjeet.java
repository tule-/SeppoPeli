package valikot;

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
import kuuntelijat.Uusipelikuuntelija;

/**
 * Pelaaja voi lukea pelin ohjeet.
 * 
 * Ruudun alalaidassa on painike jolla pelaaja siirtyy
 * takaisin päävalikkoon.
 */
public class Ohjeet  implements Runnable{
    
    private JFrame frame;
    
    /**
     * Luo ruudun, asettaa sen dimensiot sekä lisää komponentit.
     */
    @Override
    public void run() {
        this.frame = new JFrame("Ohjeet");
        
        frame.setPreferredSize(new Dimension(340, 375));
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
        
        JPanel paneeli= new JPanel(new GridLayout(13, 1));
        
        JLabel info = new JLabel("Seppo liikkuu nuolinäppäimillä ja");
        varitaLabeli(info);
        JLabel info2 = new JLabel("Sepon pahanhajuista hengitystä voidaan käyttää");
        varitaLabeli(info2);
        JLabel info3 = new JLabel("voimakentän tavoin SPACE napilla.");
        varitaLabeli(info3);
        JLabel info4 = new JLabel("");
        varitaLabeli(info4);
        JLabel info5 = new JLabel("Seppo kuolee osuessaan hirviöön. Hirviö");
        varitaLabeli(info5);
        JLabel info6 = new JLabel("puolestaan kuolee osuessaan Sepon voimakenttään.");
        varitaLabeli(info6);
        JLabel info7 = new JLabel("Jokainen tappo tuo 10 pistettä.");
        varitaLabeli(info7);
        JLabel info8 = new JLabel("");
        varitaLabeli(info8);
        JLabel info9 = new JLabel("Ole varuillasi, koska hirviöt saavat");
        varitaLabeli(info9);
        JLabel info10 = new JLabel("välillä raivonpuuskia.");
        varitaLabeli(info10);
        JLabel info11 = new JLabel("");
        varitaLabeli(info11);
        JLabel info12 = new JLabel("Onnea matkaan!");
        varitaLabeli(info12);
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