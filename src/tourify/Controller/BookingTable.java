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
public class BookingTable {
    public static void main(String[] args) throws SQLException {
        Object[][] array;
        array = getBookings1();
        
        for( Object[] row: array){
            for(Object item: row){
                System.out.print(item+"\t");
            }
                System.out.println("");
        }
    }
    public static ArrayList<Object[]> getBookings() throws SQLException{
  try(Connection con = DB.connect()){
     String query = "select "
             + "bookings.booking_id,"
             + "travellers.traveller_name,"
             + " travellers.traveller_email,"
             + " tour_packages.tour_package_name,"
             + " travellers.traveller_number,"
             + " travellers.traveller_phnumber,"
             + " bookings.booking_transportation,"
             + " bookings.booking_date,"
             + " users.user_fname,"
             + "bookings.booking_hotel_yn,"
             + " bookings.booking_room_type,"
             + "bookings.booking_room_num, "
             + "bookings.booking_guide, "
             + "bookings.tour_package_id"
             + " from"
             + " users inner join bookings on users.user_id = bookings.booking_guide"
             + " inner join travellers on  travellers.traveller_id= bookings.traveller_id"
             + " inner join tour_packages on bookings.tour_package_id = tour_packages.tour_package_id where bookings.booking_status='Unpaid'";
      PreparedStatement ps = con.prepareStatement(query);
       ResultSet rs = ps.executeQuery(query);
       
      ArrayList<Object[]> records = new ArrayList<>();
      while(rs.next()){
         records.add(new Object[]{
                  rs.getInt("bookings.booking_id"),
                  rs.getString("travellers.traveller_name"),
                  rs.getString("travellers.traveller_email"),
                  rs.getString("tour_packages.tour_package_name"),
                  rs.getString("travellers.traveller_number"),
                  rs.getString("travellers.traveller_phnumber"),
                  rs.getString("bookings.booking_transportation"), 
                  rs.getDate("bookings.booking_date"),
                  rs.getString("users.user_fname"),
                  rs.getString("bookings.booking_hotel_yn"),
                  rs.getString("bookings.booking_room_type"),
                  rs.getInt("bookings.booking_room_num"),
                  rs.getInt("bookings.tour_package_id"),
                  rs.getInt("bookings.booking_guide")
            });
        }
            return records;
    }catch(SQLException e){
        e.printStackTrace();
    }
        return null;

}
    public static Object[][] getBookings1() throws SQLException{
        try{
            ArrayList<Object[]> records = getBookings();
        
        Object[][] records1 = new Object[records.size()][];
        for(int i = 0; i<records.size(); i++){
            records1[i] = records.get(i);
        }

        return records1;
    }catch(SQLException e){
    e.printStackTrace();
}
        return null;
    };
}
