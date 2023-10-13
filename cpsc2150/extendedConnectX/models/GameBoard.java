package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */


/**
 * this class holds the gameboard and its functions like checking for wins
 * @
 */
public class GameBoard extends AbsGameBoard
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
        Board = new char[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxColumn; col++) {
                Board[row][col] = ' ';
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
        BoardPosition insert = new BoardPosition(0, c); // Start from the bottom row in column 'c'.
        for (int i = 0; i < maxRow; i++) {
        if (whatsAtPos(insert) == ' ') {
            Board[insert.getRow()][insert.getColumn()] = p; // Place the token at the current position.
            break; // Exit the loop after placing the token.
        }
        insert = new BoardPosition(insert.getRow() + 1, insert.getColumn());
        }
        System.out.println(Board[insert.getRow()][insert.getColumn()]);
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
        if (pos.getRow() < 0 || pos.getRow() >= getNumRows() || pos.getColumn() < 0 || pos.getColumn() >= getNumColumns()) {
            return ' ';
        }
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
