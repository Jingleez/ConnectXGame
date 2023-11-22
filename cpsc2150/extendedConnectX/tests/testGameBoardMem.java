package cpsc2150.extendedConnectX.tests;

import cpsc2150.extendedConnectX.models.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class testGameBoardMem {

    private IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
        return new GameBoardMem(numRows, numColumns, numToWin);
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

    /*
    public class GameBoardFactory {
        public IGameBoard makeGameBoard(int numRows, int numColumns, int numToWin) {
            return new GameBoardMem(numRows, numColumns, numToWin);
        }
        public IGameBoard makeGameBoard() {
            return new GameBoardMem(SMALL, SMALL, SMALL);
        }
    }
    private static final int SMALL = 3;
    GameBoardFactory factory1 = new GameBoardFactory();

    // Test cases for constructor

    // Test case 1 - Check constructor with valid parameters
    @Test
    public void testConstructorCase1() {
        IGameBoard gb = factory1.makeGameBoard();
        assertNotNull(gb);
        assertEquals(SMALL, gb.getNumRows());
        assertEquals(SMALL, gb.getNumColumns());
        assertEquals(SMALL, gb.getNumToWin());
    }

    // Test case 2 - Check constructor with larger grid and win condition
    @Test
    public void testConstructorCase2() {
        int med = 5;
        int win = 4;
        IGameBoard gb = factory1.makeGameBoard(med, med, win);
        assertNotNull(gb);
        assertEquals(med, gb.getNumRows());
        assertEquals(med, gb.getNumColumns());
        assertEquals(win, gb.getNumToWin());
    }

    // Test case 3 - Check constructor with minimum values
    @Test
    public void testConstructorCase3() {
        IGameBoard gb = factory1.makeGameBoard(1, 1, 1);
        assertNotNull(gb);
        assertEquals(1, gb.getNumRows());
        assertEquals(1, gb.getNumColumns());
        assertEquals(1, gb.getNumToWin());
    }


    // Test case for checkIfFree
// Test case 1 - Check if a position is free
    @Test
    public void testCheckIfFreeCase1() {
        IGameBoard gb = factory1.makeGameBoard();
        assertTrue(gb.checkIfFree(0));
    }

    // Test case 2 - Check if a position is not free after dropping a token
    @Test
    public void testCheckIfFreeCase2() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        assertFalse(gb.checkIfFree(0));
    }

    // Test case 3 - Check if a position is free after dropping tokens in other positions
    @Test
    public void testCheckIfFreeCase3() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 1);
        gb.dropToken('O', 2);
        assertTrue(gb.checkIfFree(0));
    }

    // Test case for checkHorizWin
// Test case 1 - Horizontal win in the first row
    @Test
    public void testCheckHorizWinCase1() {
        IGameBoard gb = factory1.makeGameBoard();
        char p1 = 'X';
        //char p2 = 'O';
        BoardPosition win = new BoardPosition(0, 2);
        gb.dropToken(p1, 0);
        gb.dropToken(p1, 1);
        gb.dropToken(p1, 2);
        //gb.dropToken(p2, 1);
        //gb.dropToken(p1, 1);
        //gb.dropToken(p2, 2);
        //gb.dropToken(p1, 2);

        assertTrue(gb.checkHorizWin(win, p1));
    }

    // Test case 2 - Horizontal win in the middle row
    @Test
    public void testCheckHorizWinCase2() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 1);
        gb.dropToken('O', 0);
        gb.dropToken('X', 2);
        gb.dropToken('O', 1);
        gb.dropToken('X', 0);
        assertTrue(gb.checkHorizWin());
    }

    // Test case 3 - No horizontal win in a larger board
    @Test
    public void testCheckHorizWinCase3() {
        IGameBoard gb = factory1.makeGameBoard(4, 4, 3);
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        gb.dropToken('X', 1);
        gb.dropToken('O', 2);
        gb.dropToken('X', 2);
        assertFalse(gb.checkHorizWin());
    }

    // Test case 4 - Horizontal win in the last row
    @Test
    public void testCheckHorizWinCase4() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        gb.dropToken('X', 1);
        gb.dropToken('O', 2);
        gb.dropToken('X', 0);
        assertTrue(gb.checkHorizWin());
    }


    // Test case for checkVertWin
// Test case 1 - Vertical win in the first column
    @Test
    public void testCheckVertWinCase1() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        gb.dropToken('X', 0);
        gb.dropToken('O', 2);
        gb.dropToken('X', 0);
        assertTrue(gb.checkVertWin());
    }

    // Test case 2 - Vertical win in the middle column
    @Test
    public void testCheckVertWinCase2() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 1);
        gb.dropToken('O', 0);
        gb.dropToken('X', 1);
        gb.dropToken('O', 2);
        gb.dropToken('X', 1);
        assertTrue(gb.checkVertWin());
    }

    // Test case 3 - No vertical win in a larger board
    @Test
    public void testCheckVertWinCase3() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        gb.dropToken('X', 0);
        gb.dropToken('O', 2);
        gb.dropToken('X', 0);
        assertFalse(gb.checkVertWin());
    }

    // Test case 4 - Vertical win in the last column
    @Test
    public void testCheckVertWinCase4() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 2);
        gb.dropToken('O', 1);
        gb.dropToken('X', 2);
        gb.dropToken('O', 2);
        gb.dropToken('X', 2);
        assertTrue(gb.checkVertWin());
    }

    //TEST CASES FOR CHECKDIAGWIN FUNCTION
  
    @Test
    public void testCheckDiagWin_leftToRight() {
        IGameBoard gb = factory.makeGameBoard(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);
        
        gb.placeToken('X',0);
        egb[0][0] = 'X';
        gb.placeToken('O',1);
        egb[0][1] = 'O';
        gb.placeToken('X',1);
        egb[1][1] = 'X';
        gb.placeToken('O',2);
        egb[0][2] = 'O';
        gb.placeToken('X',2);
        egb[1][2] = 'X';
        gb.placeToken('X',2);
        egb[2][2] = 'X';

        assertEquals(gb.checkDiagWin(2,2,'X'),true);
    }

    @Test
    public void testCheckDiagWin_rightToLeft() {
        IGameBoard gb = factory.makeStack(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('X',2);
        egb[0][2] = 'X';
        gb.placeToken('O',1);
        egb[0][1] = 'O';
        gb.placeToken('X',1);
        egb[1][1] = 'X';
        gb.placeToken('O',0);
        egb[0][0] = 'O';
        gb.placeToken('X',0);
        egb[1][0] = 'X';
        gb.placeToken('X',0);
        egb[2][0] = 'X';

        assertEquals(gb.checkDiagWin(2,0,'X'),true);
    }

    @Test
    public void testCheckDiagWin_horizontal() {
        IGameBoard gb = factory.makeStack(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('X',0);
        egb[0][0] = 'X';
        gb.placeToken('X',1);
        egb[0][1] = 'X';
        gb.placeToken('X',2);
        egb[0][2] = 'X';

        assertEquals(gb.checkDiagWin(0,2,'X'),false);
    }

    @Test
    public void testCheckDiagWinCase_middle() {
        IGameBoard gb = factory.makeStack(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('X',1);
        egb[0][1] = 'X';
        gb.placeToken('O',2);
        egb[0][2] = 'O';
        gb.placeToken('X',2);
        egb[1][2] = 'X';
        gb.placeToken('O',3);
        egb[0][3] = 'O';
        gb.placeToken('X',3);
        egb[1][3] = 'X';
        gb.placeToken('X',3);
        egb[2][3] = 'X';

        assertEquals(gb.checkDiagWin(2,3,'X'),true);
    }

    
    //TEST CASES FOR CHECKTIE FUNCTION
    
    @Test
    public void testCheckTie1() {
        IGameBoard gb = factory1.makeGameBoard(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);
        
        gb.placeToken('X',1);
        egb[0][1] = 'X';
        gb.placeToken('O',2);
        egb[0][2] = 'O';
        gb.placeToken('X',1);
        egb[1][1] = 'X';
        gb.placeToken('O',1);
        egb[2][1] = 'O';
        gb.placeToken('X',2);
        egb[1][2] = 'X';
        gb.placeToken('O',3);
        egb[0][3] = 'O';
        gb.placeToken('X',3);
        egb[1][3] = 'X';

        assertEquals(gb.checkTie(), false);
    }

    @Test
    public void testCheckTie2() {
        IGameBoard gb = factory1.makeGameBoard(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('O',0);
        egb[0][0] = 'O';
        gb.placeToken('O',1);
        egb[0][1] = 'O';
        gb.placeToken('O',2);
        egb[0][2] = 'O';
        gb.placeToken('O',0);
        egb[1][0] = 'O';
        gb.placeToken('O',1);
        egb[1][1] = 'O';
        gb.placeToken('O',2);
        egb[1][2] = 'O';
        gb.placeToken('O',0);
        egb[2][0] = 'O';
        gb.placeToken('O',1);
        egb[2][1] = 'O';
        gb.placeToken('O',2);
        egb[2][2] = 'O';
        gb.placeToken('X',0);
        egb[3][0] = 'X';
        gb.placeToken('X',1);
        egb[3][1] = 'X';
        gb.placeToken('X',2);
        egb[3][2] = 'X';
        gb.placeToken('O',3);
        egb[0][3] = 'O';
        gb.placeToken('O',4);
        egb[0][4] = 'O';
        gb.placeToken('O',5);
        egb[0][5] = 'O';
        gb.placeToken('O',3);
        egb[1][3] = 'O';
        gb.placeToken('O',4);
        egb[1][4] = 'O';
        gb.placeToken('O',5);
        egb[1][5] = 'O';
        gb.placeToken('O',3);
        egb[2][3] = 'O';
        gb.placeToken('O',4);
        egb[2][4] = 'O';
        gb.placeToken('O',5);
        egb[2][5] = 'O';
        gb.placeToken('X',3);
        egb[3][3] = 'X';
        gb.placeToken('X',4);
        egb[3][4] = 'X';
        gb.placeToken('X',5);
        egb[3][5] = 'X';
        
        assertEquals(gb.checkTie(),true);
    }

    @Test
    public void testCheckTie3() {
        IGameBoard gb = factory.makeStack(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('X',5);
        egb[0][5] = 'X';
        gb.placeToken('O',5);
        egb[1][5] = 'O';
        gb.placeToken('O',5);
        egb[2][5] = 'O';
        gb.placeToken('O',5);
        egb[3][5] = 'O';

        assertEquals(gb.checkTie(),false);
    }

    @Test
    public void testCheckTie4() {
        IGameBoard gb = factory.makeStack(4,6,3);
        char[][] egb = makeExpectedBoard(4,6);

        gb.placeToken('X',0);
        egb[0][0] = 'X';
        gb.placeToken('X',1);
        egb[0][1] = 'X';
        gb.placeToken('X',2);
        egb[0][2] = 'X';
        gb.placeToken('X',3);
        egb[0][3] = 'X';
        gb.placeToken('X',4);
        egb[0][4] = 'X';
        gb.placeToken('X',5);
        egb[0][5] = 'X';

        assertEquals(gb.checkTie(),false);
    }


    // Test case for whatsAtPos
// Test case 1 - Single token placement
    @Test
    public void testWhatsAtPosSingleToken() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
    }

    // Test case 2 - Multiple tokens from different players
    @Test
    public void testWhatsAtPosMultipleTokens() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
    }

    // Test case 3 - Empty space between tokens
    @Test
    public void testWhatsAtPosEmptySpaceBetweenTokens() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(1, 1)));
    }

    // Test case 4 - Empty spaces after token placements
    @Test
    public void testWhatsAtPosEmptySpacesAfterTokens() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(1, 1)));
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(2, 2)));
    }

    // Test case 5 - Empty board
    @Test
    public void testWhatsAtPosEmptyBoard() {
        IGameBoard gb = factory1.makeGameBoard();
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(1, 1)));
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(2, 2)));
    }


    // Test case for isPlayerAtPos
// Test case 1 - Single token placement
    @Test
    public void testIsPlayerAtPosSingleToken() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(0, 0), 'O'));
    }

    // Test case 2 - Different positions for the same player
    @Test
    public void testIsPlayerAtPosDifferentPositions() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 0), 'X'));
    }

    // Test case 3 - Multiple players on the board
    @Test
    public void testIsPlayerAtPosMultiplePlayers() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 1), 'O'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(0, 0), 'O'));
    }

    // Test case 4 - Multiple players with overlapping positions
    @Test
    public void testIsPlayerAtPosOverlappingPositions() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 1), 'O'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 1), 'X'));
    }

    // Test case 5 - Multiple players with non-overlapping positions
    @Test
    public void testIsPlayerAtPosNonOverlappingPositions() {
        IGameBoard gb = factory1.makeGameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 1);
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
        assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 1), 'O'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 0), 'O'));
        assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 1), 'X'));
    }


    // Test case for isPlayerAtPos
// Test case 1 - Normal token placement
    @Test
    public void testDropTokenNormalPlacement() {
        IGameBoard gb = factory1.makeGameBoard();
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

    // Test case 2 - Overlapping tokens
    @Test
    public void testDropTokenOverlappingTokens() {
        IGameBoard gb = factory1.makeGameBoard();
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

    // Test case 3 - Multiple tokens in the same column
    @Test
    public void testDropTokenMultipleInColumn() {
        IGameBoard gb = factory1.makeGameBoard();
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

    // Test case 4 - Filling a column
    @Test
    public void testDropTokenFillColumn() {
        IGameBoard gb = factory1.makeGameBoard();
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

    // Test case 5 - Filling multiple columns
    @Test
    public void testDropTokenFillMultipleColumns() {
        IGameBoard gb = factory1.makeGameBoard();
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
    }*/
}
