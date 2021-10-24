
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Vaccine;

/**
 *
 * @author DELL
 */
public class FileVaccineBinary {
    /**
     * 
     * @param filename
     * @param data
     * @throws Exception 
     * note: viết các file vaccine theo dạng binary file
     */
      public static void writeVaccineBinaryFile(String filename, ArrayList<Vaccine> data) throws Exception {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(filename);
            of = new ObjectOutputStream(f);
            for (Vaccine obj : data) {
                of.writeObject(obj);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
    } 
/**
 * 
 * @param fileName
 * @return
 * @throws Exception
 * note: đọc các file vaccine theo dạng binary file
 */
    public static ArrayList<Vaccine> readVaccineBinaryFile(String fileName) throws Exception {
        ArrayList<Vaccine> arr = new ArrayList<>();
        FileInputStream f = null;
        ObjectInputStream of = null;
        try {
            f = new FileInputStream(fileName);
            of = new ObjectInputStream(f);
            Object obj;
            while ((obj = of.readObject()) != null) {
                if (obj instanceof Vaccine) {
                    arr.add((Vaccine) obj);
                }
            }
        } catch (EOFException eof) {

        } catch (IOException ex) {
            throw ex;
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
        return arr;
    }
}
