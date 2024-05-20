import ci.CI;

public class Compound_Interest {
	public static void main(String []ar)
	{
		CI a = new CI();
		int p=Integer.parseInt(ar[0]);
		int t=Integer.parseInt(ar[1]);
		int r=Integer.parseInt(ar[2]);
		int n=Integer.parseInt(ar[3]);
		System.out.println("Compound Interest is "+a.ci(p,t,r,n));
	}
}
