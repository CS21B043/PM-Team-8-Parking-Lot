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

    protected void payment(int amt){
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose your payment method");
        System.out.println("Enter 1 for Cash");
        System.out.println("Enter 2 for Card");
        int t = in.nextInt();
        assert(t ==1 || t ==2);
        if(t == 1){
            System.out.println(amt + " has been received through cash");
        }
        else {
            System.out.println("Enter Account number: " + in.nextInt());
            System.out.println(amt + " has been credited");
        }

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
