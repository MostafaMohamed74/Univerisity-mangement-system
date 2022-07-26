package com.example.admin1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Training implements Serializable{
    private String companyname;
    private int weeks;
    private String field;
    public static ArrayList<String> trainingdata = new ArrayList<>();
    public static ArrayList<Training> terdata = new ArrayList<>();

    public static void genData()
    {
        String certificateentry = "";
        try {
            File myObj = new File("Trainings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                certificateentry += myReader.nextLine();
                certificateentry += " ";
                trainingdata.add(certificateentry);
                certificateentry = "";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    Training(String c , int w , String f){companyname = c; weeks = w; field = f;}
    public String getCompanyname() {return companyname;}
    public int getWeeks() {return weeks;}
    public String getField() {return field;}

    public void setCompanyname(String companyname) {this.companyname = companyname;}
    public void setWeeks(int weeks) {this.weeks = weeks;}
    public void setField(String field) {this.field = field;}

}
