package seppopeli.seppopeli;

import javax.swing.SwingUtilities;
import valikot.Uusipeli;

public class App {

    public static void main(String[] args) {

        Uusipeli u = new Uusipeli();
        SwingUtilities.invokeLater(u);
    }
}
