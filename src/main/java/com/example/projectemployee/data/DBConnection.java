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
            System.out.println(e + "    ket nối thất bại");
        }
    }
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM thongtinnhanvien";
        try {
            ResultSet st = connection.prepareStatement(sql).executeQuery();
            while (st.next()) {
//                System.out.println("id: " + st.getInt("id"));
//                System.out.println("name: " + st.getString("name"));
//                System.out.println("score: " + st.getFloat("score"));
                Employee employ = new Employee(
                        st.getInt("MaNV"),
                        st.getString("Hoten"),
                        st.getString("Ngaysinh"),
                        st.getString("Noisinh"),
                        st.getString("Nguyenquan"),
                        st.getString("Quoctich"),
                        st.getString("Dantoc")
                );
                list.add(employ);
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertEmployee(Employee employ) {
        String sql = "INSERT INTO thongtinnhanvien (MaNV,HoTen,NgaySinh,NoiSinh,NguyenQuan,QuocTich,DanToc) VALUES (" + employ.maNV + ",'" + employ.hoTen + "','" + employ.ngaySinh + "','" + employ.noiSinh + "','" + employ.nguyenQuan + "','" + employ.quocTich + "','" + employ.danToc + "')";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
            System.out.println("them mot hoc sinh thanh cong !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updataEmployee(Employee employ) {
        String sql = "UPDATE thongtinnhanvien SET HoTen = '" + employ.hoTen + "',NgaySinh = '" + employ.ngaySinh + "',NoiSinh = '" + employ.noiSinh + "',NguyenQuan = '" + employ.nguyenQuan + "',QuocTich = '" + employ.quocTich + "',DanToc = '" + employ.danToc + "' WHERE MaNV = " + employ.maNV + "";
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
}



