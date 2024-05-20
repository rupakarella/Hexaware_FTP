import java.util.Scanner;
class EvenOdd
{
	public static void main(String []ar)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Number ");
        	int number= scanner.nextInt();
		if(number%2==0)
		{
			System.out.println(number+" is even");
		}
		else
		{
			System.out.println(number+" is odd");
		}
	}
}