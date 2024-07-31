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
import java.sql.PreparedStatement;
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
            String password = "freefire@0852";
            
            conn = DriverManager.getConnection(url,userName,password);    
            System.out.println("Connection made");
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed");
        }
        return conn;
    }
}
