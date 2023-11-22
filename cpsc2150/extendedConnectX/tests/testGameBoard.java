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
        assertTrue(testBoard.checkIfFree()
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
    public void testDiagonalWinEasy1() {
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
    public void testDiagonalWinEasy2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(2, 0), 'O'));
    }
    @Test
    public void testDiagonalWinMedium1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 4);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                testBoard.dropToken('X', i);
            }
        }
        testBoard.dropToken('X', 3);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('O', 3);
        testBoard.dropToken('X', 4);
        testBoard.dropToken('X', 4);
        testBoard.dropToken('O', 4);
        testBoard.dropToken('X', 5);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 6);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(6, 4), 'O'));
    }
    @Test
    public void testDiagonalWinMedium2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 4);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                testBoard.dropToken('X', i);
            }
        }
        testBoard.dropToken('X', 9);
        testBoard.dropToken('X', 9);
        testBoard.dropToken('X', 9);
        testBoard.dropToken('O', 9);
        testBoard.dropToken('X', 8);
        testBoard.dropToken('X', 8);
        testBoard.dropToken('O', 8);
        testBoard.dropToken('X', 7);
        testBoard.dropToken('O', 7);
        testBoard.dropToken('O', 6);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(6, 4), 'O'));
    }
    @Test
    public void testDiagonalWinHard1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(7, 7, 4);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('X', 2);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(1, 1), 'X'));
    }
    @Test
    public void testDiagonalWinHard2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(7, 7, 4);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 3);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('O', 3);
        testBoard.dropToken('X', 3);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 1);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(2, 2), 'X'));
    }
    @Test
    public void testDiagonalWinSuperHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(25, 25, 25);
        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < j; i++) {
                testBoard.dropToken('O', j);
            }
            testBoard.dropToken('X', j);
        }
        assertTrue(testBoard.checkDiagWin(new BoardPosition(25, 25), 'X')
    }
    @Test
    public void testCheckIfTieEasy() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.checkTie(new BoardPosition(0, 0), 'X'));
    }
    @Test
    public void testCheckIfTieEasy1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.checkTie());
    }
    @Test
    public void testCheckIfTieEasy2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        assertFalse(testBoard.testBoard.checkTie());
    }
    @Test
    public void testCheckIfTieEasy1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        
        assertTrue(testBoard.checkTie());
    }
    @Test
    public void whatsAtPosEasy1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        assertEquals(testBoard.whatsAtPos(0, 0), 'X');
    }
    @Test
    public void whatsAtPosEasy2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertEquals(testBoard.whatsAtPos(2, 2), ' ');
    }
    public void whatsAtPosMedium() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertEquals(testBoard.whatsAtPos(2, 2), 'X');
    }
    public void whatsAtPosHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 10);
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 10; i++) {
                    testBoard.dropToken('O', i);
                }
            }
        assertEquals(testBoard.whatsAtPos(10, 10), 'O');
    }
    public void whatsAtPosSuperHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(20, 20, 10);
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 20; i++) {
                    if (i != 20 || j != 20) {
                        testBoard.dropToken('O', i);
                    }
                }
            }
        assertEquals(testBoard.whatsAtPos(20, 20), ' ');
    }
    @Test
    public void isPlayerAtPosEasy1() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(0, 0), 'X');
    }
    @Test
    public void isPlayerAtPosEasy2() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(2, 2), ' ');
    }
    @Test
    public void isPlayerAtPosMedium() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(2, 2), 'X');
    }
    @Test
    public void isPlayerAtPosHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 10);
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 10; i++) {
                    testBoard.dropToken('O', i);
                }
            }
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(10, 10), 'O');
    }
    @Test
    public void isPlayerAtPosSuperHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(20, 20, 10);
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 20; i++) {
                    if (i != 20 || j != 20) {
                        testBoard.dropToken('O', i);
                    }
                }
            }
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(20, 20), ' ');
    }
    @Test
    public void testCheckIfFreeEasy() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        assertTrue(gb.checkIfFree(0, 0));
    }

    @Test
    public void testCheckIfFreeMedium() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertFalse(gb.checkIfFree(0, 0));
    }

    @Test
    public void testCheckIfFreeHard() {
        IGameBoard testBoard = GameBoardFactory.makeGameBoard(10, 10, 10);
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 10; i++) {
                    testBoard.dropToken('O', i);
                }
            }
        assertFalse(testBoard.checkIfFree(10, 10));
    }
    
    //dropToken copied from mem tests (i can change if needed)
    
    @Test
    public void testDropTokenNormalPlacement() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 0)));
        gb.dropToken('O', 1);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 1)));
        gb.dropToken('X', 2);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 2)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 2)));
    }

    @Test
    public void testDropTokenOverlappingTokens() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 0)));
        gb.dropToken('O', 1);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 1)));
        gb.dropToken('X', 0); // Overlapping token
        assertEquals('X', gb.whatsAtPos(new BoardPosition(1, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 0)));
    }

    @Test
    public void testDropTokenMultipleInColumn() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 0)));
        gb.dropToken('O', 1);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 1)));
        gb.dropToken('X', 1);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(1, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 1)));
    }

    @Test
    public void testDropTokenFillColumn() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 0)));
        gb.dropToken('O', 1);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 1)));
        gb.dropToken('X', 2);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 2)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 2)));
        gb.dropToken('O', 2);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(1, 2)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 2)));
    }

    @Test
    public void testDropTokenFillMultipleColumns() {
        IGameBoard gb = GameBoardFactory.makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 0)));
        gb.dropToken('O', 1);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 1)));
        gb.dropToken('X', 2);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 2)));
        assertFalse(gb.checkIfFree(new BoardPosition(0, 2)));
        gb.dropToken('O', 0);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(1, 0)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 0)));
        gb.dropToken('X', 1);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(1, 1)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 1)));
        gb.dropToken('O', 2);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(1, 2)));
        assertFalse(gb.checkIfFree(new BoardPosition(1, 2)));
    }
    
}
