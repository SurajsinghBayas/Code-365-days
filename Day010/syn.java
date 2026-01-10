package Day010;

public class syn {

    static class TicketBooking {
        private int availableSeats = 10;

        public void bookTickets(String name, int seats) {

            for (int i = 0; i < 3; i++) {
                System.out.println("hello, " + name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            synchronized (this) {
                System.out.println(name + " is trying to book " + seats + " tickets.");
                synchronized (this) {
                    if (availableSeats >= seats) {
                        System.out.println("Booking successful for " + name + ". " + seats + " tickets booked.");
                        availableSeats -= seats;
                    } else {
                        System.out.println("Booking failed for " + name + ". Not enough seats available.");
                    }
                    System.out.println("Seats left: " + availableSeats);
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("Bye, " + name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }

    }

    static class User extends Thread {
        private String name;
        private TicketBooking booking;
        private int seatsToBook;

        public User(String name, TicketBooking booking, int seatsToBook) {
            this.name = name;
            this.booking = booking;
            this.seatsToBook = seatsToBook;
        }

        @Override
        public void run() {
            // Print hello 3 times
            // Try to book tickets

            booking.bookTickets(name, seatsToBook);
        }
    }

    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        User user1 = new User("Suraj", booking, 7);
        User user2 = new User("onkar", booking, 6);

        user1.start();
        user2.start();
    }
}
