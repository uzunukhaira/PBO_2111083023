/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu180323;

/**
 *
 * @author Lab_Jaringan_05
 */

//WhileLoop
    
import java.util.Scanner;

public class Latihan6_4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan angka: ");
        int angka = scanner.nextInt();
        
        System.out.print("Masukkan nilai pangkat: ");
        int pangkat = scanner.nextInt();
        
        int hasil = 1;
        int i = 1;
        
        while(i <= pangkat){
            hasil *= angka;
            i++;
        }
        
        System.out.println("Hasil: " + hasil);
    }
}
