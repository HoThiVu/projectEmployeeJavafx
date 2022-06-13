package com.example.projectemployee.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WellcomeScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


    }
    public Scene  renderMainboard( Stage window, Scene scene){
        //Scene1
        Label label = new Label("Welcome to Howkteam");
        Button button1 = new Button("Go to course");
        button1.setOnAction(event -> {
            window.setScene(scene);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button1);
        Scene scene1 = new Scene(layout1, 1500, 700);
        return  scene1;
    }
}
