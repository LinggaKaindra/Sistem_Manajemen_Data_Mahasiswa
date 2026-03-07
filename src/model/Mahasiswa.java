/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lingga Kaindra
 */
//public class Mahasiswa extends Person {
//
//    private String nim;
//    private String jurusan;
//
//    
//    public Mahasiswa(String nim, String name, int age, String jurusan) {
//        super(name, age);
//        this.nim = nim;
//        this.jurusan = jurusan;
//    }
//    @Override
//    public void displayInfo() {
//        System.out.println("NIM: " + nim);
//        super.displayInfo();  // menampilkan nama & umur
//        System.out.println("Jurusan: " + jurusan);
//    }
//    public String getNim() {
//    return nim;
//}
//
//    public void setNim(String nim) {
//        this.nim = nim;
//    }
//
//    public String getJurusan() {
//        return jurusan;
//    }
//
//    public void setJurusan(String jurusan) {
//        this.jurusan = jurusan;
//    }
//}

public class Mahasiswa extends Person {
    private String nim;
    private String jurusan;

    public Mahasiswa(String nim, String nama, int umur, String jurusan) {
        // super() memanggil constructor dari class Person
        super(nama, umur); 
        this.nim = nim;
        this.jurusan = jurusan;
    }

    // Atribut NIM dan Jurusan spesifik milik Mahasiswa
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    
    // name dan age otomatis tersedia karena extends Person
}