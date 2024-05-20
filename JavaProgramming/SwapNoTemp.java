import java.util.Scanner;
class SwapNoTemp
{
	public static void main(String []ar)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter a: ");
        	int a=scanner.nextInt();
		System.out.print("Enter b: ");
        	int b=scanner.nextInt();
		System.out.println("Before Swap");
		System.out.println("a:"+a+" b:"+b);
		a=a+b; 
		b=a-b; 
		a=a-b;
		System.out.println("After Swap");
		System.out.println("a:"+a+" b:"+b);
	}
}