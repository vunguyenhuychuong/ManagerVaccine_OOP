/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DELL
 */
public class Encryption {

    public static byte[] generateMD5(String fileName) throws Exception {
        return hashFile(fileName, "MD5");
    }
    
    private static byte[] hashFile(String fileName, String algorithm)
            throws Exception {
        try (
                FileInputStream inputStream = new FileInputStream(fileName)) {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            byte[] bytesBuffer = new byte[1024];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
                digest.update(bytesBuffer, 0, bytesRead);
            }
            byte[] hashedBytes = digest.digest();
            inputStream.close();
            return hashedBytes;

        } catch (NoSuchAlgorithmException | IOException ex) {
            throw new Exception(
                    "Could not generate hash from file", ex);
        }
    }
    
   
}
