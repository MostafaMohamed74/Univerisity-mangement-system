package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.mainwindow.student;

public class BalanceManagementController {

    @FXML
    private TextField balanceField;

    @FXML
    private Label myBalanceLabel;


    public void initialize()
    {
        myBalanceLabel.setText(student.getBalance() + "");
    }
    @FXML
    public void deposit() {
        try {
            student.setBalance(Integer.parseInt(balanceField.getText()) + (int) student.getBalance());
            myBalanceLabel.setText(student.getBalance() + "");
            balanceField.clear();
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please Enter a value to Deposit!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    public  void SwitchtToHome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
