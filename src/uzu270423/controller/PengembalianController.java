/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzu270423.controller;

import uzu270423.model.AnggotaDao;
import uzu270423.model.BukuDao;
import uzu270423.model.Koneksi;
import uzu270423.model.PeminjamanDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uzu270423.view.FormPengembalian;
/**
 *
 * @author LABP1KOMP
 */
public class PengembalianController {
    FormPengembalian view;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    Connection connection;
    Koneksi k;
    String[] tkodeAnggota;
    String[] tkodeBuku;

    public PengembalianController(FormPengembalian view) {
        try {
            this.view = view;
            this.peminjamanDao = new PeminjamanDao(connection){};
            this.anggotaDao = new AnggotaDao(connection){};
            this.bukuDao = new BukuDao(connection) {};
            this.k = new Koneksi();
            this.con = k.getConnection();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
