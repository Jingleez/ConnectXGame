package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

public interface IGameBoard {
    /**
     * This function checks if a specified column on the gameBoard is availble for placing a token
     *
     * @param c
     * @return
     */
    default boolean checkIfFree(int c) {
        BoardPosition check = new BoardPosition(getNumRows() - 1, c);
        if (whatsAtPos(check) == ' ') {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This function places a token in a specific column, allowing it to drop until it collides with amother token
     *
     * @param p
     * @param c
     */
    public void dropToken(char p, int c);

    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c
     * @return
     */
    default boolean checkForWin(int c) {
    BoardPosition insert = new BoardPosition(0, c);
    char piece = ' ';
    for (int i = 0; i < getNumRows(); i++) {
        int row = insert.getRow();
        if (whatsAtPos(insert) == 'O') {
            piece = 'O';
            break;
        } else if (whatsAtPos(insert) == 'X') {
            piece = 'X';
            break;
        }
        row = insert.getRow() + 1; // Update the row separately
        insert = new BoardPosition(row, insert.getColumn());
    }
    System.out.println(insert.getRow());
    
    if (checkHorizWin(insert, piece) || checkVertWin(insert, piece) || checkDiagWin(insert, piece)) {
        return true;
    } else {
        return false;
    }
    }



    /**
     * This function checks if the game has resulted in a tie. A Game is considered tie if there are no free board
     * positions remaining. It returns true if the game is tied and false otherwise
     *
     * @return
     */
    default boolean checkTie() {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                BoardPosition pos = new BoardPosition(i, j);
                if (whatsAtPos(pos) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a horizontal
     * direction
     *
     * @param pos
     * @param p
     * @return
     */

default boolean checkHorizWin(BoardPosition pos, char p) {
    int row = pos.getRow();
    int col = pos.getColumn();
    if (row < 0 || row >= getNumRows() || col < 0 || col + 3 >= getNumColumns()) {
        return false; // Invalid indices, no win possible
    }

    BoardPosition pos1 = new BoardPosition(row, col);
    BoardPosition pos2 = new BoardPosition(row + 1, col);
    BoardPosition pos3 = new BoardPosition(row + 2, col);
    BoardPosition pos4 = new BoardPosition(row + 3, col);
    BoardPosition pos5 = new BoardPosition(row - 1, col);
    BoardPosition pos6 = new BoardPosition(row - 2, col);
    BoardPosition pos7 = new BoardPosition(row - 3, col);
    if ((whatsAtPos(pos1) == p) && (whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p)) {
        return true;
    } else if ((whatsAtPos(pos1) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p)) {
        return true;
    } else {
        return false;
    }
}

default boolean checkVertWin(BoardPosition pos, char p) {
    int row = pos.getRow();
    int col = pos.getColumn();
    if (row < 0 || row + 3 >= getNumRows() || col < 0 || col >= getNumColumns()) {
        return false; // Invalid indices, no win possible
    }
    /*
    System.out.println(Board[row][col]);
    System.out.println(Board[row+1][col]);
    System.out.println(Board[row+2][col]);
    System.out.println(Board[row+3][col]);
     */
    BoardPosition pos1 = new BoardPosition(row, col);
    BoardPosition pos2 = new BoardPosition(row + 1, col);
    BoardPosition pos3 = new BoardPosition(row + 2, col);
    BoardPosition pos4 = new BoardPosition(row + 3, col);
    BoardPosition pos5 = new BoardPosition(row - 1, col);
    BoardPosition pos6 = new BoardPosition(row - 2, col);
    BoardPosition pos7 = new BoardPosition(row - 3, col);
    if ((Board[row][col] == p) && (Board[row + 1][col] == p) && (Board[row + 2][col] == p) && (Board[row + 3][col] == p)) {
        return true;
    } else {
        return false;
    }
}

default boolean checkDiagWin(BoardPosition pos, char p) {
    int row = pos.getRow();
    int col = pos.getColumn();
    if (row < 0 || row >= getNumRows() || col < 0 || col + 3 >= getNumColumns()) {
        return false; // Invalid indices, no win possible
    }

    BoardPosition pos1 = new BoardPosition(row, col);
    BoardPosition pos2 = new BoardPosition(row + 1, col);
    BoardPosition pos3 = new BoardPosition(row + 2, col);
    BoardPosition pos4 = new BoardPosition(row + 3, col);
    BoardPosition pos5 = new BoardPosition(row - 1, col);
    BoardPosition pos6 = new BoardPosition(row - 2, col);
    BoardPosition pos7 = new BoardPosition(row - 3, col);
    if ((Board[row][col] == p) && (Board[row + 1][col + 1] == p) && (Board[row + 2][col + 2] == p) && (Board[row + 3][col + 3] == p)) {
        return true;
    } else if ((Board[row][col] == p) && (Board[row - 1][col - 1] == p) && (Board[row - 2][col - 2] == p) && (Board[row - 3][col - 3] == p)) {
        return true;
    } else if ((Board[row][col] == p) && (Board[row - 1][col + 1] == p) && (Board[row - 2][col + 2] == p) && (Board[row - 3][col + 3] == p)) {
        return true;
    } else if ((Board[row][col] == p) && (Board[row + 1][col - 1] == p) && (Board[row + 2][col - 2] == p) && (Board[row + 3][col - 3] == p)) {
        return true;
    } else {
        return false;
    }
}







    /**
     * This function retrieves a character from at a specified boardPosition on the game board
     *
     * @param pos
     * @return
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * This function decides whether the selected player's token ('X' or 'O') occupies the specified position on the
     * gameboard
     *
     * @param pos
     * @param player
     * @return
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player) {
        return whatsAtPos(pos) == player;
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return
     */
    public int getNumRows();

    /**
     * returns the number of columns in the GameBoard
     *
     * @return
     */
    public int getNumColumns();

    /**
     * returns the number of tokens in a row needed to win the game
     *
     * @return
     */
    public int getNumToWin();
}
