package com.example.admin1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.admin1.mainwindow.student;

public class FeePaymentcontroller {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label feeLabel;

    @FXML
    private MenuButton myMenu;

    @FXML
    private MenuItem year1Item;

    @FXML
    private MenuItem year2Item;

    @FXML
    private MenuItem year3Item;

    @FXML
    private MenuItem year4Item;

    @FXML
    private MenuItem year5Item;

    private Fee fee;

    public void initialize()
    {
        for(int i = 0;i<student.getFees().size();i++)
        {
            if(student.getFees().get(i).getSemester() == 1)
                year1Item.setVisible(false);
            if(student.getFees().get(i).getSemester() == 2)
                year2Item.setVisible(false);
            if(student.getFees().get(i).getSemester() == 3)
                year3Item.setVisible(false);
            if(student.getFees().get(i).getSemester() == 4)
                year4Item.setVisible(false);
            if(student.getFees().get(i).getSemester() == 5)
                year5Item.setVisible(false);
        }
        balanceLabel.setText(student.getBalance()+"");
        feeLabel.setText("NaN");
    }

    @FXML
    void year1() {
        myMenu.setText("year1");
        feeLabel.setText(Fee.fees.get(0).getAmount()+"");
        fee = Fee.fees.get(0);
    }
    public void year2() {
        myMenu.setText("year2");
        feeLabel.setText(Fee.fees.get(1).getAmount()+"");
        fee = Fee.fees.get(1);
    }
    public void year3() {
        myMenu.setText("year3");
        feeLabel.setText(Fee.fees.get(2).getAmount()+"");
        fee = Fee.fees.get(2);
    }
    public void year4() {
        myMenu.setText("year4");
        feeLabel.setText(Fee.fees.get(3).getAmount()+"");
        fee = Fee.fees.get(3);
    }
    public void year5() {
        myMenu.setText("year5");
        feeLabel.setText(Fee.fees.get(4).getAmount()+"");
        fee = Fee.fees.get(4);
    }

    public void pay() {
        try {
            if (student.getBalance() < fee.getAmount()) {
                Alert a = new Alert(Alert.AlertType.NONE, "Not Enough Balance", ButtonType.CLOSE);
                a.setTitle("Error");
                a.show();
            } else {
                balanceLabel.setText((student.getBalance() - fee.getAmount()) + "");
                student.setBalance((int) student.getBalance() - (int) fee.getAmount());
                Alert a = new Alert(Alert.AlertType.NONE, "Fees Paid Successfuly!", ButtonType.CLOSE);
                a.setTitle("Successful Payment!");
                a.show();
                student.getFees().add(new Fee(fee.getAmount(), fee.getSemester()));
                myMenu.setText("Select Year");
                feeLabel.setText("NaN");
            }
            if (fee.getSemester() == 1)
                year1Item.setVisible(false);
            if (fee.getSemester() == 2)
                year2Item.setVisible(false);
            if (fee.getSemester() == 3)
                year3Item.setVisible(false);
            if (fee.getSemester() == 4)
                year4Item.setVisible(false);
            if (fee.getSemester() == 5)
                year5Item.setVisible(false);
        }
        catch (Exception e)
        {
            Alert a = new Alert(Alert.AlertType.NONE, "Please select a Year to Pay", ButtonType.CLOSE);
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
