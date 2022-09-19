import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Floor2 implements Floor{

    /** This floor is for parking electric cars, it has 160 spots and
     * 12 are reserved for handicapped, each spot has a separate charging point
     *
     */

    List<ParkingSpot> spots = new ArrayList<>();
    final int MAX_SPOTS = 160;
    boolean[] spots_available =new boolean[MAX_SPOTS];

    private void initialize_spots_available(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = true;
        }
    }

    public Floor2(){
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
