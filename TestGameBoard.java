import cpsc2150.extendedConnectX.models.IGameBoard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameBoardTester {

    public static class GameBoardFactory {
        public static IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
            return new GameBoard(numRows, numColumns, numToWin);
        }
    }

    @Test
    public void testConstructorSmall() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        assertEquals(6, testBoard.getNumRows());
        assertEquals(7, testBoard.getNumColumns());
        assertEquals(4, testBoard.getNumToWin());
    }

    @Test
    public void testConstructorMiddle() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(8, 17, 7);
        assertEquals(5, testBoard.getNumRows());
        assertEquals(8, testBoard.getNumColumns());
        assertEquals(3, testBoard.getNumToWin());
    }

    @Test
    public void testConstructorLarge() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(100, 100, 25);
        assertEquals(100, testBoard.getNumRows());
        assertEquals(100, testBoard.getNumColumns());
        assertEquals(25, testBoard.getNumToWin());
    }
    @Test
    public void testHorizontalWinEasy() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(2, 0), 'X'));
    }
    @Test
    public void testHorizontalWinMedium() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(7, 7, 4);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('X', 3);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(2, 0), 'X'));
    }
}
