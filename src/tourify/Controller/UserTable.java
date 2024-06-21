/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import tourify.database.DB;

/**
 *
 * @author Lenovo
 */
public class UserTable {
//    public static void main(String[] args) throws SQLException {
//        String[][] records = getUsers();
//        for(String[] record: records){
//            System.out.println(Arrays.toString(record));
//        }
//        
//    }
    public static String[][] getUsers() throws SQLException{
        try(Connection conn = DB.connect()){
        String query = "SELECT * FROM users";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<String[]> records = new ArrayList<>();
        while(rs.next()){

        records.add(new String[]{
            Integer.toString(rs.getInt("user_id")),
            rs.getString("user_fname"),
            rs.getString("user_lname"),
            rs.getString("user_username"),
            rs.getString("user_phnumber"),
            rs.getString("user_email"),
            rs.getString("user_role")
        });
        }
        String[][] recordsArr = new String[records.size()][7];
        
        for(int i = 0; i < records.size(); i++){
            recordsArr[i] = records.get(i); 
        
        }
        
        return recordsArr;
    }
    }
}
