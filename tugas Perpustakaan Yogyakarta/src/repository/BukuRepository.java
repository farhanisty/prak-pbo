/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Buku;
/**
 * 
 *
 * @author farhannivta
 */
public interface BukuRepository {
    public List<Buku> getAll();
    public boolean insert(Buku buku);
    public boolean delete(int id);
    public boolean update(Buku buku);
    public Buku getById(int id);
    public List<Buku> getByColumn(String column, String key);
}
