package week4;

import week1.Mahasiswa;
import java.util.*;

public class Akademik {

    public static void main(String[] args) {

        int n;
        System.out.print("Masukkan jumlah data:");


        Scanner inp = new Scanner(System.in);
        n = inp.nextInt();

        String[] nim = new String[n];
        String[] nama = new String[n];
        Double[] ipk = new Double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Data ke-"+(i+1));
            System.out.println("Masukkan NIM: ");
            nim[i] = inp.next();
            System.out.println("Masukkan Nama: ");
            nama[i] = inp.next();
            System.out.println("Masukkan IPK: ");
            ipk[i] = inp.nextDouble();
        }
        
        Mahasiswa[] mhs = new Mahasiswa[n];
        for (int i = 0; i < n; i++) {
            mhs[i] = new Mahasiswa(nim[i], nama[i], ipk[i]);
            mhs[i].getIdentitas();
        }
        
    }
    
}