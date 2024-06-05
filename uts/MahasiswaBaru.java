package uts;

import week1.Mahasiswa;
import java.util.*;
import uts.BiayaKuliah;

public class MahasiswaBaru extends Mahasiswa{

    private String nomor_pendaftaran;
    private String asal_sekolah;
    private String progdi;
    private ArrayList<BiayaKuliah> biaya; // gedung, spp, poliklinik
    private double potongan = 0.1; // pasto 10%
    private double jumlah_tagihan;


    public MahasiswaBaru(String nim, String nama, String tanggal_lahir, String asal_sekolah) {

        super.nim = nim;
        super.nama = nama;
        super.tanggal_lahir = tanggal_lahir;
        this.asal_sekolah = asal_sekolah;

        public biaya_temp = new BiayaKuliah();
        
        if (progdi=='A11' or progdi='A12') {
            biaya_temp.setBiayaGedung(30000000);
        } else if (progdi == 'A14') {
            biaya_temp.setBiayaGedung(27500000);
        } else if (progdi == 'A15') {
            biaya_temp.setBiayaGedung(25000000);
        } else {
            biaya_temp.setBiayaGedung(22500000);
        }

        biaya_temp.setBiayaSPP(3000000);
        biaya_temp.setBiayaPoliklinik(250000);

        biaya.add(biaya_temp);

        this.jumlah_tagihan = this.biaya[0].biaya_gedung + this.biaya[0].biaya_spp + this.biaya[0].biaya_poliklinik;

    } 

    public showData() {
        System.println.out("Nim: "+super.getNim());
        System.println.out("Nama: "+super.getNama());
        System.println.out("Tanggal lahir: "+super.getTanggalLahir());
        System.println.out("Usia: "+ super.hitungUsia().getYears() + "tahun"+ super.hitungUsia().getMonths() + "bulan");
        System.println.out("Nomor pendaftaran: "+this.nomor_pendaftaran);
        System.println.out("Jumlah tagihan: "+this.jumlah_tagihan);
        System.println.out("Diskon: "+this.potongan);
        System.println.out("Tagihan yang harus dibayar: "+this.jumlah_tagihan-(this.jumlah_tagihan*this.potongan));
    }
}