/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.dao;

import uzu.model.Peminjaman;
import uzu.model.anggota;
import uzu.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PeminjamanDaoimpl implements PeminjamanDao{
    private Connection connection;
    
    public PeminjamanDaoimpl(Connection connection){
        this.connection = connection;   
    }
    
    public void insert(Peminjaman peminjaman) throws Exception{
        String sql = "insert into peminjaman values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(5, peminjaman.getKodepeminjaman());
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodebuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, peminjaman.getTglkembali());
        ps.executeUpdate();
        ps.close();
    }
    
    public void update(Peminjaman peminjaman) throws Exception {
        String sql = "UPDATE peminjaman SET tglkembali =?  WHERE kodepeminjaman =? and kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglkembali());
        ps.setString(2, peminjaman.getKodepeminjaman());
        ps.setString(3, peminjaman.getAnggota().getKodeanggota());
        ps.setString(4, peminjaman.getBuku().getKodebuku());
        ps.setString(5, peminjaman.getTglpinjam());
        
        ps.executeUpdate();
        //ps.close(); 
    }
    
    public void delete(Peminjaman peminjaman) throws Exception {
        String sql = "DELETE FROM peminjaman WHERE kodeanggota =? and kodebuku=? and kodepeminjaman=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(3, peminjaman.getKodepeminjaman());
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodebuku());
        ps.executeUpdate();
        ps.close(); 
    }
    
    public Peminjaman getPeminjaman( String kodeanggota, String kodebuku, String tglpinjam, String kodepeminjaman) throws Exception {
        String sql = "SELECT * FROM peminjaman "
                + "WHERE kodeanggota =? and kodebuku=? and tglpinjam=? and kodepeminjaman=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(4, kodepeminjaman);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman = null;
        if(rs.next()){
            peminjaman = new Peminjaman();
            peminjaman.setKodepeminjaman(rs.getString(5));
            anggotadao anggotadao = new anggotadaoimpl(connection);
            anggota anggota = anggotadao.getAnggota(kodeanggota);
            peminjaman.setAnggota(anggota);
            BukuDao bukudao = new BukuDaoimpl(connection);
            Buku buku = bukudao.getBuku(kodebuku);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
        }
        return peminjaman;
    }
    
    public List<Peminjaman> getAll() throws Exception {
        String sql = "Select * FROM peminjaman";
        PreparedStatement ps = connection.prepareStatement(sql);
        Peminjaman peminjaman;
        ResultSet rs = ps.executeQuery();
        List<Peminjaman> list = new ArrayList<>();
        while(rs.next()){
            peminjaman = new Peminjaman();
            anggotadao anggotadao = new anggotadaoimpl(connection);
            anggota anggota = anggotadao.getAnggota(rs.getString(1));
            peminjaman.setAnggota(anggota);
            BukuDao Bukudao = new BukuDaoimpl(connection);
            Buku buku = Bukudao.getBuku(rs.getString(2));
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
            list.add(peminjaman);
        }
        return list;
    }
}