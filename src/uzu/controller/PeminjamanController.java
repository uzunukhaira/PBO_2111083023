/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.controller;
import uzu.model.*;
import uzu.dao.*;
import uzu.db.*;
import uzu.view.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author User
 */
public class PeminjamanController {
    FormPeminjaman view;
    anggota anggota;
    Buku buku;
    BukuDao dao;
    anggotadao Dao;
    PeminjamanDao pm;
    Peminjaman pemi;
    Connection connection;
    
    public PeminjamanController(FormPeminjaman view) {
        try {
            this.view = view;
            connection = DbHelper.getConnection();
            dao = new BukuDaoimpl(connection);
            Dao = new anggotadaoimpl(connection);
            pm = new PeminjamanDaoimpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cls() {
        view.getTxtkodepeminjaman().setText("");
        view.getTxtpinjam().setText("yyyy-mm-dd");
        view.getTxtkembali().setText("yyyy-mm-dd");
    }
    
    public void isicombo(){
        try {
        List<anggota> anggota = Dao.getAll();
        List<Buku> buku = dao.getAll();
        view.getCboanggota().removeAllItems();
        view.getCbobuku().removeAllItems();
        
        for (anggota ang : anggota){
            view.getCboanggota().addItem(ang.getKodeanggota() + " - " + ang.getNamaanggota());
        }
        
        for (Buku buk : buku){
            view.getCbobuku().addItem(buk.getKodebuku() + " - " + buk.getJudulbuku());
        }
        } catch (Exception ex){
        Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void tampil(){
        try {
             DefaultTableModel tabelModel = (DefaultTableModel) view.getTblpeminjaman().getModel();
             tabelModel.setRowCount(0);
             List<Peminjaman> list = pm.getAll();
             for(Peminjaman pemi : list){
                 Object[]row = {
                     pemi.getAnggota().getKodeanggota(),
                     pemi.getBuku().getKodebuku(),
                     pemi.getTglpinjam(),
                     pemi.getTglkembali(),
                     pemi.getKodepeminjaman()
                 };
                 tabelModel.addRow(row);
             }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void insert(){
        try {
            pemi = new Peminjaman();
            String selectedAnggota = view.getCboanggota().getSelectedItem().toString();
            String kodeanggota = selectedAnggota.split("-")[0].trim();
            anggota = Dao.getAnggota(kodeanggota);
            
            String selectedBuku = view.getCbobuku().getSelectedItem().toString();
            String kodebuku = selectedBuku.split("-")[0].trim();
            buku = dao.getBuku(kodebuku);
            
            
            pemi.setAnggota(anggota);
            pemi.setBuku(buku);
            pemi.setTglpinjam(view.getTxtpinjam().getText());
            pemi.setTglkembali(view.getTxtkembali().getText());
            pemi.setKodepeminjaman(view.getTxtkodepeminjaman().getText());
            pm.insert(pemi);
            JOptionPane.showMessageDialog(view, "tambah data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(){
        try {
            String KodePeminjaman = view.getTblpeminjaman().getValueAt(view.getTblpeminjaman().getSelectedRow(), 0).toString();
            pemi = pm.getPeminjaman("","","",KodePeminjaman);
        
            pm.delete(pemi);
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus.");
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(view, ex.getMessage());
        Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void tabelKlik(){
        try {
            String kodepeminjaman = view.getTblpeminjaman().getValueAt(view.getTblpeminjaman().getSelectedRow(),3).toString();
            String kodeanggota = view.getTblpeminjaman().getValueAt(view.getTblpeminjaman().getSelectedRow(),0).toString();
            String kodebuku = view.getTblpeminjaman().getValueAt(view.getTblpeminjaman().getSelectedRow(),1).toString();
            String tglpinjam = view.getTblpeminjaman().getValueAt(view.getTblpeminjaman().getSelectedRow(),2).toString();
            pemi = pm.getPeminjaman(kodeanggota,kodebuku,tglpinjam,kodepeminjaman);
            anggota ang = Dao.getAnggota(kodeanggota);
            Buku buk = dao.getBuku(kodebuku);
            view.getCboanggota().setSelectedItem(pemi.getAnggota().getKodeanggota());
            view.getCbobuku().setSelectedItem(pemi.getBuku().getKodebuku());
            view.getTxtpinjam().setText(pemi.getTglpinjam());
            view.getTxtkembali().setText(pemi.getTglkembali());
            view.getTxtkodepeminjaman().setText(pemi.getKodepeminjaman());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void update(){
        try {
            String selectedAnggota = view.getCboanggota().getSelectedItem().toString();
            String kodeanggota = selectedAnggota.split("-")[0].trim();
            anggota anggota = Dao.getAnggota(kodeanggota);
            
            String selectedBuku = view.getCbobuku().getSelectedItem().toString();
            String kodebuku = selectedBuku.split("-")[0].trim();
            Buku buku = dao.getBuku(kodebuku);
            
            pemi.setAnggota(anggota);
            pemi.setBuku(buku);
            pemi.setTglpinjam(view.getTxtpinjam().getText());
            pemi.setTglkembali(view.getTxtkembali().getText());
            String kodepeminjaman = view.getTxtkodepeminjaman().getText();
            Peminjaman peminjaman = pm.getPeminjaman("","","",kodepeminjaman);
            if (peminjaman == null) {
                JOptionPane.showMessageDialog(view, "Peminjaman tidak ditemukan.");
                return;
            }
            pm.update(pemi);
            JOptionPane.showMessageDialog(view,"update data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
