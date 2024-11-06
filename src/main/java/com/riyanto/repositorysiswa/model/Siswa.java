package com.riyanto.repositorysiswa.model;


public class Siswa {

    private String nis, nama, jk, alamat;

    public Siswa(String nis, String nama, String jk, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.jk = jk;
        this.alamat = alamat;
    }

    public String getNis() {
        return nis;
    }

    public String getNama() {
        return nama;
    }

    public String getJk() {
        return jk;
    }

    public String getAlamat() {
        return alamat;
    }
    
    
}
