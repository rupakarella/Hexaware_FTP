import java.util.Scanner;
class ArithmeticOp
{
	public static void main(String []ar)
	{
		Scanner scanner = new Scanner(System.in);
		int num1=Integer.parseInt(ar[0]);
		int num2=Integer.parseInt(ar[1]);
		
        	System.out.println("Choose an operation:");
       		System.out.println("1. Addition");
        	System.out.println("2. Subtraction");
        	System.out.println("3. Multiplication");
        	System.out.println("4. Division");
		
		System.out.print("Enter your choice (1-4): ");
        	int choice = scanner.nextInt();

		switch(choice)
		{
			case 1:
                		System.out.println("Sum: " + (num1 + num2));
                		break;
           		case 2:
                		System.out.println("Difference: " + (num1 - num2));
                		break;
            		case 3:
                		System.out.println("Product: " + (num1 * num2));
                		break;
            		case 4:
                		if (num2 != 0) 
				{
                    			System.out.println("Quotient: " + (num1 / num2));
                		} 
				else 
				{
                    			System.out.println("Cannot divide by zero.");
               		 	}
                		break;
            		default:
                		System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        	}
	}
}		