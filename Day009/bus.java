import java.util.Scanner;
import java.io.*;

public class bus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ava = 5;
        String name;
        do {
            System.out.println("\nWelcome to Bus Booking System");
            System.out.print("\nEnter your name :");
            name = sc.next();
            System.out.print("\n Enter number of seats to book:");
            int seat = sc.nextInt();
            if (seat <= ava) {
                System.out.println("\nBooking Successful of " + seat + " seats for name : " + name);
                ava = ava - seat;
            } else {
                System.out.println("\nBooking Failed. Not enough seats available");
            }
        } while (ava > 0);
        System.out.println("All seats are booked");
    }

}