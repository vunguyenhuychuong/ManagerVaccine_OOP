/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getChoice() {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                System.out.println((i + 1) + " - " + this.get(i));
            }
            System.out.println("Please select an operation: ");
            result = Integer.parseInt(sc.nextLine());

        }
        return result;
    }

}
