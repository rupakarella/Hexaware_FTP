import java.util.Scanner;

class EmployeeDetails 
{
    	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        int employeeID = scanner.nextInt();

        System.out.print("Enter Basic Salary: ");
        int basicSalary = scanner.nextInt();

        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + employeeName);
        System.out.println("ID: " + employeeID);
        System.out.println("Basic Salary: " + basicSalary);

        double hra = basicSalary * 12 / 100;
        double ta = basicSalary * 5 / 100;
        double da = 8 * basicSalary / 100;
        double grossSalary = hra + ta + da + basicSalary;

        System.out.println("\nSalary Components:");
        System.out.println("HRA: " + hra);
        System.out.println("TA: " + ta);
        System.out.println("DA: " + da);
        System.out.println("Gross Salary: " + grossSalary);

        if (grossSalary >= 25000) {
            System.out.println("Grade: A");
        } else if (grossSalary >= 10000 && grossSalary < 25000) {
            System.out.println("Grade: B");
        } else if (grossSalary < 10000) {
            System.out.println("Grade: C");
        }
    }
}
