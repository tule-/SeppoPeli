package kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import valikot.Uusipeli;

/**
 * Kuuntelija siirtää takaisin aloitusruutuun.
 * 
 * Uusipelikuuntelija toimii Sepontarina -
 * sekä Peliloppu- ruuduissa.
 */
public class Uusipelikuuntelija implements ActionListener{
    
    private JFrame frame;
    /**
     * Uuden pelin aloittava nappi.
     */
    private JButton uusi;
    
    /**
     * Määrittalee tarvittavat komponentit.
     * 
     * @param frame
     * @param uusipeli Uuden pelin aloittava nappi
     */
    public Uusipelikuuntelija(JFrame frame, JButton uusipeli){
        this.frame = frame;
        this.uusi = uusipeli;
    }

    /**
     * kuuntelee painettuja nappeja.
     * 
     * @param e painettu nappi
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Uusipeli uusipeli = new Uusipeli();
        if(e.getSource() == uusi){
            uusipeli.run();
            frame.dispose();
        }
    }
}
