package week1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import week5.MataKuliah;
import java.time.*;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String tanggal_lahir;
    private ArrayList<Double> nilai = new ArrayList<Double>();
    private ArrayList<MataKuliah> mk = new ArrayList<MataKuliah>();
    private int usia;


    public Mahasiswa (String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public Mahasiswa (String nim, String nama, String tanggal_lahir) {
        this.nim = nim;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
    }

    public void insertNilai(Double n1) {
        nilai.add(n1);
    }

    public void belajar() {
        System.out.println(this.nama + "belajar");
    }

    public void mainGame() {
        System.out.println(this.nama + "main game");
    }

    public void getIdentitas() {
        System.out.println("Nama mahasiswa: " + this.nama);
        System.out.println("NIM mahasiswa: " + this.nim);
        System.out.println("Usia mahasiswa: " + this.usia);
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getTanggalLahir() {
        return tanggal_lahir;
    }

    public void getNilai() {
        Iterator<Double> it = nilai.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void insertMatkul(String matkul, String kelompok, int sks){
        mk.add(new MataKuliah(matkul, kelompok, sks));
    }

    public void getMatkul() {
        Iterator<MataKuliah> it = mk.iterator();
        System.out.println("\nDAFTAR NILAI\n");
        while(it.hasNext()) {
            MataKuliah m = it.next();
            System.out.println(m.getNamaMatkul() + " - " + m.getKelompok()+ " - " + m.getSks());
        }
    }

    public Period hitungUsia() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = sdf.parse(this.tanggal_lahir);

        LocalDate curDate = LocalDate.now(); 

        Period period = Period.between(dob, curDate);  
        //prints the differnce in years, months, and days  
        return period; 
    }
}