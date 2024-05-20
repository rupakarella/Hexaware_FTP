import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.test.Calc;
public class TestLogic 
{
	@Test
	public void myTest()
	{
		assertEquals(9,Calc.add(4,5));
	}	
}
