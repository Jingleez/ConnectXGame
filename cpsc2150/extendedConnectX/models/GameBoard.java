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
    /**
     * Constructs a game board that is empty.
     * The game board is a two dimensional array initialized with blank spaces.
     * This constructor creates a new instance of the gameBoard class.
     *
     * @pre None
     *
     * @post Initializes a new game board with all the positions containing blank spaces.
     */
    public GameBoard()
    {

    }

    /**
     * This function will check if a certain column on the board is available
     * for a token to be placed in, so not yet full.
     *
     * @param c an integer, specifically the column the user inputs they want to play their token
     * @return returns a true of false statement whether or not a token can be played in
     * the selected column
     *
     * @pre
     * 0 < c <= maxColumn, must be a valid column to place token in
     *
     * @post
     * This function will check the value of GameBoard[maxRow][c], if value is X or O
     * return false, if value is " " return true, object unchanged just checking
     */
    public boolean checkIfFree(int c)
    {
        //returns true if the column can accept another token; false otherwise.
    }

    /**
     * This function place a token in a specific column and the row the token goes to
     * will drop until it collides with another token.
     *
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @param c an integer, specifically the column the user inputs they want to play their token
     *
     * @pre
     * 0 < c (latest column) <= maxColumn, must be a valid column to place token in
     * p = X or O, these are the only 2 valid pieces
     * checkIfFree() must return true to confirm a token can be placed there.
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
     * @param c an integer, the column where the token is to be placed ( 1 <= c <= maxColumn)
     * @param p a character, either 'X' or 'O', which represents the player's token
     *
     * @pre 1 <= c <= maxColumn, should be a valid column to place a token in p is either 'X' or 'O'
     *      The column 'c' must be empty or have space for the token to be placed
     *
     * @post The function places the token 'p' in the lowest availble row in the column 'c'.
     * 
     * @return true if the token is sucessfully placed, false otherwise.( this means the column is already full )
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
     * This function will check if every position is filled by either and X or an O and every time
     * the check for win functions have passed and all return false, game is declared a tie.
     *
     * @return true if whole board is filled and no win, false if there is a win somewhere
     *
     * @pre
     * The board must be full in order for this to ever return true as there are always other moves to
     * be made, but even if board is full it can check the board or whole board one more time for any
     * wins before concluding tie is true.
     *
     * @post
     * The function to save time will go through the whole top row and make sure they all either have
     * an X or O and no blank space, and this will mean that every other spot will be full if the
     * whole top is full based on functionality, and will return true if no wins were ever returned
     * true during the game
     * Board = #Board
     */
    public boolean checkTie()
    {
        /*this function will check to see if the game has resulted in a tie. A game is tied if there are no free board
        positions remaining. You do not need to check for any potential wins because we can assume that the players
        were checking for win conditions as they played the game. It will return true if the game is tied and
        false otherwise.*/
    }

    /**
     * This function will check if there are three identical pieces to the one passed in rows
     * right above the set location, or right below the set location.
     *
     * @param pos a BoardPosition, the position where the most recent piece was played in this case
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return true if there are 4 horizontal in a row, false if not
     *
     * @pre
     * BoardPosition already validated, char p must be either X or O, can't be equal to ' ' (a blank space).
     *
     * @post
    * The following function checks if BoardPosition[row][col] = p, BoardPosition[row+1][col] = p, BoardPosition[row+2][col] = p, and BoardPosition[row+3][col] = p
     * or BoardPosition[row][col] = p, BoardPosition[row-1][col] = p, BoardPosition[row-2][col] = p, and BoardPosition[row-3][col] = p
     * are true, returning true if yes and false if no.
     * self = #self
     */
    public boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
    }

    /**
     * This function will check if there are three identical pieces to the one passed in a columns
     * right next to the set location.
     *
     * @param pos a BoardPosition, the position where the most recent piece was played in this case
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return true if there are 4 vertical in a row, false if not
     *
     * @pre
     * BoardPosition already validated, char p must be either X or O, can't be equal to ' ' (a blank space).
     *
     * @post
     * The following function checks if BoardPosition[row][col] = p, BoardPosition[row][col+1] = p, BoardPosition[row][col+2] = p, and BoardPosition[row][col+3] = p
     * or BoardPosition[row][col] = p, BoardPosition[row][col-1] = p, BoardPosition[row][col-2] = p, and BoardPosition[row][col-3] = p
     * are true, returning true if yes and false if no.
     * self = #self
     */
    public boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        vertically. Returns true if it does, otherwise false*/
    }

    /**
     * This function will check if there are three identical pieces above and across from
     * each other sequentially for at least 4 pieces.
     *
     * @param pos a BoardPosition, the position where the most recent piece was played in this case
     * @param p a character, representing either X or O depending on which player’s turn it is
     * @return true if there are 4 diagnol in a row, false if not
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
     * This function returns blank space, if the specified boardPosition is unoccupied. Board = #Board
     *
     * @return The character (‘X’, ‘O’, ‘ ‘ )
     */
    public char whatsAtPos(BoardPosition pos)
    {
        //returns what is in the GameBoard at position pos If no marker is there, it returns a blank space char.
    }

    /**
     *
     * @param pos The boardPosition object that specifies the row and column to examine
     * @param player This character represents the player piece  (‘X’, ‘O’) to check for
     *
     * @pre the provided BoardPosition must not be NULL
     * The row and column values within the boardPosition object must be in the valid range of rows
     * and columns on the gameBoard.
     * The playerChar must be either 'X' or 'O'.
     *
     * @post Decides whether the selected player’s piece occupies the specified position on the gameboard
     * Board = #Board
     *
     * @return Returns true if the selected player is at the given position, false otherwise
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        /*returns true if the player is at pos; otherwise, it returns false. Note: this method will be implemented very
        similarly to whatsAtPos, but it's asking a different question. We only know they will be similar because we
        know GameBoard will contain a 2D array. If the data structure were to change in the future,
        these two methods could be radically different.*/
    }

    /**
     * This function returns the string representing the entire game board.
     * This function formats the gameBoard as string, including the row and column labels
     *
     * @pre None Required
     *
     * @post Produces a string representation of the gameBoard with a clear layout
     * The resulting string includes labels for rows and columns. Board = #Board
     *
     * @return the whole gameboard at that moment.
     */
    @Override
    public String toString(){

    }














}
