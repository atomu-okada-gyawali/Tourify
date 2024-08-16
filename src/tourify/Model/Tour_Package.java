package tourify.Model;
public class Tour_Package {

    private  int tour_package_id;
    private  String tour_package_name;
    private String tour_package_destination;
    private int tour_package_price;
    private  int tour_package_night_no;
    private byte[] tour_package_itinerary;
    private byte[] tour_package_pamphelt;
    private int trans_bus_price;
    private int trans_flight_price;
    private String hotel_phnumber;
    private int hotel_twin_size_price;
    private int hotel_queen_size_price;
    //pamphlet and itinerary determine datatype

    public Tour_Package( String tour_package_name, String tour_package_destination, int tour_package_price, int tour_package_night_no, byte[] tour_package_itinerary, byte[] tour_package_pamphelt, int trans_bus_price, int trans_flight_price, String hotel_phnumber, int hotel_twin_size_price, int hotel_queen_size_price) {
        this.tour_package_name = tour_package_name;
        this.tour_package_destination = tour_package_destination;
        this.tour_package_price = tour_package_price;
        this.tour_package_night_no = tour_package_night_no;
        this.tour_package_itinerary = tour_package_itinerary;
        this.tour_package_pamphelt = tour_package_pamphelt;
        this.trans_bus_price = trans_bus_price;
        this.trans_flight_price = trans_flight_price;
        this.hotel_phnumber = hotel_phnumber;
        this.hotel_twin_size_price = hotel_twin_size_price;
        this.hotel_queen_size_price = hotel_queen_size_price;
    }

    public int getTour_package_id() {
        return tour_package_id;
    }

    public String getTour_package_name() {
        return tour_package_name;
    }

    public String getTour_package_destination() {
        return tour_package_destination;
    }

    public int getTour_package_price() {
        return tour_package_price;
    }

    public int getTour_package_night_no() {
        return tour_package_night_no;
    }

    public byte[] getTour_package_itinerary() {
        return tour_package_itinerary;
    }

    public byte[] getTour_package_pamphelt() {
        return tour_package_pamphelt;
    }

    public int getTrans_bus_price() {
        return trans_bus_price;
    }

    public int getTrans_flight_price() {
        return trans_flight_price;
    }

    public String getHotel_phnumber() {
        return hotel_phnumber;
    }

    public int getHotel_twin_size_price() {
        return hotel_twin_size_price;
    }

    public int getHotel_queen_size_price() {
        return hotel_queen_size_price;
    }

    public void setTour_package_id(int tour_package_id) {
        this.tour_package_id = tour_package_id;
    }

    public void setTour_package_name(String tour_package_name) {
        this.tour_package_name = tour_package_name;
    }

    public void setTour_package_destination(String tour_package_destination) {
        this.tour_package_destination = tour_package_destination;
    }

    public void setTour_package_price(int tour_package_price) {
        this.tour_package_price = tour_package_price;
    }

    public void setTour_package_night_no(int tour_package_night_no) {
        this.tour_package_night_no = tour_package_night_no;
    }

    public void setTour_package_itinerary(byte[] tour_package_itinerary) {
        this.tour_package_itinerary = tour_package_itinerary;
    }

    public void setTour_package_pamphelt(byte[] tour_package_pamphelt) {
        this.tour_package_pamphelt = tour_package_pamphelt;
    }

    public void setTrans_bus_price(int trans_bus_price) {
        this.trans_bus_price = trans_bus_price;
    }

    public void setTrans_flight_price(int trans_flight_price) {
        this.trans_flight_price = trans_flight_price;
    }

    public void setHotel_phnumber(String hotel_phnumber) {
        this.hotel_phnumber = hotel_phnumber;
    }

    public void setHotel_room_type(int hotel_twin_size_price) {
        this.hotel_twin_size_price = hotel_twin_size_price;
    }

    public void setHotel_room_price(int hotel_queen_size_price) {
        this.hotel_queen_size_price= hotel_queen_size_price;
    }



    

    
}