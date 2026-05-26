
package cinema.main;

import java.util.ArrayList;
import java.util.Scanner;
import cinema.movies.*;
import cinema.booking.*;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Seat> seats = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // adding movies
        movies.add(new ActionMovie("Fast X", 120, 150, "High"));
        movies.add(new ActionMovie("Pathaan", 146, 120, "Medium"));
        movies.add(new ActionMovie("the karate kid", 140 , 150, "High"));
        movies.add(new ComedyMovie("FBI 2", 110, 70, "Slapstick"));
        movies.add(new ComedyMovie("3 Idiots", 170, 110, "Situational"));

// use a loop
        for (int i = 1; i <= 100; i++) {
            seats.add(new Seat(i));
        }

        boolean running = true;

        while (running) {
            System.out.println("\n===== Cinema Booking System =====");
            System.out.println("1. View all movies");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. View my bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {

                    System.out.println("\n--- Movies ---");
                    for (Movie m : movies) {
                        m.showDetails();
                        System.out.println("----------");
                    }

                } else if (choice == 2) {

                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                    // show available seats
                    System.out.println("\n--- Available Seats ---");
                    int count = 0;
                    for (Seat s : seats) {
                        if (s.isBooked()) {
                            System.out.print("[X]  ");
                        } else {
                            System.out.print("[" + s.getSeatNumber() + "] ");
                        }
                        count++;
                        if (count % 10 == 0) {
                            System.out.println();
                        }
                    }
                    System.out.println();
                    System.out.println("[ ] = available   [X] = taken");
                System.out.println();

                // show movies
                System.out.println("\n--- Choose a Movie ---");
                for (int i = 0; i < movies.size(); i++) {
                    System.out.println((i + 1) + ". " + movies.get(i).getTitle());
                }
                System.out.print("Enter movie number: ");
                int movieChoice = sc.nextInt();
                sc.nextLine();

                if (movieChoice < 1 || movieChoice > movies.size()) {
                    throw new Exception("Invalid movie choice!");
                }

                Movie chosenMovie = movies.get(movieChoice - 1);


                System.out.print("How many seats do you want to book? ");
                int numSeats = sc.nextInt();
                sc.nextLine();


                if (numSeats < 1 || numSeats > 10) {
                    throw new Exception("You can book between 1 and 10 seats only!");
                }

                // NEW — loop and book each seat one by one
                int bookedCount = 0;
                for (int i = 0; i < numSeats; i++) {
                    System.out.print("Enter seat number for person " + (i + 1) + ": ");
                    int seatNumber = sc.nextInt();
                    sc.nextLine();

                    if (seatNumber < 1 || seatNumber > seats.size()) {
                        System.out.println("Invalid seat number — skipping!");
                        continue; // skip this one and go to next
                    }

                    Seat chosenSeat = seats.get(seatNumber - 1);

                    if (chosenSeat.isBooked()) {
                        System.out.println("Seat " + seatNumber + " is already taken — skipping!");
                        continue; // skip and try next
                    }

                    chosenSeat.book();
                    bookings.add(new Booking(name, chosenMovie, chosenSeat));
                    bookedCount++;
                }
                if(numSeats > 1){
                    double totalPrice = numSeats * chosenMovie.getTicketPrice();
                    System.out.println("the total pricee is "+ totalPrice);
                }

                System.out.println(bookedCount + " seat(s) booked successfully for " + name + "!");
            } else if (choice == 3) {

                    if (bookings.size() == 0) {
                        System.out.println("No bookings found!");
                    } else {
                        System.out.println("\n--- Your Bookings ---");
                        for (Booking b : bookings) {
                            b.showBookingInfo();
                            System.out.println("----------");
                        }

                        System.out.print("Enter seat number to cancel: ");
                        int cancelSeat = sc.nextInt();
                        sc.nextLine();

                        boolean found = false;
                        for (int i = 0; i < bookings.size(); i++) {
                            if (bookings.get(i).getSeat().getSeatNumber() == cancelSeat) {
                                bookings.get(i).getSeat().cancel();
                                bookings.remove(i);
                                System.out.println("Booking cancelled!");
                                found = true;
                                break;
                            }
                        }

                        if (found == false) {
                            System.out.println("No booking found for seat " + cancelSeat);
                        }
                    }

                } else if (choice == 4) {
                if (bookings.size() == 0) {
                    System.out.println("No bookings yet!");
                } else {
                    System.out.println("\n--- All Bookings ---");
                    for (Booking b : bookings) {
                        b.showBookingInfo();
                        System.out.println("----------");
                    }
                }
            }else if (choice == 5) {
                    running = false;
                    System.out.println("Goodbye!");

                } else {
                    System.out.println("Invalid choice! Please enter 1 to 5.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }

        sc.close();
    }
}
