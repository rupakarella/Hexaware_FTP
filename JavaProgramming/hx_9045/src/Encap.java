import Emp.EmpEncap;
public class Encap {
	public static void main(String []args)
	{
		EmpEncap e= new EmpEncap();
		e.setEid(9045);
		e.seteName("Rupa");
		//e.setSal(49000);
		
		System.out.println(e.getEid());
		System.out.println(e.geteName());
		//System.out.println(e.getSal());
				
	}

}
