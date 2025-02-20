package cpsc2150.extendedConnectX.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * this class holds the hashmap version of the gameboard and its functions
 * @Invariant maxRow > 0 AND maxColumn > 0 AND winNum > 0 AND [no empty spaces below a token]
 *
 * @corresponds maxRow = Row AND maxCol = Col AND winNum = Win AND Board = self
 */
public class GameBoardMem extends AbsGameBoard{
    private int maxRow;
    private int maxCol;
    private int winNum;
    private HashMap<Character, List<BoardPosition>> board;

    /**
     * Constructs a game board that is empty, but uses a map for better efficiency.
     * This constructor initializes a new instance of the GameBoardMem class with a map of blank spaces,
     * in which each position is a value and is assigned to the key being the character representing the player
     * who places their piece in that location.
     * The game board is being represented as a grid with rows and columns, where each position is initially empty.
     *
     * @pre None
     *
     * @post Initializes a new game board with all the positions equal to blank spaces, AND maxRow = row
     * AND maxCol = col AND winNum = win
     * 
     */
    public GameBoardMem(int row, int col, int win) {
        maxRow = row;
        maxCol = col;
        winNum = win;
        board = new HashMap<Character, List<BoardPosition>>();
    }
    @Override
    public void dropToken(char p, int c) {
        // If the player is not already in the list of keys, this adds them to the list.
        if (!board.containsKey(p)) {
            board.put(p, new ArrayList<BoardPosition>());
        }
        // Retrieving the list of positions for the player from the board map
        List<BoardPosition> positions = board.get(p);
        for (int r=0; r < maxRow; r++) {
            BoardPosition pos = new BoardPosition(r,c);
            if (whatsAtPos(pos) == ' ') {
                positions.add(pos);
                return;
            }
        }
    }

    @Override
    public char whatsAtPos(BoardPosition pos) {
        for (Character player : board.keySet()) {
            List<BoardPosition> positions = board.get(player);
            for (BoardPosition position : positions) {
                if (position.equals(pos)) { return player; }
            }
        }
        // Returning blankspace character if no player occupies the given position
        return ' ';
    }

    /**
     * this function returns true if a specified player is at a specified location.
     *
     * @param pos [the position to check for which player is potentially located]
     * @param player [a valid player character]
     *
     * @pre pos.Row < maxRow AND pos.Row >= 0 AND pos.Column < maxColumn AND pos.Column >= 0
     * @pre player is a Character key in board
     *
     * @return true [IFF player is at pos in board] OW false
     *
     * @post
     * isPlayerAtPos = true IFF [the player at the BoardPosition pos is equal to player] OR
     * isPlayerAtPos = false IFF [gameMap does not contain player OR the key at BoardPosition is not equal to player] AND
     * maxRow = #maxRow AND maxCol = #maxCol AND winNum = #winNum AND board = #board
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        List<BoardPosition> positions = board.get(player);
        for (int i = 0; i < positions.size(); i++) {
            if (pos.equals(positions.get(i))){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumRows() {
        return maxRow;
    }

    @Override
    public int getNumColumns() {
        return maxCol;
    }

    @Override
    public int getNumToWin() {
        return winNum;
    }
}
