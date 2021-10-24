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
import model.Injection;

/**
 *
 * @author DELL
 */
public class FileInjectionBinary {
    /**
     * 
     * @param filename
     * @param data ghi file Inejction dưới dạng binary
     * @throws Exception 
=     */
     public static void writeFileInjectionBinaryFile(String filename, ArrayList<Injection> data) throws Exception {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(filename);
            of = new ObjectOutputStream(f);
            for (Injection obj : data) {
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
 * @note đọc file injection binary
 * @return
 * @throws Exception
 */
    public static ArrayList<Injection> readFileInjectionBinaryFile(String filename) throws Exception {
        FileInputStream f = null;
        ObjectInputStream of = null;
        ArrayList<Injection> fileInjectionList = new ArrayList<>();
        try {
            f = new FileInputStream(filename);
            of = new ObjectInputStream(f);
            Object obj;
            while ((obj = of.readObject()) != null) {
                if (obj instanceof Injection) {
                    fileInjectionList.add((Injection) obj);
                }
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
        return fileInjectionList;
    }
    
}
