package com.example.admin1;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import static com.example.admin1.mainwindow.coursesdata;
import static com.example.admin1.mainwindow.studentsdata;

public class Student extends Person implements Serializable{
    private static final long serialVersionUID = 1L;

    private ArrayList<Course> currentunapprovedcourses = new ArrayList<>();
    private ArrayList<Course> currentapprovedcourses = new ArrayList<>();
    private ArrayList<Course> finishedcourses = new ArrayList<>();
    private ArrayList<Course> finishedcoursesgrades = new ArrayList<>(); //Name,ID,Credits,Grade
    private ArrayList<Training> trainings = new ArrayList<>();
    private ArrayList<Fee> fee = new ArrayList<>();
    public ArrayList<Fee> getFees() {return fee;}
    private String email;
    private String bdate;
    private String address;
    private String tnumber;
    private Admin admin;
    private double balance;
    private double cumulativegpa;
    private static int counter;
    private boolean flag = true;

    public String getEmail() {
        return email;
    }

    public String getBdate() {
        return bdate;
    }

    public String getAddress() {
        return address;
    }

    public String getTnumber() {
        return tnumber;
    }

    Student (String n , int a, String g, String p, Admin m){
        super(n,a,g,p);
        admin = m;
        m.getStudents().add(this);
        counter = Integer.parseInt(studentsdata.get(studentsdata.size()-1).getID().substring(1))+1;
        generateID();
        int i =0;
        int counter = 0;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public Student(String n, int a, String g, String p, String email, String bdate, String address, String tnumber, Admin admin) {
        super(n, a, g, p);
        this.email = email;
        this.bdate = bdate;
        this.address = address;
        this.tnumber = tnumber;
        this.admin = admin;
        if(studentsdata.size() == 0)
            counter = 0;
        else
            counter = Integer.parseInt(studentsdata.get(studentsdata.size()-1).getID().substring(1))+1;
        admin.getStudents().add(this);
        generateID();
    }

    Student (String n , int a, String g, ArrayList<Course>  uc , ArrayList<Course> ac, ArrayList<Course>  fc, int b, Admin m ){
        super(n,a,g);
        currentunapprovedcourses = uc;
        finishedcourses = fc;
        currentapprovedcourses = ac;
        balance = b;
        admin = m;



        generateID();


    }

    public void setCurrentunapprovedcourses (ArrayList<Course> c){currentunapprovedcourses = c;}
    public void setCurrentapprovedcourses (ArrayList<Course> c){currentapprovedcourses = c;}
    public void setFinishedcourses (ArrayList<Course> c){finishedcourses = c;}
    public void setBalance (int b){balance = b;}
    public void setAdmin (Admin m){admin = m;}
    public ArrayList<Course> getFinishedcoursesgrades() {return finishedcoursesgrades;}


    public void setFinishedcoursesgrades(ArrayList<Course> finishedcoursesgrades) {this.finishedcoursesgrades = finishedcoursesgrades;}
    public ArrayList<Course> getCurrentunapprovedcourses (){return currentunapprovedcourses;}
    public ArrayList<Course> getCurrentapprovedcourses (){return currentapprovedcourses;}
    public ArrayList<Course> getFinishedcourses (){return finishedcourses;}
    public Admin getAdmin(){return admin;}
    public double getBalance () {return balance;}
    public double getCumulativegpa (){ calculateGPA();  return cumulativegpa;}
    public ArrayList<Training> getTrainings(){return trainings;}

    public void setID (String i){
        if (!(i.substring(0,1).equals("S"))){
            System.out.println("REFUSED, The String part (first letter) of the student ID must be the letter S");
            flag = false;
        }
        else if (Integer.valueOf(i.substring(1))<counter){
            System.out.println("REFUSED, This student ID is used before, It's recommended to use an ID with an" +
                    " integer part of: " + counter + " or higher");
            flag = false;
        }

        if(flag){
            counter = Integer.valueOf(i.substring(1)) + 1;
            super.setID(i);}
        flag = true;
    }

   public void setCoursegrade(String id,double g){
       for (int i=0 ; i<finishedcoursesgrades.size() ;i++){
           if (finishedcoursesgrades.get(i).getID().equals(id))
               finishedcoursesgrades.get(i).setGrade(g);
       }
   }

    private void calculateGPA (){
        int totalhours=0;
        double totalpoints=0;
        for (int i=0;i< finishedcoursesgrades.size();i++){
            totalhours += finishedcoursesgrades.get(i).getCredithours();

            if(finishedcoursesgrades.get(i).getGrade() != -1)
                totalpoints += finishedcoursesgrades.get(i).getGrade()*finishedcoursesgrades.get(i).getCredithours();
        }
        cumulativegpa = totalpoints/totalhours;
    }

    void generateID (){
        setID("S" + counter);
    };

    Certificate requestCertificate (String certificatetype){
        String certificates = ReadFile.readFile("Certificates.txt");
        int index = certificates.lastIndexOf(certificatetype);
        String price = "";
        for (int i = index + certificatetype.length(); i < certificates.length(); i++) {
            if (certificates.substring(i, i + 1).equals(",")) {
                int j = i + 1;
                while (!(certificates.substring(j, j + 1).equals("-")) && !(certificates.substring(j, j + 1).equals("\n"))) {
                    if (!(certificates.substring(j, j + 1).equals(" ")))
                        price += certificates.substring(j, j + 1);
                    j++;
                }
                break;
            }
        }

        String code="-1";
        if (balance >= Double.valueOf(price)){
            balance -= Double.valueOf(price);
            Certificate c = new Certificate(certificatetype,Double.valueOf(price));
            c.setStudent(this);
            code = c.getCode();
            System.out.println("Successful Payment");
            System.out.println("Your certificate is ready to be picked up from the Student Affairs Department");
            System.out.println("Certificate Type: "+ c.getType());
            System.out.println("Certificate Owner: "+ getName());
            System.out.println("Certificate Code: "+ code);
            return c;
        }
        return null;
    }

    public void registerTraining (String company,String field){
    int weeks = admin.verifyTraining(company,field);
    if (weeks >=0){
        System.out.println("Training approved");
        System.out.println("Company: " + company);
        System.out.println("Field: " + field);
        System.out.println("Number of Weeks: " + weeks);
        trainings.add(new Training(company,weeks,field));
    }
    else
        System.out.println("Training Declined");
    }

    public void registerCourse (String name){
        for (int i=0 ; i<mainwindow.coursesdata.size() ;i++){
            if (name.equals(mainwindow.coursesdata.get(i).getName())){
                this.currentunapprovedcourses.add(mainwindow.coursesdata.get(i));
            }
        }
    }

    public void payFees (int semester){
        for (int i=0; i< fee.size();i++){
            if (fee.get(i).getSemester() == semester){
                if (balance >= fee.get(i).getAmount()){
                    System.out.println("Successful Payment");
                    System.out.println("Semester: " + fee.get(i).getSemester());
                    System.out.println("Semester Fees: " + fee.get(i).getAmount());
                    System.out.println("Old Balance: " + balance);
                    balance -= fee.get(i).getAmount();
                    System.out.println("New Balance: " + balance);
                    fee.remove(i);
                    return;
                }
                else {
                    double difference = fee.get(i).getAmount()-balance;
                    System.out.println("Failed Payment, Not Enough Balance");
                    System.out.println("You need to deposit: "+ difference +" LE at least");
                    return;
                }
            }
        }
        System.out.println("No semester found, it's already paid");
    }

    void deposit (double amount){
        balance += amount;
    }

}
