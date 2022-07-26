package com.example.admin1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.CourseRegController.selectedStudent;
import static com.example.admin1.EditingGradesController.selectedCourse;
import static com.example.admin1.mainwindow.teacher;

public class EditingGrades1Controller {

    @FXML
    private TableColumn<Student, String> studentIdCol;

    @FXML
    private TableView<Student> table;

    @FXML
    private TextField gradeText;

    ObservableList<Student> oStudents;

    public void initialize()
    {
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        oStudents = table.getItems();
        oStudents.addAll(selectedCourse.getStudents());
        table.setItems(oStudents);
    }

    public void setGrade()
    {
        try {
            int selectedID = table.getSelectionModel().getSelectedIndex();
            teacher.setGrade(Double.parseDouble(gradeText.getText()), selectedCourse.getStudents().get(selectedID).getID(), selectedCourse.getID());
            oStudents.remove(selectedID);
            gradeText.clear();
        }
        catch(Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Student to Grade!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
            e.printStackTrace();
        }
    }

    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeachingStuff.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
