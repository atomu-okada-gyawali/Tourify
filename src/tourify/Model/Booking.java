/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Booking {
    private int booking_id;
    private Date booking_date;
    private String booking_hotel_yn;
    private int booking_room_num;
    private String booking_room_type;
    private int tour_package_id;
    private int traveller_id;
    private String booking_status;

    public Booking(
            Date booking_date, 
            String booking_hotel_yn, 
            int booking_room_num, 
            String booking_room_type, 
            String booking_agent, 
            String booking_status
    ) {
        this.booking_date = booking_date;
        this.booking_hotel_yn = booking_hotel_yn;
        this.booking_room_num = booking_room_num;
        this.booking_room_type = booking_room_type;
        this.booking_status = booking_status;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public String getBooking_hotel_yn() {
        return booking_hotel_yn;
    }

    public int getBooking_room_num() {
        return booking_room_num;
    }

    public String getBooking_room_type() {
        return booking_room_type;
    }

    public int getTour_package_id() {
        return tour_package_id;
    }

    public int getTraveller_id() {
        return traveller_id;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setTour_package_id(int tour_package_id) {
        this.tour_package_id = tour_package_id;
    }

    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
    }
    
    
}   
