/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import tourify.Model.Booking;
import tourify.Model.Traveller;
import tourify.Model.User;
import tourify.database.DB;



/**
 *
 * @author Lenovo
 */
public class BookingDao {
    public static void main(String[] args) throws SQLException {
        Date currentDate = new Date();
        Booking booking1 = new Booking(currentDate,
            "Yes", 
            1, 
            "Queen Size Bed",
            1,
            4, 
            "Unpaid",
            "Flight");
        Traveller traveller1 = new Traveller("Unchi",
        "unchi@gmail.com",
        "9822334455",
        3);
        addBooking(booking1,traveller1,2);
    }

    public static void addBooking(Booking booking, Traveller traveller,int booker_id) throws SQLException{
        /*takes booking object, traveller object, booker_id */

    try(Connection conn = DB.connect()){
    conn.setAutoCommit(false);
    java.sql.Date date = new java.sql.Date(booking.getBooking_date().getTime());
    String insertTravellerQ = "insert into travellers(traveller_name, traveller_email, traveller_phnumber, traveller_number)"
            + " values(?,?,?,?) ";
    String insertBookingQ = "insert into bookings"
            + "(booking_date,"
            + " booking_hotel_yn,"
            + " booking_room_num,"
            + "booking_room_type,"
            + "tour_package_id,"
            + "traveller_id,"
            + "booking_status,"
            + "booking_booker,"
            + "booking_guide,"
            + " booking_transportation)"
            + " values(?,?,?,?,?,?,?,?,?,?)";
    
    PreparedStatement insertTravellerStmt = conn.prepareStatement(insertTravellerQ);
    PreparedStatement insertBookingStmt = conn.prepareStatement(insertBookingQ);

    
    
    insertTravellerStmt.setString(1,traveller.getTraveller_name());
    insertTravellerStmt.setString(2,traveller.getTraveller_email());
    insertTravellerStmt.setString(3,traveller.getTraveller_phnumber());
    insertTravellerStmt.setInt(4,traveller.getTraveller_number());
    
    String FKfromTravellerQ = "select last_insert_id() from travellers";
    PreparedStatement getFKfromTravellerStmt = conn.prepareStatement(FKfromTravellerQ);
    insertTravellerStmt.executeUpdate();
    ResultSet rsFKTraveller = getFKfromTravellerStmt.executeQuery();
    
    int FKTraveller = 0;
    
    while(rsFKTraveller.next()){
    FKTraveller = rsFKTraveller.getInt(1);
    };
    
    
    insertBookingStmt.setDate(1, date);
    insertBookingStmt.setString(2, booking.getBooking_hotel_yn());
    insertBookingStmt.setInt(3, booking.getBooking_room_num());
    insertBookingStmt.setString(4,booking.getBooking_room_type());
    insertBookingStmt.setInt(5, booking.getTour_package_id()); 
    insertBookingStmt.setInt(6, FKTraveller);
    insertBookingStmt.setString(7, booking.getBooking_status());
    insertBookingStmt.setInt(8, booker_id);
    insertBookingStmt.setInt(9, booking.getBooking_agent_id());
    insertBookingStmt.setString(10, booking.getBooking_transportation());

    
    
    insertBookingStmt.executeUpdate();
    insertTravellerStmt.close();
    insertBookingStmt.close();
    conn.commit();
    }
    };
    
    

    public static Object[] getBooking(int id) throws SQLException{
    
    try(Connection con = DB.connect()){
        String query = "SELECT "
             + "bookings.booking_id, "
             + "travellers.traveller_name, "
             + "travellers.traveller_email, "
             + "tour_packages.tour_package_name, "
             + "travellers.traveller_number, "
             + "travellers.traveller_phnumber, "
             + "bookings.booking_transportation, "
             + "bookings.booking_date, "
             + "users.user_fname, "
             + "bookings.booking_hotel_yn, "
             + "bookings.booking_room_type, "
             + "bookings.booking_room_num "
             + "bookings.booking_guide"
             + "FROM users "
             + "INNER JOIN bookings ON users.user_id = bookings.booking_guide "
             + "INNER JOIN travellers ON travellers.traveller_id = bookings.traveller_id "
             + "INNER JOIN tour_packages ON bookings.tour_package_id = tour_packages.tour_package_id "
             + "WHERE bookings.booking_id = " + id;
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery(query);
        while(rs.next()){
            Object[] record = {
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
                  rs.getInt("booking.booking_guide")
            };
            return record;
        }
    }
    return null;
}
    
