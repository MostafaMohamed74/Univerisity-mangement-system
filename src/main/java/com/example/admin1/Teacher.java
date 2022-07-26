package com.example.admin1;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.example.admin1.mainwindow.*;

public class Teacher extends Person{
    private ArrayList<Course> taughtcourses = new ArrayList<>();
    private double salary;
    private String degree;
    private static int counter = 1;
    private boolean flag = true;

    Teacher (String n , int a,String g,String p,ArrayList<Course> tc,double s,String d){
        super(n,a,g,p);
        taughtcourses = tc;
        salary = s;
        degree = d;
        generateID();
    }
    Teacher (String n , int a,String g,String p,double s,String d){
        super(n,a,g,p);
        salary = s;
        degree = d;
        generateID();
    }

    public ArrayList<Course> getTaughtcourses() {return taughtcourses;}
    public double getSalary() {return salary;}
    public String getDegree() {return degree;}

    public void setID (String i){
        if (!(i.substring(0,1).equals("T"))){
            System.out.println("REFUSED, The String part (first letter) of the teacher ID must be the letter T");
            flag = false;
        }
        else if (Integer.valueOf(i.substring(1))<counter){
            System.out.println("REFUSED, This teacher ID is used before, It's recommended to " +
                    "use an ID with an integer part of: " + counter + " or higher");
            flag = false;
        }

        if(flag){
            counter = Integer.valueOf(i.substring(1)) + 1;
            super.setID(i);}
        flag = true;
    }
    public void setTaughtcourses(ArrayList<Course> taughtcourses) {this.taughtcourses = taughtcourses;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setDegree(String degree) {this.degree = degree;}

    void generateID (){
        setID("T" + counter);
    };

    public void setGrade (double grade,String studentid, String courseid){
        Student s = null;
        Student s1 = null;
        Course c1 = null;
        Course c = null;

        for (Student studentsdatum : studentsdata) {
            if (studentsdatum.getID().equals(studentid)) {
                student = studentsdatum;
            }
        }

        for (int i=0;i < student.getCurrentapprovedcourses().size();i++){
            if (student.getCurrentapprovedcourses().get(i).getID().equals(courseid)){
                c1 = student.getCurrentapprovedcourses().get(i);
            }
        }

        for (int i=0;i < coursesdata.size();i++){
            if (coursesdata.get(i).getID().equals(courseid)){
                c = coursesdata.get(i);
            }
        }

        for (Student studentsdatum : studentsdata) {
            if (studentsdatum.getID().equals(studentid)) {
                s = studentsdatum;
            }
        }
        for (Student studentsdatum : c.getStudents()) {
            if (studentsdatum.getID().equals(studentid)) {
                s1 = studentsdatum;
            }
        }
        s.getFinishedcourses().add(c1);
        s.getFinishedcoursesgrades().add(new Course(c.getName(),c.getID(), c.getCredithours()));
        s.setCoursegrade(courseid,grade);
        c.getStudents().remove(s1);
        s.getCurrentapprovedcourses().remove(c1);
    }

    void createForm (){
        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            //specify the protocol along with the URL
            URI oURL = new URI(
                    "https://accounts.google.com/ServiceLogin/signinchooser?service=wise&passive=1209600&continue=https%3A%2F%2Fdocs.google.com%2Fforms%2Fu%2F0%2F%3Ftgif%3Dd&followup=https%3A%2F%2Fdocs.google.com%2Fforms%2Fu%2F0%2F%3Ftgif%3Dd&ltmpl=forms&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
            desktop.browse(oURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
