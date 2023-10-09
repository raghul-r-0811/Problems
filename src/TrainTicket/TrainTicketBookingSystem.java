package TrainTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Passenger {
    String name;
    int age;
    char preference; // L (Lower), M (Middle), U (Upper), S (Side Upper/Lower)
    int berthNumber; // Added to track berth allocation

    public Passenger(String name, int age, char preference, int berthNumber) {
        this.name = name;
        this.age = age;
        this.preference = preference;
        this.berthNumber = berthNumber;
    }
}

class Ticket {
    String pnr;
    List<Passenger> passengers;

    public Ticket(String pnr, List<Passenger> passengers) {
        this.pnr = pnr;
        this.passengers = passengers;
    }
}

public class TrainTicketBookingSystem {
    static final int TOTAL_BERTHS = 16;
    static final int CONFIRMED_BERTHS = 14;
    static final int RAC_BERTHS = 2;
    static final int WAITLIST_BERTHS = 2;
    static int pnrCounter = 1001;

    static List<Ticket> confirmedTickets = new ArrayList<>();
    static List<Ticket> racTickets = new ArrayList<>();
    static List<Ticket> waitlistTickets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print All");
            System.out.println("4. Print Availability");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    cancelTicket(scanner);
                    break;
                case 3:
                    printAllTickets();
                    break;
                case 4:
                    printAvailability();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void bookTicket(Scanner scanner) {
        System.out.print("Enter the number of passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            System.out.println("Passenger " + (i + 1) + " Details:");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            char preference;
            do {
                System.out.print("Enter Preference (L/M/U/S): ");
                preference = scanner.nextLine().toUpperCase().charAt(0);
            } while (preference != 'L' && preference != 'M' && preference != 'U' && preference != 'S');

            passengers.add(new Passenger(name, age, preference, -1)); // Initialize with unassigned berth
        }

        // Process booking
        boolean booked = processBooking(passengers);
        for(int i= 0;i<passengers.size();i++){
            System.out.println(confirmedTickets.get(0));
        }

        if (booked) {
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Ticket booking failed. All berths are occupied.");
        }
    }

    static boolean processBooking(List<Passenger> passengers) {
        if (confirmedTickets.size() < CONFIRMED_BERTHS) {
            return bookConfirmedTicket(passengers);
        } else if (racTickets.size() < RAC_BERTHS) {
            return bookRACTicket(passengers);
        } else if (waitlistTickets.size() < WAITLIST_BERTHS) {
            return bookWaitlistTicket(passengers);
        } else {
            return false; // No more tickets can be booked
        }
    }

    static boolean bookConfirmedTicket(List<Passenger> passengers) {
        List<Passenger> confirmedPassengers = new ArrayList<>();
        List<Passenger> racPassengers = new ArrayList<>();
        List<Passenger> waitlistPassengers = new ArrayList<>();

        for (Passenger passenger : passengers) {
            if (passenger.age > 60 || passenger.preference == 'L') {
                confirmedPassengers.add(passenger);
            } else if (passenger.age < 5) {
                confirmedPassengers.add(passenger);
            } else if (confirmedPassengers.size() < 4) {
                confirmedPassengers.add(passenger);
            } else if (racPassengers.size() < 4) {
                racPassengers.add(passenger);
            } else {
                waitlistPassengers.add(passenger);
            }
        }

        String pnr = generatePNR();
        Ticket ticket = new Ticket(pnr, confirmedPassengers);

        confirmedTickets.add(ticket);
        racTickets.add(new Ticket(generatePNR(), racPassengers));
        waitlistTickets.add(new Ticket(generatePNR(), waitlistPassengers));

        return true;
    }

    static boolean bookRACTicket(List<Passenger> passengers) {
        List<Passenger> racPassengers = new ArrayList<>();
        List<Passenger> waitlistPassengers = new ArrayList<>();

        for (Passenger passenger : passengers) {
            if (passenger.age > 60 || passenger.preference == 'L') {
                racPassengers.add(passenger);
            } else if (passenger.age < 5) {
                racPassengers.add(passenger);
            } else if (racPassengers.size() < 4) {
                racPassengers.add(passenger);
            } else {
                waitlistPassengers.add(passenger);
            }
        }

        if (racPassengers.size() > 0) {
            racTickets.add(new Ticket(generatePNR(), racPassengers));
            return true;
        } else {
            return false;
        }
    }

    static boolean bookWaitlistTicket(List<Passenger> passengers) {
        List<Passenger> waitlistPassengers = new ArrayList<>();

        for (Passenger passenger : passengers) {
            if (passenger.age > 60 || passenger.preference == 'L') {
                waitlistPassengers.add(passenger);
            } else if (passenger.age < 5) {
                waitlistPassengers.add(passenger);
            }
        }

        if (waitlistPassengers.size() > 0) {
            waitlistTickets.add(new Ticket(generatePNR(), waitlistPassengers));
            return true;
        } else {
            return false;
        }
    }

