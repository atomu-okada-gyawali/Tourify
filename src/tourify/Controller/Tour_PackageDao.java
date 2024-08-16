/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import tourify.Model.Booking;
import tourify.Model.Tour_Package;
import tourify.Model.Traveller;
import tourify.Model.User;
import tourify.database.DB;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class Tour_PackageDao {

    public static void main(String[] args) throws SQLException {
        String filePath = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\DSC08193.jpg";

        // Convert the file to byte array
        byte[] picByte = new byte[0];
        try {
            Path path = Paths.get(filePath);
            picByte = Files.readAllBytes(path);

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            picByte = new byte[0];
        }

//String tour_package_name, String tour_package_destination, int tour_package_price, int tour_package_night_no, byte[] tour_package_itinerary, byte[] tour_package_pamphelt, int trans_bus_price, int trans_flight_price, String hotel_phnumber, int hotel_twin_size_price, int hotel_queen_size_price
        Tour_Package t1 = new Tour_Package("ABC Trekking", "Annapurna", 8000, 3, picByte, picByte, 1000, 3000, "9867777777", 1200, 1500);
        UpdateTour_package(t1, 1);
        //        UpdateTour_package(Tour_Package tour_package , int id);

    }

    public static String[] getTourPackageName() throws SQLException {
        String query = "SELECT tour_package_name FROM tour_packages";
        ArrayList<String> namesList = new ArrayList<>();

        try (Connection con = DB.connect(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                namesList.add(rs.getString("tour_package_name"));
            }
        }

        return namesList.toArray(new String[0]);
    }

    public static void addTourPackage(Tour_Package tour_package) throws SQLException {
        Connection conn = DB.connect();
        String insert_querey = "insert into tour_packages(tour_package_name,tour_package_destination,tour_package_price,tour_package_night_no,tour_package_itinerary,tour_package_pamphlet,trans_bus_price,trans_flight_price,hotel_phnumber,hotel_twin_size_price,hotel_queen_size_price)values(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement insertTour_PackageStmt = conn.prepareStatement(insert_querey);

        insertTour_PackageStmt.setString(1, tour_package.getTour_package_name());
        insertTour_PackageStmt.setString(2, tour_package.getTour_package_destination());
        insertTour_PackageStmt.setInt(3, tour_package.getTour_package_price());
        insertTour_PackageStmt.setInt(4, tour_package.getTour_package_night_no());
        insertTour_PackageStmt.setBytes(5, tour_package.getTour_package_itinerary());
        insertTour_PackageStmt.setBytes(6, tour_package.getTour_package_pamphelt());
        insertTour_PackageStmt.setInt(7, tour_package.getTrans_bus_price());
        insertTour_PackageStmt.setInt(8, tour_package.getTrans_flight_price());
        insertTour_PackageStmt.setString(9, tour_package.getHotel_phnumber());
        insertTour_PackageStmt.setInt(10, tour_package.getHotel_twin_size_price());
        insertTour_PackageStmt.setInt(11, tour_package.getHotel_queen_size_price());

        insertTour_PackageStmt.executeUpdate();

    }

    public Object[] viewTour_Package(int id) throws SQLException {
        Connection conn = DB.connect();
        String view_querey = "Select * from tour_packages where tour_package_id = " + id;
        PreparedStatement view_quereyPS = conn.prepareStatement(view_querey);

        ResultSet rs = view_quereyPS.executeQuery(view_querey);
        while (rs.next()) {
            Object[] record = {
                rs.getString("tour_package_name"),
                rs.getString("tour_package_destination"),
                rs.getInt("tour_package_price"),
                rs.getInt("tour_package_night_no"),
                rs.getBytes("tour_package_itinerary"),
                rs.getBytes("tour_package_papmphelt"),
                rs.getInt("trans_bus_price"),
                rs.getInt("trans_flight_price"),
                rs.getString("Hotel_phnumber"),
                rs.getString("Hotel_twin_size_price"),
                rs.getString("Hotel_queen_size_price"),};
            return record;
        }

        return null;
    }

    public static void UpdateTour_package(Tour_Package tour_package, int id) throws SQLException {
        try (Connection conn = DB.connect()) {
            String Update_querey = "update tour_packages  "
                    + "set tour_package_name = ?,"
                    + "tour_package_destination=?,"
                    + "tour_package_price=?,"
                    + "tour_package_night_no=?,"
                    + "tour_package_itinerary=?,"
                    + "tour_package_pamphlet=?,"
                    + "trans_bus_price=?,"
                    + "trans_flight_price=?,"
                    + "hotel_phnumber=?,"
                    + "hotel_twin_size_price=?,"
                    + "hotel_queen_size_price=?"
                    + " where tour_package_id =" + id;

            try (PreparedStatement us = conn.prepareStatement(Update_querey)) {

                us.setString(1, tour_package.getTour_package_name());
                us.setString(2, tour_package.getTour_package_destination());
                us.setInt(3, tour_package.getTour_package_price());
                us.setInt(4, tour_package.getTour_package_night_no());
                us.setBytes(5, tour_package.getTour_package_itinerary());
                us.setBytes(6, tour_package.getTour_package_pamphelt());
                us.setInt(7, tour_package.getTrans_bus_price());
                us.setInt(8, tour_package.getTrans_flight_price());
                us.setString(9, tour_package.getHotel_phnumber());
                us.setInt(10, tour_package.getHotel_twin_size_price());
                us.setInt(11, tour_package.getHotel_queen_size_price());


                us.executeUpdate();
            }
            conn.close();
        }

    }

    public static void DeleteTour_package(int id) throws SQLException {

        try (Connection con = DB.connect()) {
            String delete_query = "DELETE FROM tour_packages where tour_package_id= ?";
            PreparedStatement ps = con.prepareStatement(delete_query);
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
