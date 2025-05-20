/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author farhannivta
 */
public class BukuRepositoryFactory {
    private static BukuRepository bukuRepository = null;
    
    public static BukuRepository getSingletone() {
        if(BukuRepositoryFactory.bukuRepository == null) {
            bukuRepository = new BukuRepositoryImpl();
        }
        
        return BukuRepositoryFactory.bukuRepository;
    }
}
