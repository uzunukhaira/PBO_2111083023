/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.controller;
import uzu.model.*;
import uzu.dao.*;
import uzu.view.*;
import uzu.db.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
        
/**
 *
 * @author LAB-MM
 */
public class AnggotaController {
    FormAnggota view;
    anggota anggota;
    anggotadao dao;
    Connection connection;
    
    public AnggotaController(FormAnggota view) {
        try {
            this.view = view;
            connection = DbHelper.getConnection();
            dao = new anggotadaoimpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cls(){
        view.getTxtKode().setText("");
        view.getTxtNama().setText("");
        view.getTxtAlamat().setText("");
        view.getCboJenis().removeAllItems();
        view.getCboJenis().addItem("L");
        view.getCboJenis().addItem("P");
    }
    
    public void tampil(){
        try {
             DefaultTableModel tabelModel = (DefaultTableModel) view.getTblAnggota().getModel();
             tabelModel.setRowCount(0);
             List<anggota> list = dao.getAll();
             for(anggota a : list){
                 Object[]row = {
                     a.getKodeanggota(),
                     a.getNamaanggota(),
                     a.getAlamat(),
                     a.getJeniskelamin()
                 };
                 tabelModel.addRow(row);
             }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void insert(){
        try {
            anggota = new anggota();
            anggota.setKodeanggota(view.getTxtKode().getText());
            anggota.setNamaanggota(view.getTxtNama().getText());
            anggota.setAlamat(view.getTxtAlamat().getText());
            anggota.setJeniskelamin(view.getCboJenis().getSelectedItem().toString());
            dao.insert(anggota);
            JOptionPane.showMessageDialog(view, "tambah data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(anggota);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void tabelKlik(){
        try {
            String kodeanggota = view.getTblAnggota().getValueAt(view.getTblAnggota().getSelectedRow(),0).toString();
            anggota = dao.getAnggota(kodeanggota);
            view.getTxtKode().setText(anggota.getKodeanggota());
            view.getTxtNama().setText(anggota.getNamaanggota());
            view.getCboJenis().setSelectedItem(anggota.getJeniskelamin());
            view.getTxtAlamat().setText(anggota.getAlamat());
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void update(){
        try {
            anggota.setKodeanggota(view.getTxtKode().getText());
            anggota.setNamaanggota(view.getTxtNama().getText());
            anggota.setAlamat(view.getTxtAlamat().getText());
            anggota.setJeniskelamin(view.getCboJenis().getSelectedItem().toString());
            dao.update(anggota);
            JOptionPane.showMessageDialog(view,"update data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        
    
}
   
