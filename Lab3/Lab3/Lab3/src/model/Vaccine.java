/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *khởi tạo các setter getter và thuộc tính vaccine
 * @author DELL
 */
public class Vaccine implements Serializable {
    private String vaccineId;
    private String vaccineName;

    public Vaccine(String vaccineId, String vaccineName) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    
    @Override
    public String toString() {
        return "Vacine{" + "vacineId" + "|" + vaccineId +  "|" + " vacineName" + vaccineName + '}';
    }       
}
