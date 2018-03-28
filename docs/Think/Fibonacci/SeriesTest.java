import junit.framework.TestCase;

public class SeriesTest extends TestCase
{
	public void testFibonacci()
	{
		assertEquals(1, Fibonacci.fibonacci(1));
		assertEquals(1, Fibonacci.fibonacci(2));
		assertEquals(2, Fibonacci.fibonacci(3));
	}
}
