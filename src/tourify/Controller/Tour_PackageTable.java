
package tourify.Controller;

import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import tourify.database.DB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */

public class Tour_PackageTable {
   

    public static void main(String[] args) throws SQLException {
//        System.out.println(Arrays.toString(getByte(1)));
          System.out.println(Arrays.toString(getPictures(5)));
    }
    
public static byte[][] getPictures(int id) throws SQLException{
        byte[][] output = new byte[2][];
        try (Connection conn = DB.connect()) {
            String query = "Select tour_package_itinerary,tour_package_pamphlet From tour_packages where tour_package_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet tour_packageRS = ps.executeQuery();
            while (tour_packageRS.next()) {
            Blob itiBlob = (Blob) tour_packageRS.getBlob("tour_package_itinerary");
            output[0] = itiBlob.getBytes(1, (int) itiBlob.length());
            Blob pampBlob = (Blob) tour_packageRS.getBlob("tour_package_pamphlet");
            output[1] = pampBlob.getBytes(1, (int) pampBlob.length());
            }

            return output;
        }
    }

    public static String[][] getTourPackageNames() throws SQLException {
        try (Connection conn = DB.connect()) {
            String query = "Select tour_package_id,"
                    + "tour_package_name,"
                    + "tour_package_destination,"
                    + "tour_package_price,"
                    + "tour_package_night_no,"
                    + "tour_package_itinerary,"
                    + "tour_package_pamphlet,"
                    + "trans_bus_price,"
                    + "trans_flight_price,"
                    + "hotel_phnumber,"
                    + "hotel_twin_size_price,"
                    + "hotel_queen_size_price"
                    + " From tour_packages";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            ArrayList<String[]> records = new ArrayList<>();
//        
            while (rs.next()) {
                records.add(new String[]{
                    Integer.toString(rs.getInt("tour_package_id")),
                    rs.getString("tour_package_name"),
                    rs.getString("tour_package_destination"),
                    rs.getString("tour_package_price"),
                    rs.getString("tour_package_night_no"),
                    rs.getString("trans_bus_price"),
                    rs.getString("trans_flight_price"),
                    rs.getString("hotel_phnumber"),
                    rs.getString("hotel_twin_size_price"),
                    rs.getString("hotel_queen_size_price")

                });
            }
            String[][] recordsArr = new String[records.size()][10];

            for (int i = 0; i < records.size(); i++) {
                recordsArr[i] = records.get(i);

            }
            return recordsArr;
        }
    }
}
