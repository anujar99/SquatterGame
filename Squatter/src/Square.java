/*Project Part A, Artificial Inteligence COMP30024
 * Anuja Ratwatte 637298
 * Scotch Macdonald 643785
 */

public class Square {
	/**
	 * Sets a variable to zero.
	 */
	public static final int INIT = 0;
	/**
	 * Sets a variable back to zero from some other value.
	 */
	public static final int RESET = 0;
	/**
	 * True if there is a winner in the game. False if no winner.
	 */
	private static Boolean result;
	/**
	 * True if a position is captured by either player.
	 */
	private Boolean captured;
	/**
	 * True if the space has not been played in.
	 */
	private Boolean spaceFree;
	/**
	 * Depicts who owns the position on the board.
	 */
	private String ownedBy;

	/**
	 * 
	 * @param captured Sets the capture state of the board square.
	 * @param ownedBy Sets the owner of the square.
	 * @param spaceFree Flags whether the position has been played in.
	 */
	public Square(Boolean captured, String ownedBy, Boolean spaceFree) {
		super();
		this.captured = captured;
		this.ownedBy = ownedBy;
		this.spaceFree = spaceFree;
		Square.setResult(true);
	}
	
	/**
	 * @return A string pertaining to the owner of the square.
	 */
	public String getOwnedBy() {
		return ownedBy;
	}
	/**
	 * @param ownedBy Sets the owner of the square.
	 */
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	/**
	 * @return Whether a square is captured or not.
	 */
	public Boolean isCaptured() {
		return captured;
	}
	/**
	 * @param captured Sets the captured variable.
	 */
	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}
	/**
	 * @return The state of whether a space if free or not.
	 */
	public Boolean getSpaceFree() {
		return spaceFree;
	}
	/**
	 * @param spaceFree Sets the state of the square space.
	 */
	public void setSpaceFree(Boolean spaceFree) {
		this.spaceFree = spaceFree;
	}
	/**
	 * @return Whether the game has a result or not.
	 */
	public static Boolean getResult() {
		return Square.result;
	}
	/**
	 * @param newResult Sets the result of the game.
	 */
	private static void setResult(boolean newResult) {
		Square.result = newResult;	
	}
	
	/**
	 * 
	 * @param board The array of squares. The current board state.
	 * @param white The white player.
	 * @param black The black player.
	 */
	public static void checkSquares(Square[][] board, Player white, Player black){
		
		int boardSize = board.length;
		
		for(int row = 0; row < boardSize; row++){
			for(int col = 0; col < boardSize; col++){
				/* Find the owner of the captured square. */
				if (board[row][col].isCaptured()){
					checkCapturer(board, white, black, row, col);
				}		
				//if a square has not been played in, there is currently no winner
				if (board[row][col].spaceFree){
					setResult(false);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param board The current board state.
	 * @param white The white player.
	 * @param black The black player.
	 * @param j The column index of the captured position.
	 * @param i The row index of the captured position.
	 */
	public static void checkCapturer( Square[][] board, Player white, Player black, int row, int col){
		
		Boolean ownerFound = false;
		
		/* Keep looking above the captured spot to find the owner. */
		for(int k = 1; k <= row; k++){
			if (board[row - k][col].ownedBy == "W"){						
				int score = white.getScore() + 1;
				white.setScore(score);
				ownerFound = true;
				
			}
			else if (board[row - k][col].ownedBy == "B"){
				int score = black.getScore() + 1;						
				black.setScore(score);
				ownerFound = true;
			}	
			if (ownerFound) break;
		}		
	}
	
	/**
	 * 
	 * @param board The current board state.
	 * @param white The white player.
	 * @param black The black player.
	 */
	public static void finalPrint(Square[][] board, Player white, Player black){
		
		String winner;
		
		if(!getResult()){
			winner = "None";
		}
		else{
			if (white.getScore() > black.getScore()){
				winner = "White";
			}
			else if( black.getScore() > white.getScore()){
				winner = "Black";
			}
			else{
				winner = "Draw";
			}
		}
		String lineNew = System.getProperty("line.separator");
		System.out.println(winner + lineNew + white.getScore() + lineNew + black.getScore());	
	}
}
