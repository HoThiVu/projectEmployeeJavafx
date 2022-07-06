package com.example.projectemployee;

import com.example.projectemployee.controller.Luong;
import com.example.projectemployee.controller.WellcomeScene;
import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.Employee;
import com.example.projectemployee.models.GridHelper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

//import static java.rmi.server.LogStream.log;

public class MainProjectEmployee extends Application {
    boolean formSaveAddStatus = false;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) {
        DBConnection db = new DBConnection();
        //form
        GridHelper gridHelper = new GridHelper();

        primaryStage.setTitle("Final Project JavaFX-HTV");
        // Tạo một ScrollPane
        ScrollPane scrollPane = new ScrollPane();

        VBox root = new VBox();
//        VBox showListEmployee =new VBox();
        Button btnBack = new Button("<--- BACK");

        Button btnADD = new Button("ADD");
        Button btnADDLuong = new Button("Them lUONG");
//        Button btnReset = new Button("Reset");

//        Chia GridPane----------------------------------
        GridPane rootGridPane = new GridPane();
        GridPane formGridPane = new GridPane();

        formGridPane.setPadding(new Insets(20));
        rootGridPane.setPadding(new Insets(20));
        root.setPadding(new Insets(0, 0, 0, 50));
        formGridPane.setHgap(25);
        formGridPane.setVgap(10);
        rootGridPane.setHgap(25);
        rootGridPane.setVgap(10);
//        rootGridPane.setAlignment(Pos.CENTER);
//        formGridPane.setAlignment(Pos.CENTER);

        getDisplayEmployees(root, db, rootGridPane, formGridPane);

        btnADD.setOnAction(e -> {

            TextField textfieldMNV = (TextField) formGridPane.getChildren().get(1);
            TextField textfieldHoTen = (TextField) formGridPane.getChildren().get(3);
            TextField textfieldNgaySinh = (TextField) formGridPane.getChildren().get(5);
            TextField textfieldNoiSinh = (TextField) formGridPane.getChildren().get(7);
            TextField textfieldNguyenQuan = (TextField) formGridPane.getChildren().get(9);
            TextField textfieldQuocTich = (TextField) formGridPane.getChildren().get(11);
            TextField textfieldDanToc = (TextField) formGridPane.getChildren().get(13);
//
//            TextField textfieldID_Luong = (TextField) formGridPane.getChildren().get(15);
//            TextField textfieldCapBac = (TextField) formGridPane.getChildren().get(17);
//            TextField textfieldLuong = (TextField) formGridPane.getChildren().get(19);
//            TextField textfieldHeSoLuong = (TextField) formGridPane.getChildren().get(21);

            Employee employ = new Employee(Integer.parseInt(textfieldMNV.getText()), textfieldHoTen.getText(), textfieldNgaySinh.getText(), textfieldNoiSinh.getText(),
                    textfieldNguyenQuan.getText(), textfieldQuocTich.getText(), textfieldDanToc.getText());

            if (formSaveAddStatus == true) {
                db.updataEmployee(employ);
                System.out.println("edit success");
                //-------------reset lai textfied ne
                textfieldMNV.setText("");
                textfieldHoTen.setText("");
                textfieldNgaySinh.setText("");
                textfieldNoiSinh.setText("");
                textfieldNguyenQuan.setText("");
                textfieldQuocTich.setText("");
                textfieldDanToc.setText("");
//
//                textfieldID_Luong.setText("");
//                textfieldCapBac.setText("");
//                textfieldLuong.setText("");
//                textfieldHeSoLuong.setText("");

                formSaveAddStatus = false;

            } else {
                db.insertEmployee(employ);
                System.out.println("add success");
                //-------------reset lai textfied ne
                textfieldMNV.setText("");
                textfieldHoTen.setText("");
                textfieldNgaySinh.setText("");
                textfieldNoiSinh.setText("");
                textfieldNguyenQuan.setText("");
                textfieldQuocTich.setText("");
                textfieldDanToc.setText("");
//
//                textfieldID_Luong.setText("");
//                textfieldCapBac.setText("");
//                textfieldLuong.setText("");
//                textfieldHeSoLuong.setText("");
            }
            rootGridPane.getChildren().clear();
            getDisplayEmployees(root, db, rootGridPane, formGridPane);
        });
        gridHelper.displayGridForm(formGridPane, btnADD); // gọi hàm gridHelper
        gridHelper.displayLb(rootGridPane);

        root.getChildren().addAll(btnBack,btnADDLuong,formGridPane, rootGridPane);

        Scene scMain = new Scene(scrollPane, 1200, 500);
        WellcomeScene wS = new WellcomeScene();
        Luong luong = new Luong();
        btnBack.setOnAction(e -> {
            primaryStage.setScene(wS.renderMainboard(primaryStage,scMain));
        });
        btnADDLuong.setOnAction(e -> {
            primaryStage.setScene(luong.renderLuong(primaryStage,scMain));
        });
        primaryStage.setScene(wS.renderMainboard(primaryStage,scMain));
        scrollPane.setContent(root);
        primaryStage.show();
    }
   void getDisplayEmployees(VBox vBox, DBConnection db, GridPane rootGridPane, GridPane formGridPane) {
        ArrayList<Employee> emloyeeList = db.getEmployees();
        GridHelper gridHelper_AddForm = new GridHelper();
        gridHelper_AddForm.displayLb(rootGridPane);
        for (int i = 0; i < emloyeeList.size(); i++){
            Button btnDel = new Button("DELETE");
            Button btnEdit = new Button("EDIT");
            rootGridPane.addRow(i + 6, new Label(" " + emloyeeList.get(i).getMaNV()), new Label(" " + emloyeeList.get(i).getHoTen()),
                    new Label("" + emloyeeList.get(i).getNgaySinh()), new Label(" " + emloyeeList.get(i).getNoiSinh()), new Label(" " + emloyeeList.get(i).getNguyenQuan()),
                    new Label(" " + emloyeeList.get(i).getQuocTich()), new Label(" " + emloyeeList.get(i).getDanToc()));
            int finalI = i;
            btnDel.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation");
                alert.setHeaderText("Alert Information");
                alert.setContentText("choose your option");

                ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get()== buttonTypeYes)
                    System.out.println("Code for yes");
                else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
                    System.out.println("Code for no");
                else
                    System.out.println("Code for cancel");
                String message = result.get().getText();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Information");
                alert1.setHeaderText("Notification");
                alert1.setContentText(message);
                alert1.show();
                db.deleteEmployee(emloyeeList.get(finalI).getMaNV());
                rootGridPane.getChildren().clear();
                getDisplayEmployees(vBox, db, rootGridPane, formGridPane);
                //-------------reset lai textfied ne
                TextField textfieldMNV = (TextField) formGridPane.getChildren().get(1);
                TextField textfieldHoTen = (TextField) formGridPane.getChildren().get(3);
                TextField textfieldNgaySinh = (TextField) formGridPane.getChildren().get(5);
//                log("Hello world!");
                TextField textfieldNoiSinh = (TextField) formGridPane.getChildren().get(7);
                TextField textfieldNguyenQuan = (TextField) formGridPane.getChildren().get(9);
                TextField textfieldQuocTich = (TextField) formGridPane.getChildren().get(11);
                TextField textfieldDanToc = (TextField) formGridPane.getChildren().get(13);
                textfieldMNV.setText("");
                textfieldHoTen.setText("");
                textfieldNgaySinh.setText("");
                textfieldNoiSinh.setText("");
                textfieldNguyenQuan.setText("");
                textfieldQuocTich.setText("");
                textfieldDanToc.setText("");
            });
            btnEdit.setOnAction(e -> {
                        this.formSaveAddStatus = true;
                        Button btnSave = (Button) formGridPane.getChildren().get(14);
                        btnSave.setText("Save");
//            textFieldName.setText(String.valueOf(stdList.get(finalI).name));
//            textFieldScore.setText(String.valueOf(stdList.get(finalI).score));
                        TextField textfieldMNV = (TextField) formGridPane.getChildren().get(1);
                        TextField textfieldHoTen = (TextField) formGridPane.getChildren().get(3);
                        TextField textfieldNgaySinh = (TextField) formGridPane.getChildren().get(5);

                        TextField textfieldNoiSinh = (TextField) formGridPane.getChildren().get(7);
                        TextField textfieldNguyenQuan = (TextField) formGridPane.getChildren().get(9);
                        TextField textfieldQuocTich = (TextField) formGridPane.getChildren().get(11);
                        TextField textfieldDanToc = (TextField) formGridPane.getChildren().get(13);
                        textfieldMNV.setText(String.valueOf(emloyeeList.get(finalI).getMaNV()));
                        textfieldHoTen.setText(emloyeeList.get(finalI).getHoTen());
                        textfieldNgaySinh.setText(emloyeeList.get(finalI).getNgaySinh());
                        textfieldNoiSinh.setText(emloyeeList.get(finalI).getNoiSinh());
                        textfieldNguyenQuan.setText(emloyeeList.get(finalI).getNguyenQuan());
                        textfieldQuocTich.setText(emloyeeList.get(finalI).getQuocTich());
                        textfieldDanToc.setText(emloyeeList.get(finalI).getDanToc());
                    }
            );
            rootGridPane.add(btnDel, 7, i + 6);
            rootGridPane.add(btnEdit, 8, i + 6);
        }
        System.out.print(vBox.getChildren());
    }
}



