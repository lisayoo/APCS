/**
 * Generates problems of various levels
 * @author Lisa Yoo, Emily Sine, Sarah Robertson, Josh Slusar
 * @version 12.10.16
 */
public class ProblemGenerator 
{
	private int a;
	private int b;
	private int answer;
	private String problem;
	
	/**
	 * Creates a problem generator with first number a and second number b
	 */
	public ProblemGenerator()
	{
		a = 0;
		b = 0;
		answer = 0;
		problem = "No problem generated yet!";
	}
	
	/**
	 * Returns the first number
	 * @return The first number
	 */
	public int getA()
	{
		return a;
	}
	
	/**
	 * Returns the second number
	 * @return The second number
	 */
	public int getB()
	{
		return b;
	}
	
	/**
	 * Generates and returns a level one problem
	 * Problems only involve addition of numbers less than 10 whose sum is less than 10
	 * @return A level one problem
	 */
	public String levelOne()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		
		while ((a + b) > 10)
		{
			a = (int) (Math.random() * 9 + 1);
			b = (int) (Math.random() * 9 + 1);
		}
		
		answer = a + b;
		problem = a + " + " + b + " = ?";
		return problem;
	}
	
	/**
	 * Generates and returns a level two problem
	 * Problems only involve addition of one-digit numbers
	 * @return A level two problem
	 */
	public String levelTwo()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		
		answer = a + b;
		problem = a + " + " + b + " = ?";
		return problem;
	}
	
	/**
	 * Generates and returns a level three problem
	 * Problems involve subtraction of one-digit numbers with a non-negative difference
	 * @return A level three problem
	 */
	public String levelThree()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		
		while ((a - b) < 0)
		{
			a = (int) (Math.random() * 9 + 1);
			b = (int) (Math.random() * 9 + 1);
		}
		
		answer = a - b;
		problem = a + " - " + b + " = ?";
		return problem;
	}
	
	/**
	* Returns the answer to the problem
	* @return The answer to the problem
	*/
	public int getAnswer() 
	{
		return answer;
	}
            
	public String toString()
	{
		return problem;
	}
}