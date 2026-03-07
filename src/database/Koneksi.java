/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
///**
// *
// * @author Lingga Kaindra
// */
//public class Koneksi {
//    private static final String URL = "jdbc:mysql://localhost:3306/db_mahasiswa";
//    private static final String USER = "root";
//    private static final String PASSWORD = "";
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//}

package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            // PERBAIKAN: Cek jika conn null ATAU sudah tertutup (isClosed)
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
                String user = "root";
                String pass = "";
                conn = DriverManager.getConnection(url, user, pass);
            }
        } catch (SQLException e) {
            System.out.println("Gagal koneksi: " + e.getMessage());
        }
        return conn;
    }
}