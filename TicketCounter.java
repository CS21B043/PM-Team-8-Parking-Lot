import java.util.Objects;

public class TicketCounter {

    /** TicketCounter Class is the place which get the vehicle type and shows what
     * spots are available for that vehicle type and parks the vehicle (also notes the time of entry)
     * and calculates the price when vehicles exit
     */

    groundFloor g = new groundFloor();
    Floor1 f1 = new Floor1();
    Floor2 f2 = new Floor2();
    Floor3 f3 = new Floor3();
    int a;
    public TicketCounter() {
    }
    protected void display_parking_charges(){
        System.out.println("Rs-50 for the first hour");
        System.out.println("Rs-30 for the second and third hour");
        System.out.println("Rs-10 for all the remaining hours");
    }

    protected void availableSpots(Vehicle v){
        int wheelno=v.getWheelCnt();
        String n = v.getSpot_nature();
        boolean b=v.isElectric();
        if(wheelno>4){

            if(Objects.equals(n, "Handicapped")){
                g.display_reserved_spots();
            }
            g.slotsAvailable();
        }
        else if (wheelno==4) {
            if(b){
                if(Objects.equals(n, "Handicapped")){
                    f2.display_reserved_spots();
                }
                f2.slotsAvailable();
            }
            else{
                if(Objects.equals(n, "Handicapped")){
                    f1.display_reserved_spots();
                }
                f1.slotsAvailable();
            }
        }
        else{
            if(Objects.equals(n, "Handicapped")){
                f3.display_reserved_spots();
            }
            f3.slotsAvailable();
        }

    }

    protected void exit_vehicle(int slotno, int floorno){
        /** int t = get.this.time, now subtract this with the parking slot's time and calculte money
         * and aslo free the slot, make the spots available array value in that pos as '1' &
         * ask the payment method cash / card ( Select 1 or 2 respectively) and call the payment method()
         */
    }

    protected void payment(int t, int amt){
        if( t== 1) {
            //pays cash
        }
        else if ( t== 2){
            //mens card
        }

    }





}
