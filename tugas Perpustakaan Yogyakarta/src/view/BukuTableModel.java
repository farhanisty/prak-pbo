/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Buku;

/**
 *
 * @author farhannivta
 */
public class BukuTableModel extends AbstractTableModel {
    List<Buku> books = new ArrayList<Buku>();
    
    public void setBooks(List<Buku> books) {
        this.books = books;
    }
    
    @Override
    public int getRowCount() {
        return this.books.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Genre";
            case 3:
                return "Penulis";
            case 4:
                return "Penerbit";
            case 5:
                return "Lokasi";
            default:
                return "Stock";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buku selectedBook = this.books.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return selectedBook.id;
            case 1:
                return selectedBook.judul;
            case 2:
                return selectedBook.genre;
            case 3:
                return selectedBook.penulis;
            case 4:
                return selectedBook.penerbit;
            case 5:
                return selectedBook.lokasi;
            case 6:
                return selectedBook.stock;
            default:
                return null;
        }
    }
    
}
