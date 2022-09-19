import java.util.*;

public class groundFloor implements Floor{

    /** To park vehicles which have more than 4 wheels
     * Has 100 parking spots and the first 10 are reserved for Handicapped
     */

    List<ParkingSpot> spots = new ArrayList<>();

    final int MAX_SPOTS = 100;
    boolean[] spots_available =new boolean[MAX_SPOTS];

    private void initialize_spots_available(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = true;
        }
    }

    public groundFloor(){
        initialize_spots_available();
    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public void slotsAvailable() {

    }

    @Override
    public void display_entry_points() {

    }

    @Override
    public void display_exit_points() {

    }

    @Override
    public void display_reserved_spots() {

    }

    @Override
    public Vehicle findVehicle(int slotno) {
        return null;
    }

    @Override
    public Date findDate(int slotno) {
        return spots.get(slotno-1).getEntry();
    }

    @Override
    public void clearSpots(int slotno) {
        spots_available[slotno - 1] = true;
    }

    @Override
    public void add_vehicle(Vehicle v,int slotno) {

    }

    @Override
    public void vehicle_exit(Vehicle v, int slotno) {

    }
}
