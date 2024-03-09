package mainsource;

public class Tabung {
    Integer diameter = 5;
    Integer tinggi = 10;
    static final Float phi = 3.14f;

    public Float HitungVolume() {
        Float jari = (float) (diameter/2);
        Float luas_lingkaran = phi * jari * jari;

        return luas_lingkaran;
    }
}
