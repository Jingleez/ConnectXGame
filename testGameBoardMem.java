import cpsc2150.extendedConnectX.models.IGameBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardMemTester {
      private IGameBoard makeGameBoard(int row, int col, int win) {
        return new GameBoardMem(row, col, win);
    }

// Test cases for constructor 

// Test case 1 - Check constructor with valid parameters
@Test
public void testConstructorCase1() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    assertNotNull(gb);
    assertEquals(3, gb.getNumRows());
    assertEquals(3, gb.getNumColumns());
    assertEquals(3, gb.getNumToWin());
}

// Test case 2 - Check constructor with larger grid and win condition
@Test
public void testConstructorCase2() {
    IGameBoard gb = makeGameBoard(5, 5, 4);
    assertNotNull(gb);
    assertEquals(5, gb.getNumRows());
    assertEquals(5, gb.getNumColumns());
    assertEquals(4, gb.getNumToWin());
}

// Test case 3 - Check constructor with minimum values
@Test
public void testConstructorCase3() {
    IGameBoard gb = makeGameBoard(1, 1, 1);
    assertNotNull(gb);
    assertEquals(1, gb.getNumRows());
    assertEquals(1, gb.getNumColumns());
    assertEquals(1, gb.getNumToWin());
}


// Test case for checkIfFree
// Test case 1 - Check if a position is free
@Test
public void testCheckIfFreeCase1() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    assertTrue(gb.checkIfFree(0, 0));
}

// Test case 2 - Check if a position is not free after dropping a token
@Test
public void testCheckIfFreeCase2() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    assertFalse(gb.checkIfFree(0, 0));
}

// Test case 3 - Check if a position is free after dropping tokens in other positions
@Test
public void testCheckIfFreeCase3() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    assertTrue(gb.checkIfFree(0, 0));
}

// Test case for checkHorizWin
// Test case 1 - Horizontal win in the first row
@Test
public void testCheckHorizWinCase1() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertTrue(gb.checkHorizWin());
}

// Test case 2 - Horizontal win in the middle row
@Test
public void testCheckHorizWinCase2() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
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
    IGameBoard gb = makeGameBoard(4, 4, 3);
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
    IGameBoard gb = makeGameBoard(3, 3, 3);
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
    IGameBoard gb = makeGameBoard(3, 3, 3);
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
    IGameBoard gb = makeGameBoard(3, 3, 3);
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
    IGameBoard gb = makeGameBoard(4, 4, 3);
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
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 2);
    gb.dropToken('O', 1);
    gb.dropToken('X', 2);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertTrue(gb.checkVertWin());
}    

// Test case for checkDiagWin
// Test case 1 - Diagonal from top-left to bottom-right with a win
@Test
public void testCheckDiagWinCase1() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertTrue(gb.checkDiagWin());
}

// Test case 2 - Diagonal from top-right to bottom-left with a win
@Test
public void testCheckDiagWinCase2() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 2);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 0);
    assertTrue(gb.checkDiagWin());
}

// Test case 3 - Diagonal from top-left to bottom-right without a win
@Test
public void testCheckDiagWinCase3() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    assertFalse(gb.checkDiagWin());
}

// Test case 4 - Diagonal from top-right to bottom-left without a win
@Test
public void testCheckDiagWinCase4() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 2);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    assertFalse(gb.checkDiagWin());
}

// Test case 5 - Diagonal from top-left to bottom-right with a win on a larger board
@Test
public void testCheckDiagWinCase5() {
    IGameBoard gb = makeGameBoard(4, 4, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    gb.dropToken('O', 2);
    assertTrue(gb.checkDiagWin());
}

// Test case 6 - Diagonal from top-left to bottom-right without a win on a larger board
@Test
public void testCheckDiagWinCase6() {
    IGameBoard gb = makeGameBoard(4, 4, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertFalse(gb.checkDiagWin());
}

// Test case 7 - Diagonal from top-right to bottom-left with a win on a larger board
@Test
public void testCheckDiagWinCase7() {
    IGameBoard gb = makeGameBoard(4, 4, 3);
    gb.dropToken('X', 3);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 1);
    assertTrue(gb.checkDiagWin());
}

  
// Test case for checkTie
// Test case 1 - No tie, game in progress
@Test
public void testCheckTieNoTie() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 2);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertFalse(gb.checkTie());
}

// Test case 2 - No tie, game in progress
@Test
public void testCheckTieNoTieInProgress() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    assertFalse(gb.checkTie());
}

// Test case 3 - Tie, board filled without a win
@Test
public void testCheckTieTie() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    gb.dropToken('X', 2);
    gb.dropToken('O', 2);
    assertTrue(gb.checkTie());
}

// Test case 4 - No tie, game in progress
@Test
public void testCheckTieNoTieInProgress2() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    gb.dropToken('X', 1);
    gb.dropToken('O', 2);
    assertFalse(gb.checkTie());
}


// Test case for whatsAtPos
// Test case 1 - Single token placement
@Test
public void testWhatsAtPosSingleToken() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
}

// Test case 2 - Multiple tokens from different players
@Test
public void testWhatsAtPosMultipleTokens() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
    assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
}

// Test case 3 - Empty space between tokens
@Test
public void testWhatsAtPosEmptySpaceBetweenTokens() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
    assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 1)));
    assertEquals(' ', gb.whatsAtPos(new BoardPosition(1, 1)));
}

// Test case 4 - Empty spaces after token placements
@Test
public void testWhatsAtPosEmptySpacesAfterTokens() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
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
    IGameBoard gb = makeGameBoard(3, 3, 3);
    assertEquals(' ', gb.whatsAtPos(new BoardPosition(1, 1)));
    assertEquals(' ', gb.whatsAtPos(new BoardPosition(2, 2)));
}



// Test case for isPlayerAtPos
// Test case 1 - Single token placement
@Test
public void testIsPlayerAtPosSingleToken() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
    assertFalse(gb.isPlayerAtPos(new BoardPosition(0, 0), 'O'));
}

// Test case 2 - Different positions for the same player
@Test
public void testIsPlayerAtPosDifferentPositions() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
    assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 0), 'X'));
}

// Test case 3 - Multiple players on the board
@Test
public void testIsPlayerAtPosMultiplePlayers() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 1), 'O'));
    assertFalse(gb.isPlayerAtPos(new BoardPosition(0, 0), 'O'));
}

// Test case 4 - Multiple players with overlapping positions
@Test
public void testIsPlayerAtPosOverlappingPositions() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
    gb.dropToken('X', 0);
    gb.dropToken('O', 1);
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 0), 'X'));
    assertTrue(gb.isPlayerAtPos(new BoardPosition(0, 1), 'O'));
    assertFalse(gb.isPlayerAtPos(new BoardPosition(1, 1), 'X'));
}

// Test case 5 - Multiple players with non-overlapping positions
@Test
public void testIsPlayerAtPosNonOverlappingPositions() {
    IGameBoard gb = makeGameBoard(3, 3, 3);
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

// Test case 2 - Overlapping tokens
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

// Test case 3 - Multiple tokens in the same column
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

// Test case 4 - Filling a column
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

// Test case 5 - Filling multiple columns
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
