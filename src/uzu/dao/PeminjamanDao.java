/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uzu.dao;

import uzu.model.Peminjaman;
import java.util.List;

/**
 *
 * @author User
 */
public interface PeminjamanDao {
    void insert(Peminjaman peminjaman) throws Exception;
    void update(Peminjaman peminjaman) throws Exception;
    void delete(Peminjaman peminjaman) throws Exception;
    Peminjaman getPeminjaman( String kodeanggota, String kodebuku, String tglpinjam, String kodepeminjaman) throws Exception;
    List<Peminjaman> getAll() throws Exception;
}

