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
import tourify.database.DB;

/**
 *
 * @author Lenovo
 */
public class UserTable {
    public static void main(String[] args) throws SQLException {
        ArrayList<String[]> output = getUsers();
        for(int i=0; i < output.size(); i++){
            for(int j = 0; j < output.get(i).length; j++){
                System.out.print(output.get(i)[j]+"\t");
            }
        System.out.println("");
        }
    }
    public static ArrayList<String[]> getUsers() throws SQLException{
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
            rs.getString("user_password"),
            rs.getString("user_role")
        });
        }
               
        return records;
    }
    }
}
