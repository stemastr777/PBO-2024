package week10;

public class Persegi extends BangunDatar {
    private int sisi;

    public Persegi(int sisi) {
        this.sisi = sisi;
    }

    public void luas() {
        System.out.println("Luas persegi: " + sisi*sisi);
    }

    public void keliling() {
        System.out.println("Keliling persegi: " + 4 * sisi);
    }

    public int getSisi() {
        return this.sisi; 
    }
}