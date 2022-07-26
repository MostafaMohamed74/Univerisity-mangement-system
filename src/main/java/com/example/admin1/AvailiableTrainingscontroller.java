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

import static com.example.admin1.mainwindow.student;

public class AvailiableTrainingscontroller {

    @FXML
    private TableView<Training> myTable;

    @FXML
    private TableColumn<Training, String> trainingCol;

    @FXML
    private TableColumn<Training, Integer> weekCol;

    ObservableList<Training> oTraining;


    @FXML
    public void initialize()
    {
        trainingCol.setCellValueFactory(new PropertyValueFactory<>("companyname"));
        weekCol.setCellValueFactory(new PropertyValueFactory<>("weeks"));
        oTraining = myTable.getItems();
        for(int i = 0; i < Training.terdata.size(); i++)
        {
            if(!student.getTrainings().contains(Training.terdata.get(i)))
                oTraining.add(Training.terdata.get(i));
        }
        myTable.setItems(oTraining);
    }

    @FXML
    void enroll(ActionEvent event) {
        try {
            int selectedID = myTable.getSelectionModel().getSelectedIndex();
            student.getTrainings().add(oTraining.get(selectedID));
            oTraining.remove(selectedID);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Training to enroll in!", ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }
    public  void Switchtohome(ActionEvent event ) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
