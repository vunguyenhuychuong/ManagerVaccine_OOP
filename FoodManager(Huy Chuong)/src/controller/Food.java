/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Food implements Comparable<Food> {

    private String Id;
    private String name;
    private double weight;
    private String type;
    private String place;
    private Date outOfDate;

    public Food(String Id, String name, double weight, String type, String place, Date outOfDate) {
        this.Id = Id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.outOfDate = outOfDate;
    }

    public Food() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getOutOfDate() {
        return outOfDate;
    }

    public void setOutOfDate(Date outOfDate) {
        this.outOfDate = outOfDate;
    }

    //@Override
    /*public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Food{" + "Id=" + Id
                + ", name=" + name
                + ", weight=" + weight
                + ", type=" + type
                + ", place=" + place
                + ", outOfDate=" + df.format(outOfDate) + '}';
    }*/

    @Override
    public int compareTo(Food t) {
        return t.outOfDate.compareTo(this.outOfDate);
    }
    
    public void showFood(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("|%11s          |%11s          |%6.1f           |%11s           |%12s                   |%11s           |\n", Id, name, weight, type, place, df.format(outOfDate));
    }
}
