import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains methods that take user input and run the game
 * @author Lisa Yoo, Emily Sine, Sarah Robertson, Josh Slusar
 * @version 12.16.16
 */
public class UserInteraction
{
    private static int answer;
    private ProblemGenerator problem;
    private ScoreKeeper score;
    private Scanner in;
    
    /**
     * Creates a user who can input an answer, given problem generator and score keeper
     */
    public UserInteraction()
    {
        in = new Scanner(System.in);
        answer = 0;
        problem = new ProblemGenerator();
        score = new ScoreKeeper(this, problem);
    }
    
    /**
     * Directions to follow to play the game
     */
    public void runGame()
    {
    	boolean wrongAnswer = false;
    	boolean isPlaying = true;
    	String saveProblem = "";
    	boolean badInput = false;
    	
    	while(score.getLevel() <= 3 && isPlaying == true)
    	{
    		if (!wrongAnswer) 
    		{
    			if (score.getLevel() == 1) 
    			{
    				saveProblem = problem.levelOne();
    			} 
    			else if (score.getLevel() == 2) 
    			{
    				saveProblem = problem.levelTwo();
    			}
    			else 
    			{
    				saveProblem = problem.levelThree();
    			}  
    		}
    		System.out.println(saveProblem);
    		
    		try 
    		{
    			answer = in.nextInt();
    			badInput = false;
    		} 
    		catch (InputMismatchException e) 
    		{
    			System.out.println("Please type a valid integer input!");
    			in.next();
    			wrongAnswer = true;
    			badInput = true;
    		}
    		
    		if (!badInput) 
    		{
    			boolean result = score.checkAnswer();
    			if (!result) 
    			{
    				wrongAnswer = true;
    				if (score.getTrials() != 0)
    				{
    					System.out.println("Try again. You have one attempt left.");
    				}
    				else 
    				{
    					score.resetTrials();
    					System.out.println("Sorry you're out of tries for that problem!" +
    											" Here is a new one!");
    					if (score.getLevel() == 1) 
    					{
    						saveProblem = problem.levelOne();
    					} 
    					else if (score.getLevel() == 2) 
    					{
    						saveProblem = problem.levelTwo();
    					}
    					else 
    					{
    						saveProblem = problem.levelThree();
    					}  
    				}
    			}	
    			else if (result) 
    			{
    				wrongAnswer = false;
    				if (score.getScore() % 5 != 0) 
    				{
    					System.out.println("Good job! You got it right.");
    					System.out.println("Your current score is "+ score.getScore() 
    							+" on level "+score.getLevel()+"!");
    				} 
    				else 
    				{
    					if(score.getLevel() > 3)
    					{
    						System.out.println("Congrats, you've won!");
    						System.out.println("Would you like to play again? Enter n for no, "
    								+ "or anything else for yes.");
        					String keepPlaying = in.next();
        					if(keepPlaying.equals("n"))
        					{
        						isPlaying = false;
        					}
        					score.resetGame();
    					}
    					else
    					{
    						System.out.println("Congrats, you've advanced to the next level!");
    					}
    				}
    			}
    		}
    	}
    }
    
    /**
     * Returns the user's answer
     * @return answer
     */
    public int getAnswer()
    {
        return answer;
    }
    
    public String toString()
    {
    	return "The level is " + score.getLevel() + " with a score of " + score.getScore();
    }
}
