package com.example.admin1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.admin1.mainwindow.*;


public class Main extends Application {


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.admin1.Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 350);
        stage.setTitle("University Management System");
        stage.setOnCloseRequest(evt -> {
            // allow user to decide between yes and no
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this application?", ButtonType.YES, ButtonType.NO);

            // clicking X also means no
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

            if (ButtonType.NO.equals(result)) {
                // consume event i.e. ignore close request
                evt.consume();
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ArrayList<Course> courseskdaoekda = new ArrayList<>();

        ObjectIOExample objectIO = new ObjectIOExample();
        studentsdata = (ArrayList<Student>) (objectIO.ReadObjectFromFile("students"));
        adminsdata = (ArrayList<Admin>) (objectIO.ReadObjectFromFile("admins"));
        coursesdata = (ArrayList<Course>) (objectIO.ReadObjectFromFile("courses"));



        Certificate.genData();
        Training.genData();
        Fee.genData();
        for(int i = 0; i < Certificate.certificatesdata.size(); i++)
        {
            int j = 2;
            String s = Certificate.certificatesdata.get(i);
            while(j < s.length())
            {
                if(s.charAt(j) == ',')
                    break;
                j++;
            }
            String cerName = s.substring(2,j - 1);
            while(j < s.length())
            {
                if(IsNumeric.isNumeric(s.charAt(j) + ""))
                    break;
                j++;
            }
            String cerPrice = s.substring(j,j+2);
            Certificate.cerdata.add(new Certificate(cerName,Integer.parseInt(cerPrice)));
        }

        for(int i = 0; i < Training.trainingdata.size(); i++)
        {
            int j = 2;
            String s = Training.trainingdata.get(i);
            while(j < s.length())
            {
                if(s.charAt(j) == ',')
                    break;
                j++;
            }
            String treName = s.substring(2,j - 1);
            j = j+2;
            int temp = j;
            while(j < s.length())
            {
                if(s.charAt(j) == ',')
                    break;
                j++;
            }

            String treField = s.substring(temp,j - 1);

            while(j < s.length())
            {
                if(IsNumeric.isNumeric(s.charAt(j) + ""))
                    break;
                j++;
            }
            String treWeeks = s.substring(j,j+1);

           Training.terdata.add(new Training(treName,Integer.parseInt(treWeeks),treField));
        }

        for(int i = 0; i < Fee.feeString.size(); i++)
        {
            int j = 0;
            String s = Fee.feeString.get(i);
            String fee = "";
            while(j < s.length())
            {
                if(IsNumeric.isNumeric(s.charAt(j)+""))
                    break;
                j++;
            }

            while(IsNumeric.isNumeric(s.charAt(j)+""))
            {
                fee += s.charAt(j);
                j++;
            }
            Fee.fees.add(new Fee(Double.parseDouble(fee),i+1));
        }







       Course c1 = new Course("English", courseskdaoekda, 3);
       Course c2 = new Course("Math",courseskdaoekda, 4);
       Course c3 = new Course("Arabic", courseskdaoekda, 2);
       Course c4 = new Course("Physics1", courseskdaoekda, 3);
       ArrayList<Course> pre1 = new ArrayList<>(){{add(c4);}};
       Course c5 = new Course("Physics2",pre1, 3);




        ShutDownTask shutDownTask = new ShutDownTask();
        Runtime.getRuntime().addShutdownHook(shutDownTask);


        launch();
    }
}
