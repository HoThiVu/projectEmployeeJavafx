package com.example.projectemployee.models;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GridHelper {
    public void displayLb(GridPane rootGridPane) {

        //        ------------------------------------------------------------------------------Grid pane lable title name
        Label lblTitleMaNV = new Label("Mã NV");
        Label lblTitleHoTen = new Label("Họ Tên");
        Label lblTitleNgaySinh = new Label("Ngày Sinh");
        Label lblTitleNoiSinh = new Label("Nơi Sinh");
        Label lblTitleNguyenQuan = new Label("Nguyên Quán");
        Label lblTitleQuocTich = new Label("Quốc Tịch");
        Label lblTitleDanToc = new Label("Dân Tộc");
        Label lblTitleEdit = new Label("Delete");
        Label lblTitleDelete = new Label("Edit");

        //------------Grid pane lable title name
        rootGridPane.add(lblTitleMaNV, 0, 5);
        rootGridPane.add(lblTitleHoTen, 1, 5);
        rootGridPane.add(lblTitleNgaySinh, 2, 5);
        rootGridPane.add(lblTitleNoiSinh, 3, 5);
        rootGridPane.add(lblTitleNguyenQuan, 4, 5);
        rootGridPane.add(lblTitleQuocTich, 5, 5);
        rootGridPane.add(lblTitleDanToc, 6, 5);
        rootGridPane.add(lblTitleEdit, 7, 5);
        rootGridPane.add(lblTitleDelete, 8, 5);
    }
    public void displayLbLuong(GridPane rootGridPane){
        Label lblTitleID_Luong = new Label("ID Luong");
        Label lblTitleMaNV = new Label("Ma NV");
        Label lblTitleCapBac  = new Label("Cap Bac");
        Label lblTitleLuong = new Label("Luong Chinh");
        Label lblTitleHeSoLuong = new Label("He So Luong");


        //------------Grid pane lable title name
        rootGridPane.add(lblTitleID_Luong, 0, 6);
        rootGridPane.add(lblTitleMaNV, 1, 6);
        rootGridPane.add(lblTitleCapBac, 2, 6);
        rootGridPane.add(lblTitleLuong , 3, 6);
        rootGridPane.add(lblTitleHeSoLuong , 4, 6);

    }
    public void displayGrindSalary(GridPane formGridPane, Button btnADD){
        Label labelID_Luong = new Label("Nhập ID_Luong nhan vien :");
        TextField tfID_Luong = new TextField();
        //
        Label labelLuong = new Label("Nhập Luong nhan vien :");
        TextField tfLuong = new TextField();

        Label labelCapBac = new Label("Nhập cap bac nhan vien :");
        TextField tfCapBac = new TextField();

        Label labelHeSoLuong = new Label("Nhập he so luong nhan vien :");
        TextField tfHeSoLuong = new TextField();

        Label lblMaEmployee = new Label("Nhập Mã Nhân Viên :");
        TextField tfMaEmployee = new TextField();

        formGridPane.add(labelID_Luong, 4, 0);
        formGridPane.add(tfID_Luong, 5, 0);

        formGridPane.add(labelCapBac, 4, 1);
        formGridPane.add(tfCapBac, 5, 1);

        formGridPane.add(labelLuong, 4, 2);
        formGridPane.add(tfLuong, 5, 2);

        formGridPane.add(labelHeSoLuong, 4, 3);
        formGridPane.add(tfHeSoLuong, 5, 3);

        formGridPane.add(lblMaEmployee, 4, 4);
        formGridPane.add(tfMaEmployee, 5, 4);

        btnADD.setMaxWidth(200);
        formGridPane.add(btnADD, 2, 5);
    }
    public void displayGridForm(GridPane formGridPane, Button btnADD) {

        //FROM NHẬP -------------------------------
        Label lblMaEmployee = new Label("Nhập Mã Nhân Viên :");
        TextField tfMaEmployee = new TextField();

        Label labelHoTen = new Label(" Nhập Họ Tên :");
        TextField tfHoTen = new TextField();

        Label labelNgaySinh = new Label("Nhập Ngày Sinh :");
        TextField tfNgaySinh = new TextField();
//
        Label labelNoiSinh = new Label("Nhập Nơi Sinh :");
        TextField tfNoiSinh = new TextField();
        //
        Label labelNguyenQuan = new Label("Nhập Nguyên Quán :");
        TextField tfNguyenQuan = new TextField();
//
        Label labelQuocTich = new Label("Nhập Quốc Tịch :");
        TextField tfQuocTich = new TextField();
        //
        Label labelDanToc = new Label("Nhập Tên Dân Tộc :");
        TextField tfDanToc = new TextField();


        //--------------------------------Grid pane from
        formGridPane.add(lblMaEmployee, 0, 0);
        formGridPane.add(tfMaEmployee, 1, 0);
//
        formGridPane.add(labelHoTen, 0, 1);
        formGridPane.add(tfHoTen, 1, 1);
//
        formGridPane.add(labelNgaySinh, 0, 2);
        formGridPane.add(tfNgaySinh, 1, 2);
//
        formGridPane.add(labelNoiSinh, 0, 3);
        formGridPane.add(tfNoiSinh, 1, 3);
        //// hàng thứ ba
        formGridPane.add(labelNguyenQuan, 2, 0);
        formGridPane.add(tfNguyenQuan, 3, 0);
//
        formGridPane.add(labelQuocTich, 2, 1);
        formGridPane.add(tfQuocTich, 3, 1);
        //
        formGridPane.add(labelDanToc, 2, 2);
        formGridPane.add(tfDanToc, 3, 2);
//        ----luong COT:I , HANG:I1


        btnADD.setMaxWidth(200);
        formGridPane.add(btnADD, 2, 4);

    }

}
