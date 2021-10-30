/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import controller.Food;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Database {

    public static void saveToFile(String fileName, ArrayList<Food> dsMonAn) {
        if (dsMonAn.isEmpty()) {
            System.out.println(" Empty list ");
            return;
        }
        try {

            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Food x : dsMonAn) {
                pw.println(x.getId() + "," + x.getName() + "," + x.getWeight() + "," + x.getType() + "," + x.getPlace() + "," + x.getOutOfDate());
            }
            pw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
