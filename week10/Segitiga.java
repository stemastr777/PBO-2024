package week10;

class Segitiga extends BangunDatar {

    private int alas;
    private int tinggi;

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public void luas() {
        System.out.println("Luas segitiga: " + alas*tinggi/2);
    }

    public void keliling() {
        System.out.println("Keliling segitiga (sama sisi): " + alas*3);
    }

    public int getTinggi() {
        return tinggi;
    }

    public int getAlas() {
        return alas;
    }
}