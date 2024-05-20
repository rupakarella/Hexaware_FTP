import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
public class EnumDemo 
{
	public static void main(String[] args) 
	{
		Hashtable<Integer,String> h = new Hashtable<Integer,String>();
		System.out.println("The HashTable is");
		h.put(1, "Rupa");
		h.put(3, "Sri");
		h.put(4, "Haasini");
		h.put(2, "Leela");
		h.put(5, "Lakshmi");
		
		/*Enumeration e = h.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}*/
		for(Map.Entry<Integer,String> m:h.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
		
		Vector<String> v= new Vector<String>();
		v.add("Banana");
		v.add("Apple");
		v.add("Mango");
		v.add("Orange");
		v.add("Lemon");
		v.add("Guava");
		System.out.println("The Vector is");
		Enumeration<String> c=v.elements();
		while(c.hasMoreElements()) 
		{
			System.out.println(c.nextElement());
		}
		
	}
}
