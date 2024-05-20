
public class Calc_Overloading 
{
	    public int add(int a, int b) 
	    {
	    	
	        return a + b;
	    }
	    public double add(double a, double b, double c)
	    {
	        return a + b + c;
	    }
	    public static void main(String []args) 
	    {
	    	Calc_Overloading a =new Calc_Overloading();
	    	System.out.println(a.add(1, 2));
	    	System.out.println(a.add(1.5, 2.7,3.2)); 	
	    }

}
