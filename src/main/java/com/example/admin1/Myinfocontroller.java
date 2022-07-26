package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.mainwindow.student;

public class Myinfocontroller {

    @FXML
    private Label GPALabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label advisorLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label trainingLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label tnumberLabel;
    @FXML
    private Label bdateLabel;
    @FXML
    private Label addressLabel;

    @FXML
    public void initialize()
    {
        int weeks = 0;
        int credits = 0;
        for(int i = 0; i < student.getTrainings().size();i++)
        {
            weeks += student.getTrainings().get(i).getWeeks();
        }
        for(int i = 0; i < student.getFinishedcoursesgrades().size();i++)
        {
            credits += student.getFinishedcoursesgrades().get(i).getCredithours();
        }
        GPALabel.setText(student.getCumulativegpa() + "");
        IDLabel.setText(student.getID());
        advisorLabel.setText(student.getAdmin().getName());
        ageLabel.setText(student.getAge()+"");
        nameLabel.setText(student.getName());
        balanceLabel.setText(student.getBalance()+"");
        trainingLabel.setText(weeks + "");
        creditLabel.setText(credits+"");
        emailLabel.setText(student.getEmail());
        addressLabel.setText(student.getAddress());
        tnumberLabel.setText(student.getTnumber());
        bdateLabel.setText(student.getBdate());
    }


    @FXML
    void switchSceneCourses(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("myCoursesScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchSceneFee(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("feeHistoryScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
