package RH;

import java.util.Objects;

//jako produkt
public abstract class Herbata {

    private String smak;
    private double ilosc;

    public Herbata(){
        this.smak = null;
    }

    public Herbata(String smak, int ilosc) {         //konstruktor do listy
        this.smak = smak;
        this.ilosc = ilosc;
    }

    private int cenaZaKg;
    private int progPromocji=0;
    private int cenaZaMniej;  //wieksza
    private int cenaZaWiecej; //mniejsza

    public Herbata(String smak, int progPromocji, int cenaZaMniej, int cenaZaWiecej, boolean cennik){          //konstruktor do cennika 1
        this.smak = smak;
        this.progPromocji = progPromocji;
        this.cenaZaMniej = cenaZaMniej;
        this.cenaZaWiecej = cenaZaWiecej;

    }

    public Herbata(String smak, int cenaZaKg, boolean cennik){   //konstruktor do cennika 2
        this.smak = smak;
        this.cenaZaKg = cenaZaKg;

    }

    // dodaje zmienna logiczna 'cennik' aby rozwiazac problem tych samych typow danych w przypadku herbarty do koszyka i dwuargumentowego konstruktora herbaty do koszyka



    //GETTERY
    public String getSmak() {
        return smak;
    }

    public double getIlosc() {return ilosc;}

    public int getCenaZaMniej() {return cenaZaMniej;}

    public int getCenaZaWiecej() {return cenaZaWiecej;}

    public int getProgPromocji() {return progPromocji;}

    public int getCenaZaKg() {return cenaZaKg;}

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }
    //SETTERY

    public void setSmak(String smak) {
        this.smak = smak;
    }

    public void setProgPromocji(int progPromocji) {
        this.progPromocji = progPromocji;
    }

    public void setCenaZaMniej(int cenaZaMniej) {
        this.cenaZaMniej = cenaZaMniej;
    }

    public void setCenaZaWiecej(int cenaZaWiecej) {
        this.cenaZaWiecej = cenaZaWiecej;
    }

    public void setCenaZaKg(int cenaZaKg) {
        this.cenaZaKg = cenaZaKg;
    }

    //OVERRIDY
    @Override
    public String toString() {
        return
                "smak: " + smak +
                ", ilosc " + ilosc + "kg ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herbata herbata = (Herbata) o;
        return ((Herbata) o).smak.equals(getSmak());
    }

    @Override
    public int hashCode() {
        return Objects.hash(smak);
    }
}
