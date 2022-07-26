package com.example.admin1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.mainwindow.coursesdata;
import static com.example.admin1.mainwindow.student;

public class MyCoursesController {
    @FXML
    private TableView<Course> courses;
    @FXML
    private TableColumn<Course, String> coursesColumn;

    @FXML
    private TableView<Course> regiseredCourses;
    @FXML
    private TableColumn<Course, String> registeredCoursesColumn;

    @FXML
    private TableView<Course> studiedCourses;
    @FXML
    private TableColumn<Course, String> studiedCoursesColumn;
    @FXML
    private TableColumn<Course, Double> gradeColumn;

    ObservableList<Course> rCourses;
    ObservableList<Course> sCourses;
    ObservableList<Course> currentCourses;

    public void initialize()
    {
        coursesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        registeredCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rCourses = regiseredCourses.getItems();
        currentCourses = courses.getItems();
        rCourses.addAll(student.getCurrentunapprovedcourses());
        currentCourses.addAll(student.getCurrentapprovedcourses());
        regiseredCourses.setItems(rCourses);
        courses.setItems(currentCourses);


        //two Dimensional
        studiedCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        sCourses = studiedCourses.getItems();
        sCourses.addAll(student.getFinishedcoursesgrades());
        studiedCourses.setItems(sCourses);

    }

    public  void returnScene(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
