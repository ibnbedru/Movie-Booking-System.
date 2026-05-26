package cinema.booking;

public class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false; // starts as free
    }

    public int getSeatNumber() { return seatNumber; }
    public boolean isBooked() { return isBooked; }

    public void book() {
        if (isBooked) {
            System.out.println("Seat " + seatNumber + " is already taken!");
        } else {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully!");
        }
    }

    public void cancel() {
        isBooked = false;
        System.out.println("Seat " + seatNumber + " is now available.");
    }
}
