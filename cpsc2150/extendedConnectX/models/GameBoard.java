package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */


/**
 * this class holds the gameboard and its functions like checking for wins
 */
public class GameBoard
{
    int maxRow = 6;
    int maxColumn = 7;
    char[][] Board;


    /*
     * Constructs a game board that is empty.
     * This constructor initializes a new instance of the gameboard class with a 2D array of blank spaces
     * The game board is being represented as a grid with rows and columns, where each position is initially empty.
     *
     * @pre None
     *
     * @post Initializes a new game board with all the positions containing blank spaces.
     * 
     */
    public GameBoard()
    {

    }


    /**
     * This function checks if a specified column on the gameBoard is availble for placing a token
     *
     * @param c an integer representing the column where the user wants to play their token (0 to maxColumn-1)
     * 
     * @return  Returns true if the selected column is availble, false otherwise
     *
     * @pre The parameter 'c' must be a non-negative integer within the vaild range of columns (0 to maxColumn-1)
     *
     * @post Returns true if the top-most row of the specified column 'c' contains a blank space, which means the 
     *       column is availble for placing a token
     *       Returns false if the top-most row of the specified column 'c' is already occupied by a token ('X' or 'O')
     * 
     */
    public boolean checkIfFree(int c)
    {
        //returns true if the column can accept another token; false otherwise.
    }


    /**
     * This function places a token in a specific column, allowing it to drop until it collides with amother token
     *
     * @param p a character, representing either X or O depending on the current player's turn
     * @param c an integer, specifically the column where the player wants to play their token (0 to maxColumn-1)
     *
     * @pre 
     * The integer parameter 'c' must be a non-negative integer within the vaild range of columns
     * The character parameter 'p' must be 'X' or 'O', representing the tokens for the players
     * There also must be space availble in the specified column 'c' for the token to be placed
     *
     * @post
     * The following function will loop (i = 0, i <= maxRow, i++) checking whether the location
     * GameBoard[maxRow-i][c] each loop checking if spot is occupied by X or O, after going 
     * down and when the loop either ends because no token or is occupied by X or O, go back up one row
     * and place token value p at that location.
     */
    public void dropToken(char p, int c)
    {
        //Places the character 'p' in column 'c'. The token will be placed in the lowest available row in column 'c'.
    }


    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c an integer, the column where the last token was dropped
     *
     * @pre 'c' is the column where the last token was placed. and it should be within the valid column range [0, maxColumn-1]
     *
     * @post 
     * The method returns true if the last placed token in column 'c' resulted in the player winning the game by forming
     * a winning sequence either vertically, horizontally, or diagonally
     * The state of the 'Board' remains unchanged after this function is called
     * 
     * @return Returns true if the last move resulted in a player winning the game, otherwise false
     * 
     * 
     */
    public boolean checkForWin(int c)
    {
        /*this function will check to see if the last token placed in column c resulted in the player winning the game.
        If so it will return true, otherwise false. Note: this is not checking the entire board for a win, it is just
        checking if the last token placed results in a win. You may call other methods to complete this method */
    }


    /**
     * This function checks if the game has resulted in a tie. A Game is considered tie if there are no free board positions remaining.
     * It returns true if the game is tied and false otherwise
     *
     * @return Returns true of the whole board is filled with 'X' or 'O' ( no empty places ) and no player has won, false otherwise
     *
     * @pre None Required
     *
     * @post
     * The function returns true if every position on the board is filled with either 'X' or 'O', indicating a tie game, and no
     * player has won. It returns false if there is a win somewhere on the board
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     */
    public boolean checkTie()
    {
        /*this function will check to see if the game has resulted in a tie. A game is tied if there are no free board
        positions remaining. It will return true if the game is tied (all positions filled with X or O) and
        false otherwise.*/
    }


    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a horizontal direction
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (horizontal), false if not
     *
     * @pre
     * The character 'p' must be either 'X' or 'O' (representing the player's token)
     * No explicit precondition checking is done here, as the contracts for BoardPosition are expected to ensure this.
     *
     * @post
     * The function checks for four consecutive identical pieces starting at the 'pos' position, both to the right and to the left
     * It returns true if it finds four identical pieces in a horizontal direction (either right or left), and false otherwise
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     * 
     */
    public boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
    }


    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a vertical direction
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (vertically), false if not
     *
     * @pre
     * The character 'p' must be either 'X' or 'O' (representing the player's token)
     * No explicit precondition checking is done here, as the contracts for BoardPosition are expected to ensure this.
     *
     * @post
     * The function checks for four consecutive identical pieces starting at the 'pos' position, both upwards and downwards
     * It returns true if it finds four identical pieces in a vertical direction (either up or down), and false otherwise
     * The state of the 'Board' remains unchanged after this method is called (self = #self).
     * 
     */
    public boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in four in a row
        vertically. Returns true if it does, otherwise false*/
    }


    /**
     * This function checks if there are four identical pieces diagonally aligned with the specified position
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (diagonally), false if not
     *
     * @pre
     * The character 'p' must be either 'X' or 'O' (representing the player's token)
     * No explicit precondition checking is done here, as the contracts for BoardPosition are expected to ensure this.
     *
     * @post
     * The function checks for four consecutive identical pieces starting at the 'pos' position in diagonal directions.
     * It returns true if it finds four identical pieces diagonally (in any of the two diagonal directions), and false otherwise
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     */
    public boolean checkDiagWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        diagonally. Returns true if it does, otherwise false Note: there are two diagonals to check*/
    }


    /**
     * This function retrieves a character from at a specified boardPosition on the game board
     *
     * @param pos The boardPosition object that specifies the row and column to examine
     *
     * @pre 
     * The boardPosition 'pos' provided to the function is assumed to be valid and not null.
     * No explicit precondition checking is done here, as the contracts for BoardPosition are expected to ensure this.
     *
     * @post This function returns the character (‘X’, ‘O’, ‘ ‘ ) located at the specific boardPosition
     * This function returns blank space, if the specified boardPosition is unoccupied. 
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     *
     * @return The character (‘X’, ‘O’, ‘ ‘ )
     */
    public char whatsAtPos(BoardPosition pos)
    {
        //Returns the character at the specified boardPosition on the gameboard. If no marker is there, it returns a blank space character
    }


    /**
     * This function decides whether the selected player's token ('X' or 'O') occupies the specified position on the gameboard
     *
     * @param pos The boardPosition object that specifies the row and column to examine
     * @param player This character represents the player piece  (‘X’, ‘O’) to check for
     *
     * @pre 
     * The provided BoardPosition 'pos' must not be NULL
     * The row and column values within the 'pos' object are expected to be within the valid range of rows 
     * and columns on the game board.
     * The 'player' character must be either 'X' or 'O'
     *
     * @post
     * This function returns true if the selected player is at the given position, false if not
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     *
     * @return Returns true if the selected player is at the given position, false otherwise
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        /* Returns true if the player's piece ('X' or 'O') is at the specified position 'pos'otherwise, it returns false. 
        Note: This method is implemented similarly to whatsAtPos, but it checks for a specific player's piece instead.
     */
    }


    /**
     * This function returns a string representing the entire gameboard, including row and column labels
     *
     * @pre None Required
     *
     * @post 
     * This function produces a string representation of the gameBoard with a clear layout, including the labels for rows and columns
     * The resulting string represents the current state of the gameboard
     * The state of the 'Board' remains unchanged after this method is called (self = #self)
     *
     * @return The string representation of the entire gameboard
     */
    @Override
    public String toString(){
        /*This function returns a string representation of the entire game board, including labels for rows and columns,
         without altering the board's state. */
    }


}
