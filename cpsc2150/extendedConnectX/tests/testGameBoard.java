package cpsc2150.extendedConnectX.tests;

import cpsc2150.extendedConnectX.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class testGameBoard {

    private IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
            return new GameBoard(numRows, numColumns, numToWin);
    }
    private IGameBoard makeGameBoard() {
            return new GameBoard(SMALL, SMALL, SMALL);
    }
    private final int SMALL = 3;

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
    public void testHorizontalWinMedium() {
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
}