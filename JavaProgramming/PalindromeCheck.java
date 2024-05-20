import java.util.Scanner;

class PalindromeCheck 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        	System.out.print("Enter a string: ");
        	String str = scanner.nextLine();

        	int i = 0;
        	int j = str.length() - 1;

        
        	while (i < j) 
		{
            		if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) 
			{
                		System.out.println("NOT PALINDROME");
                		return; 
            		}
            		else 
			{
                		i++;
                		j--;
            		}
        	}
       		System.out.println("PALINDROME");
	}
}
