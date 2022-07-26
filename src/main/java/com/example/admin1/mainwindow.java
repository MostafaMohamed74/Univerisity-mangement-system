package com.example.admin1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class mainwindow {

    public static ArrayList<Student> studentsdata = new ArrayList<>();
    public static ArrayList<Course> coursesdata = new ArrayList<>();
    public static ArrayList<Admin> adminsdata = new ArrayList<>();
    public static ArrayList<Teacher> teachersdata = new ArrayList<>();


    public static Admin admin;
    public static Teacher teacher;
    public static Student student;

    @FXML
    private  TextField email;
    @FXML
    private TextField passField;


    @FXML
    protected void loginbutton (ActionEvent event) throws IOException {
        String s1 = email.getText() ;
        String s2 = passField.getText();
        boolean found= false;
        if (s1.charAt(0)=='S')
        {
            for(int i = 0; i < studentsdata.size();i++)
            {
                System.out.println(studentsdata.get(i).getID());
                if(studentsdata.get(i).getID().equals(s1))
                {
                    found = true;
                    if(studentsdata.get(i).getPassword().equals(s2))
                    {
                        student = studentsdata.get(i);
                        System.out.println(Certificate.certificatesdata);
                        SwitchtoStudentWindow(event);
                    }
                    else
                    {
                        Alert a = new Alert(Alert.AlertType.NONE, "Wrong Password", ButtonType.CLOSE);
                        a.setTitle("Error");
                        a.show();
                    }
                }
            }
            if(!found)
            {
                Alert a = new Alert(Alert.AlertType.NONE, "Wrong ID", ButtonType.CLOSE);
                a.setTitle("Not Found");
                a.show();
            }
        }
        else if (s1.charAt(0)=='T')
        {
            Teacher t1 =  new Teacher("Tafatef", 23,"Male","123",coursesdata,5000,"Physics");
            teachersdata.add(t1);
            for(int i = 0; i < teachersdata.size();i++)
            {
                if(teachersdata.get(i).getID().equals(s1))
                {
                    found = true;
                    if(teachersdata.get(i).getPassword().equals(s2))
                    {
                        teacher = teachersdata.get(i);
                        SwitchtoTEACHINGWindow(event);
                    }
                    else
                    {
                        Alert a = new Alert(Alert.AlertType.NONE, "Wrong Password", ButtonType.CLOSE);
                        a.setTitle("Error");
                        a.show();
                    }
                }
            }
            if(!found)
            {
                Alert a = new Alert(Alert.AlertType.NONE, "Wrong ID", ButtonType.CLOSE);
                a.setTitle("Not Found");
                a.show();
            }
        }
        else if (s1.charAt(0)=='A')
        {
            for(int i = 0; i < adminsdata.size();i++)
            {
                System.out.println(adminsdata.get(i).getStudents().size());
                if(adminsdata.get(i).getID().equals(s1))
                {
                    found = true;
                    if(adminsdata.get(i).getPassword().equals(s2))
                    {
                        admin = adminsdata.get(i);
                        SwitchtoAdminWindow(event);
                    }
                    else
                    {
                        Alert a = new Alert(Alert.AlertType.NONE, "Wrong Password", ButtonType.CLOSE);
                        a.setTitle("Error");
                        a.show();
                    }
                }
            }
            if(!found)
            {
                Alert a = new Alert(Alert.AlertType.NONE, "Wrong ID", ButtonType.CLOSE);
                a.setTitle("Not Found");
                a.show();
            }
        }

        }

    public void SwitchtoAdminWindow(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void SwitchtoStudentWindow(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void SwitchtoTEACHINGWindow(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeachingStuff.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
