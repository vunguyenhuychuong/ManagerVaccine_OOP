/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Vaccine;

/**
 *
 * @author DELL
 */
public class WritingFileVaccine {
    private static final String FILENAME = "vaccine.dat";
    public static void main(String[] args) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAME);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("1", "AstraZeneca"));
            list.add(new Vaccine("2", "SPUTNIK V"));
            list.add(new Vaccine("3", "Vero Cell"));
            list.add(new Vaccine("4", "Pfizer"));
            list.add(new Vaccine("5", "Moderna"));
            list.add(new Vaccine("6", "Janssen"));
            list.add(new Vaccine("7", "CoviVac"));
            list.add(new Vaccine("8", "CoronaVac"));
            list.add(new Vaccine("9", "Abdala"));
            list.add(new Vaccine("10", "Sputnik Light"));
            for (Vaccine obj : list) {
                oStream.writeObject(obj);
            }
            oStream.close();
            file.close();
            System.out.println("success");
        } catch (Exception ex) {
            System.out.println("Failed");
        }
    }
}
