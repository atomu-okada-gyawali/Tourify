/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;


import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class Bill {

    private String name;
    private String phonenum;
    private String package_name;
    private String transport;
    private String roomType;
    private int travellerNum;
    private int hotelNum;
    private int packageRate;
    private int transportRate;
    private int hotelRate;
    private int packageSTotal;
    private int transportSTotal;
    private int hotelSTotal;
    private int bill_total;
    private byte[] itinerary;
    private byte[] pamphlet;


    public Bill(String name,
            String phonenum,
            String package_name,
            String transport,
            String roomType,
            int travellerNum,
            int hotelNum,
            int packageRate,
            int transportRate,
            int hotelRate,
            byte[] itineraryByte,
            byte[] pamphletByte) throws IOException {
        this.name = name;
        this.phonenum = phonenum;
        this.package_name = package_name;
        this.transport = transport;
        this.roomType = roomType;
        this.travellerNum = travellerNum;
        this.hotelNum = hotelNum;
        this.packageRate = packageRate;
        this.transportRate = transportRate;
        this.hotelRate = hotelRate;
        this.packageSTotal = travellerNum * packageRate;
        this.transportSTotal = travellerNum * transportRate;
        this.hotelSTotal = hotelNum * hotelRate;
        this.bill_total = this.packageSTotal + this.transportSTotal + this.hotelSTotal;
        this.itinerary = itineraryByte;
        this.pamphlet = pamphletByte;
    }

    public String getName() {
        return name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getTransport() {
        return transport;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getTravellerNum() {
        return travellerNum;
    }

    public int getHotelNum() {
        return hotelNum;
    }

    public int getPackageRate() {
        return packageRate;
    }

    public int getTransportRate() {
        return transportRate;
    }

    public int getHotelRate() {
        return hotelRate;
    }

    public int getPackageSTotal() {
        return packageSTotal;
    }

    public int getTransportSTotal() {
        return transportSTotal;
    }

    public int getHotelSTotal() {
        return hotelSTotal;
    }

    public int getBill_total() {
        return bill_total;
    }

    public byte[] getItinerary() {
        return itinerary;
    }

    public byte[] getPamphlet() {
        return pamphlet;
    }

}
