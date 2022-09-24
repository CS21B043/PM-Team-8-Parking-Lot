import java.util.Date;
import java.util.Scanner;

public class TicketCounter {

    /** TicketCounter Class is the place which get the vehicle type and shows what
     * spots are available for that vehicle type and parks the vehicle (also notes the time of entry)
     * and calculates the price when vehicles exit
     */
    //Creating objects of every floor
    groundFloor g = new groundFloor();
    Floor1 f1 = new Floor1();
    Floor2 f2 = new Floor2();
    Floor3 f3 = new Floor3();
    public TicketCounter() {
    }
    
    //Prints the parking charges per hour.
    protected void display_parking_charges(){
        System.out.println("\nRs-50 for the first hour");
        System.out.println("Rs-30 for the second and third hour");
        System.out.println("Rs-10 for all the remaining hours");
    }
    
    //Given a vehicle v, this method finds which floor it must be parked on.
    protected int findFloor(Vehicle v){
        int wheelno = v.getWheelCnt();
        boolean is_electric = v.isElectric;
        if( wheelno > 4){
            return 0;
        }
        else if (wheelno == 4){
            if(is_electric){
                return 2;
            }
            return 1;
        }
        return 3;
    }
    
    //Given a vehicle v, this methods prints all the possible spots on which it can be parked.
    protected void availableSpots(Vehicle v){
        int floor_no = findFloor(v);
        System.out.println("\nFLOOR NO: " + floor_no);
        boolean is_handicapped = v.isHandicapped();
        if(floor_no == 0){

            if(is_handicapped){
                g.display_reserved_spots();
            }
            g.slotsAvailable();
        }
        else if (floor_no == 2) {
            if(is_handicapped){
                f2.display_reserved_spots();
            }
            f2.slotsAvailable();
        }
        else if (floor_no == 1){
            if(is_handicapped){
                f1.display_reserved_spots();
            }
            f1.slotsAvailable();

        }
        else{
            if(is_handicapped){
                f3.display_reserved_spots();
            }
            f3.slotsAvailable();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("\nChoose one from any of these available spots: ");
        int slot_no = in.nextInt();
        add_vehicle_toSpot(v,slot_no,floor_no);
    }
    
    //It links a vehicle to its corresponding parking spot.
    protected void add_vehicle_toSpot(Vehicle v, int slotno, int floorno){
        Date in = new Date();
        ParkingSpot p = new ParkingSpot(slotno,floorno,v,in);
        assert(floorno >=0 && floorno <4);

        if(floorno == 0){
            g.add_vehicle(p);
        }
        else if (floorno == 1){
            f1.add_vehicle(p);
        }
        else if (floorno == 2){
            f2.add_vehicle(p);
        }
        else{
            f3.add_vehicle(p);
        }
    }

    //This method helps in calculating the amount a user has to pay when they leave, according to the parking charges mentioned earlier.
    protected int calculate_amt(Date in){
        int amt;
        Date exit = new Date();
        int hours = exit.getHours() - in.getHours()+1;
        int day = exit.getDay() - in.getDay();

        if(day<0)day=day+7;
        day=day*24;
        if((hours+day)==1){
            amt=50;
        }
        else if((hours+day)==2 || (hours+day)==3){
            amt=50+(hours+day-1)*30;
        }
        else{
            amt=(50+(2)*30)+(hours+day-3)*30;
        }
        return amt;
    }
    
    //This method helps in making the code for payment methods more readable.
    public void print_menu(String s, int i){
        System.out.println("Enter "+i+" for using " + s);
    }
    
    //This method helps the user in navigating the Customer's Info Portal, where they can pay online, either using UPI or NetBanking.
    protected void pay_at_cip(int amt) {
        Scanner in = new Scanner(System.in);
        String id,password;
        System.out.println("Welcome to the Customer's Info Portal");
        System.out.println("You can pay using NetBanking or UPI");
        print_menu("UPI", 1);
        print_menu("NetBanking", 2);
        int t = in.nextInt();
        assert (t == 1 || t == 2);
        if (t == 1) {
            System.out.println("Please enter your UPI ID");
            id = in.next();
            System.out.println("Please enter your 6 digit UPI pin");
        } else {
            System.out.print("Enter your user id: ");
            id = in.next();
            System.out.print("Enter your password: ");
        }
        password = in.next();
        System.out.println("Your Payment of Rs." + amt + " using account id " + id +
                " was successful! Thank you for using the Customer's Info Portal");
    }
    
    //This method helps the user to pay automatically, using FASTAG.
    protected void pay_using_aep(int amt){
        System.out.println("Your Payment of Rs. " + amt + " using FASTAG was successful! Thank you for using the Automated Exit Panel");
    }
    
    //This method helps the user to pay at the ticket counter to a parking attendant, either in Cash or Card.
    protected void pay_to_attendant(int amt) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose your payment method");
        print_menu("Cash", 1);
        print_menu("Card", 2);
        int t = in.nextInt();
        assert (t == 1 || t == 2);
        if (t == 1) {
            System.out.println(amt + " has been received through cash");
        } else {
            System.out.println("Enter Account number: ");
            int ac = in.nextInt();
            System.out.println(amt + " has been credited to " + ac);
        }
    }
    
