/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lingga Kaindra
 */
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
    
    @Override
public void displayInfo() {
    System.out.println("NIM : " + nim);
    System.out.println("Nama : " + name);
    System.out.println("Umur : " + age);
    System.out.println("Jurusan : " + jurusan);
}

// OVERLOADING
public void displayInfo(boolean detail) {

    if(detail){
        displayInfo();
    }else{
        System.out.println("NIM : " + nim + " | Nama : " + name);
    }

}
    // name dan age otomatis tersedia karena extends Person
}