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
import model.Student;

/**
 *
 * @author DELL
 */
public class FileStudentBinary {
    /**
     * note: ghi file student thành dạng binary file
     */
     public static void writeStudentBinaryFile(String filename, ArrayList<Student> data) throws Exception {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(filename);
            of = new ObjectOutputStream(f);
            for (Student obj : data) {
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
 * note: đọc file student theo dạng binary file
 */
    public static ArrayList<Student> readStudentBinaryFile(String fileName) throws Exception {
        ArrayList<Student> arr = new ArrayList<>();
        FileInputStream f = null;
        ObjectInputStream of = null;
        try {
            f = new FileInputStream(fileName);
            of = new ObjectInputStream(f);
            Object obj;
            while ((obj = of.readObject()) != null) {
                if (obj instanceof Student) {
                    arr.add((Student) obj);
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
