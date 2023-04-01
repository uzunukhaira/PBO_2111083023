/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu010423;

/**
 *
 * @author USER
 */
public class StudentRecorndExample {
    public static void main(String[] args) {
        StudentRecord anna = new StudentRecord();
        StudentRecord cris = new StudentRecord();
        
        //isi Data
        anna.setName("Anna");
        anna.setAddress("Padang");
        anna.setAge(18);
        
        cris.setName("Cris");
        cris.setAddress("Bukittinggi");
        cris.setAge(20);
        
        //menampilkan
        System.out.println("Data Objek anna");
        System.out.println("Nama    :" + anna.getName());
        System.out.println("Alamat  :" + anna.getAddress());
        System.out.println("Umur    :" + anna.getAge());
        
        //memanggil method print
        System.out.println("Data Objek Cris");
        cris.print("");
        cris.print(70,80,90);
        
        //menampilkan jumlah siswa
        System.out.println("Count=" + StudentRecord.getStudentCount());
    }
}
