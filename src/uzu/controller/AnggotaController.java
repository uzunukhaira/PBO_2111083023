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
    
    public AnggotaController (FormAnggota view){
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
        view.getCboJenis().removeAllItems("");
        view.getCboJenis().addItem("L");
        view.getCboJenis().addItem("P");
    }
    
    public void tampil() {
        try
            DefaultTableModel tabelmodel = (DefaultTableModel)
                    view.getTabelAnggota().getModel();
            tabelModel.setRouwCount(0);
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
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            anggota = new anggota;
            anggota.setKodeanggota(view.getTxtKodeanggota().getText());
            anggota.setNamaanggota(view.getTxtNamaanggota().getText());
            anggota.setAlamat(view.getTxtAlamat().getText());
            anggota.setJeniskelamin(view.getCboJeniskelamin);
                   .getSelectedItem().toString());
            dao.insert(anggota);
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaConroller.class.getname().)log(Level.SEVERE,null,ex);  
        }
    }

}
   
