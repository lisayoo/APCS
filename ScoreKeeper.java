/**
 * Keeps track of the score, levels, and number of guesses in a game
 * @author Lisa Yoo, Emily Sine, Sarah Robertson, Josh Slusar
 * @version 12.14.16
 */
public class ScoreKeeper 
{
	private int score;
	private int level;
	private int numTrials;
	private ProblemGenerator probGen;
	private UserInteraction user;
	
	/**
	 * Creates a score keeper with a given user and problem generator
	 * @param user The user
	 * @param probGen The problem generator
	 */
	public ScoreKeeper(UserInteraction user, ProblemGenerator probGen)
	{
		score = 0;
		level = 1;
		numTrials = 2;
		this.probGen = probGen;
		this.user = user;
	}
	
	/**
	 * Returns the user's current score
	 * @return The user's current score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Returns the user's current level
	 * @return The user's current level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * Returns the user's current number of trials.
	 * @return The user's current number of trials
	 */
	public int getTrials()
	{
	    return numTrials;
	}
	
	/**
	 * Checks the answer of the user and returns a boolean
	 * @return isCorrect A boolean of whether the user's answer is correct
	 */
	public boolean checkAnswer()
	{
		if (probGen.getAnswer() == user.getAnswer())
		{
			score++;
			if (score == 5) 
			{
				changeLevel(level + 1);
			}
			numTrials = 2;
			return true;
		}
		else
		{
			numTrials --;
			return false;
		}
	}
	
	/**
	 * Changes what level the user is on
	 * @param newLevel The new level to move up to
	 */
	public void changeLevel(int newLevel)
	{
		level = newLevel;
		resetScore();
	}
	
	/**
	 * Resets the number of remaining trials to 2
	 */
	public void resetTrials()
	{
		numTrials = 2;
	}
	
	/**
	 * Resets the score to 0
	 */
	public void resetScore() 
	{
		score = 0;
	}

	/**
	 * Resets the game to start from level 1 with score 0
	 */
	public void resetGame()
	{
		score = 0;
		level = 1;
		numTrials = 2;
	}
	
	public String toString()
	{
		return "Current score is " + score + " on level " + level 
				+ " with " + numTrials + " trials remaining.";
	}
}