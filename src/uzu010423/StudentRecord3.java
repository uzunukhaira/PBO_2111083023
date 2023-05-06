/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzu010423;

/**
 *
 * @author LABP1KOMP
 */
public class StudentRecord3 {
     private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average; 
    private char Huruf;
    
    //private static int studentCount;//class variable
    
    /*public StudentRecord3(){
    //area inisialisasi kode;
        studentCount++;
    }
    public StudentRecord3(String temp){
        this.name = temp;
        studentCount++;
    }*/
    public StudentRecord3(String name, String address,int age,  double mGrade, double eGrade, double sGrade, double average, char Huruf){
        this.name = name;
        this.address = address;
        this.age = age;
        this.mathGrade = mGrade;
        this.englishGrade = eGrade;
        this.scienceGrade = sGrade;
        this.average = average;
        this.Huruf = Huruf;
        //studentCount++;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public double getMathGrade(){
        return mathGrade;
    }
    
    public void setMathGrade(double mathGrade){
        this.mathGrade = mathGrade;
    }
    public double getenglishGrade(){
        return englishGrade;
    }
    
    public void setenglishGrade(double englishGrade){
        this.englishGrade = englishGrade;
    }
    public double getscienceGrade(){
        return scienceGrade;
    }
    
    public void setscienceGrade(double scienceGrade){
        this.scienceGrade = scienceGrade;
    }
    public double getAverage(){
        average = (mathGrade + englishGrade + scienceGrade) /3;
        return average;
    }
    
    public void setaverage(double average){
        this.average = average;
    }
    
     public char getHuruf(){
        if (getAverage() > 80){
            Huruf = 'A';
        }else if(getAverage() > 65){
            Huruf = 'B';
        }else if(getAverage() > 55){
            Huruf = 'C';
        }else if(getAverage() > 40){
            Huruf = 'D';
        }else if(getAverage() > 0){
            Huruf = 'E';   
        }
        return Huruf;
    }
     
    public void setHuruf(char Huruf){
        this.Huruf = Huruf;
    }
    
    //public static int getStudentCount(){
        //return studentCount;
    //}
    
    public void printRecord(){
    System.out.println("Name                :" + name);
    System.out.println("Address             :" + address);
    System.out.println("Age                 :" + age);
    System.out.println("Math Grade          :" + mathGrade);
    System.out.println("English Grade       :" + englishGrade);
    System.out.println("Science Grade       :" + scienceGrade);
    System.out.println("Nilai rata - rata   :" + average);
    System.out.println("Nilai Huruf         :" + Huruf);
    }
}
