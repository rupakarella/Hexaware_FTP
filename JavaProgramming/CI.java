package ci;
public class CI
{
	public double ci(int p, int t, int r,int n)
	{
        	return p * Math.pow(1 + (r/n), n*t) - p;
	}
}
