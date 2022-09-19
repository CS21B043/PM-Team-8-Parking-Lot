import javax.swing.*;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TicketCounter {

    /** TicketCounter Class is the place which get the vehicle type and shows what
     * spots are available for that vehicle type and parks the vehicle (also notes the time of entry)
     * and calculates the price when vehicles exit
     */

    groundFloor g = new groundFloor();
    Floor1 f1 = new Floor1();
    Floor2 f2 = new Floor2();
    Floor3 f3 = new Floor3();
    public TicketCounter() {
    }
    protected void display_parking_charges(){
        System.out.println("Rs-50 for the first hour");
        System.out.println("Rs-30 for the second and third hour");
        System.out.println("Rs-10 for all the remaining hours");
    }

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
    protected void availableSpots(Vehicle v){
        int floor_no = findFloor(v);
        boolean is_handicapped = v.isHandicapped();
        boolean b = v.isElectric();
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
        System.out.print("Choose one from any of these available spots: ");
        int slot_no = in.nextInt();
        add_vehicle_toSpot(v,slot_no,floor_no);
    }

    protected void add_vehicle_toSpot(Vehicle v, int slotno, int floorno){
        if(floorno == 0){
            g.add_vehicle(v,slotno);
        }
        else if (floorno == 1){
            f1.add_vehicle(v,slotno);
        }
        else if (floorno == 2){
            f2.add_vehicle(v,slotno);
        }
        else{
            f3.add_vehicle(v,slotno);
        }
    }

    public void print_menu(String s, int i){
        System.out.println("Enter "+i+" for using " + s);
    }
    protected void pay_at_cip(int amt) {
        Scanner in = new Scanner(System.in);
        String id;
        String password;
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
            System.out.println("Please enter your user id");
            id = in.next();
            System.out.println("Please enter your password");
        }
        password = in.next();
        System.out.println("Your Payment of Rs. " + amt + " using account id " + id +
                " was successful! Thank you for using the Customer's Info Portal");
    }

    protected void pay_using_aep(int amt){
        System.out.println("Your Payment of Rs. " + amt + " using FASTAG was successful! Thank you for using the Automated Exit Panel");
    }
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
            System.out.println("Enter Account number: " + in.nextInt());
            System.out.println(amt + " has been credited");
        }
    }
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
        /** int t = get.this.time, now subtract this with the parking slot's time and calculte money
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
        int amt = 0;
        Date exit = new Date();
        int hours = exit.getHours() - in.getHours();
        int day = exit.getDay() - in.getDay();
        int minutes = exit.getMinutes() - in.getMinutes();

        if(day<0)day=day+7;
        day=day*24;
        if((hours+day)==1){
            System.out.println((hours+day)*50);
            amt=(hours+day)*50;
        }
        else if((hours+day)==2 || (hours+day)==3){
            System.out.println((50+(hours+day-1)*30));
            amt=50+(hours+day-1)*30;
        }
        else{
            amt=(50+(2)*30)+(hours+day-3)*30;
            System.out.println((amt));
        }
        payment(amt);
        freeSpots(slotno, floorno);
    }
    

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

}
