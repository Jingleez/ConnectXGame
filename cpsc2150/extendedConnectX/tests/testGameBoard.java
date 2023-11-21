package cpsc2150.extendedConnectX.tests;

import cpsc2150.extendedConnectX.models.BoardPosition;
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTester {

    public static class GameBoardFactory {
        public static IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
            return new GameBoard(numRows, numColumns, numToWin);
        }
    }
    
    
    @Test
    public void testCheckIfFreeSmall() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);

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
        assertTrue(testBoard.checkHorizWin(new BoardPosition(2, 2), 'X'));
    }
    @Test
    public void testHorizontalWinHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 7);
        for (int col = 0; col < 10; col++) {
            testBoard.dropToken('X', col);
        }
        testBoard.dropToken('O', 3);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 6);
        testBoard.dropToken('O', 7);
        testBoard.dropToken('O', 8);
        testBoard.dropToken('O', 9);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(4, 6), 'O'));
    }
    @Test
    public void testHorizontalWinSuperHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 7);
        for (int col = 0; col < 9; col++) {
            testBoard.dropToken('X', col);
        }
        testBoard.dropToken('O', 3);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 6);
        testBoard.dropToken('O', 7);
        testBoard.dropToken('O', 8);
        testBoard.dropToken('O', 9);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(4, 6), 'O'));
    }
    @Test
    public void testVerticalWinEasy() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(4, 4, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(0, 2), 'X'));
    }
    @Test
    public void testVerticalWinMedium() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(6, 6, 3);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 5);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(5, 0), 'O'));
    }
    @Test
    public void testVerticalWinHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(12, 12, 6);
        testBoard.dropToken('X', 4);
        testBoard.dropToken('X', 4);
        testBoard.dropToken('X', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('O', 4);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(5, 8), 'O'));
    }
    @Test
    public void testVerticalWinSuperHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(100, 100, 25);
        for (int i = 0; i < 75; i++) {
            testBoard.dropToken('X', 99);
        }
        for (int i = 0; i < 25; i++) {
            testBoard.dropToken('O', 99);
        }
        assertTrue(testBoard.checkHorizWin(new BoardPosition(99, 87), 'O'));
    }
    @Test
    public void testDiagonalWinEasy() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 2);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(0, 0), 'X'));
    }

    @Test
    public void testDiagonalWinEasy() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(2, 0), 'O'));
    }
    
}
