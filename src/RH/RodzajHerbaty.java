package RH;

public enum RodzajHerbaty {
    CZARNA("Czarna", new Czarna()),
    ZIELONA("Zielona", new Zielona()),
    CZERWONA("Czerwona", new Czerwona()),
    NIEBIESKA("Niebieska", new Niebieska()),
    ROZOWA("Różowa", new Rozowa());


    private final String opis;
    private final Herbata h;


    RodzajHerbaty(String opis, Herbata h) {
        this.opis = opis;
        this.h = h;
    }

    public String pobierzOpis() {
        return opis;
    }

    public Herbata pobierzTypKlasy(){return h;}
}
