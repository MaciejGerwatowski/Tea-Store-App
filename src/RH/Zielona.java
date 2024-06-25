package RH;

public class Zielona extends Herbata {

    public Zielona() {
    }

    public Zielona(String smak, int ilosc) {
        super(smak, ilosc);
    }

    public Zielona(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik) {
        super(smak, progPromocji, cenaZaMniej, cenaZaWiecej, cennik);
    }

    public Zielona(String smak, int cenaZaKg, boolean cennik) {
        super(smak, cenaZaKg, cennik);
    }

    @Override
    public String toString() {
        return "Zielona, " + super.toString();
    }
}
