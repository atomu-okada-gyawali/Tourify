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
        Date dateInSql = new Date();
        Traveller traveller1 = new Traveller("Atomu","atomgyawali2@gmail.com","9812292921",3);
        Booking booking1 = new Booking(dateInSql,"Yes",2,"Queen Size","Unchi", "Booked");
        addBooking(booking1, traveller1, 2,2);

    }
    public static void addBooking(Booking booking, Traveller traveller,int booker_id, int guide_id) throws SQLException{
        /*takes booking object, traveller object, booker_id and guide_id*/
//        TODO:determine whether values for foreign key attributes of a model should be assigned through constructor or setter
//        if from constructor => then add tour_package_id in constructor parameter
//        if from setter     => then add tour_package_id in addBookin() function
    try(Connection conn = DB.connect()){
    java.sql.Date date = new java.sql.Date(booking.getBooking_date().getTime());
    String insertTravellerQ = "insert into travellers(traveller_name, traveller_email, traveller_phnumber, traveller_number) values(?,?,?,?) ";
    String insertBookingQ = "insert into bookings(booking_date, booking_hotel_yn, booking_room_num,booking_room_type,tour_package_id,traveller_id,booking_status,booking_booker,booking_guide) values(?,?,?,?,?,?,?,?,?)";

    
    String FKfromTravellerQ = "select last_insert_id() from travellers";
    
    PreparedStatement insertTravellerStmt = conn.prepareStatement(insertTravellerQ);
    PreparedStatement insertBookingStmt = conn.prepareStatement(insertBookingQ);

    
    PreparedStatement getFKfromTravellerStmt = conn.prepareStatement(FKfromTravellerQ);
    
    insertTravellerStmt.setString(1,traveller.getTraveller_name());
    insertTravellerStmt.setString(2,traveller.getTraveller_email());
    insertTravellerStmt.setString(3,traveller.getTraveller_phnumber());
    insertTravellerStmt.setInt(4,traveller.getTraveller_number());
    
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
    insertBookingStmt.setInt(5, 1); //fix this too
    insertBookingStmt.setInt(6, FKTraveller);
    insertBookingStmt.setString(7, booking.getBooking_status());
    insertBookingStmt.setInt(8, booker_id);
    insertBookingStmt.setInt(9, guide_id);

    
    
    insertBookingStmt.executeUpdate();
    insertTravellerStmt.close();
    insertBookingStmt.close();
    }
    };
    
    
            
//    public static String[] getBooking(int id) throws SQLException{
//    try(Connection con = DB.connect()){
//        String query = "SELECT * FROM bookings where bookings_id = "+id;
//        PreparedStatement ps = con.prepareStatement(query);
//
//        ResultSet rs = ps.executeQuery(query);
//        while(rs.next()){l
//            String[] record = {
//                rs.getString("user_fname"),
//                rs.getString("user_lname"),
//                rs.getString("user_username"),
//                rs.getString("user_phnumber"),
//                rs.getString("user_email"),
//                rs.getString("user_password"),
//                rs.getString("user_role")
//            };
//            return record;
//        }
//    }
//    return null;
//}
    
}



