package com.example.admin1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.admin1.mainwindow.student;

public class FeeHistoryController {
    @FXML
    private TableColumn<Fee, Double> amountCol;

    @FXML
    private TableView<Fee> myTable;

    @FXML
    private TableColumn<Fee, Integer> yearCol;

    @FXML
    private TableColumn<Fee, LocalDate> dateCol;

    ObservableList<Fee> oFee;


    @FXML
    public void initialize()
    {
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("localDate"));
        oFee = myTable.getItems();
        oFee.addAll(student.getFees());
        myTable.setItems(oFee);
    }

    @FXML
    void switchToScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentwindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
