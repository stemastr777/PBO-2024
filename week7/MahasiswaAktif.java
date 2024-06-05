package week7;

import week1.Mahasiswa;

public class MahasiswaAktif extends Mahasiswa {

    public int usia;
    public int semester;
    private String nama;

    public MahasiswaAktif(String nim, String nama, String tanggal_lahir, int semester) {
        super(nim, nama, tanggal_lahir);
        this.semester = semester;
        // this.nama = "IMPOSTOR!!!";
    }

    public void getIdentitas() {
        System.out.println("Nama mahasiswa: " + super.getNama());
        System.out.println("NIM mahasiswa: " + super.getNim());
        System.out.println("Tanggal lahir: " + super.getTanggalLahir());
        System.out.println("Usia: " + getUsia());
        System.out.println("Tanggal lahir: " + getSemester());
        System.out.println("Impostor: " + this.nama);

    }

    public int getUsia() {
        return this.usia;
    }

    public int getSemester() {
        return this.semester;
    }

    public void setUsia(int usia) {
        this.usia = usia; 
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

}