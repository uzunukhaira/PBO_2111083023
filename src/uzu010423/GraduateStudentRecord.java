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
public class GraduateStudentRecord extends StudentRecord3 {
    private String thesisTitle;
    private int thesisDefenseScore;
    
    public GraduateStudentRecord(String name, String address, int age, double mathGrade, double englishGrade, double scienceGrade, double average, char Huruf, String thesisTitle, int thesisDefenseScore) {
        super(name, address, age, mathGrade, englishGrade, scienceGrade, average, Huruf);
        this.thesisTitle = thesisTitle;
        this.thesisDefenseScore = thesisDefenseScore;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public int getThesisDefenseScore() {
        return thesisDefenseScore;
    }

    public void setThesisDefenseScore(int thesisDefenseScore) {
        this.thesisDefenseScore = thesisDefenseScore;
    }
    
    @Override
    public void printRecord() {
        super.printRecord();
        System.out.println("Thesis Title        :"+thesisTitle);
        System.out.println("Thesis Defense Score:"+thesisDefenseScore);
    }
    
}
