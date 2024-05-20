import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class DRS_Demo 
{
	public static void main(String[] args) 
	{
		Date d = new Date();
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter StudentId");
		int sId = s.nextInt();
		System.out.println("Enter Student Name");
		String sName = s.next();
		System.out.println("Hello "+sName+" Your ID is "+sId+" DOJ "+d+" Ticket No."+r.nextInt(10000));
	}
}
