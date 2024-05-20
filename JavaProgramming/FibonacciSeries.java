class FibonacciSeries 
{
	public static void main(String[] ar) 
	{
        	int n=9;
        	int a=0, b=1;
		System.out.println("Fibonacci Series:");
        	for (int i=0; i<=n; i++) 
		{
			System.out.print(a+ " ");
            		int c=a+b;
			a=b;
			b=c;
		}
       
   	}
}
