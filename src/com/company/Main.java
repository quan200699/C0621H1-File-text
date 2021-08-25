package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("demo.txt");// đường dẫn tương đối
        File directory = new File("/Users/quan/Java/Console/demo-file-text/.idea");
        File[] files = directory.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
