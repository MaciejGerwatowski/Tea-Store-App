package RH;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Klient {

    private final String nazwaUzytkownika;
    private double wartoscPortfela;
    private final ListaZakupow lista;
    private final Koszyk koszykKlienta;
    private int id = 0;
    private static int sID =0;
    Cennik cennik = Cennik.pobierzCennik();


    public Klient(String nazwaUzytkownika, int wartoscPortfela) {
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.wartoscPortfela = wartoscPortfela;
        this.lista = new ListaZakupow();
        this.koszykKlienta = new Koszyk();
        sID++;
        this.id = sID;
    }

    public void dodaj(Herbata herbata){
        lista.add(herbata);
    }

    public ListaZakupow pobierzListeZakupow(){
        lista.setKlient(nazwaUzytkownika);
        return lista;
    }

    public Koszyk pobierzKoszyk(){
        koszykKlienta.setKlient(nazwaUzytkownika);
        return koszykKlienta;
    }
    public double pobierzPortfel(){
        return wartoscPortfela;
    }

    public int getId() {
        return id;
    }

    public void przepakuj() {
        Iterator<Herbata> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Herbata h = iterator.next();
            if (cennik.czyHerbataJestWcenniku(h)) {
                koszykKlienta.add(h);
                iterator.remove();
            }
        }

    }

        Map<Herbata, Double> kupioneIlosc = new HashMap<>();
    public void zaplac(boolean typPlatnosci) {        //true - karta 2,5% prowizji   false - przelew, brak prowizji
        double totalCena = 0;
        koszykKlienta.sortuj();
        double temp = wartoscPortfela;
        Iterator<Herbata> iterator = koszykKlienta.iterator();

        for (Herbata h : koszykKlienta) {
            totalCena += cennik.cenaHerbaty(h) * h.getIlosc();
            kupioneIlosc.put(h, h.getIlosc());
        }

        double prowizja;
        prowizja = (typPlatnosci ? 1.025 : 1);


        if(totalCena * prowizja <= wartoscPortfela){
            wartoscPortfela -= totalCena;
            koszykKlienta.clear();

        } else {
            kupioneIlosc.clear();
            while (iterator.hasNext()) {
                Herbata h = iterator.next();
                if (typPlatnosci) {
                    for (int i = 0; i < h.getIlosc(); i++) {
                        if (cennik.cenaHerbaty(h) * (h.getIlosc() - i) + (cennik.cenaHerbaty(h) * (h.getIlosc() - i)) * 0.025 <= wartoscPortfela) {
                            wartoscPortfela -= cennik.cenaHerbaty(h) * (h.getIlosc() - i) + (cennik.cenaHerbaty(h) * (h.getIlosc() - i)) * 0.025;
                            if (i == 0) {
                                kupioneIlosc.put(h, h.getIlosc() -i );
                                iterator.remove();
                            } else {
                                kupioneIlosc.put(h, h.getIlosc() - i);
                                h.setIlosc(i);
                            }
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < h.getIlosc(); i++) {
                        if (cennik.cenaHerbaty(h) * (h.getIlosc() - i) <= wartoscPortfela) {
                            wartoscPortfela -= cennik.cenaHerbaty(h) * (h.getIlosc() - i);
                            if (i == 0) {
                                kupioneIlosc.put(h, h.getIlosc() - i);
                                iterator.remove();
                            } else {
                                kupioneIlosc.put(h, h.getIlosc() - i);
                                h.setIlosc(i);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void zwroc(RodzajHerbaty rodzajHerbaty, String smak, int ilosc) {
        try {
            Herbata h1 = null;
            switch (rodzajHerbaty) {
                case CZARNA -> h1 = new Czarna(smak, ilosc);
                case CZERWONA -> h1 = new Czerwona(smak, ilosc);
                case NIEBIESKA -> h1 = new Niebieska(smak, ilosc);
                case ZIELONA -> h1 = new Zielona(smak, ilosc);
                default -> {
                    h1 = rodzajHerbaty.pobierzTypKlasy();
                    h1.setSmak(smak);
                    h1.setIlosc(ilosc);
                }
            }

            if (kupioneIlosc.get(h1) >= ilosc) {
                if (kupioneIlosc.containsKey(h1)) {
                    koszykKlienta.add(h1);
                    wartoscPortfela += cennik.cenaHerbaty(h1) * kupioneIlosc.get(h1);
                } else {
                    System.out.println("nie zakupiono takiej herbaty");
                }

            }

        } catch (NullPointerException e) {
            System.out.println("nie zakupiono takiej herbaty");
        }
    }
}