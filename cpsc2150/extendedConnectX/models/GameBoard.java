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
public class GameBoard implements IGameBoard
{
    int maxRow = 9;
    int maxColumn = 7;
    int winNum = 5;
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
        BoardPosition insert = new BoardPosition(maxRow, c);
        for (int i = 0; i < maxRow; i++) {
            if (whatsAtPos(insert) == ' ') {
                insert.Row -= 1;
            }
            else {
                Board[insert.Row][c] = p;
            }
        }
        //Places the character 'p' in column 'c'. The token will be placed in the lowest available row in column 'c'.
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
       return Board[pos.Row][pos.Column];
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumRows() {
        return maxRow;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumColumns() {
        return maxColumn;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumToWin() {
        return winNum;
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
        // Initial check to see if the 'board' has rows and columns
        if (Board == null || Board.length == 0 || Board[0] == null) {
            return "The 'board' is either empty or doesn't have rows and columns.";
        }
        StringBuilder boardString = new StringBuilder(); // Create a StringBuilder for the string representation.
        // Before going to next row, adding a newline first
        boardString.append("|");
        for (int col=0; col <Board[0].length; col++) {
            boardString.append(" " + col + "|");
        }
        boardString.append("\n");
        
        // This loop adds row labels and board contents
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[0].length; col++) {
                boardString.append("|" + Board[row][col] + "|"); // Appending contents of cell
            }
            // Before going to next row, adding a newline first
            boardString.append("\n");
        }
    
        // This converts the StringBuilder to a string and returns the final string representing the board.
       return boardString.toString();
    }


}
