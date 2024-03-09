package mainsource;

public class Lingkaran {
    Integer diameter = 10;
    static final Float phi = 3.14f;

    public Float HitungKeliling() {

        Float keliling = 2 * phi * this.diameter;

        return keliling;
    }
}

