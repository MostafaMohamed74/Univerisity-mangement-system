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

public class approveSceneController {
    @FXML
    private TableView<Course> registeredCoursesTable;
    @FXML
    private TableColumn<Course,String> coursesColumn;

    @FXML
    public void initialize()
    {
        coursesColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        ObservableList<Course> oCourses = registeredCoursesTable.getItems();
        oCourses.addAll(selectedStudent.getCurrentunapprovedcourses());
        registeredCoursesTable.setItems(oCourses);
        System.out.println(selectedStudent.getCurrentunapprovedcourses().size());
        System.out.println(selectedStudent.getCurrentapprovedcourses().size());
    }

    public void reject()
    {
        try {
            int selectedID = registeredCoursesTable.getSelectionModel().getSelectedIndex();
            selectedStudent.getCurrentunapprovedcourses().remove(selectedID);
            registeredCoursesTable.getItems().remove(selectedID);
            System.out.println(selectedStudent.getCurrentunapprovedcourses().size());
            System.out.println(selectedStudent.getCurrentapprovedcourses().size());
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Course!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }


    public void approve()
    {
        try {
            int selectedID = registeredCoursesTable.getSelectionModel().getSelectedIndex();
            selectedStudent.getCurrentapprovedcourses().add(selectedStudent.getCurrentunapprovedcourses().get(selectedID));

            for (int i = 0; i < coursesdata.size(); i++) {
                if (coursesdata.get(i).getName().equals(selectedStudent.getCurrentunapprovedcourses().get(selectedID).getName()))
                    coursesdata.get(i).getStudents().add(selectedStudent);
            }

            selectedStudent.getCurrentunapprovedcourses().remove(selectedID);
            registeredCoursesTable.getItems().remove(selectedID);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Course!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    public void returnToScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
