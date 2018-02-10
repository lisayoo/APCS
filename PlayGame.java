
/**
 * Runs the game
 * @author Lisa Yoo, Emily Sine, Sarah Robertson, Josh Slusar
 *
 */
public class PlayGame 
{
	public static void main(String[] args) 
	{
		UserInteraction u = new UserInteraction();
		System.out.println(u.toString());
		
		ProblemGenerator p = new ProblemGenerator();
		System.out.println(p.toString());
		p.levelOne();
		
		ScoreKeeper s = new ScoreKeeper(u, p);
		System.out.println(s.toString());
		System.out.println(u.toString());
	}
}
