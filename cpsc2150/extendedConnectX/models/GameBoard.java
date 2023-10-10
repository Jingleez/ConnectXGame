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
public class GameBoard extends AbsGameBoard
{
    int maxRow = 6;
    int maxColumn = 7;
    int winNum = 4;
    char[][] Board;


    /**
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


    // remove if it is not overridden
    /**
     * This function checks if a specified column on the gameBoard is availble for placing a token
     *
     * @param c an integer representing the column where the user wants to play their token (0 to maxColumn-1)
     * 
     * @return  Returns true if the selected column is availble, false otherwise
     *
     * @pre  0 < c <= maxColumn, [must be a valid column to place token in]
     *
     * @post * This function will check the value of GameBoard[maxRow][c], if value is X or O
     * return false, if value is " " return true, object unchanged just checking
     * 
     */
    public boolean checkIfFree(int c)
    {
        //returns true if the column can accept another token; false otherwise.
    }


    /**
     * This function places a token in a specific column, allowing it to drop until it collides with amother token
     *
     * @param c an integer, the column where the token is to be placed ( 0 <= c <= maxColumn-1)
     * @param p a character, either 'X' or 'O', which represents the player's token
     *
     * @pre 
     * 0 < c (latest column) <= maxColumn - 1, [must be a valid column to place token in
     * p = X or O, these are the only 2 valid pieces
     * checkIfFree() must return true to confirm a token can be placed there.]
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


    // remove if it is not overridden
    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c an integer, the column where the last token was dropped
     *
     * @pre 'c' is the column where the last token was placed. and it should be within the valid column range [0, maxColumn-1]
     *
     * @post 
     * Returns true if the last token placed makes up the last of the consecutive marker changes needed
     * for a win, so if any of checkVertWin, checkHorizWin, or checkDiag() win return true,
     * then this returns true, otherwise false
     * state unchanged, self = #self
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


    // remove if it is not overridden
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


    // remove if it is not overridden
    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a horizontal direction
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (horizontal), false if not
     *
     * @pre
     * BoardPosition already validated, char p must be either X or O, can't be equal to ' ' (a blank space).
     *
     * @post
     * The following function checks if BoardPosition[row][col] = p, BoardPosition[row][col+1] = p, BoardPosition[row][col+2] = p, and BoardPosition[row][col+3] = p
     * or BoardPosition[row][col] = p, BoardPosition[row][col-1] = p, BoardPosition[row][col-2] = p, and BoardPosition[row][col-3] = p
     * are true, returning true if yes and false if no.
     * self = #self
     * 
     */
    public boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
    }


    // remove if it is not overridden
    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a vertical direction
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (vertically), false if not
     *
     * @pre
     * BoardPosition already validated, char p must be either X or O, can't be equal to ' ' (a blank space).
     *
     * @post
     * The following function checks if BoardPosition[row][col] = p, BoardPosition[row+1][col] = p, BoardPosition[row+2][col] = p, and BoardPosition[row+3][col] = p
     * or BoardPosition[row][col] = p, BoardPosition[row-1][col] = p, BoardPosition[row-2][col] = p, and BoardPosition[row-3][col] = p
     * are true, returning true if yes and false if no.
     * self = #self
     * 
     */
    public boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in four in a row
        vertically. Returns true if it does, otherwise false*/
    }


    // remove if it is not overridden
    /**
     * This function checks if there are four identical pieces diagonally aligned with the specified position
     *
     * @param pos a BoardPosition, the position where the most recent piece was played
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return Returns true if there are four consecutive identical pieces (diagonally), false if not
     *
     * @pre
     * BoardPosition already validated, char p must be either X or O, can't be equal to ' ' (a blank space).
     *
     * @post
     * The following function checks if BoardPosition[row][col] = p, BoardPosition[row+1][col+1] = p, BoardPosition[row+2][col+2] = p, and BoardPosition[row+3][col+3] = p
     * or BoardPosition[row][col] = p, BoardPosition[row-1][col-1] = p, BoardPosition[row-2][col-2] = p, and BoardPosition[row-3][col-3] = p
     * or BoardPosition[row][col] = p, BoardPosition[row+1][col-1] = p, BoardPosition[row+2][col-2] = p, and BoardPosition[row+3][col-3] = p
     * or BoardPosition[row][col] = p, BoardPosition[row-1][col+1] = p, BoardPosition[row-2][col+2] = p, and BoardPosition[row-3][col+3] = p
     * are true, returning true if yes and false if no.
     * self = #self
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
     * @pre None
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


    // remove if it is not overridden
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
     *
     * @return
     */
    @Override
    public int getNumRows() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumColumns() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumToWin() {
        return 0;
    }


    // remove toString unless override again for some reason
    /**
     * This function returns a string representing the entire gameboard, including row and column labels
     *
     * @pre None Required
     *
     * @post 
     * 
     *
     * @return The string representation of the entire gameboard
     */
    @Override
    public String toString(){
        /*This function returns a string representation of the entire game board, including labels for rows and columns,
         without altering the board's state. */
    }


}
