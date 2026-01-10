package Day010;

class busTicketBooking extends Thread {
    private String name;
    private int seats;

    public busTicketBooking(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    private static int availableSeats = 10;

    public void run() {
        // Print hello 3 times
        for (int i = 0; i < 3; i++) {
            System.out.println("hello, " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        // Try to book tickets with block-level synchronization
        synchronized (busTicketBooking.class) {
            if (availableSeats >= seats) {
                System.out.println(name + " booked " + seats + " tickets.");
                availableSeats -= seats;
            } else {
                System.out.println(name + " failed to book tickets. Not enough seats.");
            }
            System.out.println("Seats left: " + availableSeats);
        }
        // Print bye 3 times
        for (int i = 0; i < 3; i++) {
            System.out.println("Bye, " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

}

public class demo {
    public static void main(String[] args) {
        busTicketBooking t1 = new busTicketBooking("User1", 7);
        busTicketBooking t2 = new busTicketBooking("User2", 6);
        t1.start();
        t2.start();
    }
}
