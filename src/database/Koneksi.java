/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lingga Kaindra
 */

public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            // Mengecek jika conn null atau sudah tertutup (isClosed)
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