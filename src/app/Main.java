/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import service.MahasiswaService;
import java.util.Scanner;

/**
 *
 * @author Lingga Kaindra
 */
//public class Main {
//    public static void main(String[] args) {
//        try {
//            database.Koneksi.getConnection();
//            System.out.println("Koneksi ke database berhasil!");
//        } catch (Exception e) {
//            System.out.println("Koneksi gagal!");
//            e.printStackTrace();
//        }
//        Scanner input = new Scanner(System.in);
//        MahasiswaService service = new MahasiswaService();
//
//        int pilih;
//
//        do {
//            System.out.println("===== MENU =====");
//            System.out.println("1. Tambah Data");
//            System.out.println("2. Lihat Data");
//            System.out.println("3. Update Data");
//            System.out.println("4. Hapus Data");
//            System.out.println("0. Keluar");
//            System.out.print("Pilih: ");
//
//            pilih = input.nextInt();
//            input.nextLine();
//
//            switch (pilih) {
//                case 1 -> service.create();
//                case 2 -> service.read();
//                case 3 -> service.update();
//                case 4 -> service.delete();
//                case 0 -> System.out.println("Keluar...");
//                default -> System.out.println("Pilihan salah!");
//            }
//
//        } while (pilih != 0);
//    }
//}
public class Main {

//    public static void main(String[] args) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuFrame().setVisible(true);
//            }
//        });
//
//    }
    public static void main(String[] args) {

        new FormMahasiswa().setVisible(true);

    }
}
