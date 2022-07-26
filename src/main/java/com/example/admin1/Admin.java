package com.example.admin1;
import java.util.ArrayList;
import java.io.Serializable;
public class Admin extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Student> students = new ArrayList<>();
    private static int counter = 1;
    private boolean flag = true;

    Admin(String n, int a, String g,String p) {
        super(n, a, g,p);
        generateID();
    }

    public ArrayList<Student> getStudents() {return students;}

    public void setID(String i) {
        if (!(i.substring(0, 1).equals("A"))) {
            System.out.println("REFUSED, The String part (first letter) of the admin ID must be the letter A");
            flag = false;
        } else if (Integer.valueOf(i.substring(1)) < counter) {
            System.out.println("REFUSED, This admin ID is used before, It's recommended to use an ID with an" +
                    " integer part of: " + counter + " or higher");
            flag = false;
        }

        if (flag) {
            counter = Integer.valueOf(i.substring(1)) + 1;
            super.setID(i);
        }
        flag = true;
    }

    void generateID() {
        setID("A" + counter);
    }

    int verifyTraining(String company, String field) {
        String weeks = "";
        String trainings = ReadFile.readFile("Trainings.txt");
        int cindex = trainings.lastIndexOf(company);
        String price = "";
        String foundfield = "";
        for (int i = cindex + company.length(); i < trainings.length(); i++) {
            if (trainings.substring(i, i + 1).equals(",")) {
                int j = i + 1;
                while (!(trainings.substring(j, j + 1).equals(","))) {
                    if (!(trainings.substring(j, j + 1).equals(" ")))
                        foundfield += trainings.substring(j, j + 1);
                    j++;
                }
                break;
            }
        }
        if (field.equals(foundfield)) {
            for (int i = cindex + company.length(); i < trainings.length(); i++) {
                if (trainings.substring(i, i + 1).equals(",")) {
                    int j = i + 1;
                    while (!(trainings.substring(j, j + 1).equals("-")) && !(trainings.substring(j, j + 1).equals("\n"))) {
                        if (IsNumeric.isNumeric(trainings.substring(j, j + 1)))
                            weeks += trainings.substring(j, j + 1);
                        j++;
                    }
                    break;
                }
            }
        }
        if (weeks.equals(""))
         return -1;

        return Integer.valueOf(weeks);
    }

    public void registerStudent (String n, int a, String g, String p, String email, String bdate, String address, String tnumber){
        Student s = new Student (n,a,g,p,email,bdate,address,tnumber,this);
        mainwindow.studentsdata.add(s);
    }

    void approveCourse (String courseid,String studentid){
      Student s = null;
      Course c = null;
        for (int i=0;i<students.size();i++) {
            if (studentid.equals(students.get(i).getID())) {
                s = students.get(i);
            }
        }
        for (int i=0;i<s.getCurrentunapprovedcourses().size();i++) {
            if (courseid.equals(s.getCurrentunapprovedcourses().get(i).getID())){
                c = s.getCurrentunapprovedcourses().get(i);
            }
        }
        c.getStudents().add(s);
        s.getCurrentapprovedcourses().add(c);
        s.getCurrentunapprovedcourses().remove(c);
}
}
