/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.Mahasiswa;
import java.util.List;
/**
 *
 * @author Lingga Kaindra
 */
public interface Crudable {
    void create(Mahasiswa m);
    void update(Mahasiswa m);
    void delete(String nim);
    List<Mahasiswa> getAll();
}
