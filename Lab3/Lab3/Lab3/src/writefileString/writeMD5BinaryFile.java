/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writefileString;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author DELL
 */
public class writeMD5BinaryFile {
    private static final String FILENAME = "Encrytion.dat";
    public static void writeMD5BinaryFile(StringBuffer data) throws IOException {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(FILENAME);
            of = new ObjectOutputStream(f);
            of.writeObject(data);
        } catch (EOFException eof) {

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
    public static StringBuffer readMD5BinaryFile() throws Exception {
        FileInputStream f = null;
        ObjectInputStream of = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            f = new FileInputStream(FILENAME);
            of = new ObjectInputStream(f);
            Object obj;
            while ((obj = of.readObject()) != null) {
                if (obj instanceof StringBuffer) {
                    stringBuffer = (StringBuffer) obj;
                }
            }
        } catch (EOFException eof) {

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
        return stringBuffer;
    }
}
