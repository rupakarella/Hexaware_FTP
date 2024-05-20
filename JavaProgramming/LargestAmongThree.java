class LargestAmongThree
{
	public static void main(String []ar)
	{
		int a=43, b=70, c=79;
		if(a>=b && a>=c)
		{
			System.out.println(a+" is largest");
		}
		else if(a>=b && b>=c)
		{
			System.out.println(b+" is largest");
		}
		else
		{
			System.out.println(c+" is largest");
		}
	}
}