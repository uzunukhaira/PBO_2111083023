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
public class Student extends Person {
    
    public Student(){
        super("Ali", "Padang");
        System.out.println("Inside Student:Constructor");
    }
    
    public static void main(String[] args){
        Student student = new Student();
        System.out.println("Nama    :"+student.name);
        System.out.println("Nama    :"+student.address);
    }
    
}
