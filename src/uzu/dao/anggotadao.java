/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.dao;

import java.util.*;
/**
 *
 * @author User
 */
public interface anggotadao {
    void insert(uzu.model.anggota anggota) throws Exception;
    void update(uzu.model.anggota anggota) throws Exception;
    void delete(uzu.model.anggota anggota) throws Exception;
    uzu.model.anggota getAnggota(String kodeanggota) throws Exception;
    List<uzu.model.anggota> getAll() throws Exception;
}
