
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

import static com.example.admin1.mainwindow.student;


public class Getcertifactecontroller {


    @FXML
    private Label blanceLabel;

    @FXML
    private TableColumn<Certificate, String> certCol;

    @FXML
    private TableView<Certificate> myTable;

    @FXML
    private TableColumn<Certificate, Double> priceCol;

    ObservableList<Certificate> oCer;

    @FXML
    void getCertificate(ActionEvent event) {
        try {
            int selectedID = myTable.getSelectionModel().getSelectedIndex();
            if (student.getBalance() < oCer.get(selectedID).getPrice()) {
                Alert a = new Alert(Alert.AlertType.NONE, "Not Enough Balance", ButtonType.CLOSE);
                a.setTitle("Error");
                a.show();
            } else {
                student.setBalance((int) student.getBalance() - (int) oCer.get(selectedID).getPrice());
                blanceLabel.setText(student.getBalance() + "");
                Certificate c = new Certificate(oCer.get(selectedID).getType(), oCer.get(selectedID).getPrice());
                Alert a = new Alert(Alert.AlertType.NONE, "Your certificate is ready to be picked up from the Student Affairs Department\n" + "Certificate Type: " + c.getType()
                        + '\n' + "Certificate Code: " + c.getCode(), ButtonType.CLOSE);
                a.setTitle("Successful Payment");
                a.show();
            }
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Certificate to Request!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    @FXML
    public void initialize()
    {
        blanceLabel.setText(student.getBalance()+"");
        certCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        oCer = myTable.getItems();
        oCer.addAll(Certificate.cerdata);
        myTable.setItems(oCer);
    }
    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

