package tourify.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lenovo
 */
public class DB {
    static Connection conn = null;
    public static Connection connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/Tourify";
            String userName = "root";
            String password = "dirtydeedsdonedirtcheap@D4C";
            
            conn = DriverManager.getConnection(url,userName,password);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
