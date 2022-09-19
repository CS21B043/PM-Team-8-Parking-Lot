import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Floor3 implements Floor{

    /** This floor is for parking 2 Wheelers with spot count = 400
     * First 30 spots are reserved for handicapped
     */

    List<ParkingSpot> spots = new ArrayList<>();
    final int MAX_SPOTS = 400;
    boolean[] spots_available =new boolean[MAX_SPOTS];

    private void initialize_spots_available(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = true;
        }
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
    public void add_vehicle(Vehicle v,int slotno) {

    }
}
