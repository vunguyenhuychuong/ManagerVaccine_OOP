/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.FileInjectionBinary;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Encryption;
import model.Injection;
import model.Student;
import model.Vaccine;
import validation.Myvalidation;
import writefileString.writeMD5BinaryFile;

/**
 *
 * @author DELL
 */
public class InjectionController {

    ArrayList<Injection> Injection_List;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final String FILENAME = "Injection.dat";
    StudentController studentManagement;
    VaccineController vaccineManagement;

    /**
     *
     * @throws Exception note: khởi tạo phương thức injection management
     */
    public InjectionController() throws Exception {
        Injection_List = new ArrayList();
        studentManagement = new StudentController();
        vaccineManagement = new VaccineController();
        addFromFile();

    }

    /**
     *
     * @return note: tìm kiếm thông tin injection theo dạng integer
     */
    public int searchInjectionId(String id) {
        if (Injection_List != null) {
            int size = Injection_List.size();
            if (size == 0) {
                System.out.println("The list is empty !");
                return -1;
            } else {
                for (int i = 0; i < size; i++) {
                    if (Injection_List.get(i).getInjectionID().equals(id)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * nhập thông tin injection mới
     */
    public void addNewInjection() throws Exception {
        System.out.println("Danh sách student");
        studentManagement.printStudent();
        System.out.println("Danh sách vaccine: ");
        vaccineManagement.printVaccine();
        String injectionID = "", studentID = "", vaccineID = "", studentName = "";
        LocalDate firstDoseDate;
        String firstDosePlace;
        LocalDate secondDoseDate;
        String secondDosePlace;
        Student student;
        Vaccine vaccine;
        int checkId;
        do {
            injectionID = Myvalidation.getAnString("Injection Id(Ví dụ:1): ");
            checkId = searchInjectionId(injectionID);
            if (checkId >= 0) {
                System.out.println("Your injectionId can not duplicated");
            }
        } while (checkId >= 0);
        boolean flag = true;
        do {
            studentID = Myvalidation.getNonBlankString("Student Id(Ví dụ:SE1500XX(1-10)): ");
            student = studentManagement.searchByStudentID(studentID);
            if (student != null) {
                vaccineID = Myvalidation.getNonBlankString("Vaccine Id(Ví du: 1): ");
                vaccine = vaccineManagement.searchByVaccineID(vaccineID);
                if (vaccine != null) {
                    firstDosePlace = Myvalidation.getNonBlankString("First place injection: ");
                    firstDoseDate = Myvalidation.getDate("First date injection(Ex:2021-09-09): ");
                    secondDosePlace = null;
                    secondDoseDate = null;
                    Injection_List.add(new Injection(injectionID, firstDoseDate, firstDosePlace, secondDoseDate, secondDosePlace, student, vaccine));
                    System.out.println("Added !");
                    flag = false;
                } else {
                    System.out.println("Vaccine id must appear in list of student: ");
                }
            } else {
                System.out.println("Student id must appear in list of student: ");
            }
        } while (flag);
        String report = Myvalidation.getPattern("Do you want to continue ? (please type (Y|N))", "(Y|N)");
        if (report.equalsIgnoreCase("Y")) {
            this.addNewInjection();
        }
        String cf = Myvalidation.checkYesNo("DO you want to save it? (type Y /N)");
        if (cf.equalsIgnoreCase("Y")) {
            this.saveInjectionToFile();
            this.callMD5();
        } else {
            System.out.println("không lưu!!");
        }
    }

    /**
     * note: cập nhật thông tin các injection sau khi thêm vào
     */
    public void UpdateInjection() throws Exception {
        LocalDate seconDoseDate;
        int posId = searchInjectionId(Myvalidation.getNonBlankString("Choose Injection Id you want to update: "));
        if (posId >= 0) {
            boolean flag = true;
            do {
                seconDoseDate = Myvalidation.getDate("Updating second dose date(yyyy-mm-dd(EX:2021-09-09): ");
                Duration differ = Duration.between(Injection_List.get(posId).firstDoseDate.atStartOfDay(), seconDoseDate.atStartOfDay());
                long differDays = differ.toDays();
                if (differDays >= 28 && differDays <= 84) {
                    Injection_List.get(posId).setSecondDoseDate(seconDoseDate);
                    Injection_List.get(posId).setSecondDosePlace(Myvalidation.getNonBlankString("Updated second dose place: "));
                    System.out.println("Updated!");
                    System.out.println("The student has complete 2 injections!");
                    flag = false;
                } else {
                    System.out.println("The second day of injection must be given 4 to 12 week after get a first injection!");
                }
            } while (flag);
        } else {
            System.out.println("The Injection Id do not exist!");
        }
        String cf = Myvalidation.checkYesNo("DO you want to save it? (type Y /N)");
        if (cf.equalsIgnoreCase("Y")) {
            this.saveInjectionToFile();
            this.callMD5();
        } else {
            System.out.println("không lưu!!");
        }
    }

    public void RemoveInjection() throws Exception {
        int posId = searchInjectionId(Myvalidation.getNonBlankString("Enter your injection want to delete: "));
        if (posId >= 0) {
            String report = Myvalidation.getPattern("Make sure do you want to delete it?(Y|N)", "(Y|N)");
            if (report.equalsIgnoreCase("Y")) {
                Injection_List.remove(posId);
                System.out.println("Removed !");
            } else {
                System.out.println("Remove fail !");
            }
        } else {
            System.out.println("The Injection Id do not exist!");
        }
        String cf = Myvalidation.checkYesNo("DO you want to save it? (type Y /N)");
        if (cf.equalsIgnoreCase("Y")) {
            this.saveInjectionToFile();
            this.callMD5();
        } else {
            System.out.println("không lưu!!");
        }
    }

    public void searchInjectionByStudentID(String studentName) {
        String report = Myvalidation.getNonBlankString("Enter student id you want to search: ");
        for (int i = 0; i < Injection_List.size(); i++) {
            if (Injection_List.get(i).getStudent().getStudentId().equals(report)) {
                Injection_List.get(i).show();
            }
        }
        System.out.println("Not found or student does not exist!!!");
    }

    public void searchInjectionByStudentName(String studentName) {
        boolean check = false;
        for (int i = 0; i < Injection_List.size(); i++) {
            if (Injection_List.get(i).getStudent().getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                check = true;
                Injection_List.get(i).show();
            }
        }
        if (check == false) {
            System.out.println("Not found or student does not exist!!!");
        }
    }

    public void displayInjectionList() {
        if (Injection_List.isEmpty() || Injection_List == null) {
            System.out.println("The list is empty!");
        } else {
            System.out.printf("|%11s|%12s|%12s|%16s|%16s|%15s|%20s|%15s|%20s|\n", "injectionID","studentID","vaccineID","vaccineName","studentName","firstDoseDate", "firstDosePlace", "secondDoseDate", "secondDosePlace");
            for (Injection in : Injection_List) {
                in.show();
            }
        }
    }

    /**
     *
     * @throws Exception note: lưu trữ các dữ liệu của injection theo file
     */
    public void saveInjectionToFile() throws Exception {
        if (Injection_List.isEmpty() || Injection_List == null) {
            System.out.println("The list is empty !");
            return;
        } else {
            FileInjectionBinary.writeFileInjectionBinaryFile(FILENAME, Injection_List);
            System.out.println("Lưu thành công!!");
        }
    }

    /**
     *
     * @throws Exception note: hàm thêm từ file
     */
    private void addFromFile() throws Exception {
        Injection_List = FileInjectionBinary.readFileInjectionBinaryFile(FILENAME);
    }

    private StringBuffer encryptionMD5() throws Exception {
        Encryption encryption = new Encryption();
        byte[] generateMD5 = encryption.generateMD5(FILENAME);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < generateMD5.length; i++) {
            sb.append(Integer.toHexString((generateMD5[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb;
    }

    public void saveMD5() throws Exception {
        StringBuffer sb = encryptionMD5();
        writeMD5BinaryFile.writeMD5BinaryFile(sb);
    }

    public boolean callMD5() throws Exception {
        StringBuffer loadfile = writeMD5BinaryFile.readMD5BinaryFile();
        StringBuffer sb = encryptionMD5();
        return loadfile.compareTo(sb) == 0;
    }

}
