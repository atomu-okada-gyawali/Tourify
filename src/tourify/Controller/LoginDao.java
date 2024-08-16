/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;

import tourify.database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import tourify.Model.LoginModel;

/**
 *
 * @author Lenovo
 */
public class LoginDao {


    public static boolean loginVerify(LoginModel login) throws SQLException, UserNotFoundException {
        Connection conn = DB.connect();
        String query = "Select user_password from users where user_username=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, login.getUsername());
        ResultSet rs = ps.executeQuery();

        boolean isAuthenticated = false;

        try {
            if (rs.next()) {
                String dbPassword = rs.getString("user_password");
                isAuthenticated = login.getPass().equals(dbPassword);
            } else {
                throw new UserNotFoundException("User not found");
            }
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }

        return isAuthenticated;
    }

    public static class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
