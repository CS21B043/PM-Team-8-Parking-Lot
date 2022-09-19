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

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }
}
