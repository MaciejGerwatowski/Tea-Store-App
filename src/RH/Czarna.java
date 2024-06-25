package RH;

public class Czarna extends Herbata {

    public Czarna(){}

    public Czarna(String smak, int ilosc) {
        super(smak, ilosc);
    }

    public Czarna(String smak, int cenaZaKg, boolean cennik) {
        super(smak, cenaZaKg, cennik);
    }

    public Czarna(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik) {
        super(smak, progPromocji, cenaZaMniej, cenaZaWiecej, cennik);
    }

    @Override
    public String toString() {
        return "Czarna, " + super.toString();
    }
}
