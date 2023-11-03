package cpsc2150.extendedConnectX.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameBoardMem extends AbsGameBoard{
    private int maxRow;
    private int maxColumn;
    private int winNum;
    private HashMap<Character, List<BoardPosition>> board;
    private List<Character> players;


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
            board.put(p, new ArrayList<>()); 
        }
        // Retrieving the list of positions for the player from the board map
        List<BoardPosition> positions = board.get(p);
        for (int r=maxRow-1; r>=0; r--) {
            BoardPosition pos = new BoardPosition(r,c);
            if (!isPlayerAtPos(pos, p)) {
                positions.add(pos);
                return;
            }
        }
    }

    @Override
    public char whatsAtPos(BoardPosition pos) {
        return 0;
    }

    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        return super.isPlayerAtPos(pos, player);
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
