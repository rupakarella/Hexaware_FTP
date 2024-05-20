import java.util.Stack;
public class StackDemo 
{
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		System.out.println("Stack" +s);
		pushEle(s, 43);
		pushEle(s,24);
		pushEle(s, 693);
		pushEle(s,254);
		pushEle(s, 743);
		pushEle(s,242);
		pushEle(s, 1043);
		pushEle(s,2124);
		try
		{
			popEle(s);
			popEle(s);
		}
		catch(Exception e)
		{
			System.out.println("Empty Stack");
		}
	}
	
	static void pushEle(Stack stk, int p)
	{
		stk.push(new Integer(p));
		System.out.println("Push=>"+p);
		System.out.println("Stack"+stk);
	}
	static void popEle(Stack stk)
	{
		System.out.println("Pop=>");
		Integer p=(Integer) stk.pop();
		System.out.println(p);
		System.out.println("Stack"+stk);
	}
}
