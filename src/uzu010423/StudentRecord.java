/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uzu010423;

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class StudentRecord {
    
        private String name; 
        private String address; 
        private int age; 
        private double mathGrade; 
        private double englishGrade; 
        private double scienceGrade; 
        private double average; 
        
        private static int studentCount;
        private static double nilaiHuruf;
        
        
        public StudentRecord(){ 
            //area inisialisasi kode; 
            studentCount++;
        } 
        
        public StudentRecord(String temp){ 
            this.name = temp; 
            studentCount++;
        } 
        
        public StudentRecord(String name, String address){ 
            this.name = name; 
            this.address = address; 
            studentCount++;
        } 
        
        public StudentRecord(double mGrade, double eGrade, double sGrade){ 
            mathGrade = mGrade; 
            englishGrade = eGrade; 
            scienceGrade = sGrade; 
            studentCount++;
        }
            
        public String getName(){ 
            return name; 
        }
        
        public void setName( String name ){ 
            this.name = name; 
        }
        
         public String getAddress(){ 
            return address; 
        }
        
        public void setAddress( String address ){ 
            this.address = address; 
        }
        
         public int getAge(){ 
            return age; 
        }
        
        public void setAge( int age ){ 
            this.age = age; 
        }
        
         public double getMathGrade(){ 
            return mathGrade; 
        }
        
        public void setMathGrade( double mathGrade ){ 
            this.mathGrade = mathGrade; 
        }
        
         public double getEnglishGrade(){ 
            return englishGrade; 
        }
        
        public void setEnglishGrade( double englishGrade ){ 
            this.englishGrade = englishGrade; 
        }
        
        public double getScienceGrade(){ 
            return scienceGrade; 
        }
        
        public void setAcienceGrade(double scienceGrade ){ 
            this.scienceGrade = scienceGrade; 
        }
        
         public double getAverage(){ 
            average = ( (mathGrade + englishGrade + scienceGrade)/3); 
            return average;
        }       
        
     
        public static double getStudentCount(){
            return studentCount;
        }
        
        public static double getNilaiHuruf(){
            return studentCount;
        }
        public void print( String temp ){ 
            System.out.println("Name:" + name); 
            System.out.println("Address:" + address); 
            System.out.println("Age:" + age); 
        } 
        
        public void print(double eGrade, double mGrade, double sGrade){
            System.out.println("Name:" + name); 
            System.out.println("Math Grade:" + mGrade); 
            System.out.println("English Grade:" + eGrade); 
            System.out.println("Science Grade:" + sGrade); 
        }
        
       public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahNilai = 0;
        double rataRata;
        String nilaiHuruf = "";
            int[] nilai = new int[100];
            for (int i = 0; i < 100; i++) {
                System.out.print("Masukkan nilai ke-" + (i+1) + ": ");
                nilai[i] = input.nextInt();
                jumlahNilai += nilai[i];
            }
            
            rataRata = (double) jumlahNilai / 100;
            System.out.println("Rata-rata nilai: " + rataRata);

            if (rataRata >= 80) {
                nilaiHuruf = "A";
            } else if (rataRata >= 65) {
                nilaiHuruf = "B";
            } else if (rataRata >= 55) {
                nilaiHuruf = "C";
            } else if (rataRata >= 40) {
                nilaiHuruf = "D";
            } else {
                nilaiHuruf = "E";
            }

            System.out.println("Nilai huruf: " + nilaiHuruf);
        }
    }