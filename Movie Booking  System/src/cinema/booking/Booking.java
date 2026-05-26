package cinema.booking;
import cinema.movies.Movie;

public class Booking {
    private String customerName;
    private Movie movie;
    private Seat seat;

    public Booking(String customerName ,Movie movie ,Seat seat){
        this.customerName= customerName;
        this.seat=seat;
        this.movie=movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Seat getSeat() {
        return seat;
    }


    public  void calculatePrice(){
        System.out.println("the price is "+ movie.getTicketPrice());
    }

    public void showBookingInfo() {
        System.out.println("Customer: " + customerName);
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Seat Number: " + seat.getSeatNumber());
        System.out.println("Total Price: " + movie.getTicketPrice() + " birr");
    }
}
