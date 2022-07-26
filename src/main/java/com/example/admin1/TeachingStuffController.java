package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TeachingStuffController {


    public void editgradesbutton(ActionEvent event ) throws IOException
    {
        Switchtohome(event) ;
    }
    public void openForm(ActionEvent event)
    {

        mainwindow.teacher.createForm();
    }


    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditingGrades.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switchtomain(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void SwitchToFormScene(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
