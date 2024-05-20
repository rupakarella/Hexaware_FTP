class AreaOfCircle
{
	void m3()
	{
		int r=7;
		double z;
		z=3.14*r*r;
		System.out.println("Area Of Circle is "+z);
	}
}
public class SimpleeInterest extends AreaOfCircle implements PerimeterOfCircle, AreaOfRectangle
{
	public void m2()
	{
		int R;
		double p;
		R=7;
		p= 2*3.14*R;
		System.out.println("Perimeter Of Circle is "+p);
	}
	public void m4()
	{
		int A,l,b;
		l=5;b=4;
		A=l*b;
		System.out.println("Area of Rectangle is "+A);
	}
	void m1()
	{
		int P,T,rate;
		P=12000;T=4;rate=5;
		double I;
		I=P*T*rate*0.01;
		System.out.println("Simple Interest "+I);
	}
	public static void main(String []ar)
	{
		SimpleeInterest a= new SimpleeInterest();
		a.m1();
		a.m2();
		a.m3();
		a.m4();
	}
}