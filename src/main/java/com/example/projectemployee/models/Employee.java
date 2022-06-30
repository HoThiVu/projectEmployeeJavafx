package com.example.projectemployee.models;

public class Employee {

    private int maNV;
    private String hoTen;
    private String ngaySinh;
    private String noiSinh;
    private String nguyenQuan;
    private String quocTich;
    private String danToc;
//
    private int ID_Luong;
    private String CapBac;
    private float Luong;
    private int HeSoLuong;

    public Employee(int maNV, String hoTen, String ngaySinh, String noiSinh, String nguyenQuan, String quocTich, String danToc,int ID_Luong,String CapBac, float Luong, int HeSoLuong) {
        setDanToc(danToc);
        setHoTen(hoTen);
        setNgaySinh(ngaySinh);
        setNoiSinh(noiSinh);
        setNguyenQuan(nguyenQuan);
        setMaNV(maNV);
        setQuocTich(quocTich);
        setID_Luong(ID_Luong);
        setCapBac(CapBac);
        setHeSoLuong(HeSoLuong);
        setLuong(Luong);
    }
    public Employee(int maNV, String hoTen, String ngaySinh, String noiSinh, String nguyenQuan, String quocTich, String danToc) {
        setDanToc(danToc);
        setHoTen(hoTen);
        setNgaySinh(ngaySinh);
        setNoiSinh(noiSinh);
        setNguyenQuan(nguyenQuan);
        setMaNV(maNV);
        setQuocTich(quocTich);
    }

    public int getMaNV() {
        return maNV;
    }

    public String getDanToc() {
        return danToc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public int getID_Luong() {
        return ID_Luong;
    }

    public String getCapBac() {
        return CapBac;
    }

    public int getHeSoLuong() {
        return HeSoLuong;
    }

    public float getLuong() {
        return Luong;
    }

    //-----
    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setID_Luong(int ID_Luong) {
        this.ID_Luong = ID_Luong;
    }

    public void setCapBac(String capBac) {
        this.CapBac = capBac;
    }

    public void setLuong(float luong) {
        this.Luong = luong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.HeSoLuong = heSoLuong;
    }
}

