import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class TicketBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeats = 100; 
        int[] bookedSeats = new int[totalSeats]; 

        
        System.out.print("Enter the number of passengers: ");
        int numPassengers = scanner.nextInt();

        for (int i = 1; i <= numPassengers; i++) {
            double totalFare = 0.0;
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

            
            int availableSeats = displayAvailableSeats(totalSeats, bookedSeats);
            System.out.println("Number of Available Seats: " + availableSeats);
            if(availableSeats<=0)System.out.println("No more seats available");
            else
            {
            System.out.print("Enter the number of seats to reserve: ");
            int seatsToReserve = scanner.nextInt();

            while (seatsToReserve > availableSeats) {
                System.out.println("Invalid! Number of seats to reserve exceeds available seats.");
                seatsToReserve=0;
                break;
            }
            if(seatsToReserve>0) {
            for (int j = 1; j <= seatsToReserve; j++) {
           
                bookSeat(bookedSeats);

                
                double baseFare = 1000.0;

               
                double occupancyPercentage = (double) countBookedSeats(bookedSeats) / totalSeats * 100;
                double extraFare = 0.0;
                if (occupancyPercentage > 50 && occupancyPercentage <= 75) {
                    extraFare = baseFare * 0.18;
                } else if (occupancyPercentage > 75) {
                    extraFare = baseFare * 0.32;
                }
                double genderDiscount = (gender == 'F') ? baseFare * 0.147 : 0.0;

               
                double ageDiscount = (age > 60) ? baseFare * 0.1 : 0.0;

                
                totalFare += (baseFare + extraFare - genderDiscount - ageDiscount);
            }

            
            System.out.println("Total Fare for Passenger " + i + ": " + totalFare);
        }

        }
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

    private static void bookSeat(int[] bookedSeats) {
        for (int i = 0; i < bookedSeats.length; i++) {
            if (bookedSeats[i] == 0) {
                bookedSeats[i] = 1;
                break;
            }
        }
    }
}
