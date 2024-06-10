/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;

/**
 *
 * @author Lenovo
 */
public class Traveller {
    private int traveller_id;
    private String traveller_name;
    private String traveller_email;
    private String traveller_phnumber;
    private int traveller_number;

    public Traveller(String traveller_name, String traveller_email, String traveller_phnumber, int traveller_number) {
        this.traveller_name = traveller_name;
        this.traveller_email = traveller_email;
        this.traveller_phnumber = traveller_phnumber;
        this.traveller_number = traveller_number;
    }

    public int getTraveller_id() {
        return traveller_id;
    }

    public String getTraveller_name() {
        return traveller_name;
    }

    public String getTraveller_email() {
        return traveller_email;
    }

    public String getTraveller_phnumber() {
        return traveller_phnumber;
    }

    public int getTraveller_number() {
        return traveller_number;
    }
    
}
