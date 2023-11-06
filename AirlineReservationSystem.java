import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private double price;
    private int availableSeats;

    public Flight(String flightNumber, String departureCity, String destinationCity, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void cancelSeat() {
        availableSeats++;
    }
}

class Reservation {
    private String passengerName;
    private Flight flight;

    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
        flight.bookSeat();
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void cancelReservation() {
        flight.cancelSeat();
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AA101", "New York", "Los Angeles", 250.0, 150));
        flights.add(new Flight("UA202", "Chicago", "Houston", 200.0, 100));
        flights.add(new Flight("DL303", "San Francisco", "Miami", 300.0, 200));

        List<Reservation> reservations = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Airline Reservation System!");

        while (true) {
            System.out.println("1. List Flights");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Available Flights:");
                for (Flight flight : flights) {
                    System.out.println(flight.getFlightNumber() + " - " +
                            flight.getDepartureCity() + " to " + flight.getDestinationCity() +
                            " Price: $" + flight.getPrice() + " Available Seats: " + flight.getAvailableSeats());
                }
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                scanner.nextLine(); // Consume the newline character
                String passengerName = scanner.nextLine();
                System.out.print("Enter the flight number you want to book: ");
                String flightNumber = scanner.next();

                Flight selectedFlight = null;
                for (Flight flight : flights) {
                    if (flight.getFlightNumber().equals(flightNumber)) {
                        selectedFlight = flight;
                        break;
                    }
                }

                if (selectedFlight != null && selectedFlight.getAvailableSeats() > 0) {
                    Reservation reservation = new Reservation(passengerName, selectedFlight);
                    reservations.add(reservation);
                    System.out.println("Reservation successful! " + passengerName + " is booked on flight " +
                            selectedFlight.getFlightNumber() + " from " + selectedFlight.getDepartureCity() +
                            " to " + selectedFlight.getDestinationCity());
                } else {
                    System.out.println("Invalid flight number or no available seats.");
                }
            } else if (choice == 3) {
                System.out.print("Enter your name for cancellation: ");
                scanner.nextLine(); // Consume the newline character
                String passengerName = scanner.nextLine();
                System.out.print("Enter the flight number for cancellation: ");
                String flightNumber = scanner.next();

                Reservation reservationToRemove = null;
                for (Reservation reservation : reservations) {
                    if (reservation.getPassengerName().equals(passengerName) &&
                        reservation.getFlight().getFlightNumber().equals(flightNumber)) {
                        reservationToRemove = reservation;
                        break;
                    }
                }

                if (reservationToRemove != null) {
                    reservationToRemove.cancelReservation();
                    reservations.remove(reservationToRemove);
                    System.out.println("Cancellation successful for " + passengerName + " on flight " + flightNumber);
                } else {
                    System.out.println("No matching reservation found for cancellation.");
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
