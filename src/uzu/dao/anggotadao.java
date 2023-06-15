/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.dao;

import uzu.model.anggota;
import java.util.*;
/**
 *
 * @author User
 */
public interface anggotadao {
    void insert(anggota anggota) throws Exception;
    void update(String index,anggota anggota)throws Exception;
    void delete(String index)throws Exception;
    anggota getanggota (String kodeanggota)throws Exception;
    List <anggota> getAll()throws Exception;
}
