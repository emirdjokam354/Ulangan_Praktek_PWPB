package com.example.ulangan_praktek_pwpb;

public class Siswa {
    String Siswaid;
    String SiswaJudul;
    String SiswaDeskripsi;

    public Siswa(){

    }

    public Siswa(String siswaid, String siswaJudul, String siswaDeskripsi) {
        this.Siswaid = siswaid;
        this.SiswaJudul = siswaJudul;
        this.SiswaDeskripsi = siswaDeskripsi;
    }

    public String getSiswaid() {
        return Siswaid;
    }

    public String getSiswaJudul() {
        return SiswaJudul;
    }

    public String getSiswaDeskripsi() {
        return SiswaDeskripsi;
    }
}
