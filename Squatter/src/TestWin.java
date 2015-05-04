/*Project Part A, Artificial Inteligence COMP30024
 * Anuja Ratwatte 637298
 * Scotch Macdonald 643785
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestWin {
	/**
	 * Sets a variable to zero.
	 */
	public static final int INIT = 0;
	/**
	 * Sets a variable back to zero from some other value.
	 */
	public static final int RESET = 0;
	
	/**
	 * @throws Exception Any of the possible exceptions that could be encountered from the input.
	 */
	public static void main(String[] args) throws Exception{
	    
		/* Create instances of the two players. */
		Player white = new Player("W", INIT);
		Player black = new Player("B", INIT);
		int detectedSpaces = INIT, row = INIT, col = INIT;
		
		try{
			
			/* Create reader to take in console input. */
			BufferedReader readIn = new BufferedReader(new InputStreamReader(System.in));		
			
			/* Read in the integer as the board size. And create an array of squares (board). */
			int boardSize = Integer.parseInt(readIn.readLine());
			Square[][] board = new Square[boardSize][boardSize];
		
			/* Read in the input and create the corresponding game board. */
			String input;
			while ((input = readIn.readLine()) != null){
				/* When an empty line is reached, means end of input therefore stop reading in. */
				if (input.length() == 0){
					break;
				}
				/* Create array of strings to temporarily store data. */ 
				input = input.trim();
				String[] line = input.split(" ");
				
				/* Takes data, in any form, and transfers it into the appropriate board structure. */
				for(int elem=0; elem<line.length; elem++){
					if (col >= boardSize){
						col = RESET;
						row++;
					}
					/* Keeps track of the number of spaces to get the input correct. */
					detectedSpaces++;
					/* Creates a square instance in each array position. */
					switch(line[elem]){
						case "W": 	board[row][col] = new Square(false, "W", false);
									col++;
									continue;
						case "B":	board[row][col] = new Square(false, "B", false);
									col++;
									continue;
						case "+":	board[row][col] = new Square(false, "+", true);
									col++;
									continue;
						case "-":	board[row][col] = new Square(true, "-", false);
									col++;
									continue;
					}
				}			
			}
			
			/* Exit program if the entered data does not match the declared amount. */
			if (detectedSpaces != boardSize*boardSize) {
				System.out.println("Error. Check your input!");
				System.exit(0);
			}
			
			Square.checkSquares(board, white, black);
			Square.finalPrint(board, white, black);
			
		}catch(IOException | NumberFormatException | ArrayIndexOutOfBoundsException e){
			System.out.println("Error. Check your input.");
			throw e;
		}
		
		
	}
}
