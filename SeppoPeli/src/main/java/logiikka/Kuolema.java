package logiikka;

/**
 * Kuolema luokka tarkistaa onko hirviö tai pelaaja kuollut.
 *
 * Kuolema tarkistaa koordinaattien avulla osuuko pelaaja hirviöön tai hirviö
 * voimakenttään.
 */
public class Kuolema {

    /**
     * Tarkistaa onko pelaaja kuollut.
     *
     * Tarkistus tapahtuu niin, että katsotaan ovatko hirviön ja pelaajan
     * koordinaatit samat.
     *
     * @param pelaajaX pelaajan x-koordinaatti
     * @param pelaajaY pelaajan y-koordinaatti
     *
     * @param hirvioX hirviön x-koordinaatti
     * @param hirvioY hirviön y-koordinaatti
     *
     * @return true jos pelaaja on kuollut tai false jos pelaaja on elossa
     */
    public boolean pelaajakuollut(int pelaajaX, int pelaajaY, int hirvioX, int hirvioY) {
        if (pelaajaX == hirvioX && pelaajaY == hirvioY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistus onko hirviö kuollut.
     *
     * Tarkistus tapahtuu niin, että katsotaan ovatko hirviön ja voimakentän
     * koordinaatit samat.
     *
     * @param hirvioX hirviön x-koordinaatti
     * @param hirvioY hirviön y-koordinaatti
     *
     * @param voimakentta voimakenttä. Voidaan tuoda voimakentän koordinaatit.
     *
     * @return true jos hirviö kuolee ja false jos hirviö on elossa
     */
    public boolean hirviokuollut(int hirvioX, int hirvioY, Voimakentta voimakentta) {

        int x1 = voimakentta.getVoimakentta().get(0);
        int y1 = voimakentta.getVoimakentta().get(1);

        int x2 = voimakentta.getVoimakentta().get(2);
        int y2 = voimakentta.getVoimakentta().get(3);

        int x3 = voimakentta.getVoimakentta().get(4);
        int y3 = voimakentta.getVoimakentta().get(5);

        int x4 = voimakentta.getVoimakentta().get(6);
        int y4 = voimakentta.getVoimakentta().get(7);

        if (hirvioX == x1 && hirvioY == y1 || hirvioX == x2 && hirvioY == y2 || hirvioX == x3 && hirvioY == y3 || hirvioX == x4 && hirvioY == y4) {
            return true;
        } else {
            return false;
        }
    }
}
