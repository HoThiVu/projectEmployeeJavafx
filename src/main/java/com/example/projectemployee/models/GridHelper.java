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
        Label lblTitleEdit = new Label("Edit");
        Label lblTitleDelete = new Label("Delete");
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

        btnADD.setMaxWidth(200);
        formGridPane.add(btnADD, 2, 4);
//        formGridPane.add(btnReset, 3, 4);
    }

}
