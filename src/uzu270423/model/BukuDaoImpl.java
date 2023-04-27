/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzu270423.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LABP1KOMP
 */
public class BukuDaoImpl {
    
    public BukuDaoImpl() {
        data.add(new Buku("B001", "Pascal", "Andi", "Andi"));
        data.add(new Buku("B002", "Algorithma", "Andi", "Andi"));
        data.add(new Buku("B003", "Java", "Andi", "Andi"));
    }

    public void save (Buku buku){
        data.add(buku);
    }
    
    public void update (int index, Buku buku){
        data.set(index, buku);
    }
    
    public void delete (int index){
        data.remove(index);
    }
    
    public Buku getBuku(int index){
        return data.get(index);
    }
    
    public List<Buku> getAllBuku(){
        return data;
    }
}
