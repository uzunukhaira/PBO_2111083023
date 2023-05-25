/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS_B;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LABP1KOMP
 */
public abstract class PegawaiDaoImpl implements PegawaiDao {
    List<Pegawai> data = new ArrayList<>();

    public PegawaiDaoImpl() {
        data.add(new Pegawai("1234 4567891 1 02", "Ali"));
        data.add(new Pegawai("1234 4567891 1 02", "Deni"));
        data.add(new Pegawai("1234 4567891 1 02", "Ani"));
    }
    
    public void save(Pegawai pegawai){
        data.add(pegawai);
    }
    public void update(int index, Pegawai pegawai){
        data.set(index, pegawai);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Pegawai getPegawai(int index){
        return data.get(index);
    }
    
    public List<Pegawai> getAll(){
        return data;
    }
}
