import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class SetDemo 
{
	public static void main(String[] args) 
	{
		Set<String> s=new HashSet<String>();
		s.add("Rupa");
		s.add("Vinay");
		s.add("Mohan");
		s.add("Sai");
		s.add("Lakshmi");
		s.add("Haasini");
		s.add("Haasini");
		s.add(null);
		s.add(null);
		System.out.println("The HashSet is");
		for(String i:s)
		{
			System.out.println(i);
		}
		//System.out.println(s);
		/*
		Iterator<String> i= s.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		*/
		
		System.out.println("-----");
		TreeSet<String> r=new TreeSet<String>();
		r.add("Rupa");
		r.add("Vinay");
		r.add("Mohan");
		r.add("Sai");
		r.add("Lakshmi");
		r.add("Haasini");
		r.add("Haasini");
		//r.add(null);
		//r.add(null);
		System.out.println("The TreeSet is");
		Iterator<String> i= r.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		System.out.println("The HeadSet Of Lakshmi is"+r.headSet("Lakshmi"));
		System.out.println("The TailSet Of Lakshmi is"+r.tailSet("Lakshmi"));
		//System.out.println("The SubSet Of Lakshmi and Haasini is"+r.subSet("Lakshmi","Haasini"));
		
		System.out.println("-----");
		Set<String> m=new LinkedHashSet<String>();
		m.add("Rupa");
		m.add("Vinay");
		m.add("Mohan");
		m.add("Sai");
		m.add("Lakshmi");
		m.add("Haasini");
		m.add("Haasini");
		m.add(null);
		m.add(null);
		System.out.println("The LinkedHashSet is");
		Iterator<String> j= m.iterator();
		while(j.hasNext())
		{
			System.out.println(j.next());
		}
	}
}
