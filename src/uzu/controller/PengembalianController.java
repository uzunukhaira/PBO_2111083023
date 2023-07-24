/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu.controller;

import uzu.db.*;
import uzu.dao.*;
import uzu.model.*;
import uzu.view.FormPengembalian;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PengembalianController {
    private FormPengembalian form;
    private anggotadao daoAgg;
    private BukuDao daoBuku;
    private PengembalianDao dao;
    private Pengembalian pg;
    private Connection cn;

    public PengembalianController(FormPengembalian form) throws Exception {
        this.form = form;
        cn = DbHelper.getConnection();
        daoAgg = new anggotadaoimpl(cn);
        daoBuku = new BukuDaoimpl(cn);
        dao = new PengembalianDaoimpl(cn);
        pg = new Pengembalian();
    }

    public void Clear() {
        try {
            form.getBtnreturn().setEnabled(false);
            List<Buku> bukuD = daoBuku.getAll();
            List<anggota> aggD = daoAgg.getAll();
            form.getTxtdenda().setText("");
            form.getCboanggota().removeAllItems();
            form.getCbobuku().removeAllItems();
            form.getTxtdikembalikan().setText("");
            form.getTxtterlambat().setText("");
            form.getTxtcari().setText("");
            form.getTxtpinjam().setText("");
            for (anggota agg : aggD) {
                form.getCboanggota().addItem(agg.getKodeanggota());
            }
            for (Buku buku : bukuD) {
                form.getCbobuku().addItem(buku.getKodebuku());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void getPengemballian() {
        try {
            form.getBtnreturn().setEnabled(true);
            String tanggalPinjam = form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 4)
                    .toString();
            String tanggalkembali = form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 5)
                    .toString();
            form.getCboanggota()
                    .setSelectedItem(form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 0)
                            .toString());
            form.getCbobuku()
                    .setSelectedItem(form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 2)
                            .toString());
            form.getTxtpinjam()
                    .setText(tanggalPinjam);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tglDikembalikan = format.format(new java.util.Date());
            form.getTxtdikembalikan().setText(tglDikembalikan);
            int terlambat = dao.terlambat(tglDikembalikan, tanggalkembali);
            pg.setTerlambat(terlambat);
            form.getTxtterlambat().setText("" + terlambat);
            form.getTxtdenda().setText((String.valueOf(pg.getDenda())));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, null, 0);
        }
    }

    public void Showdata() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) form.getTblpengembalian().getModel();
            tableModel.setRowCount(0);
            List<Pengembalian> List = dao.getAll();
            for (Pengembalian pm : List) {
                Object[] data = {
                        pm.getKodeanggota(),
                        pm.getNamaanggota(),
                        pm.getKodebuku(),
                        pm.getJudulbuku(),
                        pm.getTglpiinjam(),
                        pm.getTglkembali(),
                        pm.getDikembalikan(),
                        pm.getTerlambat(),
                        pm.getDenda()
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void cari() {
        try {
            String kode = form.getTxtcari().getText();
            DefaultTableModel tableModel = (DefaultTableModel) form.getTblpengembalian().getModel();
            tableModel.setRowCount(0);
            List<Pengembalian> List = dao.cari(kode);
            if (List.isEmpty()) {
                JOptionPane.showMessageDialog(form, "Kode Anggota '" + kode + "' Tidak dapat ditemukan");
            } else {
                for (Pengembalian pm : List) {
                    Object[] data = {
                            pm.getKodeanggota(),
                            pm.getNamaanggota(),
                            pm.getKodebuku(),
                            pm.getJudulbuku(),
                            pm.getTglpiinjam(),
                            pm.getTglkembali(),
                            pm.getDikembalikan(),
                            pm.getTerlambat(),
                            pm.getDenda()
                    };
                    tableModel.addRow(data);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, null, 0);
        }
    }

    public void insert() {
        try {
            pg.setKodeanggota(form.getCboanggota().getSelectedItem().toString());
            pg.setKodebuku(form.getCbobuku().getSelectedItem().toString());
            pg.setTglpiinjam(form.getTxtpinjam().getText());
            pg.setDikembalikan(form.getTxtdikembalikan().getText());
            pg.setTerlambat(Integer.parseInt(form.getTxtterlambat().getText()));
            pg.setDenda(Double.parseDouble(form.getTxtdenda().getText()));
            dao.insert(pg);
            JOptionPane.showMessageDialog(form, "Berhasil Mengembalikan Buku.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "Tidak dapat melakukan pengembalian!", null, 0);
        }
    }

    public void delete() {
        try {
            pg.setKodeanggota(form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 0)
                    .toString());
            pg.setKodebuku(form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 2)
                    .toString());
            pg.setTglpiinjam(form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 4)
                    .toString());
            dao.delete(pg);
            JOptionPane.showMessageDialog(form, "Data pada pengembalian berhasil dihapus!", null, 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int Dikembalikan() throws Exception {
        String tglDikembalikan = form.getTxtdikembalikan().getText();
        String tanggalkembali = form.getTblpengembalian().getValueAt(form.getTblpengembalian().getSelectedRow(), 5)
                .toString();
        int terlambat = dao.terlambat(tglDikembalikan, tanggalkembali);
        form.getTxtterlambat().setText("" + terlambat);
        form.getTxtdikembalikan().setText(tglDikembalikan);
        form.getTxtdenda().setText((String.valueOf(terlambat * 1000)));
        return terlambat;
    }

    public void update() {
        try {
            pg.setKodeanggota(form.getCboanggota().getSelectedItem().toString());
            pg.setKodebuku(form.getCbobuku().getSelectedItem().toString());
            pg.setTglpiinjam(form.getTxtpinjam().getText());
            pg.setDikembalikan(form.getTxtdikembalikan().getText());
            pg.setTerlambat(Integer.parseInt(form.getTxtterlambat().getText()));
            pg.setDenda(Double.parseDouble(form.getTxtdenda().getText()));
            dao.update(pg);
            JOptionPane.showMessageDialog(form, "Data Pengembalian telah dirubah!", null, 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
