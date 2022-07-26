package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class studentwindow {

    @FXML
    protected void CourseRegbutton (ActionEvent event) throws IOException {

        Switcht1(event);
    }
    @FXML
    protected void GetCertifacatebutton (ActionEvent event) throws IOException {

        Switcht2(event);

    }
    @FXML
    protected void FeePaymentbutton (ActionEvent event) throws IOException {
        Switcht3(event);
    }
    @FXML
    protected void AvaliableTraniingbutton (ActionEvent event) throws IOException {

        Switcht4(event);
    }
    @FXML
    protected void Myinfobutton (ActionEvent event) throws IOException {

        Switcht5(event);
    }

    public void deposit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("balanceManagementScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void Switcht1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CoursesRegisteration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switcht2(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GetCertificate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switcht3(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FeesPayment.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switcht4(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AvailableTrainings.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switcht5(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void Switchtmain(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
