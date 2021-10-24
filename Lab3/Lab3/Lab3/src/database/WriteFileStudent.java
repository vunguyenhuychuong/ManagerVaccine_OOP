/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author DELL
 */
public class WriteFileStudent {
    private static final String FILENAME = "student.dat";
    public static void main(String[] args) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAME);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Student> list = new ArrayList<>();
            list.add(new Student("SE150001", "Hoang Chi Cuong"));
            list.add(new Student("SE150002", "Hoang Minh Thuan"));
            list.add(new Student("SE150003", "Ho Dang Khoa"));
            list.add(new Student("SE150004", "Le Quoc Khanh"));
            list.add(new Student("SE150005", "Nguyen Dang Nam"));
            list.add(new Student("SE150006", "Nguyen Huu Phuc "));
            list.add(new Student("SE150007", "Nguyen Huynh Minh Khoi "));
            list.add(new Student("SE150008", "Nguyen Phuoc Tho"));
            list.add(new Student("SE150009", "Nguyen Van Hai Nam"));
            list.add(new Student("SE150010", "Bui Khoi Nguyen"));
            for (Student obj : list) {
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
