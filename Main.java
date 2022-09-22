import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("\nMenu:");
        System.out.println("1)Select Ticket counter");
        System.out.println("2)Display Parking Charges per hour");
        System.out.println("3)Display free slots");
        System.out.println("4)Display parked vehicles details");
        System.out.println("5)Exit vehicle");
        System.out.println("6)Exit Program");
        System.out.print("Choose an option from the Menu: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
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

                System.out.print("\nEnter your Name: ");
                in.nextLine();
                String name = in.nextLine();
                System.out.print("Enter Vehicle's Wheel count: ");
                int wheel_count = in.nextInt();
                System.out.print("Enter license number: ");
                String license_num = in.next();
                boolean isElectric = false;
                if(wheel_count == 4) {
                    System.out.print("Is it an electric vehicle? (true/false): ");
                    isElectric = in.nextBoolean();
                }
                System.out.print("Enter vehicle's color: ");
                in.nextLine();
                String color = in.nextLine();
                System.out.print("Are you handicapped?(true/false): ");
                boolean is_handicapped = in.nextBoolean();

                Vehicle v = new Vehicle(name, wheel_count, license_num, isElectric, color, is_handicapped);

                /**
                 * available spots are displayed for a specific vehicle type
                 * then he/she chooses one of those spots
                 */

                ticket_counter.availableSpots(v);

            }
            else if (n == 2){
                ticket_counter.display_parking_charges();
            }
            else if (n == 3){
                ticket_counter.display_free_slots();
            }
            else if (n == 4){
                ticket_counter.display_vehicles();
            }
            else if (n == 5){

                /** Get slot no, and floor.no and show the price for parking, get the cash paid through
                 * cash or card and remove vehicle from the slot and make it free (change slots_occupied array to 1
                 */

                System.out.println("Please enter the slot number and the floor number");
                int slotno = in.nextInt();
                int floorno = in.nextInt();
                ticket_counter.exit_vehicle(slotno, floorno);
            }
            else if(n == 6){
                break;
            }
            else{
                System.out.println("INVALID OPTION!");
            }
        }
    }

}
