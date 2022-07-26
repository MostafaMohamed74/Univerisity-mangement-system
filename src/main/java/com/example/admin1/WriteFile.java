package com.example.admin1;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void writeFile(String filename, String writedata) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(writedata);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}