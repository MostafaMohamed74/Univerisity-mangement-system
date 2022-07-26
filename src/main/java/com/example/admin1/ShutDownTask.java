package com.example.admin1;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

public class ShutDownTask extends Thread {
    @Override
    public void run() {
        ObjectIOExample objectIO = new ObjectIOExample();
        objectIO.WriteObjectToFile("students",mainwindow.studentsdata);
        objectIO.WriteObjectToFile("courses",mainwindow.coursesdata);
        objectIO.WriteObjectToFile("admins",mainwindow.adminsdata);
    }
}

