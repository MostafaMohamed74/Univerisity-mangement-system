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

import static com.example.admin1.CourseRegController.selectedStudent;
import static com.example.admin1.mainwindow.coursesdata;

public class EditingGradesController {
    @FXML
    private TableColumn<Course,String> coursesColumn;
    public static Course selectedCourse;



    @FXML
    private TableView<Course> table;
    @FXML
    public void initialize()
    {
        coursesColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        ObservableList<Course> oCourses = table.getItems();
        oCourses.addAll( mainwindow.teacher.getTaughtcourses());
        table.setItems(oCourses);
    }
    @FXML
    public void selectCourse(ActionEvent event) throws IOException
    {
        try {
            int selectedID = table.getSelectionModel().getSelectedIndex();
            Course C = mainwindow.teacher.getTaughtcourses().get(selectedID);
            for (int i = 0; i < coursesdata.size(); i++) {
                if (coursesdata.get(i).getName().equals(C.getName()))
                    selectedCourse = coursesdata.get(i);
            }
            switchToStudentGrades(event);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Course to Grade!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    @FXML
    public void backbutton(ActionEvent event ) throws IOException
    {
        Switchtohome(event) ;
    }

    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeachingStuff.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void switchToStudentGrades(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditingGrades1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
