package cpsc2150.extendedConnectX.tests;

import cpsc2150.extendedConnectX.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class testGameBoard {

    private IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
            return new GameBoard(numRows, numColumns, numToWin);
    }
    private IGameBoard makeGameBoard() {
        int small = 3;
        return new GameBoard(small, small, small);
    }

    //test cases for GameBoard Constructor

    //test case 1 - minimum size board
    @Test
    public void testConstructorMinimum() {
        int small = 3;
        IGameBoard testBoard = makeGameBoard(small, small, small);
        assertEquals(small, testBoard.getNumRows());
        assertEquals(small, testBoard.getNumColumns());
        assertEquals(small, testBoard.getNumToWin());
    }

    //test case 2 - medium size board
    @Test
    public void testConstructorMedium() {
        int row = 8;
        int col = 17;
        int win = 7;
        IGameBoard testBoard = makeGameBoard(row, col, win);
        assertEquals(row, testBoard.getNumRows());
        assertEquals(col, testBoard.getNumColumns());
        assertEquals(win, testBoard.getNumToWin());
    }
    /* @Test
    public void testCheckIfFreeSmall() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        assertTrue(testBoard.checkIfFree())
    }*/

    //test case 3 - maximum size board
    @Test
    public void testConstructorMaximum() {
        int row = 100;
        int col = 100;
        int win = 25;
        IGameBoard testBoard = makeGameBoard(row, col, win);
        assertEquals(row, testBoard.getNumRows());
        assertEquals(col, testBoard.getNumColumns());
        assertEquals(win, testBoard.getNumToWin());
    }

    // Test cases for dropToken

    // Test case 1 - 3 in a row horizontal
    @Test
    public void testDropToken2Horizontal() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int Lrow = gb.getNumRows() - 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row, col2)));
    }

    // Test case 2 - 2 in a column
    @Test
    public void testDropToken2InAColumn() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int row2 = 1;
        int Lrow = gb.getNumRows() - 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        gb.dropToken(p1, col1); // Overlapping token
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row, col2)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row2, col1)));
    }

    // Test case 3 - Multiple tokens in the same row
    @Test
    public void testDropTokenFillRow() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int row2 = 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col3);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col2)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row2, col3)));
    }

    // Test case 4 - Filling a column
    @Test
    public void testDropTokenFillColumn() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        int row1 = 0;
        int row2 = 1;
        int row3 = 2;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row1, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row2, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row3, col1)));
    }

    // Test case 5 - Filling multiple columns
    @Test
    public void testDropTokenFillBoard() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char p3 = 'A';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row1 = 0;
        int row2 = 1;
        int row3 = 2;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        gb.dropToken(p2, col2);
        gb.dropToken(p2, col2);
        gb.dropToken(p3, col3);
        gb.dropToken(p3, col3);
        gb.dropToken(p3, col3);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row1, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row2, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row3, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row1, col2)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row2, col2)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row3, col2)));
        assertEquals(p3, gb.whatsAtPos(new BoardPosition(row1, col3)));
        assertEquals(p3, gb.whatsAtPos(new BoardPosition(row2, col3)));
        assertEquals(p3, gb.whatsAtPos(new BoardPosition(row3, col3)));
    }

    // Test cases for whatsAtPos
    // Test case 1 - Single token placement
    @Test
    public void testWhatsAtPosSingleToken() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col = 0;
        gb.dropToken(p1, col);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(0, col)));
    }

    // Test case 2 - Multiple tokens from different players
    @Test
    public void testWhatsAtPosMultipleTokens() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int row = 0;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row, col2)));
    }

    // Test case 3 - Empty space between tokens
    @Test
    public void testWhatsAtPosEmptySpaceBetweenTokens() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col3);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row, col3)));
        assertEquals(empty, gb.whatsAtPos(new BoardPosition(row, col2)));
    }

    // Test case 4 - Empty spaces after token placements
    @Test
    public void testWhatsAtPosEmptySpaceAfterTokens() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p2, gb.whatsAtPos(new BoardPosition(row, col2)));
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(row, col3)));
    }

    // Test cases for isPlayerAtPos
    // Test case 1 - Single token placement
    @Test
    public void testIsPlayerAtPosSingleToken() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        gb.dropToken(p1, col1);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col1), p1));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(row, col1), p2));
    }

    // Test case 2 - Different positions for the same player
    @Test
    public void testIsPlayerAtPosEmptySpace() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int Lrow = gb.getNumRows() - 1;
        gb.dropToken(p1, 0);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col1), p1));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(col3, Lrow), p1));
    }

    // Test case 3 - Multiple players on the board
    @Test
    public void testIsPlayerAtPosMultiplePlayers() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col1), p1));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col2), p2));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(row, col1), p2));
    }

    // Test case 4 - Multiple players with overlapping positions
    @Test
    public void testIsPlayerAtPosOverlappingPositions() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int row2 = 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col1), p1));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col2), p2));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(row2, col2), p1));
    }

    // Test case 5 - Multiple players with non-overlapping positions
    @Test
    public void testIsPlayerAtPosNonOverlappingPositions() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        char empty = ' ';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        int row2 = 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p2, col2);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col1), p1));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(row, col2), p2));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(row2, col1), p2));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(row2, col2), p1));
    }

    //test cases for checkIfFree

    //test case 1 - empty board
    @Test
    public void testCheckIfFreeEmptyBoard() {
        IGameBoard gb = makeGameBoard();
        int col = 0;
        assertTrue(gb.checkIfFree(col));
    }

    // test case 2 - column partially full
    @Test
    public void testCheckIfFreeColumnPartiallyFull() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col = 0;
        gb.dropToken(p1, col);
        assertTrue(gb.checkIfFree(col));
    }

    // test case 3 - one column full
    @Test
    public void testCheckIfFreeColumnFull() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        int col2 = 1;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        assertFalse(gb.checkIfFree(col1));
        assertTrue(gb.checkIfFree(col2));
    }

    // test case 4 - board full
    @Test
    public void testCheckIfFreeBoardFull() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col3);
        gb.dropToken(p1, col3);
        gb.dropToken(p1, col3);
        assertFalse(gb.checkIfFree(col1));
        assertFalse(gb.checkIfFree(col2));
        assertFalse(gb.checkIfFree(col3));
    }

    //test cases for checkTie

    //test case 1 - empty board
    @Test
    public void testCheckTieEmptyBoard() {
        IGameBoard gb = makeGameBoard();
        assertFalse(gb.checkTie());
    }

    //test case 2 - partial board
    @Test
    public void testCheckTiePartiallyFullBoard() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        gb.dropToken(p1, col1);
        assertFalse(gb.checkTie());
    }

    //test case 3 - all but one space full
    @Test
    public void testCheckTieAlmostFullBoard() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col3);
        gb.dropToken(p1, col3);
        assertFalse(gb.checkTie());
    }

    //test case 4 - full board
    @Test
    public void testCheckTieFullBoard() {
        IGameBoard gb = makeGameBoard();
        char p1 = 'X';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col3);
        gb.dropToken(p1, col3);
        gb.dropToken(p1, col3);
        assertTrue(gb.checkTie());
    }

    // test cases for checkHorizontalWin

    // test case 1 - left to right
    @Test
    public void testHorizontalWinLeftToRight() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        int row = 0;
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p1, col3);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(row, col1), p1));
    }

    //test case 2 - right to left
    @Test
    public void testHorizontalWinRightToLeft() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        int row = 0;
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p1, col3);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(row, col3), p1));
    }

    //test case 3 - use middle position for check
    @Test
    public void testHorizontalWinMiddle() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        int row = 0;
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p1, col3);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(row, col2), p1));
    }

    //test case 4 - different num to win size
    @Test
    public void testHorizontalWinDiffSize() {
        int row = 7;
        int col = 7;
        int win = 4;
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int col4 = 3;
        int Wrow = 2;
        IGameBoard testBoard = makeGameBoard(row, col, win);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p1, col4);
        testBoard.dropToken(p1, col4);
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p1, col3);
        testBoard.dropToken(p1, col4);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(Wrow, col1), p1));
    }

    // test cases for checkVertWin

    //test case 1 - bottom to top
    @Test
    public void testVerticalWinBottomToTop() {
        IGameBoard gb = makeGameBoard();
        int row = 0;
        int col = 0;
        char p1 = 'X';
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        assertTrue(gb.checkVertWin(new BoardPosition(row,col), p1));
    }

    // test case 2 - top to bottom
    @Test
    public void testVerticalWinTopToBottom() {
        IGameBoard gb = makeGameBoard();
        int row = 2;
        int col = 0;
        char p1 = 'X';
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        assertTrue(gb.checkVertWin(new BoardPosition(row,col), p1));
    }

    //test case 3 - from middle
    @Test
    public void testVerticalWinFromMiddle() {
        IGameBoard gb = makeGameBoard();
        int row = 1;
        int col = 0;
        char p1 = 'X';
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        gb.dropToken(p1, col);
        assertTrue(gb.checkVertWin(new BoardPosition(row,col), p1));
    }

    //test case 4 - different win size
    @Test
    public void testVerticalWinDifferentWinSize() {
        int row = 7;
        int col = 7;
        int win = 4;
        IGameBoard gb = makeGameBoard(row, col, win);
        int Wrow = 0;
        int Wcol = 3;
        char p1 = 'X';
        gb.dropToken(p1, Wcol);
        gb.dropToken(p1, Wcol);
        gb.dropToken(p1, Wcol);
        gb.dropToken(p1, Wcol);
        assertTrue(gb.checkVertWin(new BoardPosition(Wrow, Wcol), p1));
    }

    //test cases for Diagonal Win

    //test case 1 - left to right and bottom to top
    @Test
    public void testDiagonalWinBottomLeftToUpperRight() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p1, col3);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col1), p1));
    }

    //test case 2 - right to left and top to bottom
    @Test
    public void testDiagonalWinUpperRightToBottomLeft() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 2;
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p1, col3);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col3), p1));
    }

    //test case 3 - right to left and bottom to top
    @Test
    public void testDiagonalWinlowerRightToUpperLeft() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        testBoard.dropToken(p1, col3);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p1, col1);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col3), p1));
    }

    //test case 4 - left to right and top to bottom
    @Test
    public void testDiagonalWinUpperLeftToLowerRight() {
        IGameBoard testBoard = makeGameBoard();
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 2;
        testBoard.dropToken(p1, col3);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p1, col1);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col1), p1));
    }

    /*
    @Test
    public void testHorizontalWinHard() {
        IGameBoard testBoard = makeGameBoard(10, 10, 7);
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
        IGameBoard testBoard = makeGameBoard(10, 10, 7);
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
        IGameBoard testBoard = makeGameBoard(4, 4, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('X', 0);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(0, 2), 'X'));
    }
    @Test
    public void testVerticalWinMedium() {
        IGameBoard testBoard = makeGameBoard(6, 6, 3);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 5);
        testBoard.dropToken('O', 5);
        assertTrue(testBoard.checkHorizWin(new BoardPosition(5, 0), 'O'));
    }
    @Test
    public void testVerticalWinHard() {
        IGameBoard testBoard = makeGameBoard(12, 12, 6);
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
        IGameBoard testBoard = makeGameBoard(100, 100, 25);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
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
        IGameBoard testBoard = makeGameBoard(10, 10, 4);
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
        IGameBoard testBoard = makeGameBoard(10, 10, 4);
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
        IGameBoard testBoard = makeGameBoard(7, 7, 4);
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
        IGameBoard testBoard = makeGameBoard(7, 7, 4);
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
        IGameBoard testBoard = makeGameBoard(25, 25, 25);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('O', 0);
        testBoard.dropToken('X', 1);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('X', 0);
        testBoard.dropToken('O', 1);
        assertFalse(testBoard.checkTie());
    }
    @Test
    public void testCheckIfTieEasy1() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        
        assertTrue(testBoard.checkTie());
    }
    @Test
    public void whatsAtPosEasy1() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        assertEquals(testBoard.whatsAtPos(0, 0), 'X');
    }
    @Test
    public void whatsAtPosEasy2() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertEquals(testBoard.whatsAtPos(2, 2), ' ');
    }
    public void whatsAtPosMedium() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertEquals(testBoard.whatsAtPos(2, 2), 'X');
    }
    public void whatsAtPosHard() {
        IGameBoard testBoard = makeGameBoard(10, 10, 10);
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 10; i++) {
                    testBoard.dropToken('O', i);
                }
            }
        assertEquals(testBoard.whatsAtPos(10, 10), 'O');
    }
    public void whatsAtPosSuperHard() {
        IGameBoard testBoard = makeGameBoard(20, 20, 10);
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
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 0);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(0, 0), 'X');
    }
    @Test
    public void isPlayerAtPosEasy2() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(2, 2), ' ');
    }
    @Test
    public void isPlayerAtPosMedium() {
        IGameBoard testBoard = makeGameBoard(3, 3, 3);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        testBoard.dropToken('X', 2);
        testBoard.dropToken('O', 2);
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(2, 2), 'X');
    }
    @Test
    public void isPlayerAtPosHard() {
        IGameBoard testBoard = makeGameBoard(10, 10, 10);
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 10; i++) {
                    testBoard.dropToken('O', i);
                }
            }
        assertTrue(testBoard.isPlayerAtPos(whatsAtPos(10, 10), 'O');
    }
    @Test
    public void isPlayerAtPosSuperHard() {
        IGameBoard testBoard = makeGameBoard(20, 20, 10);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
        assertTrue(gb.checkIfFree(0, 0));
    }

    @Test
    public void testCheckIfFreeMedium() {
        IGameBoard gb = makeGameBoard(3, 3, 3);
        gb.dropToken('X', 0);
        assertFalse(gb.checkIfFree(0, 0));
    }

    @Test
    public void testCheckIfFreeHard() {
        IGameBoard testBoard = makeGameBoard(10, 10, 10);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
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
        IGameBoard gb = makeGameBoard(3, 3, 3);
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
    */
}
