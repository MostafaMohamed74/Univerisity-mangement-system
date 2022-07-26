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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController {

    @FXML
    private TextField addressText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField bdateText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField tnumberText;
    @FXML
    public void initialize()
    {
        passwordText.setText(EditController1.selectedStudent.getPassword());
        nameText.setText(EditController1.selectedStudent.getName());
        ageText.setText(""+EditController1.selectedStudent.getAge());
        emailText.setText(EditController1.selectedStudent.getEmail());
        tnumberText.setText(EditController1.selectedStudent.getTnumber());
        bdateText.setText(EditController1.selectedStudent.getBdate());
        addressText.setText(EditController1.selectedStudent.getAddress());
    }



    public void change(ActionEvent event) throws IOException {
        try {
            EditController1.selectedStudent.setPassword(passwordText.getText());
            EditController1.selectedStudent.setName(nameText.getText());
            EditController1.selectedStudent.setAge(Integer.parseInt(ageText.getText()));
            EditController1.selectedStudent.setTnumber(tnumberText.getText());
            EditController1.selectedStudent.setBdate(bdateText.getText());
            EditController1.selectedStudent.setAddress(addressText.getText());
            EditController1.selectedStudent.setEmail(emailText.getText());
            returnToScene(event);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please Fill all the values", ButtonType.CLOSE);
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
