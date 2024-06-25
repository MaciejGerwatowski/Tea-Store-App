package RH;

public class Niebieska extends Herbata {

    public Niebieska() {
    }

    public Niebieska(String smak, int ilosc) {
        super(smak, ilosc);
    }

    public Niebieska(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik) {
        super(smak, progPromocji, cenaZaMniej, cenaZaWiecej, cennik);
    }

    public Niebieska(String smak, int cenaZaKg, boolean cennik) {
        super(smak, cenaZaKg, cennik);
    }

    @Override
    public String toString() {
        return "Niebieska, " + super.toString();
    }
}
