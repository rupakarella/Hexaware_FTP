package E;

public class Employee {
	int eid;
	String ename;
int basic;

	public Employee(int eid, String ename, int basic) 
{
    	this.eid = eid;
    	this.ename = ename;
	this.basic = basic;
	}

	public int getEid() 
{
    	return eid;
	}
	public String getEname() 
{
    	return ename;
	}
public int basic()
{
    	return basic;
	}
public double hra()
{
    	return basic()*0.12;
	}
public double ta()
{
    	return basic()*0.05;
	}
public double da()
{
    	return basic()*0.08;
	}
public double gross()
{
    	return basic()+hra()+ta()+da();
	}
public String Grade()
{
	if (gross() >= 25000) 
	{
        		return "A";
    	} 
	else
	{
       		return "B";
    	} 
	
}
}
