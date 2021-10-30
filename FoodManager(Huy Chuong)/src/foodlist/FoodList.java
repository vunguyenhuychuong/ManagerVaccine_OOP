/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodlist;

import file.Database;
import controller.Food;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class FoodList {

    Scanner sc = new Scanner(System.in);
    ArrayList<Food> dsMonAn;

    public FoodList() {
        dsMonAn = new ArrayList<>();
    }

    public FoodList(ArrayList<Food> dsMonAn) {
        this.dsMonAn = dsMonAn;
    }

    public ArrayList<Food> getDsMonAn() {
        return dsMonAn;
    }

    public void setDsMonAn(ArrayList<Food> dsMonAn) {
        this.dsMonAn = dsMonAn;
    }

    // _ là vì dễ nhập dữ liệu và đỗ dữ liệu vào khuôn
    //khi mà clone một vùng nhớ kiểu đó
    public void addFoodTheList() {
        System.out.println("Please Input ID, Name, Weight, Type, Place, Expired Date Of The Food ");
        boolean cont = true;
        String _Id = "";
        String _name = "";
        double _weight = 0;
        String _type = "";
        String _place = "";
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date _outOfDate = null;
        int dem = 0;

        do {
            try {
                dem = 0;
                String patter = "^(0\\d{2}$)";
                System.out.println("Input ID(xxx): ");
                _Id = sc.nextLine().toUpperCase();

                if (findID(_Id) == true) {
                    System.out.println("Same ID Please input againt!");
                    dem++;
                }
                if (!_Id.matches(patter)) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please Input Id valid!");
                cont = true;
                dem++;
            }
        } while (dem != 0);
        do {
            try {
                System.out.println("Input Name of the food: ");
                _name = sc.nextLine();
                if (_name.isEmpty()) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Please Input Name is not empty!!");
                cont = true;
            }
        } while (cont);
        do {
            try {
                System.out.println("Nhập Weight(Trọng Lượng): ");
                _weight = Integer.parseInt(sc.nextLine());
                if (_weight < 1) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Please Input Weight valid!! ");
                cont = true;
            }
        } while (cont);
        do {
            try {
                System.out.println("Input Type of the food: ");
                _type = sc.nextLine();
                if (_name.isEmpty()) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Please Input Type is not empty!!");
                cont = true;
            }
        } while (cont);
        do {
            try {
                System.out.println("Input Place of the food: ");
                _place = sc.nextLine();
                if (_name.isEmpty()) {
                    throw new Exception();
                }

                cont = false;
            } catch (Exception e) {
                System.out.println("Please Input Place is not empty!!");
                cont = true;
            }
        } while (cont);
        do {
            try {
                System.out.println("Input Expired Date(dd-MM-yyyy)!!");
                //df.parse -> ép kiểu dữ liệu nhập từ bàn phím thành date
                // muốn in theo kiểu dữ liệu người dùng nhập dùng df.format
                _outOfDate = df.parse(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.println("Please Input Expired Date valid!!");
                cont = true;
            }
        } while (cont);
        Food _food = new Food(_Id, _name, _weight, _type, _place, _outOfDate);

        dsMonAn.add(_food);
    }

// Function: In list of the food
    public void printTheFood() {
        for (Food x : dsMonAn) {
            System.out.println(x.toString());
        }
        if (dsMonAn == null) {
            System.out.println("The list is empty");
        }
    }

    //Fuction: search the food by name
    
    public void searchFoodByName() {
        int count = 0;
        System.out.println("Input Name to search ");
        String _Name = sc.nextLine();
        for (Food name : this.dsMonAn) {
            if (name.getName().contains(_Name)) {
                System.out.println("The Food Information");
               // System.out.println(name.toString());
                name.showFood();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("This food dose not exist");
        }
    }

    //Fuction: Remove the food by id
    public void removeFoodById() {
        String again = "";
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã đồ ăn(id) cần xóa ");
        String _maId = sc.nextLine();
        for (int i = 0; i < dsMonAn.size(); i++) {
            if (dsMonAn.get(i).getId().equals(_maId)) {

                do {
                    System.out.println("Do you sure about remove this food(YES/NO)");
                    again = sc.nextLine();
                } while (!again.equalsIgnoreCase("YES") && !again.equalsIgnoreCase("NO"));
                if (again.equalsIgnoreCase("YES")) {
                    dsMonAn.remove(i);
                    System.out.println("Remove success!");
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Remove Wrong!!!");
            }
        }
    }

    // Fuction: hàm dùng để check id trùng
    public boolean findID(String _Id) {
        for (int i = 0; i < dsMonAn.size(); i++) {
            if (dsMonAn.get(i).getId().equals(_Id)) {
                return true;
            }
        }
        return false;
    }

    //Fuction: hàm check id remove
    public boolean checkIdRemove(String _maString) {
        for (int i = 0; i < dsMonAn.size(); i++) {
            if (dsMonAn.get(i).getId().equals(_maString)) {
                dsMonAn.remove(i);
            }
        }
        return false;
    }

    //Function: hàm save file
    public void saveToFile(String fileName) {
        Database db = new Database();
        db.saveToFile(fileName, dsMonAn);
    }

    //Sắp xếp phần tử ngày trong mảng theo giảm dần
    public void sortByDate() {
        if (dsMonAn.isEmpty()) {
            System.out.println("The food is empty!No food is found");
        } else {
            Collections.sort(dsMonAn);
        }
    }
    
    public void sortByOutOfDate() {

        if (dsMonAn.isEmpty()) {
            System.out.println("The Food is empty!No food is found! ");
        } else {
            Collections.sort(dsMonAn);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                      HERE IS THE MENU\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|      ID             |      NAME           |      WEIGHT     |      TYPE            |       PLACE                 |      DATE            |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (Food food : dsMonAn
        ){
             food.showFood();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
}
