import java.util.ArrayList;
import java.util.List;

public class Floor2 implements Floor{

    /** This floor is for parking electric cars, it has 160 spots and
     * 12 are reserved for handicapped, each spot has a separate charging point
     *
     */

    List<ParkingSpot> spots = new ArrayList<>();
    final int MAX_SPOTS = 160;
    int[] spots_available =new int[MAX_SPOTS];

    private void farr(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = 1;
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
}