    //This is the MAIN payment method, where the user can choose any one of the 3 payment methods mentioned above.
    protected void payment(int amt){
        Scanner in = new Scanner(System.in);
        System.out.println("You can pay at the Customer's Info Portal or using an Automated Exit Panel or to the Parking Attendant");
        print_menu("Customer's Info Portal", 1);
        print_menu("Automated Exit Panel", 2);
        print_menu("Parking Attendant", 3);
        int t = in.nextInt();
        assert(t ==1 || t ==2 || t==3);
        if(t==1){
            pay_at_cip(amt);
        }
        else if(t==3){
            pay_to_attendant(amt);
        }
        else{
            pay_using_aep(amt);
        }
    }
    
    protected void exit_vehicle(int slotno, int floorno){
        /** int t = get.this.time, now subtract this with the parking slot's time and calculate money
         * and also free the slot, make the spots available array value in that pos as '1' &
         * ask the payment method cash / card ( Select 1 or 2 respectively) and call the payment method()
         */
        Date in;
        if(floorno == 0){
            in = g.findDate(slotno);
        }
        else if (floorno == 1){
            in = f1.findDate(slotno);
        }
        else if (floorno == 2){
            in = f2.findDate(slotno);
        }
        else if (floorno == 3){
            in = f3.findDate(slotno);
        }
        else{
            System.out.println("Enter Valid floor & Slot number");
            return;
        }
        int amt = calculate_amt(in);
        System.out.println("You have to pay: " + amt);
        payment(amt);
        freeSpots(slotno, floorno);
        remove_vehicle(slotno, floorno);
    }
    
    //This method helps in freeing up the slot of a vehicle when it leaves.
    protected void remove_vehicle(int slotno, int floorno){
        if(floorno == 0){
            g.vehicle_exit(slotno);
        }
        else if (floorno == 1){
            f1.vehicle_exit(slotno);
        }
        else if(floorno == 2){
            f2.vehicle_exit(slotno);
        }
        else if (floorno == 3){
            f3.vehicle_exit(slotno);
        }
    }
    
    //Prints all available slots in the entire building.
    public void display_free_slots(){
        System.out.println("\n\nThe slots available in the ground floor are : ");
        g.slotsAvailable();
        g.display_reserved_spots();

        System.out.println("\n\nThe slots available in the first floor are : ");
        f1.slotsAvailable();
        f1.display_reserved_spots();

        System.out.println("\n\nThe slots available in the second floor are : ");
        f2.slotsAvailable();
        f2.display_reserved_spots();

        System.out.println("\n\nThe slots available in the third floor are : ");
        f3.slotsAvailable();
        f3.display_reserved_spots();
        System.out.println();
    }
    
    //This method helps in clearing a slot and making it available to use again. 
    protected void freeSpots(int slotno, int floorno){
        if(floorno == 0){
            g.clearSpots(slotno);
        }
        else if (floorno == 1){
            f1.clearSpots(slotno);
        }
        else if (floorno == 2){
            f2.clearSpots(slotno);
        }
        else if (floorno == 3){
            f3.clearSpots(slotno);
        }
    }
    
    //Displays all the vehicles in the building floor by floor.
    protected void display_vehicles(){
        System.out.println("GROUND FLOOR:");
        g.display_vehicles_details();
        System.out.println("\nFIRST FLOOR:");
        f1.display_vehicles_details();
        System.out.println("\nSECOND FLOOR:");
        f2.display_vehicles_details();
        System.out.println("\nTHIRD FLOOR:");
        f3.display_vehicles_details();
    }

}
