import si.SI;
public class Simple_Interest {
	public static void main(String []ar)
	{
		SI a = new SI();
		int p=Integer.parseInt(ar[0]);
		int t=Integer.parseInt(ar[1]);
		int r=Integer.parseInt(ar[2]);
		System.out.println("Simple Interest is "+a.si(p,t,r));
	}
}
