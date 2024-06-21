/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;

/**
 *
 * @author Lenovo
 */
public class User {
    private int user_id;
    private String user_fname;
    private String user_lname;
    private String user_username;
    private String user_phnumber;
    private String user_email;
    private String user_password;
    private String user_role;

    public User( String user_fname, String user_lname, String user_username, String user_phnumber, String user_email, String user_role) {

        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_username = user_username;
        this.user_phnumber = user_phnumber;
        this.user_email = user_email;
        this.user_role = user_role;
    }
    public int getUser_id() {
        return user_id;
    }
    
    public String getUser_fname() {
        return user_fname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public String getUser_username() {
        return user_username;
    }

    public String getUser_phnumber() {
        return user_phnumber;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public void setUser_phnumber(String user_phnumber) {
        this.user_phnumber = user_phnumber;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

}
