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

    private String buildBoard(int r, int c) {
        StringBuilder boardString = new StringBuilder(); // Create a StringBuilder for the string representation.
        // Before going to next row, adding a newline first
        boardString.append("|");
        for (int col=0; col < c; col++) {
            //for (int row = 0; row < getNumRows(); row++) {
            if (col < 10) {
                //if (row < 10) {
                boardString.append(" ");
            }
            boardString.append(col + "|");
            //boardString.append(row + "|");
        }
        boardString.append("\n");
        // This loop adds row labels and board contents
        for (int row = r - 1; row > -1; row--) {
            //for (int col = getNumColumns() - 1; col > -1; col--) {
            for (int col = 0; col < c; col++) {
                //for (int row = 0; row < getNumRows(); row++) {
                BoardPosition pos = new BoardPosition(row, col);
                boardString.append("|" +"  "); // Appending contents of cell
            }
            boardString.append("|");
            // Before going to next row, adding a newline first
            boardString.append("\n");
        }
        // This converts the StringBuilder to a string and returns the final string representing the board.
        return boardString.toString();
    }

    //test cases for GameBoard Constructor

    //test case 1 - minimum size board
    @Test
    public void testConstructorMinimum() {
        int small = 3;
        String expBoard = buildBoard(small, small);
        IGameBoard testBoard = makeGameBoard(small, small, small);
        assertEquals(small, testBoard.getNumRows());
        assertEquals(small, testBoard.getNumColumns());
        assertEquals(small, testBoard.getNumToWin());
        assertEquals(expBoard, testBoard.toString());
    }

    //test case 2 - medium size board
    @Test
    public void testConstructorMedium() {
        int row = 8;
        int col = 17;
        int win = 7;
        String expBoard = buildBoard(row, col);
        IGameBoard testBoard = makeGameBoard(row, col, win);
        assertEquals(row, testBoard.getNumRows());
        assertEquals(col, testBoard.getNumColumns());
        assertEquals(win, testBoard.getNumToWin());
        assertEquals(expBoard, testBoard.toString());
    }

    //test case 3 - maximum size board
    @Test
    public void testConstructorMaximum() {
        int row = 100;
        int col = 100;
        int win = 25;
        String expBoard = buildBoard(row, col);
        IGameBoard testBoard = makeGameBoard(row, col, win);
        assertEquals(row, testBoard.getNumRows());
        assertEquals(col, testBoard.getNumColumns());
        assertEquals(win, testBoard.getNumToWin());
        assertEquals(expBoard, testBoard.toString());
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
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 0;
        gb.dropToken(p1, col1);
        gb.dropToken(p1, col2);
        gb.dropToken(p1, col3);
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col1)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col2)));
        assertEquals(p1, gb.whatsAtPos(new BoardPosition(row, col3)));
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
        assertTrue(gb.checkVertWin(new BoardPosition(row, col), p1));
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
        assertTrue(gb.checkVertWin(new BoardPosition(row, col), p1));
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
        assertTrue(gb.checkVertWin(new BoardPosition(row, col), p1));
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

    //test case 5 -
    @Test
    public void testDiagonalWinMedium1() {
        int rows = 10;
        int cols = 10;
        int win = 4;
        char p1 = 'X';
        char p2 = 'O';
        int col4 = 3;
        int col5 = 4;
        int col6 = 5;
        int col7 = 6;
        int row = 6;
        IGameBoard testBoard = makeGameBoard(rows, cols, win);
        for (int j = 0; j < win; j++) {
            for (int i = 0; i < rows; i++) {
                testBoard.dropToken(p1, i);
            }
        }
        testBoard.dropToken(p1, col4);
        testBoard.dropToken(p1, col4);
        testBoard.dropToken(p1, col4);
        testBoard.dropToken(p2, col4);
        testBoard.dropToken(p2, col5);
        testBoard.dropToken(p1, col5);
        testBoard.dropToken(p2, col5);
        testBoard.dropToken(p1, col6);
        testBoard.dropToken(p2, col6);
        testBoard.dropToken(p2, col7);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col5), p2));
    }

    //test case 6 -
    @Test
    public void testDiagonalWinfalse() {
        int rows = 7;
        int cols = 7;
        int win = 4;
        char p1 = 'X';
        char p2 = 'O';
        int col1 = 0;
        int col2 = 1;
        int col3 = 2;
        int row = 1;
        IGameBoard testBoard = makeGameBoard(rows, cols, win);
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col3);
        testBoard.dropToken(p2, col1);
        testBoard.dropToken(p1, col2);
        testBoard.dropToken(p2, col3);
        testBoard.dropToken(p1, col1);
        testBoard.dropToken(p2, col2);
        testBoard.dropToken(p1, col3);
        assertFalse(testBoard.checkDiagWin(new BoardPosition(row, col2), p1));
    }

    //test case 7 -
    @Test
    public void testDiagonalWinMedium2() {
        int rows = 10;
        int cols = 10;
        int win = 4;
        char p1 = 'X';
        char p2 = 'O';
        int col10 = 9;
        int col9 = 8;
        int col8 = 7;
        int col7 = 6;
        int row = 4;
        IGameBoard testBoard = makeGameBoard(rows, cols, win);
        for (int j = 0; j < win; j++) {
            for (int i = 0; i < rows; i++) {
                testBoard.dropToken(p1, i);
            }
        }
        testBoard.dropToken(p1, col10);
        testBoard.dropToken(p1, col10);
        testBoard.dropToken(p1, col10);
        testBoard.dropToken(p2, col10);
        testBoard.dropToken(p1, col9);
        testBoard.dropToken(p1, col9);
        testBoard.dropToken(p2, col9);
        testBoard.dropToken(p1, col8);
        testBoard.dropToken(p2, col8);
        testBoard.dropToken(p2, col7);
        assertTrue(testBoard.checkDiagWin(new BoardPosition(row, col7), p2));
    }
}
