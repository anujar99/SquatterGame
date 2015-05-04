/*Project Part A, Artificial Inteligence COMP30024
 * Anuja Ratwatte 637298
 * Scotch Macdonald 643785
 */

public class Player {
	
	/**
	 * The colour of the player.
	 */
	private String colour;
	/**
	 * The total score of the player.
	 */
	private int score;
	
	/**
	 * @param colour Sets the colour of the player.
	 * @param score Sets the score of the player to zero.
	 */
	public Player(String colour, int score) {
		super();
		this.colour = colour;
		this.setScore(score);
	}
	/**
	 * @return The colour of the player.
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @return Gets the score of the player.
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score Sets the score of the player.
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
