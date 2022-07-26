package com.example.admin1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Fee implements Serializable {
    private double amount;
    private int semester;
    public static ArrayList<Fee> fees = new ArrayList<>();
    public static ArrayList<String> feeString = new ArrayList<>();
    private final LocalDate localDate;

    public LocalDate getLocalDate() {
        return localDate;
    }

    Fee (double a, int s){amount = a; semester =s; localDate = LocalDate.now();}


    public double getAmount() {return amount;}
    public int getSemester() {return semester;}

    public static void genData()
    {
        String certificateentry = "";
        try {
            File myObj = new File("Fees.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                certificateentry += myReader.nextLine();
                certificateentry += " ";
                feeString.add(certificateentry);
                certificateentry = "";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void setAmount(double amount) {this.amount = amount;}
    public void setSemester(int semester) {this.semester = semester;}


}
