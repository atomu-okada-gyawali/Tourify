/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourify.Model;

/**
 *
 * @author Lenovo
 */
public class Bill {
    private int bill_id;
    private int booking_id;
    private int bill_total;

    public Bill(int bill_id, int bill_total) {
        this.bill_id = bill_id;
        this.bill_total = bill_total;
    }

    public int getBill_id() {
        return bill_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getBill_total() {
        return bill_total;
    }
    
}
