package RH;

public class Czerwona  extends Herbata {

    public Czerwona(){}

    public Czerwona(String smak, int ilosc) {
        super(smak, ilosc);
    }

    public Czerwona(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik) {
        super(smak, progPromocji, cenaZaMniej, cenaZaWiecej, cennik);
    }

    public Czerwona(String smak, int cenaZaKg, boolean cennik) {
        super(smak, cenaZaKg, cennik);
    }

    @Override
    public String toString() {
        return "Czerwona, " + super.toString();
    }
}
