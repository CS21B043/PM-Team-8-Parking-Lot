import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Floor3 implements Floor{

    /** This floor is for parking 2 Wheelers with spot count = 400
     * First 30 spots are reserved for handicapped
     */

    final int MAX_SPOTS = 400;
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

    public Floor3(){
        initialize_spots_available();
        initialize_array_list();
    }

    @Override
    public boolean isFull() {
        boolean k = true;
        for(int i=0; i<MAX_SPOTS; ++i){
            if(spots_available[i]){
                k = false;
                break;
            }
        }
        return k;
    }


    @Override
    public void slotsAvailable() {
        int cnt = 0;
        System.out.println("GENERAL PARKING SLOTS");
        for(int i=30; i<MAX_SPOTS; ++i){
            if(spots_available[i]){
                ++cnt;
                System.out.print(i+1 + " ");
            }
            if(cnt > 20) {
                cnt = 0;
                System.out.println();
            }
        }
    }

    @Override
    public void display_entry_points() {
        System.out.println("1. Handicapped Road");
        System.out.println("2. South Gate Road");
        System.out.println("3. North Gate Road");
        System.out.println("4. East Gate Road");
    }

    @Override
    public void display_exit_points() {
        System.out.println("1. Handicapped Road");
        System.out.println("2. South Gate Road");
        System.out.println("3. North Gate Road");
        System.out.println("4. East Gate Road");
    }

    @Override
    public void display_reserved_spots() {
        System.out.println("\nRESERVED FOR HANDICAPPED");
        for(int i=0; i<30; ++i){
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
