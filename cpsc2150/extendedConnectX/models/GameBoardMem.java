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
