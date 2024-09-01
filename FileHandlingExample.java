package com;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandlingExample {

    public static void main(String[] args) {
        String filePath = "example.txt";
        
        // 1. Create and Write to a File
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(filePath);
            writer.write("Hello, this is a file handling example in Java.\n");
            writer.write("We are writing to this file.");
            writer.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while creating or writing to the file.");
            e.printStackTrace();
        }

        // 2. Read from the File
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println("Reading from the file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }

        // 3. Delete the File
        try {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println("Deleted the file: " + file.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

        } catch (SecurityException e) {
            System.out.println("An error occurred while deleting the file.");
            e.printStackTrace();
        }
    }
}
