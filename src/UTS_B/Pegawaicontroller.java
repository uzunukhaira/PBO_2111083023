/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS_B;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LABP1KOMP
 */
public class Pegawaicontroller {
    private FormGaji formGaji;
    private PegawaiDao pegawaiDao;
    private Pegawai pegawai;
    private final FormGaji FormGaji;
    
    
    public Pegawaicontroller(FormGaji formGaji){
        this.FormGaji = formGaji;
        pegawaiDao = new PegawaiDaoImpl() {
            @Override
            public Pegawai getFormGaji(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    public void bersihForm(){
        formGaji.getTxtNip().setText("");
        formGaji.getTxtNama().setText("");
        formGaji.getTxtAlamat().setText("");
    }
    
    public void saveAnggota(){
        pegawai = new Pegawai();
        pegawai.setNip(formGaji.getTxtNip().getText());
        pegawai.setNama(formGaji.getTxtNama().getText());
        pegawai.setAlamat(formGaji.getTxtAlamat().getText());
        pegawaiDao.save(pegawai);
        javax.swing.JOptionPane.showMessageDialog(formGaji, 
                "Entri Ok");
    }
    
    public void getPegawai(){
        int index = formGaji.getTblPegawai().getSelectedRow();
        pegawai = pegawaiDao.getPegawai(index);
        if(pegawai != null){
            formGaji.getTxtNip().setText(pegawai.getNip());
            formGaji.getTxtNama().setText(pegawai.getNama());
            formGaji.getTxtAlamat().setText(pegawai.getAlamat());
        }
    }
    
    public void updatePegawai(){
        int index = formGaji.getTblPegawai().getSelectedRow();
        pegawai.setNip(formGaji.getTxtNip().getText());
        pegawai.setNama(formGaji.getTxtNama().getText());
        pegawai.setAlamat(formGaji.getTxtAlamat().getText());
        pegawaiDao.update(index, pegawai);
        javax.swing.JOptionPane.showMessageDialog(formGaji, 
                "Update Ok");
    }
    
    public void deletePegawai(){
        int index = formGaji.getTblPegawai().getSelectedRow();
        pegawaiDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formGaji, "Delete Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
               (DefaultTableModel) formGaji.getTblPegawai().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pegawai> list = pegawaiDao.getAll();
        for(Pegawai pegawai : list){
            Object[] data = {
                pegawai.getNip(),
                pegawai.getNama(),
                pegawai.getAlamat()
            };
            tabelModel.addRow(data); 
        }
    }

    void savePegawai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
