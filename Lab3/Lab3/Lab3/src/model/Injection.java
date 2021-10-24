/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * tạo các thuôc tính cho injection khởi tạo các phương thức getter setter
 *
 * @author DELL
 */
//Serizable giúp cho object chuyển sang đọc binary đ
// để chuyển đối tượng thành luồng các byte thì nó mới ghi xuống file được
// và đọc dữ liệu từ file lên được
// nếu ko triển khai Serializable thì nó ko chuyển xuống được vì ta dùng FileOutPutStream vì nó ko có chức năng 
//đó nên ta nhờ Serializable làm điều đó
public class Injection implements Serializable {

  private String injectionID;
    public LocalDate firstDoseDate;
    private String firstDosePlace;
    public LocalDate secondDoseDate;
    private String secondDosePlace;
    private Student student;
    private Vaccine vaccine;

    public Injection(String injectionID, LocalDate firstDoseDate, String firstDosePlace, LocalDate secondDoseDate, String secondDosePlace, Student student, Vaccine vaccine) {
        this.injectionID = injectionID;
        this.firstDoseDate = firstDoseDate;
        this.firstDosePlace = firstDosePlace;
        this.secondDoseDate = secondDoseDate;
        this.secondDosePlace = secondDosePlace;
        this.student = student;
        this.vaccine = vaccine;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public LocalDate getFirstDoseDate() {
        return firstDoseDate;
    }

    public void setFirstDoseDate(LocalDate firstDoseDate) {
        this.firstDoseDate = firstDoseDate;
    }

    public String getFirstDosePlace() {
        return firstDosePlace;
    }

    public void setFirstDosePlace(String firstDosePlace) {
        this.firstDosePlace = firstDosePlace;
    }

    public LocalDate getSecondDoseDate() {
        return secondDoseDate;
    }

    public void setSecondDoseDate(LocalDate secondDoseDate) {
        this.secondDoseDate = secondDoseDate;
    }

    public String getSecondDosePlace() {
        return secondDosePlace;
    }

    public void setSecondDosePlace(String secondDosePlace) {
        this.secondDosePlace = secondDosePlace;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    
    
    public void show(){
        System.out.printf("|%11s|%12s|%12s|%16s|%16s|%15s|%20s|%15s|%20s|\n", injectionID,student.getStudentId(), vaccine.getVaccineId(), vaccine.getVaccineName(), student.getStudentName(), firstDoseDate, firstDosePlace, secondDoseDate, secondDosePlace);
    }
}



