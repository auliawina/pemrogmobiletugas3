package com.example.uts.model;

import java.io.Serializable;

public class produk implements Serializable {
    private String jenis;
    private String nama;
    private String waktu;
    private String rate;
    private String kalori;
    private String deskripsi;
    private String harga;
    private int drawable;

    public produk(String jenis, String nama, String waktu, String rate,String kalori, String deskripsi, String harga, int drawable) {
        this.jenis = jenis;
        this.nama = nama;
        this.waktu = waktu;
        this.rate = rate;
        this.kalori = kalori;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.drawable = drawable;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
