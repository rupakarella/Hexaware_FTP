
public class Exceptions 
{
	public static void main(String []args)
	{
		try
		{
			
			 //int i=39,j=0,k; k=i/j; 
			 //System.out.println(k);
			 //String s = "abc"; 
			 //int l =Integer.parseInt(s); 
			 //System.out.println(l);
			 //String m = null; 
			 //System.out.println(m.length());
			 //int ar[]= {5,1,7,3,2};
			 //System.out.println(ar[5]);
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println("catch1");
		}
		catch(NullPointerException n)
		{
			n.printStackTrace();
			System.out.println("catch2");
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			a.printStackTrace();
			System.out.println("catch3");
		}
		catch(NumberFormatException f)
		{
			f.printStackTrace();
			System.out.println("catch4");
		}
		catch(Exception g)
		{
			g.printStackTrace();
			System.out.println("catch5");
		}
		finally
		{
			System.out.println("finally...");
		}
	}
}
