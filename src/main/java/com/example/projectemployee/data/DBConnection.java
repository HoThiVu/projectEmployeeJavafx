package com.example.projectemployee.data;
import com.example.projectemployee.data.DBConnection;
import com.example.projectemployee.models.Employee;
import javafx.scene.Node;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DBConnection {
    private Connection connection;
    public DBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/projectemployee", "root", "");
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e + "  ket nối thất bại");
        }
    }
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "SELECT thongtinnhanvien.MaNV, thongtinnhanvien.HoTen, thongtinnhanvien.NgaySinh, thongtinnhanvien.NoiSinh, thongtinnhanvien.NguyenQuan, thongtinnhanvien.QuocTich, thongtinnhanvien.DanToc, luong.ID_Luong, luong.Luong,luong.CapBac, luong.HeSoLuong  FROM thongtinnhanvien CROSS JOIN luong ON luong.MaNV = thongtinnhanvien.MaNV";
        try {
            ResultSet st = connection.prepareStatement(sql).executeQuery();
            while (st.next()) {
//                System.out.println("id: " + st.getInt("id"));
//                System.out.println("name: " + st.getString("name"));
//                System.out.println("score: " + st.getFloat("score"));
                Employee employ = new Employee(
                        st.getInt("MaNV"),
                        st.getString("HoTen"),
                        st.getString("NgaySinh"),
                        st.getString("NoiSinh"),
                        st.getString("NguyenQuan"),
                        st.getString("QuocTich"),
                        st.getString("DanToc"),
//
                        st.getInt("ID_Luong"),
                        st.getString("CapBac"),
                        st.getFloat("Luong"),
                        st.getInt("HeSoLuong")

                );
                list.add(employ);
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertEmployee(Employee employ) {
        String sql = "INSERT INTO thongtinnhanvien (MaNV,HoTen,NgaySinh,NoiSinh,NguyenQuan,QuocTich,DanToc) VALUES (" + employ.getMaNV() + ",'" + employ.getHoTen() + "','" + employ.getNgaySinh() + "','" + employ.getNoiSinh() +
                "','" + employ.getNguyenQuan() + "','" + employ.getQuocTich() + "','" + employ.getDanToc() + "')";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
            System.out.println("them mot hoc sinh thanh cong !!!");
            sql =  "INSERT INTO luong (ID_Luong, MaNV,CapBac, Luong, HeSoLuong) VALUES (" + employ.getID_Luong() + ",'" + employ.getMaNV() + ",'" + employ.getCapBac() + "','" + employ.getLuong() + "','" + employ.getHeSoLuong()+ "')";
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updataEmployee(Employee employ) {
        String sql = "UPDATE thongtinnhanvien SET HoTen = '" + employ.getHoTen() + "',NgaySinh = '" + employ.getNgaySinh() + "',NoiSinh = '" + employ.getNoiSinh() +
                "',NguyenQuan = '" + employ.getNguyenQuan() + "',QuocTich = '" + employ.getQuocTich() + "',DanToc = '" + employ.getDanToc() + "' WHERE MaNV = " + employ.getMaNV() + "";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(int maNV) {
        String sql = " DELETE FROM thongtinnhanvien WHERE MaNV = " + maNV + "";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertSalary(Employee employee){
        String sql = "INSERT INTO luong (ID_LUONG,MaNV,CapBac,Luong,HesoLuong) VALUES (" + employee.getID_Luong() + ",'" + employee.getMaNV() +
                "','" + employee.getCapBac() + "','" + employee.getLuong() +
                "','" + employee.getHeSoLuong()+"')";
        try {
            connection.prepareStatement(sql).executeUpdate();
            System.out.println("good");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



