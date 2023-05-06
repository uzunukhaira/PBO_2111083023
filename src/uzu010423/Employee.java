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
public class Employee extends Person {
    
    public Employee(){
        super("Ali", "Padang");
        System.out.println("Inside Student:Constructor");
    }
    
    public static void main(String[] args){
        Employee emp = new Employee();
        System.out.println("Nama    :"+emp.name);
        System.out.println("Nama    :"+emp.address);
    }
    
}
