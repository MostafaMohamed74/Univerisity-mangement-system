package com.example.admin1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Certificate {
    private String type;
    private String code;
    private double price;
    private Student student;
    private static int counter = 1;
    public static ArrayList<String> certificatesdata = new ArrayList<>();
    public static ArrayList<Certificate> cerdata = new ArrayList<>();


    Certificate (String t, double p){type =t;  price =p; generateCode();}

    public String getType() {return type;}
    public String getCode() {return code;}
    public double getPrice() {return price;}
    public Student getStudent() {return student;}

    public void setType(String type) {this.type = type;}
    public void setPrice(double price) {this.price = price;}
    public void setStudent(Student student) {this.student = student;}
    void generateCode (){
        code = "CER" + counter;
        counter++;
    };

    public static void genData()
    {
        String certificateentry = "";
        try {
            File myObj = new File("certificates.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                certificateentry += myReader.nextLine();
                certificateentry += " ";
                certificatesdata.add(certificateentry);
                certificateentry = "";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
