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
public class StudentRecordData {
     public static void main(String[] args) {
        StudentRecord student = new StudentRecord("John Doe", 17, 11, true);

        System.out.println("Student Record:");
        student.printRecord();

        
        student.setName("Jane Doe");
        student.setAge(18);
        student.setGrade(12);
        student.setMale(false);

        System.out.println("\nNew student record:");
        student.printRecord();
        
        System.out.println();
        ComputerScienceStudentRecord student2 = new ComputerScienceStudentRecord("Jane Smith", 20, 11, false, "Java", true);
        student2.printRecord();
    }
}
