import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class A 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/hexaware","root","Rupa212*");
		PreparedStatement ps=con.prepareStatement("create table book(bookName varchar(25), price int);");
		ps.executeUpdate();
		System.out.println("Table created successfully!");
		
		/*
		PreparedStatement ps=con.prepareStatement("insert into book values(?,?)");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter BookName");
		String bookName=sc.next();
		System.out.println("Enter BookPrice");
		int price=sc.nextInt();
		ps.setString(1, bookName);
		ps.setInt(2, price);
		*/
		
		/*
		PreparedStatement ps=con.prepareStatement("update book set price=? where bookName=?");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter BookName");
		String bookName=sc.next();
		System.out.println("Enter BookPrice");
		int price=sc.nextInt();
		ps.setString(2, bookName);
		ps.setInt(1, price);
		int c= ps.executeUpdate();	
		System.out.println(c+" record updated");
		*/
		
		/*
		PreparedStatement ps=con.prepareStatement("delete from book where bookName=?");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter BookName");
		String bookName=sc.next();
		ps.setString(1, bookName);
		int c= ps.executeUpdate();
		System.out.println(c+" record deleted");
		sc.close();
		con.close();	
		*/	
	}
}
