/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.Menu;
import foodlist.FoodList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
//là clone vùng nhớ cho nó
//add vào đó 6 cái chuỗi
//mục đích của getchoice  nằm ở switch á nhập 1->6
//nó truyền vào trả về kết quả
//phương thức add() của một menu khác để làm menu con
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("1.Add a new food");
        menu.add("2.Search a food by name");
        menu.add("3.Remove the food by ID");
        menu.add("4.Print the food list in the descending order of expired date");
        menu.add("5.Save to file");
        menu.add("6.Quit");

        int choice;
        FoodList listobj = new FoodList();
        do {
            System.out.println("\nFOOD MANAGER");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    int addChoice;

                    do {
                        System.out.println("1.Add the food ");
                        System.out.println("2.Exit");
                        addChoice = sc.nextInt();
                        switch (addChoice) {
                            case 1:
                                listobj.addFoodTheList();
                                break;
                        }
                    } while (addChoice == 1);
                    break;

                case 2:
                    int searchChoice;
                    sc = new Scanner(System.in);
                    do {
                        System.out.println("1.Search the food ");
                        System.out.println("2.Exit");
                        searchChoice = sc.nextInt();
                        switch (searchChoice) {
                            case 1:
                                listobj.searchFoodByName();
                                break;
                        }
                    } while (searchChoice == 1);
                    break;
                case 3:
                    listobj.removeFoodById();
                    break;
                case 4:
                    listobj.sortByDate();
                    listobj.sortByOutOfDate();
                    break;
                case 5:
                    String choose;
                    do {
                        System.out.println("Bạn có muốn lưu file: YES or NO");
                        sc = new Scanner(System.in);
                        choose = sc.nextLine();
                        if (choose.equalsIgnoreCase("YES")) {
                            sc = new Scanner(System.in);
                            System.out.println("Nhập tên file");
                            String fileName = sc.nextLine();
                            listobj.saveToFile(fileName);
                        } else if (choose.equalsIgnoreCase("NO")) {
                            System.out.println("Đã Thoát Program!!!");
                        }
                    } while (!choose.equalsIgnoreCase("YES") && !choose.equalsIgnoreCase("NO"));
                    break;
                case 6:
                    System.out.println("     Bye!!     ");
            }
        } while ((choice >= 1) && choice < 5);

    }
}
