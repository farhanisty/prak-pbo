/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author farhannivta
 */
public class Connector {
    private static Connection connection = null;
    
    public static Connection getInstance() {
        if(Connector.connection == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("perpustakaan_yogyakarta");
            data.setUser("root");
            data.setPassword("");
            
            try {
                Connector.connection = data.getConnection();
            } catch(SQLException exception) {
            }
        }
        
        return Connector.connection;
    }
}
