/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionListener;
import model.Buku;

/**
 *
 * @author farhannivta
 */
public interface MainView {
    public void setDataBukuTable(List<Buku> books);
    
    public void setIdTextField(String id);
    public String getIdTextField();
    
    public void setJudulTextField(String judul);
    public String getJudulTextField();
    
    public void setGenreTextField(String genre);
    public String getGenreTextField();
    
    public void setPenulisTextField(String penulis);
    public String getPenulisTextField();
    
    public void setPenerbitTextField(String penerbit);
    public String getPenerbitTextField();
    
    public void setLocationTextField(String location);
    public String getLocationTextField();
    
    public void setStcokTextField(String stock);
    public String getStockTextField();
    
    public void setSearchTextField(String search);
    public String getSearchTextField();
    
    public String getSearchByComboBox();
    
    public void setBukuTableClickListener(ListSelectionListener listener);
    public int getSelectedRowIndex();
    public Buku getBookByRow(int row);
    
    public void addClearListener(ActionListener listener);
    public void addSimpanListener(ActionListener listener);
    public void addUpdateListener(ActionListener listener);
    public void addHapusListener(ActionListener listener);
    public void addCariListener(ActionListener listener);
    public void addTampilSemuaListener(ActionListener listener);
}
