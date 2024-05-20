import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class MapDemo 
{
	public static void main(String[] args) 
	{
		Map<Integer,String> h= new HashMap<Integer,String>();
		System.out.println("The HashMap is");
		h.put(1, "Rupa");
		h.put(3, "Sri");
		h.put(4, "Haasini");
		h.put(2, "Leela");
		h.put(null, "Rupa");
		h.put(5, "Lakshmi");
		
		for(Map.Entry<Integer,String> m:h.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
		/*h.putIfAbsent(6,"Sai");
		for(Map.Entry<Integer,String> m:h.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
		*/
		
		System.out.println("The TreeMap is");
		Map<Integer,String> t= new TreeMap<Integer,String>();
		t.put(1, "Rupa");
		t.put(2, "Leela");
		t.put(3, "Sri");
		t.put(5, "Lakshmi");
		t.put(4, "Haasini");
		//t.put(null, "Rupa");
		
		for(Map.Entry<Integer,String> m:t.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
		
		Map<Integer,String> l= new LinkedHashMap<Integer,String>();
		System.out.println("The LinkedHashMap is");
		l.put(1, "Rupa");
		l.put(3, "Sri");
		l.put(4, "Haasini");
		l.put(2, "Leela");
		l.put(null, "Rupa");
		l.put(5, "Lakshmi");
		
		for(Map.Entry<Integer,String> m:l.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
	}
}
