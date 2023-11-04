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
    private int maxColumn;
    private int winNum;
    private HashMap<Character, List<BoardPosition>> board;
    private List<Character> players;

    /**
     * Constructs a game board that is empty, but uses a map for better efficiency.
     * This constructor initializes a new instance of the gameboard class with a map of blank spaces,
     * in which each position is a value and is assigned to the key being the character representing the player
     * who places their piece in that location.
     * The game board is being represented as a grid with rows and columns, where each position is initially empty.
     *
     * @pre None
     *
     * @post Initializes a new game board with all the positions containing blank spaces.
     * 
     */
    public GameBoardMem(int row, int col, int win) {
        maxRow = row;
        maxColumn = col;
        winNum = win;
        board = new HashMap<Character, List<BoardPosition>>();
        players = new ArrayList<Character>();
    }
    @Override
    public void dropToken(char p, int c) {
        // If the player is not already in the list of players, this adds them to the list.
        if (!players.contains(p)) {
            players.add(p);
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
        return maxColumn;
    }

    @Override
    public int getNumColumns() {
        return maxRow;
    }

    @Override
    public int getNumToWin() {
        return winNum;
    }
}
