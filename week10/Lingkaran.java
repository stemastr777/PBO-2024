package week10;

public class Lingkaran {
    private int radius;
    private static final double pi = 3.14;

    public Lingkaran(int radius) {
        this.radius = radius;
    }

    public void luas() {
        System.out.println("Luas lingkaran: " + radius * radius * pi);
    }

    public void keliling() {
        System.out.println("Keliling lingkaran: " + 2 * radius * pi);
    }

    public int getRadius() {
        return radius;
    }
}