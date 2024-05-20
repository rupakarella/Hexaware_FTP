class Super
{
	void m1()
	{
		System.out.println("In Super");
	}
}

public class RTP extends Super
{
	@Override
	void m1() 
	{	
		System.out.println("In RTP");
	}
	public static void main(String []args)
	{
		RTP a= new RTP();
		a.m1();
	}
}
