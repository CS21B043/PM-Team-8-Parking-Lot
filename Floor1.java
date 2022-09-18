import java.util.ArrayList;
import java.util.List;

public class Floor1 implements Floor{

    /** This floor is to park all non-electric 4 wheelers
     * Has 200 parking spots, out of which the first 20 are reserved for handicapped
     * We have a List named spot which has initially values 0s and 1s ( 0- general free spots, 1- handicapped free spots)
     */

    List<ParkingSpot> spots = new ArrayList<>();
    final int MAX_SPOTS = 200;
    int[] spots_available =new int[MAX_SPOTS];

    private void farr(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = 1;
        }
    }
    public Floor1() {

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
