import java.util.*;

public class groundFloor implements Floor{

    /** To park vehicles which have more than 4 wheels
     * Has 100 parking spots and the first 10 are reserved for Handicapped
     */

    final int MAX_SPOTS = 100;
    List<ParkingSpot> spots = new ArrayList<>(MAX_SPOTS);
    boolean[] spots_available =new boolean[MAX_SPOTS];

    private void initialize_spots_available(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots_available[i] = true;
        }
    }

    private void initialize_array_list(){
        for(int i=0; i<MAX_SPOTS; ++i){
            spots.add(i, null);
        }
    }

    public groundFloor(){
        initialize_spots_available();
        initialize_array_list();
    }


    @Override
    public boolean isFull() {
        int cnt = 0;
        for(int i=0; i<MAX_SPOTS; ++i){
            if(!spots_available[i]){
                cnt += 1;
            }
        }
        return cnt == MAX_SPOTS;
    }


    @Override
    public void slotsAvailable() {
        System.out.println("GENERAL PARKING SLOTS");
        for(int i=10; i<MAX_SPOTS; ++i){
            if(spots_available[i]){
                System.out.print(i+1 + " ");
            }
        }
    }

    @Override
    public void display_entry_points() {
        /**
         * Prints 4 entry points names in the floor
         */
        System.out.println("1. Handicapped Entrance");
        System.out.println("2. South Gate Entrance");
        System.out.println("3. North Gate Entrance");
        System.out.println("4. East Gate Entrance");
    }

    @Override
    public void display_exit_points() {
        /**
         * Prints 4 exit points names in the floor
         */
        System.out.println("1. Handicapped Exit");
        System.out.println("2. South Gate Exit");
        System.out.println("3. North Gate Exit");
        System.out.println("4. East Gate Exit");
    }

    @Override
    public void display_reserved_spots() {
        System.out.println("RESERVED FOR HANDICAPPED");
        for(int i=0; i<10; ++i){
            if(spots_available[i]){
                System.out.print(i+1 + " ");
            }
        }
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
    public void add_vehicle(ParkingSpot p) {
        int slotno = p.getSlotNo();
        if(spots_available[slotno-1]){
            spots_available[slotno-1] = false;
            spots.set(slotno-1,p);
        }
    }

    @Override
    public void vehicle_exit(int slotno) {
        if(!spots_available[slotno-1]){
            spots_available[slotno-1] = true;
            spots.set(slotno-1,null);
        }
    }
}
