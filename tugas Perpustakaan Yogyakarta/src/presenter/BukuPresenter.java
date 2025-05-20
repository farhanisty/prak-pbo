/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.util.ArrayList;
import java.util.List;
import model.Buku;
import repository.BukuRepository;
import view.MainView;

/**
 *
 * @author farhannivta
 */
public class BukuPresenter {
    private BukuRepository bukuRepository;
    private MainView mainView;
    
    public BukuPresenter(BukuRepository bukuRepository, MainView mainView) {
        this.bukuRepository = bukuRepository;
        this.mainView = mainView;
        
        this.initListener();
    }
    
    private void initListener() {
        this.mainView.setDataBukuTable(this.bukuRepository.getAll());
        this.mainView.setBukuTableClickListener(e -> this.onBukuTableClicked());
        this.mainView.addClearListener(e -> this.clearForm());
        this.mainView.addSimpanListener(e -> this.onSimpan());
        this.mainView.addHapusListener(e -> this.onHapus());
        this.mainView.addUpdateListener(e -> this.onUpdate());
        this.mainView.addCariListener(e -> this.onCari());
        this.mainView.addTampilSemuaListener(e -> this.onTampilSemua());
    }
    
    private void onTampilSemua() {
        this.mainView.setDataBukuTable(this.bukuRepository.getAll());
    }
    
    private void onCari() {
        if(!this.mainView.getSearchByComboBox().isEmpty()) {
            String searchColumn = this.mainView.getSearchByComboBox();
            String searchInput = this.mainView.getSearchTextField();
            
            if(searchInput.isEmpty()) {
                return;
            }
            
            List<Buku> books = new ArrayList<>();
            
            if(searchColumn.equals("id")) {
                Buku book = this.bukuRepository.getById(Integer.parseInt(searchInput));
                if(book.id != 0) {
                    books.add(book);
                }
            } else {
                books = this.bukuRepository.getByColumn(searchColumn, searchInput);
            }
            
            this.mainView.setDataBukuTable(books);
        }
    }
    
    private void onSimpan() {
        if(this.mainView.getIdTextField().isEmpty()) {
            Buku book = new Buku();
            book.id = 0;
            book.genre = this.mainView.getGenreTextField();
            book.judul = this.mainView.getJudulTextField();
            book.penerbit = this.mainView.getPenerbitTextField();
            book.penulis = this.mainView.getPenulisTextField();
            book.lokasi = this.mainView.getLocationTextField();
            book.stock = Integer.parseInt(this.mainView.getStockTextField());
            
            this.bukuRepository.insert(book);
            
            this.mainView.setDataBukuTable(this.bukuRepository.getAll());
        }
    }
    
    private void onUpdate() {
        if(!this.mainView.getIdTextField().isEmpty()) {
            Buku book = new Buku();
            book.id = Integer.parseInt(this.mainView.getIdTextField());
            book.genre = this.mainView.getGenreTextField();
            book.judul = this.mainView.getJudulTextField();
            book.penerbit = this.mainView.getPenerbitTextField();
            book.penulis = this.mainView.getPenulisTextField();
            book.lokasi = this.mainView.getLocationTextField();
            book.stock = Integer.parseInt(this.mainView.getStockTextField());
            
            this.bukuRepository.update(book);
            this.clearForm();
            this.mainView.setDataBukuTable(this.bukuRepository.getAll());
        }
    }
    
    private void onHapus() {
        if(!this.mainView.getIdTextField().isEmpty()) {
            int id = Integer.parseInt(this.mainView.getIdTextField());
            this.bukuRepository.delete(id);
            this.clearForm();
            this.mainView.setDataBukuTable(this.bukuRepository.getAll());
        }
    }
    
    private void onBukuTableClicked() {
        int index = this.mainView.getSelectedRowIndex();
        if(index == -1) {
            return;
        }
        Buku book = this.mainView.getBookByRow(index);
        
        this.mainView.setIdTextField(String.valueOf(book.id));
        this.mainView.setGenreTextField(book.genre);
        this.mainView.setPenulisTextField(book.penulis);
        this.mainView.setPenerbitTextField(book.penerbit);
        this.mainView.setJudulTextField(book.judul);
        this.mainView.setLocationTextField(book.lokasi);
        this.mainView.setStcokTextField(String.valueOf(book.stock));
    }
    
    private void clearForm() {
        this.mainView.setIdTextField("");
        this.mainView.setGenreTextField("");
        this.mainView.setPenulisTextField("");
        this.mainView.setPenerbitTextField("");
        this.mainView.setJudulTextField("");
        this.mainView.setLocationTextField("");
        this.mainView.setStcokTextField("");
    }
}
