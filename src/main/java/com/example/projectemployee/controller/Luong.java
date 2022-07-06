package com.example.projectemployee.controller;

import com.example.projectemployee.MainProjectEmployee;
import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.Employee;
import com.example.projectemployee.models.GridHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Optional;

public class Luong extends Application {
    private boolean statusForm = false;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

    }
    private  Stage window;
    private Scene scene1;
    public  Luong (Stage window, Scene scene1){
        this.window =  window;
        this.scene1 = scene1;
    }
    public Luong (){

    }
    public Scene renderLuong(){
        //Scene1
        Label label = new Label("Chao mừng bạn đến với thông tin Lương của nhân viên là :");

        Button back = new Button("QUAY LẠI !!!");
        WellcomeScene ws = new WellcomeScene();
        back.setOnAction(event -> {
            window.setScene(ws.renderMainboard(window,scene1));
        });
        VBox layout = new VBox();
        layout.getChildren().addAll(label, back);
        layout.getChildren().add(this.renderEmployeeSalary(new DBConnection().getSalary()));
        Scene sceneLuong = new Scene(layout, 1500, 700);
        return  sceneLuong;
    }
    // khởi tạo 1 hàm renderRow với nhiệm vuk show từng nv(lương ) theo hàng
    // Mỗi lần gọi hàm thì sẽ in ra mội hàng
    public void renderRow(Employee employee,GridPane gridPane,int index, DBConnection db){
        ArrayList<Employee> emloyeeList = db.getEmployees();
        Button btnEdit =  new Button("sua");

        btnEdit.setOnAction(e->{
            this.statusForm =true;
//            Button btnSave = (Button) gridPane.getChildren().get(14);
//            btnSave.setText("Save");
//            textFieldName.setText(String.valueOf(stdList.get(finalI).name));
//            textFieldScore.setText(String.valueOf(stdList.get(finalI).score));
            TextField textfieldId_luong = (TextField) gridPane.getChildren().get(1);
            TextField textfieldCapBac = (TextField) gridPane.getChildren().get(3);
            TextField textfieldLuong = (TextField) gridPane.getChildren().get(5);

            TextField textfieldHeSoLuong = (TextField) gridPane.getChildren().get(7);
            TextField textfieldMaNV = (TextField) gridPane.getChildren().get(9);


            textfieldId_luong.setText(String.valueOf(employee.getID_Luong()));
            textfieldCapBac.setText(employee.getCapBac());
            textfieldLuong.setText(String.valueOf(employee.getLuong()));
            textfieldHeSoLuong.setText(String.valueOf(employee.getHeSoLuong()));
            textfieldMaNV.setText(String.valueOf(employee.getMaNV()));
//            textfieldDanToc.setText(emloyeeList.get(finalI).getDanToc());
        });

            // viet them những trường vào đây
        gridPane.addRow(index,
                new Label( ""+employee.getID_Luong()),new Label(" "+employee.getMaNV()),
                new Label(" "+employee.getCapBac()),new Label(" "+employee.getLuong()), new Label(" "+employee.getHeSoLuong()),
                btnEdit);
                gridPane.setHgap(25);
                gridPane.setVgap(10);

    }
    public GridHelper renderLbLuong(GridPane rootGridPane){
                GridHelper LbLuong = new GridHelper();
                LbLuong.displayLbLuong(rootGridPane);
                return  LbLuong;
    }
    // render full screen for Salary
    public GridPane renderEmployeeSalary(ArrayList<Employee> employees){

        GridPane gridPane = new GridPane();
//        GridPane rootGridPane = new GridPane();
        GridHelper gridHelper = new GridHelper();
        Button btnSave = new Button("save");
        if(this.statusForm){
            btnSave.setText("Update");
        }
        gridHelper.displayGrindSalary(gridPane,btnSave);
        renderLbLuong(gridPane);
        // when btn was clicked it will create a object after that add  to database;

        btnSave.setOnAction(e->{
            TextField textfieldID_Luong = (TextField) gridPane.getChildren().get(1);
            TextField textfieldCapBac = (TextField) gridPane.getChildren().get(3);
            TextField textfieldLuong = (TextField) gridPane.getChildren().get(5);
            TextField textfieldHeSoLuong = (TextField) gridPane.getChildren().get(7);
            TextField maNV = (TextField) gridPane.getChildren().get(9);
            Employee employee = new Employee(Integer.parseInt(textfieldID_Luong.getText()),textfieldCapBac.getText(), Integer.parseInt(textfieldHeSoLuong.getText()),Float.parseFloat(textfieldLuong.getText()),Integer.parseInt(maNV.getText()));
            DBConnection dbConnection = new DBConnection();

            if(this.statusForm){
                dbConnection.updataSalary(employee);
                this.statusForm = false;
            }
            else {
                dbConnection.insertSalary(employee);
            }


            window.setScene( renderLuong());
        });

        for (int i = 0;i <employees.size();i ++){
            renderRow(employees.get(i),gridPane,i+7,new DBConnection());
        }
        return gridPane;
    }
}

