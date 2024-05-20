import java.util.ArrayList;
import java.util.Collections;

class Emp implements Comparable<Emp> 
{
    int empId;
    String eName;
    int sal;

    public Emp(int empId, String eName, int sal) {
        this.empId = empId;
        this.eName = eName;
        this.sal = sal;
    }
    @Override
    public int compareTo(Emp otherEmp) 
    {
        // Compare based on the salary
        return this.eName.compareTo( otherEmp.eName);
    }
}  
public class SortObjects 
{
	 public static void main(String[] args) 
	 {
	        ArrayList<Emp> a = new ArrayList<Emp>();
	        a.add(new Emp(1, "Gopi", 4892));
	        a.add(new Emp(2, "Ram", 9254));
	        a.add(new Emp(3, "syam", 5492));
	        a.add(new Emp(4, "ricky", 7892));
	        Collections.sort(a);
	        for(Emp e:a)
	        	System.out.println(e.sal+" "+e.eName);
	  }
}
