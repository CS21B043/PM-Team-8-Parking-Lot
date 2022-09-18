import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= 1;
        ArrayList<Vehicle> vehicles_arr = new ArrayList<>(400+200+160+100);
        TicketCounter ticket_counter = new TicketCounter();
        while(true){
            menu();
            n = in.nextInt();
            if(n == 1){
                System.out.println("1)TC - 1");
                System.out.println("2)TC - 2");
                System.out.println("3)TC - 3");
                System.out.println("4)TC - 4");
                System.out.print("Choose your TC: ");
                int tc = in.nextInt();

                System.out.println("\nEnter your vehicle's Wheel count, license number, color");
                int wheel_count = in.nextInt();
                String license_num = in.next();
                boolean isElectric=in.nextBoolean();
                String color = in.next();
                String nature = in.next();

                Vehicle v = new Vehicle(wheel_count,license_num,isElectric,color,nature);
                vehicles_arr.add(v);
                /**
                 * available spots are displayed for a specific vehicle type
                 * the he/she chooses one of those spots
                 */

            }
            else if (n == 2){
                ticket_counter.display_parking_charges();
            }
            else if (n == 3){

            }
            else if (n == 4){
                /** Get slot no, and floor.no and show the price for parking, get the cash paid through
                 * cash or card and remove vehicle from the slot and make it free (change slots_occupied array to 1
                 */
            }
            else if(n == 5){
                break;
            }
            else{
                System.out.println("INVALID OPTION!");
            }
        }
    }

    public static void menu(){
        System.out.println("Menu:");
        System.out.println("1)Select Ticket counter");
        System.out.println("2)Display Parking Charges per hour");
        System.out.println("3)Display free slots");
        System.out.println("4)Exit vehicle");
        System.out.println("5)Exit Program");
        System.out.println("Choose an option from the Menu");
    }
}
