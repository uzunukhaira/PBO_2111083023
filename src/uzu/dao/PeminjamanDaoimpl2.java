/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.dao;

import uzu.dao.anggotadao;
import uzu.dao.anggotadaoimpl;
import uzu.dao.PeminjamanDao2;
import uzu.model.Peminjaman2;
import uzu.view.FormPeminjaman2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PeminjamanDaoimpl2 implements PeminjamanDao2{
    private Connection cn;
    private Peminjaman2 pm = new Peminjaman2();
    private anggotadao dao;
    private FormPeminjaman2 form;

    public PeminjamanDaoImpl2(Connection cn) throws Exception {
        this.cn = cn;
        dao = new anggotadaoimpl(cn);
    }

    public void Insert(Peminjaman2 pm) throws Exception {
        String insert = "INSERT INTO Peminjaman2 VALUES(?,?,?,?)";
        PreparedStatement ps = cn.prepareStatement(insert);
        ps.setString(1, pm.getKodeanggota());
        ps.setString(2, pm.getKodebuku());
        ps.setString(3, pm.getTglpinjam());
        ps.setString(4, pm.getTglkembali());
        ps.executeUpdate();
    }

    public void Update(Peminjaman2 pm) throws Exception {
        String update = "UPDATE Peminjaman2 set kodeBuku =?, kodeanggota =?, tglpinjam =?, tglkembali =? WHERE kodeBuku = ? && kodeAnggota = ? && tglpinjam = ?";
        PreparedStatement ps = cn.prepareStatement(update);
        ps.setString(4, pm.getTglkembali());
        ps.setString(1, pm.getKodebuku());
        ps.setString(2, pm.getKodeanggota());
        ps.setString(3, pm.getTglpinjam());
        ps.setString(5, pm.getKodebuku());
        ps.setString(6, pm.getKodeanggota());
        ps.setString(7, pm.getTglpinjam());
        ps.executeUpdate();
    }

    public void Delete(Peminjaman2 pm) throws Exception {
        String delete = "DELETE FROM Peminjaman2 WHERE kodeBuku = ? && kodeanggota = ? && tglpinjam = ?";
        PreparedStatement ps = cn.prepareStatement(delete);
        ps.setString(1, pm.getKodebuku());
        ps.setString(2, pm.getKodeanggota());
        ps.setString(3, pm.getTglpinjam());
        ps.executeUpdate();
    }

    public Peminjaman2 getPm2(String kodeBuku, String kodeanggota, String tglpinjam) throws Exception {
        String get = "SELECT * FROM Peminjaman2 WHERE kodeBuku= ? && kodeanggota = ? && tglpinjam = ?";
        PreparedStatement ps = cn.prepareStatement(get);
        ps.setString(1, kodeBuku);
        ps.setString(2, kodeanggota);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pm = new Peminjaman2();
            pm.setKodeanggota(rs.getString(1));
            pm.setKodebuku(rs.getString(2));
            pm.setTglpinjam(rs.getString(3));
            pm.setTglkembali(rs.getString(4));
        }
        return pm;
    }

    public List<Peminjaman2> getAll() throws Exception {
        String tampil = "SELECT * FROM Peminjaman2";
        PreparedStatement ps = cn.prepareStatement(tampil);
        ResultSet rs = ps.executeQuery();
        List<Peminjaman2> data = new ArrayList<>();
        while (rs.next()) {
            pm = new Peminjaman2();
            pm.setKodeanggota(rs.getString(1));
            pm.setKodebuku(rs.getString(2));
            pm.setTglpinjam(rs.getString(3));
            pm.setTglkembali(rs.getString(4));
            data.add(pm);
        }
        return data;
    }
}