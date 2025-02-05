package com.example.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        stage.setTitle("To do list");
        stage.setScene(root);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}