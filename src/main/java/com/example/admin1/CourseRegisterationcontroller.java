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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.admin1.CourseRegController.selectedStudent;
import static com.example.admin1.mainwindow.coursesdata;
import static com.example.admin1.mainwindow.student;

public class CourseRegisterationcontroller {

    @FXML
    private TableView<Course> availableCoursesTable;
    @FXML
    private TableView<Course> registeredCoursesTable;
    @FXML
    private TableColumn<Course,String> availableCoursesColumn;
    @FXML
    private TableColumn<Course,String> registeredCoursesColumn;

    ObservableList<Course> rCourses;
    ObservableList<Course> aCourses;
    ArrayList<Course> availableCourses = new ArrayList<>();
    Course missing = null;

    public void fillList()
    {
        for(int i = 0; i < coursesdata.size();i++)
        {
            boolean flag = true;
            String s = coursesdata.get(i).getID();
            for(int j = 0;j < student.getCurrentunapprovedcourses().size();j++)
            {
                if(student.getCurrentunapprovedcourses().get(j).getID().equals(s))
                {
                    flag = false;
                }
            }
            for(int j = 0;j < student.getCurrentapprovedcourses().size();j++)
            {
                if(student.getCurrentapprovedcourses().get(j).getID().equals(s))
                {
                    flag = false;
                }
            }
            for(int j = 0;j < student.getFinishedcourses().size();j++)
            {
                if(student.getFinishedcourses().get(j).getID().equals(s))
                {
                    flag = false;
                }
            }
            if(flag)
                availableCourses.add(coursesdata.get(i));
        }
    }
    public void initialize()
    {
        fillList();
        availableCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        registeredCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rCourses = registeredCoursesTable.getItems();
        aCourses = availableCoursesTable.getItems();
        aCourses.addAll(availableCourses);
        registeredCoursesTable.setItems(rCourses);
        availableCoursesTable.setItems(aCourses);
    }

    public boolean check(Course c)
    {
        for(int i = 0; i < c.getPrereq().size();i++)
        {
            boolean flag = false;
            String s = c.getPrereq().get(i).getID();
            for(int j = 0;j < student.getFinishedcourses().size();j++)
            {
                if(student.getFinishedcourses().get(j).getID().equals(s))
                {
                    flag = true;
                }
            }
            if(!flag)
            {
                missing = c.getPrereq().get(i);
               return false;
            }
        }
        return true;

    }
    public void addCourse()
    {
        try {
            int selectedID = availableCoursesTable.getSelectionModel().getSelectedIndex();
            Course c = availableCourses.get(selectedID);
            boolean flag = true;
            for(int i = 0; i < c.getPrereq().size(); i++)
            {
                if(!check(c))
                {
                    Alert a = new Alert(Alert.AlertType.NONE, "You need to have studied: " + missing.getPrereq().get(i).getName(), ButtonType.CLOSE);
                    a.setTitle("Error");
                    a.show();
                    flag = false;
                }

            }
            if(flag) {
                rCourses.add(availableCourses.get(selectedID));
                availableCourses.remove(selectedID);
                aCourses.remove(selectedID);
            }
        }catch(Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Course to Register!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    public void registerCourse()
    {
        try {
            student.getCurrentunapprovedcourses().addAll(rCourses);
            System.out.println(student.getID() + student.getCurrentunapprovedcourses().get(0));
            System.out.println(student.getCurrentunapprovedcourses().get(0).getName());
            rCourses.clear();
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "The List is empty please add courses to register", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    public void removeCourse()
    {
        try {
            int selectedID = registeredCoursesTable.getSelectionModel().getSelectedIndex();
            aCourses.add(rCourses.get(selectedID));
            availableCourses.add(rCourses.get(selectedID));
            rCourses.remove(selectedID);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a course to remove", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    @FXML
    public void backbutton(ActionEvent event ) throws IOException {
        Switchtohome(event) ;

    }
    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
