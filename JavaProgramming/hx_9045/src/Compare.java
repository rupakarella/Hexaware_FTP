import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class SalComp implements Comparator
{
	@Override
	public int compare(Object o1, Object o2)
	{
		Emp e1=(Emp) o1;
		Emp e2=(Emp) o2;
		if(e1.sal==e2.sal)
			return 0;
		if(e1.sal>e2.sal)
			return 1;
		else
			return -1;
	}
}
class NamComp implements Comparator
{
	@Override
	public int compare(Object o1, Object o2)
	{
		Emp e1=(Emp) o1;
		Emp e2=(Emp) o2;
		return e1.eName.compareTo(e2.eName);
	}
}
public class Compare 
{
	 public static void main(String[] args) 
	 {
	        ArrayList<Emp> a = new ArrayList<Emp>();
	        a.add(new Emp(1, "Gopi", 4892));
	        a.add(new Emp(2, "Ram", 9254));
	        a.add(new Emp(3, "syam", 5492));
	        a.add(new Emp(4, "ricky", 7892));
	        System.out.println("Sorted according to Name");
	        Collections.sort(a,new NamComp());
	        for(Emp e:a)
	        	System.out.println(e.sal+" "+e.eName);
	        System.out.println("Sorted according to Salary");
	        Collections.sort(a,new SalComp());
	        for(Emp e:a)
	        	System.out.println(e.sal+" "+e.eName);
	        
	  }
}
