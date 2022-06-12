package com.example.projectemployee.models;

public class Employee {
    //    public String Ngaysinh;
    //    public String MaNV;
    public int maNV;
    public String hoTen;
    public String ngaySinh;
    public String noiSinh;
    public String nguyenQuan;
    public String quocTich;
    public String danToc;

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


}

