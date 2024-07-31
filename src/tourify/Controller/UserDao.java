/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import tourify.Model.User;

import tourify.database.DB;

/**
 *
 * @author Lenovo
 */
public class UserDao {

    public static void main(String[] args) throws SQLException {
//        printNestedHashMap(getGuideHash());
    }

    public static void addUser(User user) throws SQLException {
        try (Connection con = DB.connect()) {
            String query = "insert into users(user_fname,user_lname,user_username,user_phnumber,user_email,user_password,user_role) values(?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query) //        ps.setInt(1, user.getUser_id());
                    ) {
                ps.setString(1, user.getUser_fname());
                ps.setString(2, user.getUser_lname());
                ps.setString(3, user.getUser_username());
                ps.setString(4, user.getUser_phnumber());
                ps.setString(5, user.getUser_email());
                ps.setString(6, user.getUser_password());
                ps.setString(7, user.getUser_role());

                ps.executeUpdate();
            }
            con.close();

        }
    }

    public static void editUser(User user) throws SQLException {
        try (Connection con = DB.connect()) {
            String query = "update users set user_fname = ?,user_lname = ?,user_username = ?,user_phnumber = ?,user_email = ?,user_role = ? where user_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, user.getUser_fname());
                ps.setString(2, user.getUser_lname());
                ps.setString(3, user.getUser_username());
                ps.setString(4, user.getUser_phnumber());
                ps.setString(5, user.getUser_email());
                ps.setString(6, user.getUser_role());
                ps.setInt(7, user.getUser_id());

                ps.executeUpdate();
            }
            con.close();
        }

        System.out.println("Done");
    }

    public static void deleteUser(int id) throws SQLException {
        try (Connection con = DB.connect()) {
            String query = "DELETE FROM users where user_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static String[] getUser(int id) throws SQLException {
        try (Connection con = DB.connect()) {
            String query = "SELECT * FROM users where user_id = " + id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                String[] record = {
                    rs.getString("user_fname"),
                    rs.getString("user_lname"),
                    rs.getString("user_username"),
                    rs.getString("user_phnumber"),
                    rs.getString("user_email"),
                    rs.getString("user_password"),
                    rs.getString("user_role")
                };
                return record;
            }
        }
        return null;
    }

    public static HashMap<Integer, String> getGuideHash() throws SQLException {
        Connection conn = DB.connect();
        String getGuideHashQ = "select user_id, user_username, user_role from users";
        PreparedStatement getGuideHashPS = conn.prepareStatement(getGuideHashQ);
        ResultSet rs = getGuideHashPS.executeQuery();
        HashMap<Integer, String> output = new HashMap<>();
        while (rs.next()) {
            HashMap<Integer, String> inner_hash = new HashMap<>();
            if ("Tour guide".equals(rs.getString("user_role"))) {
                output.put(rs.getInt("user_id"), rs.getString("user_username"));
            }
        }
        return output;

    }

    public static void printNestedHashMap(HashMap<Integer, String> hash) {
        for (Integer key : hash.keySet()) {
            System.out.println(key + " " + hash.get(key));
        }
    }
}
