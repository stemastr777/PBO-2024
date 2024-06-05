package responsi;

import responsi.Pegawai;
import java.util.*;

public class ArrayPegawai {

    public static void main(String[] args) {
        
        // private KumpulanPegawai<Pegawai> = new ArrayList<Pegawai>();

        int n;
        System.out.print("Masukkan jumlah data:");


        Scanner inp = new Scanner(System.in);
        n = inp.nextInt();

        String[] nama = new String[n];
        String[] departemen = new String[n];
        int[] usia = new int[n]; 
        double[] gaji = new double[n]; 
        int[] masaKerja = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Data ke-"+(i+1));
            System.out.println("Masukkan Nama: ");
            nama[i] = inp.next();
            System.out.println("Masukkan Departemen: ");
            departemen[i] = inp.next();
            System.out.println("Masukkan usia: ");
            usia[i] = inp.nextInt();
            System.out.println("Masukkan gaji: ");
            gaji[i] = inp.nextDouble();
            System.out.println("Masukkan masa kerja: ");
            masaKerja[i] = inp.nextInt();
            
        } 

        Pegawai[] kumpulan_pegawai = new Pegawai[n];
        for (int i = 0; i < n; i++) {
            kumpulan_pegawai[i] = new Pegawai(nama[i], departemen[i], usia[i], gaji[i], masaKerja[i]);
            kumpulan_pegawai[i].getIdentitas();
        }
    }

}