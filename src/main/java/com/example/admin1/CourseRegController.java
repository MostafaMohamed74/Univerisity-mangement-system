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
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.admin1.mainwindow.admin;

public class CourseRegController {


    @FXML
    private TableColumn<Student, String> myStudents;

    @FXML
    private TableView<Student> studentsTable;

    public static Student selectedStudent;
    @FXML
    public void initialize()
    {
        myStudents.setCellValueFactory(new PropertyValueFactory<>("name"));
        ObservableList<Student> oStudents = studentsTable.getItems();
        oStudents.addAll(admin.getStudents());
        studentsTable.setItems(oStudents);
    }



    public void getStudent(ActionEvent event) throws IOException {
        try {
            int selectedID = studentsTable.getSelectionModel().getSelectedIndex();
            Student student = mainwindow.admin.getStudents().get(selectedID);
            for (int i = 0; i < mainwindow.studentsdata.size(); i++) {
                if (mainwindow.studentsdata.get(i).getID().equals(student.getID())) {
                    selectedStudent = mainwindow.studentsdata.get(i);
                }
            }
            switchToSceneApprove(event);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Student!", ButtonType.CLOSE);
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
    public void switchToSceneApprove(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("approvalScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
