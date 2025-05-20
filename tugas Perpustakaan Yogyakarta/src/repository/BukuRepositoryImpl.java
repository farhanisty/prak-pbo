/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.Connector;
import model.Buku;

/**
 *
 * @author farhannivta
 */
public class BukuRepositoryImpl implements BukuRepository {
    @Override
    public List<Buku> getAll() {
        List<Buku> books = new ArrayList<Buku>();
        
        Connection conn = Connector.getInstance();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM buku");
            
            while(rs.next()) {
                Buku book = new Buku();
                book.id = rs.getInt("id");
                book.genre = rs.getString("genre");
                book.penulis = rs.getString("penulis");
                book.penerbit = rs.getString("penerbit");
                book.lokasi = rs.getString("lokasi");
                book.judul = rs.getString("judul");
                book.stock = rs.getInt("stock");
                
                books.add(book);
            }
            
            return books;
        } catch(SQLException e) {
            return books;
        }
    }
    
    @Override
    public boolean insert(Buku book) {
        PreparedStatement statement = null;
        
        try {
            statement = Connector.getInstance().prepareStatement("INSERT INTO buku(judul, genre, penulis, penerbit, lokasi, stock) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, book.judul);
            statement.setString(2, book.genre);
            statement.setString(3, book.penulis);
            statement.setString(4, book.penerbit);
            statement.setString(5, book.lokasi);
            statement.setInt(6, book.stock);
            
            statement.executeUpdate();
        }catch(SQLException e) {
            return false;
        } finally {
            try {
                statement.close();
            } catch(SQLException e) {
                return false;
            }
            
        }
        
        return true;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = Connector.getInstance().prepareStatement("DELETE FROM buku WHERE id = ?");
        
            statement.setInt(1, id);
            statement.execute();
        }catch(SQLException e) {
           return false;
        } finally {
            try {
                statement.close();
            } catch(SQLException e) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean update(Buku buku) {
        PreparedStatement statement = null;
        try {
            statement = Connector.getInstance().prepareStatement("UPDATE buku SET judul = ?, genre = ?, penulis = ?, penerbit = ?, lokasi = ?, stock = ? WHERE id = ?");
            
            statement.setString(1, buku.judul);
            statement.setString(2, buku.genre);
            statement.setString(3, buku.penulis);
            statement.setString(4, buku.penerbit);
            statement.setString(5, buku.lokasi);
            statement.setInt(6, buku.stock);
            statement.setInt(7, buku.id);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException e ) {
                System.out.print(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public Buku getById(int id) {
        PreparedStatement statement = null;
        Buku book = new Buku();
        try {
            statement = Connector.getInstance().prepareStatement("SELECT * FROM buku WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                book.id = id;
                book.judul = rs.getString("judul");
                book.genre = rs.getString("genre");
                book.penulis = rs.getString("penulis");
                book.penerbit = rs.getString("penerbit");
                book.lokasi = rs.getString("lokasi");
                book.stock = rs.getInt("stock");
            }
        } catch(SQLException e) {
            return null;
        } finally {
            try {
                statement.close();
            } catch(SQLException e) {
                return null;
            }
        }
        
        return book;
    }

    @Override
    public List<Buku> getByColumn(String column, String key) {
        String query = "SELECT * FROM buku WHERE " + column + " LIKE ?";
        PreparedStatement statement = null;
        ArrayList<Buku> books = new ArrayList<Buku>();
        
        try {
            statement = Connector.getInstance().prepareStatement(query);
            statement.setString(1, "%" + key + "%");
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                Buku book = new Buku();
                book.id = rs.getInt("id");
                book.genre = rs.getString("genre");
                book.penulis = rs.getString("penulis");
                book.penerbit = rs.getString("penerbit");
                book.lokasi = rs.getString("lokasi");
                book.judul = rs.getString("judul");
                book.stock = rs.getInt("stock");
                
                books.add(book);
            }
        } catch(SQLException e) {
            
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                
            }
        }
        
        return books;
    }
}
