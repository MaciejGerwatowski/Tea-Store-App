package RH;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaZakupow implements Iterable<Herbata> {

    private String klient;
   private final List<Herbata> lista = new ArrayList<>();
    Cennik cennik = Cennik.pobierzCennik();

    public void add(Herbata herbata){
        lista.add(herbata);
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(!lista.isEmpty()) {
            for (Herbata herbata : lista) {
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
    public Iterator<Herbata> iterator() {
        return lista.listIterator();
    }
}
