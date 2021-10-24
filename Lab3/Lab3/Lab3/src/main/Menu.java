/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Menu extends ArrayList<String>{
     public int getVaccineChoice() {
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        int choice = 0;
        do {
            System.out.println("----------------------");
            System.out.println("Covid-19 Vaccine Management - @ 2021 by <SE150542 - VUNGUYENHUYCHUONG >");
            System.out.println("Menu to choose:");
            for (int i = 0; i < this.size(); i++) {
                System.out.println((i + 1) + ". " + this.get(i) + ".");
            }
            System.out.print("\tChoose an option: ");
            try {
                sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice < 1 || choice > this.size()) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Please enter number between 1 and " + this.size() + "!");
                cont = true;
            }
        } while (cont);
        return choice;
    }
}
