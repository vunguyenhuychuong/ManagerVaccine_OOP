/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * khởi tạo phương thức cho student và các thuộc tính
 * @author DELL
 */
//Serizable giúp cho object chuyển sang đọc binary 
// để chuyển đối tượng thành luồng các byte thì nó mới ghi xuống file được
// và đọc dữ liệu từ file lên được
// nếu ko triển khai Serializable thì nó ko chuyển xuống được vì ta dùng FileOutPutStream vì nó ko có chức năng 
//đó nên ta nhờ Serializable làm điều đó
public class Student implements Serializable {

    private String studentId;
    private String studentName;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId" +  "|" + studentId + "|" + " studentName" + "|" +studentName + '}';
    }  
}
