package com.example.projectemployee.controller;

import com.example.projectemployee.MainProjectEmployee;
import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.GridHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Luong extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    public Scene renderLuong(Stage window, Scene scene1){
        //Scene1
        Label label = new Label("Chao mừng bạn đến với thông tin Lương của nhân viên là :");
//        Button back = new Button("Thông Tin Nhân Viên!!!");
        Button back = new Button("Bạn đang đứng ở trang lương bạn có thể nhấn Trở lại trang chủ!!!");
        WellcomeScene ws = new WellcomeScene();
        back.setOnAction(event -> {
            window.setScene(ws.renderMainboard(window,scene1));
        });

GridPane gridPaneFromLuong = new GridPane();
        MainProjectEmployee mainProjectEmployee = new MainProjectEmployee();
//        mainProjectEmployee.getDisplayEmployees(root);
        GridHelper fromLuong = new GridHelper();
//        fromLuong.displayGridForm(formGridPane,btnADD);


        VBox layout1 = new VBox();


        layout1.getChildren().addAll(label, back);
        Scene sceneLuong = new Scene(layout1, 1500, 700);
        return  sceneLuong;
    }
}
