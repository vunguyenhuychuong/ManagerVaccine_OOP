/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Myvalidation {
    public static Scanner sc = new Scanner(System.in);
        
        /**
         * Hàm này hỗ trợ nhập số integer
         * @param inputMsg
         * @param errorMsg
         * @return 
         */
        public static int getAnInt(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //nhập int theo giới hạn
    public static int getAnInt(String inputMsg, String errorMsg,
            int lowerNum, int upperNum) {
        if (lowerNum > upperNum) {
            int tmp = lowerNum;
            lowerNum = upperNum;
            upperNum = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerNum || n > upperNum) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

/**
 * 
 * @param msg
 * @return 
 * note: tạo để nhập các dữ liệu theo dạng String
 */
    public static String getAnString(String msg) {
        System.out.println(msg);
        String data = sc.nextLine().trim();
        return data;
    }
/**
 * 
 * @param msg
 * @return
 * note: hạn chế các khoảng trống trong String
 */
    public static String getNonBlankString(String msg) {
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }
/**
 * Hàm này hỗ trơ khoảng cách chuỗi
 * @param msg
 */
    public static String getPattern(String msg, String pattern) {
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }
/**
 * Hàm này hỗ trợ ngày tháng 
 * @param msg
 */
    public static LocalDate getDate(String msg) {
        LocalDate data = null;
        boolean getflag = true;
        do {
            try {
                System.out.println(msg);
                data = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                getflag = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (getflag);
        return data;
    }
    public static String checkYesNo(String msg) {
        String value = "";
        boolean check = true;
        while(check) {
            try {
                System.out.print(msg);
                value = sc.nextLine();
                if(value.isEmpty()) {
                    System.out.println("Vui lòng nhập giá trị");
                }
                if(value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
                    check = false;
                } else {
                    System.out.println("input Y or N!!!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return value;
    }
    
}
