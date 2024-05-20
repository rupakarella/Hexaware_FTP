import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class TicketsBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeats = 100;
        int[] bookedSeats = new int[totalSeats];

        System.out.print("Enter the number of passengers: ");
        int numPassengers = scanner.nextInt();

        for (int i = 1; i <= numPassengers; i++) {
            System.out.println("\nPassenger " + i + " Details:");
            System.out.print("Enter Passenger ID: ");
            int passengerId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();
            int age = calculateAge(dobString);
            System.out.print("Enter Passenger Gender (M/F): ");
            char gender = scanner.next().charAt(0);

            System.out.print("Enter the type of booking (direct/vendor): ");
            String bookingType = scanner.next();

            int availableSeats = displayAvailableSeats(totalSeats, bookedSeats);
            System.out.println("Number of Available Seats: " + availableSeats);

            int seatsToReserve = 0;

            if ("direct".equalsIgnoreCase(bookingType)) {
                System.out.print("Enter the number of seats to reserve: ");
                seatsToReserve = scanner.nextInt();
            } else if ("vendor".equalsIgnoreCase(bookingType)) {
                System.out.print("Enter the vendor type (v1/v2/v3): ");
                String vendorType = scanner.next();
                seatsToReserve = reserveSeatsByVendorType(availableSeats, vendorType);
            }

            while (seatsToReserve > availableSeats) {
                System.out.println("Invalid! Number of seats to reserve exceeds available seats.");
                seatsToReserve = 0;
                break;
            }

            double totalFare = calculateTotalFare(seatsToReserve, gender, age, bookingType, availableSeats, bookedSeats);

            System.out.println("Total Fare for Passenger " + i + ": " + totalFare);
        }

        scanner.close();
    }

    private static int calculateAge(String dobString) {
        LocalDate dob = LocalDate.parse(dobString);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    private static int displayAvailableSeats(int totalSeats, int[] bookedSeats) {
        return totalSeats - countBookedSeats(bookedSeats);
    }

    private static int countBookedSeats(int[] bookedSeats) {
        int count = 0;
        for (int seat : bookedSeats) {
            if (seat == 1) {
                count++;
            }
        }
        return count;
    }

    private static int reserveSeatsByVendorType(int availableSeats, String vendorType) {
        int seatsToReserve = 0;
        if ("v1".equalsIgnoreCase(vendorType)) {
            seatsToReserve = (int) (availableSeats * 0.1);
        } else if ("v2".equalsIgnoreCase(vendorType)) {
            seatsToReserve = (int) (availableSeats * 0.05);
        } else if ("v3".equalsIgnoreCase(vendorType)) {
            seatsToReserve = (int) (availableSeats * 0.03);
        }
        return seatsToReserve;
    }

    private static double calculateTotalFare(int seatsToReserve, char gender, int age, String bookingType, int availableSeats, int[] bookedSeats) {
        double totalFare = 0.0;

        for (int j = 1; j <= seatsToReserve; j++) {
            bookSeat(bookedSeats);

            double baseFare = 1000.0;
            double occupancyPercentage = (double) countBookedSeats(bookedSeats) / (availableSeats + seatsToReserve) * 100;
            double extraFare = calculateExtraFare(bookingType, occupancyPercentage);
            double genderDiscount = (gender == 'F') ? baseFare * 0.147 : 0.0;
            double ageDiscount = (age > 60) ? baseFare * 0.1 : 0.0;

            totalFare += (baseFare + extraFare - genderDiscount - ageDiscount);
        }

        return totalFare;
    }

    private static void bookSeat(int[] bookedSeats) {
        for (int i = 0; i < bookedSeats.length; i++) {
            if (bookedSeats[i] == 0) {
                bookedSeats[i] = 1;
                break;
            }
        }
    }

    private static double calculateExtraFare(String bookingType, double occupancyPercentage) {
        if ("direct".equalsIgnoreCase(bookingType)) {
            if (occupancyPercentage > 50 && occupancyPercentage <= 75) {
                return 1000.0 * 0.18; // Additional 18% for 50%-75% occupancy
            } else if (occupancyPercentage > 75) {
                return 1000.0 * 0.32; // Additional 32% for more than 75% occupancy
            }
        } else if ("vendor".equalsIgnoreCase(bookingType)) {
            if ("v1".equalsIgnoreCase(bookingType)) {
                return 1000.0 * 0.07; // Additional 7% for v1
            } else if ("v2".equalsIgnoreCase(bookingType)) {
                return 1000.0 * 0.05; // Additional 5% for v2
            } else if ("v3".equalsIgnoreCase(bookingType)) {
                return 1000.0 * 0.09; // Additional 9% for v3
            }
        }
        return 0.0;
    }
}
