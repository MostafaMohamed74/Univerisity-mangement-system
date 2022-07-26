package com.example.admin1;
import java.io.Serializable;
public abstract class Person implements Serializable {
    private String name;
    private String id;
    private int age;
    private String gender;
    private String password;


    Person (String n , int a,String g, String p){
        name = n;  age = a; gender = g; password = p;
    }

    Person (String n , int a,String g){
        name = n;  age = a; gender = g;
    }

    public void setName (String n){name = n;}
    public void setAge (int a){age = a;}
    public void setID (String i){
        id = i;
    };
    public void setPassword(String password) {this.password = password;}

    public String getGender(){return gender;}
    public String getName(){return name;}
    public String getID(){return id;}
    public int getAge(){return age;}
    public String getPassword() {return password;}

    abstract void generateID ();

}
