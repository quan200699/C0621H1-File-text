package com.company;

import java.io.IOException;
import java.util.Scanner;

public class StudentMain {
    public static Scanner sc = new Scanner(System.in);
    private static StudentManagement studentManagement = new StudentManagement();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    showAllStudent();
                    break;
                }
                case 2: {
                    addNewStudent();
                    break;
                }
                case 3: {
                    readFile();
                    break;
                }
                case 4: {
                    writeFile();
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void writeFile() {
        try {
            studentManagement.writeStudentListToFile("student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try {
            studentManagement.readStudentFromFile("student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNewStudent() {
        System.out.println("Nhập id:");
        String id = sc.nextLine();
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh:");
        String birthday = sc.nextLine();
        Student student = new Student(id, name, birthday);
        studentManagement.addStudent(student);
    }

    private static void showAllStudent() {
        studentManagement.showAll();
    }

    private static void menu() {
        System.out.println("Menu");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm học viên");
        System.out.println("3. Đọc danh sách viên có sẵn trong file");
        System.out.println("4. Ghi danh sách học viên hiện có ra file");
        System.out.println("0. Thoát");
    }
}
