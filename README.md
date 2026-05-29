# 🎬 Movie Booking System

A console-based Java application that simulates a real cinema booking experience.
Built as a student project to demonstrate core Object-Oriented Programming concepts.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Project Structure](#project-structure)
- [OOP Concepts Used](#oop-concepts-used)
- [How to Run](#how-to-run)
- [How to Use](#how-to-use)
- [Classes Explained](#classes-explained)

---

## About the Project

This program lets a user:
- View all available movies (Action and Comedy)
- Book one or multiple seats for a movie
- See a visual seat map showing available and taken seats
- Cancel an existing booking
- View all current bookings

All data is managed in memory using ArrayLists and user interaction
is handled through the terminal using Java's Scanner class.

---

## Project Structure

```
CinemaBooking/
 └── src/
      └── cinema/
           ├── movies/
           │    ├── Movie.java          (abstract class)
           │    ├── ActionMovie.java    (extends Movie)
           │    └── Comedy.java         (extends Movie)
           ├── booking/
           │    ├── Seat.java
           │    └── Booking.java
           └── main/
                └── Main.java
```

---

## OOP Concepts Used

| Concept | Where |
|---|---|
| Encapsulation | Private fields + getters/setters in Movie, Seat, Booking |
| Constructors | All 5 classes have constructors |
| Inheritance | ActionMovie and Comedy extend Movie |
| Method Overriding | showDetails() overridden in ActionMovie and Comedy |
| Method Overloading | showDetails(String rating) in ActionMovie and Comedy |
| Polymorphism | ArrayList\<Movie\> holds ActionMovie and Comedy objects |
| Abstraction | Movie is an abstract class with abstract showDetails() |
| Packages | cinema.movies, cinema.booking, cinema.main |
| Access Modifiers | private, public used throughout all classes |
| ArrayList | movies, seats, bookings lists in Main |
| Scanner | All user input in Main |
| Exception Handling | try-catch wraps all menu logic in Main |

---

## How to Run

### Requirements
- Java JDK 8 or higher
- IntelliJ IDEA (recommended) or any Java IDE

### Steps in IntelliJ IDEA

1. Open IntelliJ IDEA
2. Click **File → New → Project**
3. Name the project `CinemaBooking`, select Java, click **Create**
4. Right click `src` → **Mark Directory as → Sources Root**
5. Create packages by right clicking `src`:
   - `New → Package → cinema.movies`
   - `New → Package → cinema.booking`
   - `New → Package → cinema.main`
6. Create each Java class inside the correct package
7. Copy the code into each file
8. Open `Main.java` and click the **green play button** next to `main`

---

## How to Use

When you run the program you will see this menu:

```
===== Cinema Booking System =====
1. View all movies
2. Book a seat
3. Cancel booking
4. View my bookings
5. Exit
Enter choice:
```

### Option 1 — View all movies
Displays all available movies with title, duration, price and genre details.

### Option 2 — Book a seat
- Enter your name
- A seat grid is shown: `[1] [2] [X] [4]...` where X means taken
- Choose a movie from the list
- Enter how many seats you want
- Enter a seat number for each person
- Total price is calculated and displayed at the end

### Option 3 — Cancel a booking
- Shows all current bookings
- Enter the seat number you want to cancel
- The seat is freed and the booking is removed

### Option 4 — View all bookings
Shows all current bookings with customer name, movie, seat number and price.

### Option 5 — Exit
Closes the program.

---

## Classes Explained

### Movie.java (abstract)
The blueprint for all movies. Contains private fields `title`, `duration`
and `price` with getters and setters. Declares the abstract method
`showDetails()` which all subclasses must implement.

### ActionMovie.java
Extends Movie. Adds a private field `actionLevel` (e.g. High, Medium, Low).
Overrides `showDetails()` to print action movie details.
Overloads `showDetails(String rating)` to also print a rating.

### Comedy.java
Extends Movie. Adds a private field `comedyType` (e.g. Slapstick, Situational).
Overrides `showDetails()` to print comedy details.
Overloads `showDetails(String rating)` to also print a rating.

### Seat.java
Represents one physical seat in the cinema. Tracks `seatNumber` and
`isBooked`. The `book()` method marks the seat as taken and `cancel()`
frees it again.

### Booking.java
Connects a customer name, a Movie object and a Seat object together.
The `showBookingInfo()` method prints all booking details including price.

### Main.java
Entry point of the program. Creates and manages three ArrayLists
(movies, seats, bookings). Runs a while loop showing the menu,
reads user input with Scanner, and wraps everything in try-catch
for safe error handling.

---

## Sample Output

```
Enter your name: Abebe
How many seats do you want to book? 3

Seat for person 1: 5
seat 5 booked!
Seat for person 2: 6
seat 6 booked!
Seat for person 3: 7
seat 7 booked!

3 seat(s) booked successfully for Abebe!
Total price: 450.0 birr
```

---

*Developed as part of a Java OOP course assignment.*
