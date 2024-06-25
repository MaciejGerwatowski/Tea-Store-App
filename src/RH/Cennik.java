package RH;

import java.util.HashSet;
import java.util.Set;

public class Cennik {

    public static Cennik instancja;
    private final Set<Herbata> cennik;

    private Cennik() {
        cennik = new HashSet<>();  //prywatny konstruktor zapobiega tworzeniu obiektow klasy
    }


    public static Cennik pobierzCennik() {
        if (instancja == null) {
            instancja = new Cennik();
        }
        return instancja;
    }


    public void dodaj(RodzajHerbaty rodzajHerbaty, String smak, int cenaZaKg){
       switch (rodzajHerbaty){
           case CZARNA -> cennik.add(new Czarna(smak, cenaZaKg, true));
           case ZIELONA -> cennik.add(new Zielona(smak, cenaZaKg, true));
           case CZERWONA -> cennik.add(new Czerwona(smak, cenaZaKg, true));
           case NIEBIESKA -> cennik.add(new Niebieska(smak, cenaZaKg, true));
           default -> {
                Herbata h = rodzajHerbaty.pobierzTypKlasy();
                h.setSmak(smak);
                h.setCenaZaKg(cenaZaKg);
                cennik.add(h);
           }

       }
    }

    public void dodaj(RodzajHerbaty rodzajHerbaty, String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej){
        switch (rodzajHerbaty){
            case CZARNA -> cennik.add(new Czarna(smak, progPromocji, cenaZaMniej, cenaZaWiecej, true));
            case ZIELONA -> cennik.add(new Zielona(smak, progPromocji, cenaZaMniej, cenaZaWiecej, true));
            case CZERWONA -> cennik.add(new Czerwona(smak, progPromocji, cenaZaMniej, cenaZaWiecej, true));
            case NIEBIESKA -> cennik.add(new Niebieska(smak, progPromocji, cenaZaMniej, cenaZaWiecej, true));
            default -> {
                Herbata h = rodzajHerbaty.pobierzTypKlasy();
                h.setSmak(smak);
                h.setProgPromocji(progPromocji);
                h.setCenaZaMniej(cenaZaMniej);
                h.setCenaZaWiecej(cenaZaWiecej);
                cennik.add(h);
            }
        }
    }

    public  boolean czyHerbataJestWcenniku(Herbata herbata) {
        boolean czyJest = false;
        for(Herbata h : cennik){
            if (herbata.equals(h)) {
                czyJest = true;
                break;
            }
        }
        return czyJest;
    }

    public Herbata zwrocZCennika(Herbata herbata) {
        if(czyHerbataJestWcenniku(herbata)) {
            Herbata temp = null;
            for (Herbata h : cennik) {
                if (herbata.equals(h))
                    temp = h;
            }
            return temp;
        } else return herbata;
    }

    public int cenaHerbaty(Herbata herbata){
        Herbata h = zwrocZCennika(herbata);
        if(czyPromocyjna(h)){
            if (herbata.getIlosc() >= h.getProgPromocji()) {
                return h.getCenaZaWiecej();
            } else {
                return h.getCenaZaMniej();
            }
        } else{
            herbata.setCenaZaKg(-1);
            return h.getCenaZaKg();
        }
    }

    public boolean czyPromocyjna(Herbata h){
        return h.getProgPromocji() != 0;
    }


    @Override
    public String toString() {
        return "Cennik{" +
                "cennik=" + cennik +
                '}';
    }
}


