/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tourify;

import tourify.View.MainApp;
import tourify.View.Registration;
import tourify.database.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Tourify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "freefire@0852";
            
            Connection conn = DriverManager.getConnection(url,userName,password);    
            
            String createDatabaseQ = "create database if not exists Tourify";
            Statement createDatabaseStmt = conn.createStatement();
            createDatabaseStmt.executeUpdate(createDatabaseQ);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection conn = DB.connect();
            String usersQ = "CREATE TABLE if not exists users ("
                    + "user_id int(10) NOT NULL AUTO_INCREMENT,"
                    + " user_fname varchar(255) NOT NULL,"
                    + " user_lname varchar(255) NOT NULL,"
                    + " user_username varchar(255) NOT NULL,"
                    + " user_pnumber varchar(10) NOT NULL,"
                    + " user_email varchar(255) NOT NULL,"
                    + " user_password varchar(255) NOT NULL,"
                    + " user_role varchar(255) NOT NULL,"
                    + " PRIMARY KEY (user_id))";
            
            String travellersQ = "CREATE TABLE if not exists travellers ("
                    + "traveller_id int(10) NOT NULL AUTO_INCREMENT,"
                    + " traveller_name varchar(255) NOT NULL,"
                    + " traveller_email varchar(255) NOT NULL,"
                    + " traveller_phnumber varchar(10) NOT NULL,"
                    + " traveller_number int(10) NOT NULL,"
                    + " PRIMARY KEY (traveller_id))";
            
            String tour_packagesQ = "CREATE TABLE if not exists tour_packages ("
                    + "tour_package_id int(10) NOT NULL AUTO_INCREMENT,"
                    + " tour_package_name varchar(255) NOT NULL,"
                    + " tour_package_destination varchar(255) NOT NULL,"
                    + " tour_package_price int(10) NOT NULL,"
                    + " tour_package_night_no int(10) NOT NULL,"
                    + " tour_package_itinerary longblob,"
                    + " tour_package_pamphlet longblob,"
                    + " trans_bus_price int(10) NOT NULL,"
                    + " trans_flight_price int(10) NOT NULL,"
                    + " hotel_phnumber varchar(255) NOT NULL,"
                    + " hotel_twin_size_price int(10) NOT NULL,"
                    + " hotel_queen_size_price int(10) NOT NULL,"
                    + " PRIMARY KEY (tour_package_id));";
            
            String bookingsQ = "CREATE TABLE if not exists bookings ("
                    + " booking_id int(10) NOT NULL AUTO_INCREMENT,"
                    + " booking_date date NOT NULL,"
                    + " booking_hotel_yn varchar(255) NOT NULL,"
                    + " booking_room_num varchar(255),"
                    + " booking_room_type varchar(255),"
                    + " tour_package_id int(10) NOT NULL,"
                    + " traveller_id int(10) NOT NULL,"
                    + " booking_status varchar(255) NOT NULL"
                    + ", booking_booker int(10) NOT NULL,"
                    + " booking_guide int(10) NOT NULL,"
                    + " booking_transportation int(11) NOT NULL,"
                    + " PRIMARY KEY (booking_id),"
                    + "foreign key(tour_package_id) references tour_packages(tour_package_id)," +
                    "foreign key(traveller_id) references travellers(traveller_id), " +
                    "foreign key(booking_booker) references users(user_id)," +
                    "foreign key(booking_guide) references users(user_id))";
            
            PreparedStatement usersPS = conn.prepareStatement(usersQ);
            usersPS.execute();
            PreparedStatement travellersPS = conn.prepareStatement(travellersQ);
            travellersPS.execute();
            PreparedStatement tour_packagesPS = conn.prepareStatement(tour_packagesQ);
            tour_packagesPS.execute();
            PreparedStatement bookingsPS = conn.prepareStatement(bookingsQ);
            bookingsPS.execute();
//        Registration nf = new Registration();
//        nf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tourify.class.getName()).log(Level.SEVERE, null, ex);
        }
MainApp mApp = new MainApp();
mApp.setVisible(true);
    }
    
}
