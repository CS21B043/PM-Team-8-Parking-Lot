import java.util.Date;

public interface Floor {
    /**
     * Checks if all slots in a floor are occupied
     * @return true/false
     */
    boolean isFull();

    /**
     * Shows general parking slot numbers available in the floor
     */
    void slotsAvailable();

    /**
     * Shows the name of different entry points in a floor
     */
    void display_entry_points();

    /**
     * Shows the name of different exit points in a floor
     */
    void display_exit_points();

    /**
     * Shows the slot numbers which are reserved for handicapped
     */
    void display_reserved_spots();

    /**
     * Given a slot no, it checks for the vehicle in that slot number in the respective floor
     * @param slotno 
     * @return Vehicle
     */
    Vehicle findVehicle(int slotno);

    /**
     * Given the slot no, it will return the entry date of the vehicle in that slot no in the respective floor
     * @param slotno 
     * @return Entry Date
     */
    Date findDate(int slotno);

    /**
     * Clears the vehicle in that slot no, set the array names slots_available value as false 
     * @param slotno
     */
    void clearSpots(int slotno);

    /**
     * Adds new vehicle the slots array in respective floor
     * @param p
     */
    void add_vehicle(ParkingSpot p);

    /**
     * This method will find the vehicle in the slot no, then sets the slot no's value as false in the spots_available 
     * array as false
     * @param slotno
     */
    void vehicle_exit(int slotno);
}
