public class Addition
{
	int add(int a, int b)
	{
		return a+b;
	}
	public static void main(String args[])
	{
		int a=4, b=5;
		int result;
		Addition c= new Addition();
		result=c.add(a,b);
		System.out.println(result);
		System.out.println("Hello World");
	}
}