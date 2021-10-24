/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Student;
import database.FileStudentBinary;
/**
 *
 * @author DELL
 */
public class StudentController {
    private ArrayList<Student> studentList;
/** 
 * 
 * @throws Exception
 * note: khởi tạo phương thức student management
 */
    public StudentController() throws Exception {
        loadFileStudent();
    }
/**
 * 
 * @throws Exception
 * note: khởi tạo student theo dạng file
 */
    private void loadFileStudent() throws Exception {
        try {
            studentList = FileStudentBinary.readStudentBinaryFile("student.dat");
        } catch (Exception ex) {
            throw ex;
        }
    }
/**
 * note: in ra danh sách student 
 */
    ArrayList<Student> list = new ArrayList<>();
    public void printStudent() {
        if (studentList.isEmpty()) {
            System.err.println("No data yet!!");
        } else {
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        }
    }
   
     public ArrayList<Student> getStudent() {
        if (studentList == null) {
            System.err.println("No data yet!!");
        } else {
            for (Student student : studentList) {
                String[] split = student.toString().split(";");
            String ID = split[0];
            String name = split[1];     
            list.add(new Student(ID, name));
            }
        }
        return list;
    }
/**
 * 
 * @param id
 * @return
 * note: tìm kiếm thông tin student bằng id
 */
    public Student searchByStudentID(String id) {
        if (studentList.isEmpty()) {
            System.err.println("Empty!!");
            return null;
        } else {
            int size = studentList.size();
            if (studentList.isEmpty() || size == 0) {
                System.err.println("Empty!!");
                return null;
            } else {
                for (int i = 0; i < size; i++) {
                    if (studentList.get(i).getStudentId().equals(id)) {
                        return studentList.get(i);
                    }
                }
            }
        }
        return null;
    }
    
    public Student searchByStudentName(String name) {
        if(studentList.isEmpty()) {
            System.out.println("Empty");
            return null;
        } else {
            int size = studentList.size();           
            if(size == 0) {
                System.out.println("Empty!!");
                return null;
            } else {
                for (int i = 0; i < size; i++) {
                    if(studentList.get(i).getStudentName().contains(name)) {
                        return studentList.get(i);
                    }
                }
            }
        }
        return null;
    }
    
    
}