    public static void editBooking(Booking booking, Traveller traveller) throws SQLException{
        Connection conn = DB.connect();
        conn.setAutoCommit(false);
        java.sql.Date date = new java.sql.Date(booking.getBooking_date().getTime());
        int traveller_id = 0;
        String getFkTravellerQ = "Select traveller_id from bookings where booking_id = "+booking.getBooking_id();
        PreparedStatement fkTravellerPS = conn.prepareStatement(getFkTravellerQ);
        ResultSet traveller_idRS = fkTravellerPS.executeQuery();
        while(traveller_idRS.next()){
            traveller_id = traveller_idRS.getInt("traveller_id");
        }
            System.out.println(traveller_id);
String updateTravellerQ = "UPDATE travellers "
                        + "SET "
                        + "traveller_name = ?, "
                        + "traveller_email = ?, "
                        + "traveller_phnumber = ?, "
                        + "traveller_number = ? "
                        + "WHERE traveller_id = ?";
        
String updateBookingQ = "UPDATE bookings "
                     + "SET "
                     + "booking_date = ?, "
                     + "booking_hotel_yn = ?, "
                     + "booking_room_num = ?, "
                     + "booking_room_type = ?, "
                     + "tour_package_id = ?, "
                     + "booking_status = ?, "
                     + "booking_guide = ? ,"
                     + "booking_transportation = ? "
                     + "WHERE booking_id = "+booking.getBooking_id();

    
    String FKfromTravellerQ = "select last_insert_id() from travellers";
    
    PreparedStatement updateTravellerStmt = conn.prepareStatement(updateTravellerQ);
    PreparedStatement updateBookingStmt = conn.prepareStatement(updateBookingQ);

    
 
    
    updateTravellerStmt.setString(1,traveller.getTraveller_name());
    updateTravellerStmt.setString(2,traveller.getTraveller_email());
    updateTravellerStmt.setString(3,traveller.getTraveller_phnumber());
    updateTravellerStmt.setInt(4,traveller.getTraveller_number());
    updateTravellerStmt.setInt(5,traveller_id);
    

    
    
    updateBookingStmt.setDate(1, date);
    updateBookingStmt.setString(2, booking.getBooking_hotel_yn());
    updateBookingStmt.setInt(3, booking.getBooking_room_num());
    updateBookingStmt.setString(4,booking.getBooking_room_type());
    updateBookingStmt.setInt(5, booking.getTour_package_id());
    updateBookingStmt.setString(6, booking.getBooking_status());
    updateBookingStmt.setInt(7,booking.getBooking_agent_id());
    updateBookingStmt.setString(8,booking.getBooking_transportation());

    
    updateTravellerStmt.executeUpdate();
    updateBookingStmt.executeUpdate();
    updateTravellerStmt.close();
    updateBookingStmt.close();
    conn.commit();
    }
    
    public static void deleteBooking(int id) throws SQLException{
        Connection conn = DB.connect();
        conn.setAutoCommit(false);
        int traveller_id = 0;
        String getFkTravellerQ = "Select traveller_id from bookings where booking_id = "+id;
        PreparedStatement fkTravellerPS = conn.prepareStatement(getFkTravellerQ);
        ResultSet traveller_idRS = fkTravellerPS.executeQuery();
        while(traveller_idRS.next()){
            traveller_id = traveller_idRS.getInt("traveller_id");
        }
        String deleteBookingQ = "Delete from Bookings where booking_id = "+ id;
        PreparedStatement deleteBookingPS = conn.prepareStatement(deleteBookingQ);
        
        deleteBookingPS.executeUpdate();
        
        String deleteTravellerQ = "Delete from Travellers where traveller_id = "+ traveller_id;
        PreparedStatement deleteTravellerPS = conn.prepareStatement(deleteTravellerQ);
        
        deleteTravellerPS.executeUpdate();
        
        conn.commit();
    }
}