    static void cancelTicket(Scanner scanner) {
        System.out.print("Enter PNR number to cancel ticket: ");
        String pnrToCancel = scanner.nextLine();

        // Find the ticket with the provided PNR
        Ticket ticketToCancel = findTicketByPNR(pnrToCancel);

        if (ticketToCancel != null) {
            // List all passengers in the ticket
            System.out.println("Passengers in the ticket to cancel:");
            int passengerCount = 1;
            for (Passenger passenger : ticketToCancel.passengers) {
                System.out.println(passengerCount + ". " + passenger.name + ", " + passenger.age + ", Berth no. " + passenger.berthNumber);
                passengerCount++;
            }

            System.out.print("Enter the serial number(s) of the passenger(s) to cancel (comma-separated): ");
            String[] passengerNumbers = scanner.nextLine().split(",");

            List<Passenger> racPassengers = new ArrayList<>();
            for (String number : passengerNumbers) {
                int index = Integer.parseInt(number.trim()) - 1;
                if (index >= 0 && index < ticketToCancel.passengers.size()) {
                    Passenger passenger = ticketToCancel.passengers.get(index);
                    racPassengers.add(passenger);
                    ticketToCancel.passengers.remove(index);
                }
            }

            // Update Rac and Waitlist passengers
            updateRACAndWaitlist(racPassengers);

            // Remove the ticket if there are no more passengers
            if (ticketToCancel.passengers.isEmpty()) {
                confirmedTickets.remove(ticketToCancel);
            }

            System.out.println("Ticket canceled successfully.");
        } else {
            System.out.println("PNR not found. No ticket canceled.");
        }
    }

    static void updateRACAndWaitlist(List<Passenger> racPassengers) {
        // Try to accommodate RAC passengers in confirmed berths
        for (Passenger racPassenger : racPassengers) {
            // Find an available confirmed berth based on preference
            int availableBerth = findAvailableConfirmedBerth(racPassenger.preference);

            if (availableBerth != -1) {
                racPassenger.berthNumber = availableBerth;
                racTickets.removeIf(ticket -> ticket.passengers.contains(racPassenger));
                confirmedTickets.add(new Ticket(generatePNR(), List.of(racPassenger)));
            }
        }

        // Try to move Waitlist passengers to RAC
        if (!waitlistTickets.isEmpty() && racPassengers.size() < RAC_BERTHS) {
            Ticket waitlistTicket = waitlistTickets.get(0);
            Passenger waitlistPassenger = waitlistTicket.passengers.get(0);
            waitlistPassenger.berthNumber = -1; // Unassigned

            // Find an available RAC berth
            int availableRACBerth = findAvailableRACBerth();

            if (availableRACBerth != -1) {
                waitlistTicket.passengers.remove(waitlistPassenger);
                racTickets.add(new Ticket(generatePNR(), List.of(waitlistPassenger)));
            }
        }
    }

    static int findAvailableConfirmedBerth(char preference) {
        for (int berth = 1; berth <= TOTAL_BERTHS; berth++) {
            boolean isOccupied = isBerthOccupied(berth);
            if (!isOccupied && isPreferredBerth(berth, preference)) {
                return berth;
            }
        }
        return -1; // No available berth
    }

    static boolean isPreferredBerth(int berth, char preference) {
        // Implement logic to check if the berth matches the preference
        // You can customize this logic based on your preferences (e.g., age, group, etc.)
        return true;
    }

    static int findAvailableRACBerth() {
        for (int racBerth = 1; racBerth <= RAC_BERTHS; racBerth++) {
            boolean isOccupied = isRACBerthOccupied(racBerth);
            if (!isOccupied) {
                return racBerth;
            }
        }
        return -1; // No available RAC berth
    }

    static boolean isBerthOccupied(int berth) {
        for (Ticket ticket : confirmedTickets) {
            for (Passenger passenger : ticket.passengers) {
                if (passenger.berthNumber == berth) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isRACBerthOccupied(int racBerth) {
        for (Ticket ticket : racTickets) {
            for (Passenger passenger : ticket.passengers) {
                if (passenger.berthNumber == racBerth) {
                    return true;
                }
            }
        }
        return false;
    }

    static Ticket findTicketByPNR(String pnr) {
        for (Ticket ticket : confirmedTickets) {
            if (ticket.pnr.equals(pnr)) {
                return ticket;
            }
        }
        for (Ticket ticket : racTickets) {
            if (ticket.pnr.equals(pnr)) {
                return ticket;
            }
        }
        for (Ticket ticket : waitlistTickets) {
            if (ticket.pnr.equals(pnr)) {
                return ticket;
            }
        }
        return null;
    }


    static void printAllTickets() {
        System.out.println("Berth no. , PNR , Name , Age");
        for (int berth = 1; berth <= TOTAL_BERTHS; berth++) {
            boolean isVacant = true;
            StringBuilder passengerDetails = new StringBuilder();

            for (Ticket ticket : confirmedTickets) {
                for (Passenger passenger : ticket.passengers) {
                    if (passenger.berthNumber == berth) {
                        passengerDetails.append(passenger.name).append(", ").append(passenger.age).append(", ").append(ticket.pnr);
                        isVacant = false;
                    }
                }
            }

            if (isVacant) {
                System.out.println(berth + " , vacant");
            } else {
                System.out.println(berth + " , " + passengerDetails.toString());
            }
        }
    }

    static void printAvailability() {
        int vacantBerths = TOTAL_BERTHS - confirmedTickets.size() - racTickets.size();
        int racCount = racTickets.size();

        System.out.println(vacantBerths + " berths and " + racCount + " RAC tickets available");
        System.out.println("Berth no ,  Status");

        for (int berth = 1; berth <= TOTAL_BERTHS; berth++) {
            boolean isVacant = true;

            for (Ticket ticket : confirmedTickets) {
                for (Passenger passenger : ticket.passengers) {
                    if (passenger.berthNumber == berth) {
                        System.out.println(berth + " , " + ticket.pnr);
                        isVacant = false;
                    }
                }
            }

            if (isVacant) {
                System.out.println(berth + " , vacant");
            }
        }
    }

    static String generatePNR() {
        return "PNR" + pnrCounter++;
    }
}

