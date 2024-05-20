package main;
import java.sql.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import exception.AdoptionException;
import exception.InsufficientFundsException;
import exception.InvalidPetAgeException;
import exception.NullReferenceException;

public class DatabaseConnectivity 
{
	static 
	{
        try 
        {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) 
        {
            System.err.println("Error loading JDBC driver: " + e.getMessage());
        }
	}
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            try {
	                displayMenu();
	                choice = scanner.nextInt();
	                scanner.nextLine(); 

	                switch (choice) {
	                    case 1:
	                        displayPetListings();
	                        break;
	                    case 2:
	                        recordCashDonation();
	                        break;
	                    case 3:
	                        manageAdoptionEvents();
	                        break;
	                    case 4:
	                        addPetToDatabase();
	                        break;
	                    case 5:
	                        adoptPet();
	                        break;
	                    case 6:
	                        System.out.println("Enter the file name to read pets from:");
	                        String fileName = scanner.nextLine();
	                        readPetsFromFile(fileName);
	                        break;
	                    case 7:
	                        System.out.println("Exiting");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please choose a valid task.");
	                }
	            
	                
	            } catch (Exception e) {
	                System.err.println("Error: " + e.getMessage());
	                choice = 0; 
	            }
	        } while (choice != 7);
	    } 
	

	private static void displayMenu() {
	    System.out.println("Choose a task:");
	    System.out.println("1. Display Pet Listings");
	    System.out.println("2. Record Cash Donation");
	    System.out.println("3. Manage Adoption Events");
	    System.out.println("4. Add Pet to database");
	    System.out.println("5. Adopt Pet");
	    System.out.println("6. Read Pets from File");
	    System.out.println("7. Exit");
	}

    
    private static void displayPetListings() throws SQLException 
    {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetPals","root","Rupa212*")) 
        {
            String query = "SELECT * FROM pet";
            try (PreparedStatement stmt = conn.prepareStatement(query);ResultSet rs = stmt.executeQuery()) 
            {
                System.out.println("Available Pets:");
                while (rs.next()) 
                {
                    System.out.println(rs.getString("name") + " - " + rs.getInt("age") + " years old, " + rs.getString("breed"));
                }
            }
        }
    }
    private static void recordCashDonation() throws SQLException, InsufficientFundsException 
    {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetPals","root","Rupa212*")) 
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter donor name:");
            String donorName = scanner.nextLine();
            System.out.println("Enter donation amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount < 10) 
            {
                throw new InsufficientFundsException(amount);
            }    
            String query = "INSERT INTO donation (donor_name, amount) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) 
            {
                stmt.setString(1, donorName);
                stmt.setDouble(2, amount);
                stmt.executeUpdate();                             
                System.out.println("Cash donation recorded successfully");
            }            
        }
    }
    private static void manageAdoptionEvents() throws SQLException  
    {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetPals","root","Rupa212*")) 
        {
            // Retrieving upcoming adoption events
            String eventsQuery = "SELECT * FROM AdoptionEvent";
            try (PreparedStatement eventsStmt = conn.prepareStatement(eventsQuery);
                 ResultSet eventsRs = eventsStmt.executeQuery()) 
            {
                System.out.println("Upcoming Adoption Events:");
                while (eventsRs.next()) 
                {
                    System.out.println("Event ID: " + eventsRs.getInt("event_id"));
                    System.out.println("Event Date: " + eventsRs.getDate("event_date"));
                    System.out.println("Event Location: " + eventsRs.getString("event_location"));
                }
                // Registering for an event
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter event ID to register:");
                int eventId = scanner.nextInt();
                String registerQuery = "INSERT INTO EventParticipants (event_id, participant_name) VALUES (?, ?)";
                try (PreparedStatement registerStmt = conn.prepareStatement(registerQuery)) 
                {
                    registerStmt.setInt(1, eventId);
                    scanner.nextLine();                    
                    System.out.println("Enter your name:");                    
                    String participantName = scanner.nextLine();
                    registerStmt.setString(2, participantName);
                    registerStmt.executeUpdate();
                    System.out.println("Registration for the event successful");
                    
                }               
            }
        }
    }
    private static void addPetToDatabase() throws SQLException, InvalidPetAgeException, NullReferenceException 
    {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetPals", "root", "Rupa212*")) 
        {
        	Scanner scanner = new Scanner(System.in);
            System.out.println("Enter pet name:");
            String petName = scanner.nextLine();
            if (petName == null || petName.trim().isEmpty()) 
            {
                throw new NullReferenceException(petName);
            }                       
            System.out.println("Enter pet age:");           
            int petAge = scanner.nextInt();
            scanner.nextLine();
            if (petAge <= 0) 
            {
                throw new InvalidPetAgeException(petAge);
            }                 
            System.out.println("Enter pet breed:");
            String petBreed = scanner.next();
            String query = "INSERT INTO pet (name, age, breed) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) 
            {
                stmt.setString(1, petName);
                stmt.setInt(2, petAge);
                stmt.setString(3, petBreed);
                stmt.executeUpdate();
                System.out.println("Pet added to the database successfully");
            }
        }
    }
    private static void adoptPet() throws SQLException, AdoptionException
    {
    	 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetPals", "root", "Rupa212*")) 
         {
    		 
             String query = "SELECT COUNT(*) FROM pet WHERE name = ?";
             String adoptPetQuery = "INSERT INTO adoptions (pet_name, adopter_name, adoption_date) VALUES (?, ?, NOW())";
             Scanner scanner = new Scanner(System.in);
             System.out.println("Enter pet name:");
             String petName = scanner.nextLine();
             try (PreparedStatement stmt = conn.prepareStatement(query)) 
             {
                 stmt.setString(1, petName);
                 try (ResultSet resultSet = stmt.executeQuery()) 
                 {
                     resultSet.next();
                     int count = resultSet.getInt(1);
                     if (count > 0) 
                     {
                         System.out.println(petName + " is available for adoption.");
                         System.out.println("Enter your name:");
                         String adopterName = scanner.nextLine();

                         try (PreparedStatement adoptPetStmt = conn.prepareStatement(adoptPetQuery)) {
                             adoptPetStmt.setString(1, petName);
                             adoptPetStmt.setString(2, adopterName);
                             adoptPetStmt.executeUpdate();
                             System.out.println("Congratulations! You have successfully adopted " + petName + ".");
                         }
                     } 
                     else 
                     {
                         throw new AdoptionException(petName);
                     }
                 }
             }
         }
    }
    private static void readPetsFromFile(String fileName) {
        boolean validFile = false;

        do {
            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);

                System.out.println("Pets from File:");
                while (fileScanner.hasNextLine()) {
                    String petInfo = fileScanner.nextLine();
                    System.out.println(petInfo);
                }

                fileScanner.close();
                validFile = true;
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + e.getMessage());
                System.out.println("Enter the file name again (or type 'cancel' to go back to the main menu):");
                Scanner scanner = new Scanner(System.in);
                fileName = scanner.nextLine();

                if (fileName.equalsIgnoreCase("cancel")) {
                    return; 
                }
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                validFile = true; // Exit the loop in case of unexpected error
            }
        } while (!validFile);
    }

}
