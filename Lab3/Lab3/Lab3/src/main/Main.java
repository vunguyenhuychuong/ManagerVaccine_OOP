/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.InjectionController;
import java.util.Scanner;
import validation.Myvalidation;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Menu menu = new Menu();
            InjectionController listobj = new InjectionController();
            while (listobj.callMD5() == false) {
                System.out.println("Dữ liệu của bạn chưa được mã hóa");
                String confirm = Myvalidation.checkYesNo(" Bạn có muốn mã hóa chọn Y or N : ");
                if (confirm.equalsIgnoreCase("Y")) {
                    listobj.saveMD5();
                } else {
                    System.out.println("Good Bye!!");
                    System.exit(0);
                }
            }
            menu.add("|----------------------Vaccine manager-----------------------------|");
            menu.add("|------------------------------------------------------------------|");
            menu.add("|       1-->Show all Student Information  from file                |");
            menu.add("|       2-->Add student's information to vaccine injection         |");
            menu.add("|       3-->Update information of student's vaccine injection      |");
            menu.add("|       4-->Remove student vaccine injection information           |");
            menu.add("|       5-->Search injection by StudentID                          |");
            menu.add("|       6-->Save to file and Quit                                  |");
            menu.add("|       7-->Quit                                                   |");
            menu.add("|------------------------------------------------------------------|");
            int userChoice;
            do {
                userChoice = menu.getVaccineChoice();
                switch (userChoice) {
                    case 1:
                        listobj.displayInjectionList();
                        break;
                    case 2:
                        int choice1;
                        do {
                            System.out.println("Menu ADD INJECTION");
                            System.out.println("1.Add Injection ");
                            System.out.println("2.Exit");
                            choice1 = sc.nextInt();
                            switch (choice1) {
                                case 1:
                                    listobj.addNewInjection();
                                    break;
                            }
                        } while (choice1 == 1);
                        break;
                    case 3:
                        int choice2;
                        do {
                            System.out.println("Menu UPDATE INJECTION");
                            System.out.println("1.Update Injection ");
                            System.out.println("2.Exit");
                            choice2 = sc.nextInt();
                            switch (choice2) {
                                case 1:
                                    listobj.UpdateInjection();
                            }
                        } while (choice2 == 1);
                        break;
                    case 4:
                        int choice3;
                        do {
                            System.out.println("Menu REMOVE STUDENT");
                            System.out.println("1.Remove studentID ");
                            System.out.println("2.Exit");
                            choice3 = sc.nextInt();
                            switch (choice3) {
                                case 1:
                                    listobj.RemoveInjection();
                                    break;
                            }
                        } while (choice3 == 1);
                        break;
                    case 5:
                        int Choice4;
                        do {
                            System.out.println("Menu SEARCH STUDENT");
                            System.out.println("1.Search student By Id");
                            System.out.println("2.Search student By Name");
                            System.out.println("3.Exit");
                            Choice4 = sc.nextInt();
                            switch (Choice4) {
                                case 1:
                                    String studentId = Myvalidation.getAnString("Input student ID(SE1500xx):");
                                    listobj.searchInjectionByStudentID(studentId);
                                    break;
                                case 2:
                                    String studentName = Myvalidation.getAnString("Input student Name: ");
                                    listobj.searchInjectionByStudentName(studentName);
                                    break;
                            }
                        } while (Choice4 == 2);
                        break;
                    case 6:
                        listobj.saveInjectionToFile();
                        break;
                    case 7:
                        System.out.println("---GoodBye!!!---");
                        break;
                }
            } while (userChoice != 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
