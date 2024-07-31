package tourify.Controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import tourify.database.DB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class BillDao {

    public static void main(String[] args) throws SQLException {
        System.out.println(createBill(5));
    }

    public static int createBill(int booking_id) throws SQLException {
        int tour_packageId = 0;
        int booker_id = 0;
        int guide_id = 0;
        int traveller_id = 0;
        int peopleNo = 0;
        int tour_packageRate = 0;
        int transportRate = 0;
        int hotelRate = 0;
        int roomNo = 0;
        String tour_package = "";
        String transportMeans = "";
        String roomType = "";
        Connection conn = DB.connect();
        conn.setAutoCommit(false);
        String bookingQuery = "select * from bookings where booking_id = ?";
        PreparedStatement bookingPS = conn.prepareStatement(bookingQuery);
        bookingPS.setInt(1, booking_id);
        ResultSet bookingRS = bookingPS.executeQuery();
        if (bookingRS.next()) {
            tour_packageId = bookingRS.getInt("tour_package_id");
            booker_id = bookingRS.getInt("booking_booker");
            guide_id = bookingRS.getInt("booking_guide");
            traveller_id = bookingRS.getInt("traveller_id");
            roomNo = bookingRS.getInt("booking_room_num");
            transportMeans = bookingRS.getString("booking_transportation");
            roomType = bookingRS.getString("booking_room_type");
            System.out.println(transportMeans);

        }
        String tour_packageQuery = "select * from tour_packages where tour_package_id = ?";
        PreparedStatement tour_packagePS = conn.prepareStatement(tour_packageQuery);
        tour_packagePS.setInt(1, tour_packageId);
        ResultSet tour_packageRS = tour_packagePS.executeQuery();

        String bookerQuery = "select user_fname, user_lname,user_role from users where user_id = ?";
        String guideQuery = "select user_fname, user_lname,user_role from users where user_id = ?";
        PreparedStatement bookerPS = conn.prepareStatement(bookerQuery);
        PreparedStatement guidePS = conn.prepareStatement(guideQuery);
        bookerPS.setInt(1, booker_id);
        guidePS.setInt(1, guide_id);
        ResultSet bookerRS = bookerPS.executeQuery();
        ResultSet guideRS = guidePS.executeQuery();

        String travellerQuery = "select * from travellers where traveller_id = " + traveller_id;
        PreparedStatement travellerPS = conn.prepareStatement(travellerQuery);

        ResultSet travellerRS = travellerPS.executeQuery();

        Date currentD = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(currentD);

        if (travellerRS.next()) {
            String name = travellerRS.getString("traveller_name");
            String phoneNum = travellerRS.getString("traveller_phnumber");
            String email = travellerRS.getString("traveller_email");
            peopleNo = travellerRS.getInt("traveller_number");
            System.out.println(name + " " + phoneNum + " " + email);
        }

        if (tour_packageRS.next()) {
            tour_package = tour_packageRS.getString("tour_package_name");
            tour_packageRate = tour_packageRS.getInt("tour_package_price");
            transportRate = transportMeans.equals("Bus") ? tour_packageRS.getInt("trans_bus_price") : tour_packageRS.getInt("trans_flight_price");
            hotelRate = roomType.equals("Queen Size Bed") ? tour_packageRS.getInt("hotel_queen_size_price") : tour_packageRS.getInt("hotel_twin_size_price");
        }
        int tour_packageTotal = roomNo * tour_packageRate;
        int transportTotal = transportRate * peopleNo;
        int hotelTotal = hotelRate * peopleNo;
        int grandTotal = tour_packageTotal + transportTotal + hotelTotal;

        conn.commit();
        return grandTotal;
    }
}
