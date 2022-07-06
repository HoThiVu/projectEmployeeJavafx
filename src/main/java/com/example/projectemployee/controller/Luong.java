package com.example.projectemployee.controller;

import com.example.projectemployee.MainProjectEmployee;
import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.Employee;
import com.example.projectemployee.models.GridHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        GridHelper fromLuong = new GridHelper();
        VBox layout1 = new VBox();

        layout1.getChildren().addAll(label, back);
        layout1.getChildren().add(this.renderEmployeeSalary(new DBConnection().getEmployees()));
        Scene sceneLuong = new Scene(layout1, 1500, 700);
        return  sceneLuong;
    }
    // khởi tạo 1 hàm renderRow với nhiệm vuk show từng nv(lương ) theo hàng
    // Mỗi lần gọi hàm thì sẽ in ra mội hàng
    public void renderRow(Employee employee,GridPane gridPane,int index){
            // viet them những trường vào đây
        gridPane.addRow(index,new Label( ""+employee.getID_Luong()), new Label(" "+employee.getHeSoLuong()));
    }

    // render full screen for Salary
    public GridPane renderEmployeeSalary(ArrayList<Employee> employees){
        GridPane gridPane = new GridPane();
        GridHelper gridHelper = new GridHelper();
        Button btnSave = new Button("save");
//        gridPane.addRow(new Label(""),new Label(),new Label("ew  new Label()")
        gridHelper.displayGrindSalary(gridPane,btnSave);

        // when btn was clicked it will create a object after that add  to database;
        btnSave.setOnAction(e->{

            TextField textfieldID_Luong = (TextField) gridPane.getChildren().get(1);
            TextField textfieldCapBac = (TextField) gridPane.getChildren().get(3);
            TextField textfieldLuong = (TextField) gridPane.getChildren().get(5);
            TextField textfieldHeSoLuong = (TextField) gridPane.getChildren().get(7);

            TextField maNV = (TextField) gridPane.getChildren().get(9);
            Employee employee = new Employee(Integer.parseInt(textfieldID_Luong.getText()),textfieldCapBac.getText(),
                    Integer.parseInt(textfieldHeSoLuong.getText()),Float.parseFloat(textfieldLuong.getText()),Integer.parseInt(maNV.getText()));
                    DBConnection dbConnection = new DBConnection();
                    dbConnection.insertSalary(employee);
        });

        for (int i = 0;i <employees.size();i ++){
            renderRow(employees.get(i),gridPane,i+8);
        }
        return gridPane;
    }
}

