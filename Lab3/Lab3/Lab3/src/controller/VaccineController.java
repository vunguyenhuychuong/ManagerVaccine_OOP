/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.FileVaccineBinary;
import java.util.ArrayList;
import model.Vaccine;

/**
 *
 * @author DELL
 */
public class VaccineController {
    private ArrayList<Vaccine> vaccineList;

    public VaccineController() throws Exception {
        loadFileVaccine();
    }
/**
 * khởi tạo file vaccineBinary
 * @throws Exception bỏ qua trường hợp lỗi
] */
    private void loadFileVaccine() throws Exception {
        try {
            vaccineList = FileVaccineBinary.readVaccineBinaryFile("vaccine.dat");
        } catch (Exception ex) {
            throw ex;
        }
    }
/**
 * Hàm này dùng để in ra danh sách vaccine
 */
    public void printVaccine() {
        if (vaccineList == null) {
            System.err.println("data empty!!");
        } else {
            for (Vaccine vaccine : vaccineList) {
                System.out.println(vaccine.toString());
            }
        }
    }
/**
 * 
 *  Hàm này dùng dể tìm kiếm vaccine theo id
 */
    public Vaccine searchByVaccineID(String id) {
        if (vaccineList == null) {
            System.err.println("data empty!!");
            return null;
        } else {
            int size = vaccineList.size();

            if (size == 0) {
                System.err.println("data empty!!");
                return null;
            } else {
                for (int i = 0; i < size; i++) {
                    if (vaccineList.get(i).getVaccineId().equals(id)) {
                        return vaccineList.get(i);
                    }
                }
            }
        }
        return null;
    }
}
