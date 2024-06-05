package responsi;

public class Pegawai {
    private String nama;
    private String departemen;
    private int usia;
    private double gaji;
    private int masaKerja;

    public Pegawai (String nama, String departemen, int usia, double gaji, int masaKerja) {
        this.nama = nama;
        this.departemen = departemen;
        this.usia = usia;
        this.gaji = gaji;
        this.masaKerja = masaKerja;

        if (this.gaji > 5000000) {
            this.gaji *= 0.99;
        }
    }

    public void getIdentitas() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Departemen: " + this.departemen);
        System.out.println("Usia: " + this.usia);
        System.out.println("Gaji: " + this.gaji);
        System.out.println("Masa kerja: " + this.masaKerja);
        System.out.println("THR: " + alokasiTHR());
    }

    public double alokasiTHR() {
        double thr; 

        if (this.masaKerja < 1) {
            thr = 0.1 * 5 * this.gaji;
        } else if (this.masaKerja >= 1 && this.masaKerja <= 5) {
            thr = 0.2 * 5 * this.gaji;
        } else {
            thr = 0.35 * 5 * this.gaji;
        }

        return thr;
    }


}