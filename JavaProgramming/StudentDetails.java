import java.util.Scanner;
class StudentDetails 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();

        System.out.print("Enter Marks for Subject 1: ");
        int m1 = scanner.nextInt();

        System.out.print("Enter Marks for Subject 2: ");
        int m2 = scanner.nextInt();

        System.out.print("Enter Marks for Subject 3: ");
        int m3 = scanner.nextInt();
	System.out.println("\nStudent Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentID);
        System.out.println("Marks - Subject 1: " + m1);
        System.out.println("Marks - Subject 2: " + m2);
        System.out.println("Marks - Subject 3: " + m3);

        int total = m1 + m2 + m3;
        double average = total / 3;
        if (average >= 60) {
            System.out.println("Class: 1st Class");
        } else if (average >= 50 && average < 60) {
            System.out.println("Class: 2nd Class");
        } else if (average >= 35 && average < 50) {
            System.out.println("Class: 3rd Class");
        }
    }
}
