package com.example.admin1;
import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable{
    private String name;
    private String id;
    private ArrayList<Course> prereq = new ArrayList<>();
    private int credithours;
    private double grade=-1;
    private ArrayList<Student> students = new ArrayList<>();
    private static int counter = 1;
    private boolean flag = true;

    Course (String n,  ArrayList<Course> p , int c ){
        name = n; prereq = p; credithours = c;
        generateID();
    }

    //For the finishedcoursesgrades
    Course (String n,  String i , int c ){
        name = n; id = i; credithours = c;
    }

    public void setName (String n){name = n;}
    public void setID (String i){
        if (!(i.substring(0,1).equals("C"))){
            System.out.println("REFUSED, The String part (first letter) of the course ID must be the letter C");
            flag = false;
        }
       else if (Integer.valueOf(i.substring(1))<counter){
            System.out.println("REFUSED, This course ID is used before, It's recommended " +
                    "to use an ID with an integer part of: " + counter+ " or higher");
            flag = false;
        }

        if(flag) {
            counter = Integer.valueOf(i.substring(1)) + 1;
            id = i;
        }
        flag = true;
    }
    public void setPrereq (ArrayList<Course> c){prereq = c;}
    public void setCredithours (int h){credithours = h;}
    public void setGrade (double g){grade = g;}
    public void setStudents (ArrayList<Student> s){students = s;}

    public String getName(){return name;}
    String getID(){return id;}
    ArrayList<Course> getPrereq (){return prereq;}
    int getCredithours(){return credithours;}
    public double getGrade () {return grade;}
    ArrayList<Student> getStudents (){return students;}

    private void generateID (){
        setID("C"+counter);
    }
}
