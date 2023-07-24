/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uzu.dao;

import uzu.model.Peminjaman2;
import java.util.List;

/**
 *
 * @author User
 */
public interface PeminjamanDao2 {
    void Insert(Peminjaman2 pm) throws Exception;

    void Update(Peminjaman2 pm) throws Exception;

    void Delete(Peminjaman2 pm) throws Exception;

    Peminjaman2 getPm2(String kodeBuku, String kodeanggota, String tglpinjam) throws Exception;

    List<Peminjaman2> getAll() throws Exception;
}