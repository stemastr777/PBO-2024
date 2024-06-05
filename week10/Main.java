package week10;

import java.util.Scanner;

class Main {

    public static void main(String[] args) { 


        /* 
            UNCOMMENT KODE DI BAWAH INI UNTUK VALIDASI FUNGSIONALITAS SETIAP METHOD LUAS() DAN KELILING()
        */

        // Segitiga segitiga_1 = new Segitiga(2,3);

        // Lingkaran lingkaran_1 = new Lingkaran(2);

        // Persegi persegi_1 = new Persegi(2);
        
        // PersegiPanjang persegipanjang_1 = new PersegiPanjang(2, 1);

        // segitiga_1.luas();
        // lingkaran_1.luas();
        // persegi_1.luas();
        // persegipanjang_1.luas();    

        // segitiga_1.keliling();
        // lingkaran_1.keliling();
        // persegi_1.keliling();
        // persegipanjang_1.keliling();


        int bentuk = -1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("PILIHAN BENTUK:\n\n" + "1. Persegi\n2. Persegi panjang\n3. Segitiga\n4. Lingkaran\n\nMasukkan nomor bentuk: ");

        bentuk = scanner.nextInt();

        // Validasi input bentuk
        while ( (bentuk < 1) || (bentuk > 4) ) {
            System.out.print("Tidak valid (nomor perlu diantara 1-4): ");
            bentuk = scanner.nextInt();
        } 
        

        if (bentuk == 1) {

            int sisi;

            System.out.print("Sisi: ");
            sisi = scanner.nextInt();

            Persegi persegi = new Persegi(sisi);

            persegi.luas();
            persegi.keliling();
        } else if (bentuk == 2) {

            int panjang;
            int lebar;

            System.out.print("Panjang: ");
            panjang = scanner.nextInt();

            System.out.print("Lebar: ");
            lebar = scanner.nextInt();

            PersegiPanjang persegi_panjang = new PersegiPanjang(panjang, lebar);

            persegi_panjang.luas();
            persegi_panjang.keliling();

        } else if (bentuk == 3) {
            
            int alas;
            int tinggi;

            System.out.print("Alas: ");
            alas = scanner.nextInt();

            System.out.print("Tinggi: ");
            tinggi = scanner.nextInt();

            Segitiga segitiga = new Segitiga(alas, tinggi);

            segitiga.luas();
            segitiga.keliling();
        } else if (bentuk == 4) {

            int radius;

            System.out.print("Radius: ");
            radius = scanner.nextInt();

            Lingkaran lingkaran = new Lingkaran(radius);

            lingkaran.luas();
            lingkaran.keliling();
        }

    }
}