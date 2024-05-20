import E.Employee;
public class Employee_Details {
	public static void main(String []ar)
	{
 
        	int eid = Integer.parseInt(ar[0]);
        	String ename = ar[1];
		int basic = Integer.parseInt(ar[2]);
 		Employee e = new Employee(eid, ename, basic);
       

        	// Display results
        	System.out.println("\nEmployee Details:");
        	System.out.println("Employee ID: " + e.getEid());
        	System.out.println("Employee Name: " + e.getEname());
        	System.out.println("Basic Salary: " + e.basic());
        	System.out.println("HRA: " + e.hra());
		System.out.println("TA: " + e.ta());
        	System.out.println("DA: " + e.da());
		System.out.println("Gross: " + e.gross());
        	System.out.println("Grade: " + e.Grade());
	}
}
