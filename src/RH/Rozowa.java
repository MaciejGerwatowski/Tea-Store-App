package RH;

public class Rozowa extends Herbata {

    public Rozowa() {
    }

    public Rozowa(String smak, int ilosc) {
        super(smak, ilosc);
    }

    public Rozowa(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik) {
        super(smak, progPromocji, cenaZaMniej, cenaZaWiecej, cennik);
    }

    public Rozowa(String smak, int cenaZaKg, boolean cennik) {
        super(smak, cenaZaKg, cennik);
    }

    @Override
    public String toString() {
        return "Różowa, " + super.toString();
    }
}
