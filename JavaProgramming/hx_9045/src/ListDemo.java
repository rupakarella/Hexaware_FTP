import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
public class ListDemo 
{
	public static void main(String[] args) 
	{
		List<String> a= new ArrayList<String>();
		System.out.println("The ArrayList is");
		a.add("Rupa");
		a.add("Gayatri");
		a.add("Raji");
		a.add("Mohana");
		a.add("Mahesh");
		a.add("Lakshmi");
		a.add("Preeti");
		
		Iterator<String> i= a.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		// retrieval
		System.out.println("The element at index 2 is"+a.get(2));
		
		List<String> l= new LinkedList<String>();
		System.out.println("The LinkedList is");
		l.add("Rupa");
		l.add("Gayatri");
		l.add("Raji");
		l.add("Mohana");
		l.add("Mahesh");
		l.add("Lakshmi");
		l.add("Preeti");
		
		Iterator<String> j= l.iterator();
		while(j.hasNext())
		{
			System.out.println(j.next());
		}
		//insertion and removal
		System.out.println("The List after inserting an element at 1 and removing an element 4");
		l.add(1,"Kumari");
		l.remove(4);
		Iterator<String> k= l.iterator();
		while(k.hasNext())
		{
			System.out.println(k.next());
		}
	}
}
