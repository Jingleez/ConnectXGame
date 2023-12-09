package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */


/**
 * this class holds the array version of gameboard and its functions like checking for wins
 * @Invariant maxRow > 0 AND maxColumn > 0 AND winNum > 0 AND [no empty spaces below a token]
 *
 * @corresponds maxRow = Row AND maxCol = Col AND winNum = Win AND Board = self
 */
public class GameBoard extends AbsGameBoard
{
    private int maxRow;
    private int maxColumn;
    private int winNum;
    private char[][] Board;


    /**
     * Constructs a game board that is empty, and uses an array to make the board.
     * This constructor initializes a new instance of the gameboard class with a 2D array of blank spaces
     * The game board is being represented as a grid with rows and columns, where each position is initially empty.
     *
     * @pre row > 0 AND col > 0 AND win > 0
     *
     * @post [Initializes a new game board with all the positions containing blank spaces] AND maxRow = Row
     * AND maxCol = Col AND winNum = Win
     * 
     */
    public GameBoard(int Row, int Col, int Win)
    {
        maxRow = Row;
        maxColumn = Col;
        winNum = Win;
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
     * @param p a character, which represents a player's token
     *
     * @pre 
     * 0 <= c <= (maxColumn - 1)
     * p = [a valid player's token]
     * [checkIfFree() must return true to confirm a token can be placed there.]
     *
     * @post
     * [dropToken calls function whatsAtPos(BoardPosition)] AND maxColumn = #maxColumn AND maxRow = #maxRow AND
     * winNum = #winNum AND Board = [Board with a playerToken placed in "available" element]
     *
     */
    public void dropToken(char p, int c)
    {
        // Start from the bottom row in column 'c'.
        BoardPosition insert = new BoardPosition(0, c); 
        for (int i = 0; i < maxRow; i++) {
        if (whatsAtPos(insert) == ' ') {
            // Place the token at the current position.
            Board[insert.getRow()][insert.getColumn()] = p; 
            // Exit the loop after placing the token.
            break; 
        }
        insert = new BoardPosition(insert.getRow() + 1, insert.getColumn());
        }
        //Places the character 'p' in column 'c'. The token will be placed in the lowest available row in column 'c'.
    }

    /**
     * This function retrieves a character from at a specified boardPosition on the game board
     *
     * @param pos The boardPosition object that specifies the row and column to examine
     *
     * @pre pos.Row >= 0 AND pos.Row < maxRow AND pos.Column >= 0 AND pos.Column < maxColumn
     *
     * @post
     * whatsAtPos = [the character at pos] AND maxColumn = #maxColumn AND maxRow = #maxRow AND
     * winNum = #winNum AND Board = #Board
     *
     * @return a valid player character or ' '
     */
    public char whatsAtPos(BoardPosition pos)
    {
        return Board[pos.getRow()][pos.getColumn()];
    }

    @Override
    public int getNumRows() {
        return maxRow;
    }



    @Override
    public int getNumColumns() {
        return maxColumn;
    }



    @Override
    public int getNumToWin() {
        return winNum;
    }


}
