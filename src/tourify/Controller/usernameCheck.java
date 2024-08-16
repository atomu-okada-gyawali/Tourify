/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import tourify.database.DB;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class usernameCheck {

    public static Boolean doesUserExist(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DB.connect();
            String query = "SELECT COUNT(*) FROM users WHERE user_username = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            return count > 0;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
