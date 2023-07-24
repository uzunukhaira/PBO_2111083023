/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.controller;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.util.List;

import uzu.db.*;
import uzu.dao.*;
import uzu.model.*;
import uzu.view.FormPeminjaman2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PeminjamanController2 {
    private FormPeminjaman2 form;
    private anggotadao daoAgg;
    private BukuDao daoBuku;
    private PeminjamanDao2 dao;
    private Peminjaman2 pm;
    private Connection cn;

    // Anggota agg = new Anggota();
    public PeminjamanController2(FormPeminjaman2 form) throws Exception {
        this.form = form;
        cn = DbHelper.getConnection();
        daoAgg = new anggotadaoimpl(cn);
        daoBuku = new BukuDaoimpl(cn);
        dao = new PeminjamanDaoimpl2(cn);
        pm = new Peminjaman2();

    }

    public void Clear() throws Exception {
        List<Buku> bukuD = daoBuku.getAll();
        List<anggota> aggD = daoAgg.getAll();
        form.getTxtkembali().setText("yyyy-mm-dd");
        form.getTxtpinjam().setText("yyyy-mm-dd");
        form.getCboanggota().removeAllItems();
        form.getCbobuku().removeAllItems();
        form.getCboanggota().addItem("");
        form.getCbobuku().addItem("");

        for (anggota agg : aggD) {
            form.getCboanggota().addItem(agg.getKodeanggota() + " - " + agg.getNamaanggota());
        }
        for (Buku buku : bukuD) {
            form.getCbobuku().addItem(buku.getKodebuku() + " - " + buku.getJudulbuku());
        }
    }

    public void Showdata() {
        DefaultTableModel tableModel = (DefaultTableModel) form.getTblpeminjaman().getModel();
        tableModel.setRowCount(0);
        try {
            List<Peminjaman2> List = dao.getAll();
            for (Peminjaman2 pm : List) {
                Object[] data = {
                        pm.getKodeanggota(),
                        pm.getKodebuku(),
                        pm.getTglpinjam(),
                        pm.getTglkembali()
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Klik() {
        try {
            String kode = form.getTblpeminjaman().getValueAt(form.getTblpeminjaman().getSelectedRow(), 1).toString();
            String kodeAngg = form.getTblpeminjaman().getValueAt(form.getTblpeminjaman().getSelectedRow(), 0)
                    .toString();
            String tglpinjam = form.getTblpeminjaman().getValueAt(form.getTblpeminjaman().getSelectedRow(), 2)
                    .toString();
            pm = dao.getPm2(kode, kodeAngg, tglpinjam);
            anggota agg = daoAgg.getAnggota(pm.getKodeanggota());
            Buku buku = daoBuku.getBuku(kode);
            form.getTxtkembali().setText(pm.getTglkembali());
            form.getCboanggota().setSelectedItem(pm.getKodeanggota() + " - " + agg.getNamaanggota());
            form.getCbobuku().setSelectedItem(pm.getKodebuku() + " - " + buku.getJudulbuku());
            form.getTxtpinjam().setText(pm.getTglpinjam());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e);
        }
    }

    public void Insert() {
        try {
            String[] kodeAnggota = form.getCboanggota().getSelectedItem().toString().split(" - ");
            pm.setKodeanggota(kodeAnggota[0]);
            String[] kodeBuku = form.getCbobuku().getSelectedItem().toString().split(" -");
            pm.setKodebuku(kodeBuku[0]);
            pm.setTglpinjam(form.getTxtpinjam().getText());
            pm.setTglkembali(form.getTxtkembali().getText());
            dao.Insert(pm);
            JOptionPane.showMessageDialog(form, "Insert Berhasil.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e);
        }
    }

    public void Update() {
        try {
            pm.setKodeanggota(form.getTblpeminjaman().getValueAt(form.getTblpeminjaman().getSelectedRow(), 0).toString());
            pm.setKodebuku(form.getTblpeminjaman().getValueAt(form.getTblpeminjaman().getSelectedRow(), 1).toString());
            pm.setTglpinjam(form.getTxtpinjam().getText());
            pm.setTglkembali(form.getTxtkembali().getText());
            dao.Update(pm);
            JOptionPane.showMessageDialog(form, "Update Berhasil.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void Delete() {
        try {
            String[] kodeAnggota = form.getCboanggota().getSelectedItem().toString().split(" - ");
            pm.setKodeanggota(kodeAnggota[0]);
            String[] kodeBuku = form.getCbobuku().getSelectedItem().toString().split(" -");
            pm.setKodebuku(kodeBuku[0]);
            dao.Delete(pm);
            JOptionPane.showMessageDialog(form, "Delete Berhasil.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e);
        }
    }
}
