package week9;

class BangunDatar {

    private int sisi;
    private int diameter;
    private int lebar;
    private int panjang;
    private int tinggi;
    private int alas;
    private static final double pi = 3.14;


    public BangunDatar(int sisi) {
        this.sisi = sisi;
        this.diameter = sisi;
    }

    public BangunDatar(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.alas = panjang;
        this.tinggi = lebar;
    }

    public int luas(int a) {
        return a*a;
    }

    public int luas(int a, int b) {
        return a*b;
    }

    public double luas(double a, double b) {
        return a*b/2;
    }

    public double luas(double a) {
        return pi*a*a;
    }

    public int keliling(int a) {
        return 4*a;
    }

    public int keliling(int a, int b) {
        return 2*(a+b);
    }

    public double keliling(double a, double b) {
        double sisi_miring = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return a+b+sisi_miring;
    }

    public double keliling(double a) {
        return pi*2*a;
    }
}