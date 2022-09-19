import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Floor1 implements Floor{

    /** This floor is to park all non-electric 4 wheelers
     * Has 200 parking spots, out of which the first 20 are reserved for handicapped
     */

    List<ParkingSpot> spots = new ArrayList<>();
    final int MAX_SPOTS = 200;
    boolean[] spots_available =new boolean[MAX_SPOTS];

    private void initialize_spots_available(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = true;
        }
    }
    public Floor1() {
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
        return null;
    }

    @Override
    public void clearSpots(int slotno) {

    }

    @Override
    public void add_vehicle(ParkingSpot p) {

    }


    @Override
    public void vehicle_exit(int slotno) {

    }
}
