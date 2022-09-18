import java.util.*;

public class groundFloor implements Floor{

    /** To park vehicles which have more than 4 wheels
     * Has 100 parking spots and the first 10 are reserved for Handicapped
     */

    List<ParkingSpot> spots = new ArrayList<>();

    final int MAX_SPOTS = 100;
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
