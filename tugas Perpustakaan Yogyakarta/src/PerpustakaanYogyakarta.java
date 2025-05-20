/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import view.MainFrame;
import koneksi.Connector;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Buku;
import presenter.BukuPresenter;
import repository.BukuRepository;
import repository.BukuRepositoryFactory;

/**
 *
 * @author farhannivta
 */
public class PerpustakaanYogyakarta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
        BukuRepository bukuRepository = BukuRepositoryFactory.getSingletone();
        
        BukuPresenter bukuPresenter = new BukuPresenter(bukuRepository, mainFrame);
    }
    
}
