package edu.uekat.pl.hotel.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HotelGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/helloView.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setTitle("Java FX");
        stage.show();
    }
}
