/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uzu.dao;
import uzu.model.Pengembalian;
import java.util.List;
/**
 *
 * @author User
 */
public interface PengembalianDao {
    void insert(Pengembalian pg) throws Exception;
    void update(Pengembalian pg) throws Exception;
    void delete(Pengembalian pg) throws Exception;
    Pengembalian getPm(String kodebuku, String kodeanggota, String tglpinjam) throws Exception;
    List<Pengembalian> getAll() throws Exception;
    int terlambat (String tgl1, String tgl2) throws Exception;
    List<Pengembalian> cari(String kode) throws Exception;
}
