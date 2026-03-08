package service;

import model.Mahasiswa;
import database.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MahasiswaService implements Crudable{

    // CREATE / TAMBAH
    // Method ini digunakan untuk menambahkan data mahasiswa ke database
    public void create(Mahasiswa m) {
        String sql = "INSERT INTO mahasiswa (nim, nama, umur, jurusan) VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNim());
            ps.setString(2, m.getName()); // Gunakan getName() atau getNama()
            ps.setInt(3, m.getAge());     // Gunakan getAge() atau getUmur()
            ps.setString(4, m.getJurusan());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE / UBAH
    public void update(Mahasiswa m) {
    String sql = "UPDATE mahasiswa SET nama = ?, umur = ?, jurusan = ? WHERE nim = ?";
    
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // Ambil data dari object Mahasiswa (m)
        ps.setString(1, m.getName());    // Dari class Person
        ps.setInt(2, m.getAge());       // Dari class Person
        ps.setString(3, m.getJurusan()); // Dari class Mahasiswa
        ps.setString(4, m.getNim());     // Sebagai kunci pencarian
        
        ps.executeUpdate();
        
    } catch (SQLException e) {
        System.out.println("Update Gagal: " + e.getMessage());
    }
}

    // DELETE / HAPUS
    public void delete(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET ALL / TAMPIL DATA
    // Method ini digunakan untuk mengambil seluruh data mahasiswa dari database
public List<Mahasiswa> getAll() {

    List<Mahasiswa> list = new ArrayList<>();
    String sql = "SELECT * FROM mahasiswa";

    try (Connection conn = Koneksi.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Mahasiswa m = new Mahasiswa(
                rs.getString("nim"),
                rs.getString("nama"),
                rs.getInt("umur"),
                rs.getString("jurusan")
            );
            list.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    Mahasiswa[] dataArray = list.toArray(new Mahasiswa[0]);

    for (Mahasiswa m : dataArray) {
        System.out.println(m.getName());
    }

    return list;
}
}