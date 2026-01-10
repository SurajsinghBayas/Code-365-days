
public class SimpleSync {
    static int availableSeats = 10;

    public static void main(String[] args) {
        Thread user1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello, User1");
            }
            bookTickets("User1", 7);
        });

        Thread user2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello, User2");
            }
            bookTickets("User2", 6);
        });

        user1.start();
        user2.start();
    }

    static void bookTickets(String name, int seats) {
        synchronized (SimpleSync.class) {
            if (availableSeats >= seats) {
                System.out.println(name + " booked " + seats + " tickets.");
                availableSeats -= seats;
            } else {
                System.out.println(name + " failed to book tickets. Not enough seats.");
            }
            System.out.println("Seats left: " + availableSeats);
        }
    }
}
