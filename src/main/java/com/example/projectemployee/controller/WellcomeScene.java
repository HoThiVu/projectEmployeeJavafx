package com.example.projectemployee.controller;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.BASELINE_CENTER;

public class WellcomeScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
    }
    public Scene  renderMainboard( Stage window, Scene scene){
        //Scene1
        Label label = new Label("Chào mừng bạn đến với chương trình quản lý sinh viên");
        Button button1 = new Button("Thông Tin Nhân Viên!!!");
        Button button2 = new Button("Lương nhân viên!!!");
        button1.setOnAction(event -> {
            window.setScene(scene);
        });
        button2.setOnAction(event -> {
//            window.setScene(sceneLuong);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button1,button2);
        Scene scene1 = new Scene(layout1, 1500, 700);
        return  scene1;
    }
}
