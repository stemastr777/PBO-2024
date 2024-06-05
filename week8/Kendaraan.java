package week8;
import java.util.ArrayList;

public class Kendaraan {

    private double berat; 
    private double tinggi; 
    private double panjang; 
    private double lebar; 
    private double kecepatan;
    private String penggerak;
    private int harga;
    private int kapasitas;


    public Kendaraan(double berat, double kecepatan, double tinggi, int kapasitas, String penggerak, int harga ) {
        this.berat = berat;
        this.kecepatan = kecepatan;
        this.tinggi = tinggi;
        this.kapasitas = kapasitas;
        this.penggerak = penggerak;
        this.harga = harga;
    }

    public void remAktif() {
        System.out.println("Rem aktif");
    }

    public void remLepas() {
        System.out.println("Rem lepas");

    }
    
    public ArrayList<double> getUkuran() {
        ArrayList<double> ukuran;
        ukuran.add()
    }

    public String getPenggerak {

    }

}