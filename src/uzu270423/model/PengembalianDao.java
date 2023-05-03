/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu270423.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uzu270423.model.Pengembalian;
/**
 *
 * @author USER
 */
public class PengembalianDao {
    
     private Connection con;

    public PengembalianDao(Connection con) {
        this.con = con;
    }

    public void insert(Pengembalian pengembalian) throws SQLException {
        String query = "insert into pengembalian values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, pengembalian.getKodeanggota());
        ps.setString(2, pengembalian.getKodebuku());
        ps.setString(3, pengembalian.getTglpinjam());
        ps.setString(4, pengembalian.getTglkembali());
        ps.setString(5, pengembalian.getTgldikembalikan());
        ps.setInt(6, pengembalian.getTerlambat());
        ps.setDouble(7, pengembalian.getDenda());
        ps.executeUpdate();
    }

    public int terlambat(String tgl1, String tgl2) throws SQLException {
        String sql = "select datediff(?,?) as selisih";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
