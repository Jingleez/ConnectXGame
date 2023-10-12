package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */


/**
 * this class holds the gameboard and its functions like checking for wins
 *
 * @invariant maxRow = 9 AND maxColumn = 7 AND winNum = 5
 *
 * @corresponds maxRow = maxRows AND maxColumn = maxCols AND winNum = winNum
 */
public class GameBoard implements IGameBoard
{
    private int maxRow = 9;
    private int maxColumn = 7;
    private int winNum = 5;
    private char[][] Board;


    /**
     * Constructs a game board that is empty.
     * This constructor initializes a new instance of the gameboard class with a 2D array of blank spaces
     * The game board is being represented as a grid with rows and columns, where each position is initially empty.
     *
     * @pre None
     *
     * @post Initializes a new game board with all the positions containing a blank space.
     * 
     */
    public GameBoard()
    {
        Board = new char[maxRow][maxColumn];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                Board[i][j] = ' ';
            }
        }
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
        for (int i = 0; i < maxRow; i++) {
            BoardPosition insert = new BoardPosition(i, c);
            if (whatsAtPos(insert) == ' ') {
                Board[i][c] = p;
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
       return Board[pos.getRow()][pos.getColumn()];
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


}
