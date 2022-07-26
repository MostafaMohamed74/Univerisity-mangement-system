package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.mainwindow.admin;

public class registerController {
    @FXML
    private TextField age;
    @FXML
    private TextField name;
    @FXML
    private TextField pass;
    @FXML
    private TextField gender;
    @FXML
    private TextField tnumberField;
    @FXML
    private TextField bdateField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;


    @FXML
    void register(ActionEvent event) throws IOException{
        try {
            System.out.println(admin.getStudents().size());
            admin.registerStudent(name.getText(), Integer.parseInt(age.getText()), gender.getText(), pass.getText(),emailField.getText(),bdateField.getText(),addressField.getText(),tnumberField.getText());
            System.out.println(mainwindow.studentsdata.get(mainwindow.studentsdata.size() - 1).getName());
            switchToScene2(event);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please Fill all the values", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void returnToScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
