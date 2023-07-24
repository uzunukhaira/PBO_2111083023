/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uzu.dao;

import java.util.List;
import uzu.model.*;

/**
 *
 * @author LAB-MM
 */
public interface BukuDao {
    void insert(Buku buku) throws Exception;
    void update(Buku buku) throws Exception;
    void delete(Buku buku) throws Exception;
    Buku getBuku(String kodebuku) throws Exception;
    List<Buku> getAll() throws Exception;
}
