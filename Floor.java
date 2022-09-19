import java.util.Date;

public interface Floor {
    boolean isFull();
    void slotsAvailable();
    void display_entry_points();
    void display_exit_points();
    void display_reserved_spots();
    Vehicle findVehicle(int slotno);
    Date findDate(int slotno);
    void clearSpots(int slotno);
    void add_vehicle(ParkingSpot p);
    void vehicle_exit(int slotno);
}
