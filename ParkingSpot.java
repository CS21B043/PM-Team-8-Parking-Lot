import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ParkingSpot {
    int slotNo;
    int floorNo;
    Vehicle vehicle;
    Date entry = new Date();

    public ParkingSpot(int slotNo, int floorNo, Vehicle vehicle, Date entry) {
        this.slotNo = slotNo;
        this.floorNo = floorNo;
        this.vehicle = vehicle;
        this.entry = entry;
    }
}
