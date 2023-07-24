/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.model;

/**
 *
 * @author USER
 */
public class Peminjaman {
    private anggota anggota;
    private Buku buku;
    private String tglpinjam;
    private String tglkembali;
    private String kodepeminjaman;
    
    public Peminjaman(){}

    public Peminjaman( anggota anggota, Buku buku, String tglpinjam, String tglkembali, String kodepeminjaman) {
        this.anggota = anggota;
        this.buku = buku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
        this.kodepeminjaman = kodepeminjaman;
    }

    public anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
    
    public String getKodepeminjaman() {
        return kodepeminjaman;
    }

    public void setKodepeminjaman(String kodepeminjaman) {
        this.kodepeminjaman = kodepeminjaman;
    }   
}