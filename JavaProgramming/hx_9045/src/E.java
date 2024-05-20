public class E 
{
	public void show(int age) throws MyExcep
	{
		if(age>60) throw new MyExcep(age);
		else
			System.out.println("Congo, Your age is "+age+"you can apply");
	}
	public static void main(String[] args) 
	{
		int p=65;
		E e = new E();
		try
		{
			e.show(p);
		}
		catch(MyExcep m)
		{
			m.printStackTrace();
		}
	}
}
