package tourify.Controller;

import com.mysql.cj.jdbc.Blob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import tourify.Model.Bill;
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

    public static BufferedImage convertToImage(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        return ImageIO.read(bis);
    }

    public static Bill createBill(int booking_id) throws SQLException, IOException {
        String name = "";
        String phoneNum = "";
        int tour_packageId = 0;
        int guide_id = 0;
        int traveller_id = 0;
        int peopleNo = 0;
        int tour_packageRate = 0;
        int transportRate = 0;
        int hotelRate = 0;
        int roomNo = 0;
        byte[] itineraryByte = new byte[0];
        byte[] pamphletByte = new byte[0];
        String tour_package = "";
        String transportMeans = "";
        String roomType = "";
        Connection conn = DB.connect();
        conn.setAutoCommit(false);
        String bookingQuery = "select * from bookings where booking_id = ? and booking_status='Unpaid'";
        PreparedStatement bookingPS = conn.prepareStatement(bookingQuery);
        bookingPS.setInt(1, booking_id);
        ResultSet bookingRS = bookingPS.executeQuery();
        if (bookingRS.next()) {
            tour_packageId = bookingRS.getInt("tour_package_id");
            traveller_id = bookingRS.getInt("traveller_id");
            roomNo = bookingRS.getInt("booking_room_num");
            transportMeans = bookingRS.getString("booking_transportation");
            roomType = bookingRS.getString("booking_room_type");
            System.out.println(transportMeans);

        } else {

        }
        String tour_packageQuery = "select * from tour_packages where tour_package_id = ?";
        PreparedStatement tour_packagePS = conn.prepareStatement(tour_packageQuery);
        tour_packagePS.setInt(1, tour_packageId);
        ResultSet tour_packageRS = tour_packagePS.executeQuery();

        String guideQuery = "select user_fname, user_lname,user_role from users where user_id = ?";
        PreparedStatement guidePS = conn.prepareStatement(guideQuery);
        guidePS.setInt(1, guide_id);
        ResultSet guideRS = guidePS.executeQuery();

        String travellerQuery = "select * from travellers where traveller_id = " + traveller_id;
        PreparedStatement travellerPS = conn.prepareStatement(travellerQuery);

        ResultSet travellerRS = travellerPS.executeQuery();

        Date currentD = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(currentD);

        if (travellerRS.next()) {
            name = travellerRS.getString("traveller_name");
            phoneNum = travellerRS.getString("traveller_phnumber");
            String email = travellerRS.getString("traveller_email");
            peopleNo = travellerRS.getInt("traveller_number");
            System.out.println(name + " " + phoneNum + " " + email);
        } else {
            JOptionPane.showMessageDialog(null, "Enter correct ID", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        if (tour_packageRS.next()) {
            tour_package = tour_packageRS.getString("tour_package_name");
            tour_packageRate = tour_packageRS.getInt("tour_package_price");
            transportRate = transportMeans.equals("Bus") ? tour_packageRS.getInt("trans_bus_price") : tour_packageRS.getInt("trans_flight_price");
            hotelRate = roomType.equals("Queen Size Bed") ? tour_packageRS.getInt("hotel_queen_size_price") : roomType.equals("Twin Size Bed") ? tour_packageRS.getInt("hotel_twin_size_price") : 0;
            Blob itiBlob = (Blob) tour_packageRS.getBlob("tour_package_itinerary");
            itineraryByte = itiBlob.getBytes(1, (int) itiBlob.length());
            Blob pampBlob = (Blob) tour_packageRS.getBlob("tour_package_pamphlet");
            pamphletByte = pampBlob.getBytes(1, (int) pampBlob.length());

        }

        Bill bill = new Bill(name, phoneNum, tour_package, transportMeans, roomType, peopleNo, roomNo, tour_packageRate, transportRate, hotelRate, itineraryByte, pamphletByte);

        conn.commit();
        return bill;
    }

    public static void processBill(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.connect();
            String query = "UPDATE bookings "
                    + "SET booking_status = 'Paid' "
                    + "WHERE booking_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

} 
