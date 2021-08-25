package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    public static List<Student> students = new ArrayList<>();

    public void showAll() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void readStudentFromFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String studentLine[] = line.split(",");
            String studentId = studentLine[0];
            String studentName = studentLine[1];
            String studentBirthday = studentLine[2];
            Student student = new Student(studentId, studentName, studentBirthday);
            students.add(student);
        }
        bufferedReader.close();
        fileReader.close();
    }

    public void writeStudentListToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < students.size(); i++) {
            bufferedWriter.write(students.get(i).toString());
            if (i != students.size() - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
