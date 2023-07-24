/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.model;

/**
 *
 * @author USER
 */
public class Pengembalian {
    private String kodeanggota;
    private String namaanggota;
    private String kodebuku;
    private String judulbuku;
    private String tglpiinjam;
    private String tglkembali;
    private String dikembalikan;
    private int terlambat;
    private double denda;
    
    public Pengembalian(){}

    public Pengembalian(String kodeanggota, String namaanggota, String kodebuku, String judulbuku, String tglpiinjam, String tglkembali, String dikembalikan, int terlambat, double denda) {
        this.kodeanggota = kodeanggota;
        this.namaanggota = namaanggota;
        this.kodebuku = kodebuku;
        this.judulbuku = judulbuku;
        this.tglpiinjam = tglpiinjam;
        this.tglkembali = tglkembali;
        this.dikembalikan = dikembalikan;
        this.terlambat = terlambat;
        this.denda = denda;
    }

    public String getKodeanggota() {
        return kodeanggota;
    }

    public void setKodeanggota(String kodeanggota) {
        this.kodeanggota = kodeanggota;
    }

    public String getNamaanggota() {
        return namaanggota;
    }

    public void setNamaanggota(String namaanggota) {
        this.namaanggota = namaanggota;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setKodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public String getTglpiinjam() {
        return tglpiinjam;
    }

    public void setTglpiinjam(String tglpiinjam) {
        this.tglpiinjam = tglpiinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public String getDikembalikan() {
        return dikembalikan;
    }

    public void setDikembalikan(String dikembalikan) {
        this.dikembalikan = dikembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public double getDenda() {
        denda = terlambat * 1000;
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }
    
    
}