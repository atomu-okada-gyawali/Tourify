/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;

/**
 *
 * @author Lenovo
 */
public class LoginModel {
    private String username;
    private String pass;

    public LoginModel(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }


    public String getPass() {
        return pass;
    }
    

}
