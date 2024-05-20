import java.util.Scanner;
class SwapTemp
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
		int c=a;
		a=b;
		b=c;
		System.out.println("After Swap");
		System.out.println("a:"+a+" b:"+b);
	}
}