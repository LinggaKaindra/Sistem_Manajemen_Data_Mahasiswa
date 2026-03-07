/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Mahasiswa;
import database.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Lingga Kaindra
 */
//public class MahasiswaService implements Crudable{
//    Scanner input = new Scanner(System.in);
//    @Override
//public void create() {
//    try {
//        Connection conn = database.Koneksi.getConnection();
//
//        System.out.print("NIM: ");
//        String nim = input.nextLine();
//
//        System.out.print("Nama: ");
//        String nama = input.nextLine();
//        
//        if (nim.isEmpty() || nama.isEmpty()) {
//        System.out.println("Data tidak boleh kosong!");
//        return;
//        }
//
//        System.out.print("Umur: ");
//        int umur = input.nextInt();
//        input.nextLine();
//        
//        if (umur <= 0) {
//        System.out.println("Umur tidak valid!");
//        return;
//        }
//
//        System.out.print("Jurusan: ");
//        String jurusan = input.nextLine();
//
//        String sql = "INSERT INTO mahasiswa (nim, nama, umur, jurusan) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//        ps.setString(1, nim);
//        ps.setString(2, nama);
//        ps.setInt(3, umur);
//        ps.setString(4, jurusan);
//
//        ps.executeUpdate();
//
//        System.out.println("Data berhasil ditambahkan!");
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//
//    @Override
//public void read() {
//    try {
//        Connection conn = database.Koneksi.getConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM mahasiswa");
//
//        ArrayList<Mahasiswa> list = new ArrayList<>();
//
//        // Ambil data dari database lalu dimasukkan ke ArrayList
//        while (rs.next()) {
//            Mahasiswa mhs = new Mahasiswa(
//                    rs.getString("nim"),
//                    rs.getString("nama"),
//                    rs.getInt("umur"),
//                    rs.getString("jurusan")
//            );
//            list.add(mhs);
//        }
//
//        System.out.println("\n===== DATA MAHASISWA =====");
//
//        // Loop ArrayList untuk tampilkan data
//        for (Mahasiswa m : list) {
//            m.displayInfo();   // polymorphism
//            System.out.println("---------------------------");
//        }
//        if (list.isEmpty()) {
//            System.out.println("Belum ada data mahasiswa.");
//        }
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//
//    @Override
//public void update() {
//    try {
//        Connection conn = database.Koneksi.getConnection();
//
//        System.out.print("Masukkan NIM yang ingin diupdate: ");
//        int id = input.nextInt();
//        input.nextLine();
//
//        System.out.print("Nama baru: ");
//        String nama = input.nextLine();
//
//        System.out.print("Umur baru: ");
//        int umur = input.nextInt();
//        input.nextLine();
//
//        System.out.print("Jurusan baru: ");
//        String jurusan = input.nextLine();
//        
//        String sql = "UPDATE mahasiswa SET nama=?, umur=?, jurusan=? WHERE nim=?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//        ps.setString(1, nama);
//        ps.setInt(2, umur);
//        ps.setString(3, jurusan);
//        ps.setInt(4, id);
//            
//        int rows = ps.executeUpdate();
//
//        if (rows > 0) {
//            System.out.println("Data berhasil diupdate!");
//        } else {
//            System.out.println("Data tidak ditemukan!");
//        }
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//// Method untuk menghapus data mahasiswa berdasarkan NIM
//    @Override
//public void delete() {
//    try {
//        Connection conn = database.Koneksi.getConnection();
//
//        System.out.print("Masukkan NIM yang ingin dihapus: ");
//        String nim = input.nextLine();
//
//        if (nim.isEmpty()) {
//            System.out.println("NIM tidak boleh kosong!");
//            return;
//        }
//
//        String sql = "DELETE FROM mahasiswa WHERE nim=?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, nim);
//
//        int rows = ps.executeUpdate();
//
//        if (rows > 0) {
//            System.out.println("Data berhasil dihapus!");
//        } else {
//            System.out.println("Data tidak ditemukan!");
//        }
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//}
public class MahasiswaService {

    // CREATE / TAMBAH
    public void create(Mahasiswa m) {
        String sql = "INSERT INTO mahasiswa (nim, nama, umur, jurusan) VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNim());
            ps.setString(2, m.getName()); // Gunakan getName() atau getNama() sesuaikan model
            ps.setInt(3, m.getAge());     // Gunakan getAge() atau getUmur()
            ps.setString(4, m.getJurusan());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE / UBAH
    public void update(Mahasiswa m) {
    // Pastikan urutan tanda tanya (?) sesuai dengan ps.set...
    String sql = "UPDATE mahasiswa SET nama = ?, umur = ?, jurusan = ? WHERE nim = ?";
    
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // Ambil data dari object Mahasiswa (m)
        ps.setString(1, m.getName());    // Dari class Person
        ps.setInt(2, m.getAge());       // Dari class Person
        ps.setString(3, m.getJurusan()); // Dari class Mahasiswa
        ps.setString(4, m.getNim());     // Sebagai kunci pencarian
        
        int rowsUpdated = ps.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Update Berhasil di Database!");
        }
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
        return list;
    }
}