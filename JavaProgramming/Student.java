package S;

public class Student 
{
	int sid;
    	String sname;
	int m1;
   	int m2;
    	int m3;


    	public Student(int sid, String sname, int m1, int m2, int m3) 
	{
        	this.sid = sid;
        	this.sname = sname;
		this.m1 = m1;
        	this.m2 = m2;
        	this.m3 = m3;
    	}

    	public int getSid() 
	{
        	return sid;
    	}

    	public String getSname() 
	{
        	return sname;
    	}
	public int total()
	{
        	return m1+m2+m3;
    	}
	public double average()
	{
		return total()/3.0;
	}
	public String Grade()
	{
		double average=average();
		if (average >= 60) 
		{
            		return "1st Class";
        	} 
		else if (average >= 50 && average < 60) 
		{
           		return "2nd Class";
        	} 
		else if (average >= 35 && average < 50) 
		{
            		return"3rd Class";
        	}
		else
		{
			return "Fail";
		}
	}

}


    