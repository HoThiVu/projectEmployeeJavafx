package com.example.projectemployee;

import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.Employee;
import com.example.projectemployee.models.GridHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainProjectEmployee extends Application {
    //    Scene Scene;
    boolean formSaveAddStatus = false;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage Scene) {
        DBConnection db = new DBConnection();
        //form
        GridHelper gridHelper = new GridHelper();

        Scene.setTitle("Final Project JavaFX-HTV");
        // Tạo một ScrollPane
        ScrollPane scrollPane = new ScrollPane();

        VBox root = new VBox();
//        VBox showListEmployee =new VBox();

        Button btnADD = new Button("ADD");
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
        rootGridPane.setAlignment(Pos.CENTER);
        formGridPane.setAlignment(Pos.CENTER);

        getDisplayEmployees(root, db, rootGridPane, formGridPane);

        btnADD.setOnAction(e -> {

            TextField textfieldMNV = (TextField) formGridPane.getChildren().get(1);
            TextField textfieldHoTen = (TextField) formGridPane.getChildren().get(3);
            TextField textfieldNgaySinh = (TextField) formGridPane.getChildren().get(5);
            TextField textfieldNoiSinh = (TextField) formGridPane.getChildren().get(7);
            TextField textfieldNguyenQuan = (TextField) formGridPane.getChildren().get(9);
            TextField textfieldQuocTich = (TextField) formGridPane.getChildren().get(11);
            TextField textfieldDanToc = (TextField) formGridPane.getChildren().get(13);
            Employee employ = new Employee(Integer.parseInt(textfieldMNV.getText()), textfieldHoTen.getText(), textfieldNgaySinh.getText(), textfieldNoiSinh.getText(), textfieldNguyenQuan.getText(), textfieldQuocTich.getText(), textfieldDanToc.getText());

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
            }
            rootGridPane.getChildren().clear();
            getDisplayEmployees(root, db, rootGridPane, formGridPane);

        });
        gridHelper.displayGridForm(formGridPane, btnADD); // gọi hàm gridHelper
        gridHelper.displayLb(rootGridPane);

        root.getChildren().addAll(formGridPane, rootGridPane);
        Scene.setScene(new Scene(scrollPane, 1500, 700));
        scrollPane.setContent(root);
        Scene.show();

    }

    void getDisplayEmployees(VBox vBox, DBConnection db, GridPane rootGridPane, GridPane formGridPane) {
        ArrayList<Employee> emloyeeList = db.getEmployees();
        GridHelper gridHelper_AddForm = new GridHelper();
        gridHelper_AddForm.displayLb(rootGridPane);
        for (int i = 0; i < emloyeeList.size(); i++) {
            Button btnDel = new Button("DELETE");
            Button btnEdit = new Button("EDIT");
            rootGridPane.addRow(i + 6, new Label(" " + emloyeeList.get(i).maNV), new Label(" " + emloyeeList.get(i).hoTen),
                    new Label("" + emloyeeList.get(i).ngaySinh), new Label(" " + emloyeeList.get(i).noiSinh), new Label(" " + emloyeeList.get(i).nguyenQuan),
                    new Label(" " + emloyeeList.get(i).quocTich), new Label(" " + emloyeeList.get(i).danToc));

            int finalI = i;
            btnDel.setOnAction(e -> {
                db.deleteEmployee(emloyeeList.get(finalI).maNV);
                rootGridPane.getChildren().clear();
                getDisplayEmployees(vBox, db, rootGridPane, formGridPane);
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
                        textfieldMNV.setText(String.valueOf(emloyeeList.get(finalI).maNV));
                        textfieldHoTen.setText(emloyeeList.get(finalI).hoTen);
                        textfieldNgaySinh.setText(emloyeeList.get(finalI).ngaySinh);
                        textfieldNoiSinh.setText(emloyeeList.get(finalI).noiSinh);
                        textfieldNguyenQuan.setText(emloyeeList.get(finalI).nguyenQuan);
                        textfieldQuocTich.setText(emloyeeList.get(finalI).quocTich);
                        textfieldDanToc.setText(emloyeeList.get(finalI).danToc);

                    }
            );
            rootGridPane.add(btnDel, 7, i + 6);
            rootGridPane.add(btnEdit, 8, i + 6);

        }
        System.out.print(vBox.getChildren());
    }
}



