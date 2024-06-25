package RH;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Koszyk implements Comparator<Herbata>, Iterable<Herbata> {

    private final List<Herbata> koszyk = new ArrayList<>();
    private String klient;

    Cennik cennik = Cennik.pobierzCennik();

    public void add(Herbata herbata){
        koszyk.add(herbata);
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }


    public void sortuj(){
        koszyk.sort(this);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(!koszyk.isEmpty()) {
            for (Herbata herbata : koszyk) {
                if (herbata == null)
                    continue;
                result.append(herbata).append("Cena: ").append(cennik.cenaHerbaty(herbata)).append("\n");
            }
        } else{
            result.append("--pusto");
        }

        return klient + ":\n" + result;
    }

    @Override
    public int compare(Herbata o1, Herbata o2) {
        if(cennik.cenaHerbaty(o1) < cennik.cenaHerbaty(o2)){
            return 1;
        } else {
            if(cennik.cenaHerbaty(o1) > cennik.cenaHerbaty(o2)){
                return -1;
            } else return 0;
        }
    }

    @Override
    public Iterator<Herbata> iterator() {
        return koszyk.iterator();
    }

    public void clear() {
        koszyk.clear();
    }
}
