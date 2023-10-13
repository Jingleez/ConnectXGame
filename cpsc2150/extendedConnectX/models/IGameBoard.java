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
    if (row < 0 || row + 4 >= getNumRows() || col < 0 || col >= getNumColumns()) {
        return false;
    }
    /*
    System.out.println(Board[row][col]);
    System.out.println(Board[row+1][col]);
    System.out.println(Board[row+2][col]);
    System.out.println(Board[row+3][col]);
     */
    BoardPosition pos1 = new BoardPosition(row, col - 4);
    BoardPosition pos2 = new BoardPosition(row, col - 3);
    BoardPosition pos3 = new BoardPosition(row, col - 2);
    BoardPosition pos4 = new BoardPosition(row, col - 1);
    BoardPosition pos5 = new BoardPosition(row, col);
    BoardPosition pos6 = new BoardPosition(row, col + 1);
    BoardPosition pos7 = new BoardPosition(row, col + 2);
    BoardPosition pos8 = new BoardPosition(row, col + 3);
    BoardPosition pos9 = new BoardPosition(row, col + 4);
    if ((whatsAtPos(pos1) == p) && (whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p)) {
        return true;
    }
    else if ((whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p) && (whatsAtPos(pos9) == p)) {
        return true;
    } 
    else {
        return false;
    }
}

default boolean checkVertWin(BoardPosition pos, char p) {
    int row = pos.getRow();
    int col = pos.getColumn();
    if (row < 0 || row + 4 >= getNumRows() || col < 0 || col >= getNumColumns()) {
        return false;
    }
    /*
    System.out.println(Board[row][col]);
    System.out.println(Board[row+1][col]);
    System.out.println(Board[row+2][col]);
    System.out.println(Board[row+3][col]);
     */
    BoardPosition pos1 = new BoardPosition(row - 4, col);
    BoardPosition pos2 = new BoardPosition(row - 3, col);
    BoardPosition pos3 = new BoardPosition(row - 2, col);
    BoardPosition pos4 = new BoardPosition(row - 1, col);
    BoardPosition pos5 = new BoardPosition(row, col);
    BoardPosition pos6 = new BoardPosition(row + 1, col);
    BoardPosition pos7 = new BoardPosition(row + 2, col);
    BoardPosition pos8 = new BoardPosition(row + 3, col);
    BoardPosition pos9 = new BoardPosition(row + 4, col);
    if ((whatsAtPos(pos1) == p) && (whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p)) {
        return true;
    }
    else if ((whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p) && (whatsAtPos(pos9) == p)) {
        return true;
    } 
    else {
        return false;
    }
}

default boolean checkDiagWin(BoardPosition pos, char p) {
    int row = pos.getRow();
    int col = pos.getColumn();
    if (row < 0 || row + 4 >= getNumRows() || col < 0 || col + 4 >= getNumColumns()) {
        return false; 
    }
    BoardPosition pos1 = new BoardPosition(row - 4, col - 4);
    BoardPosition pos2 = new BoardPosition(row - 3, col - 3);
    BoardPosition pos3 = new BoardPosition(row - 2, col - 2);
    BoardPosition pos4 = new BoardPosition(row - 1, col - 1);
    BoardPosition pos5 = new BoardPosition(row, col);
    BoardPosition pos6 = new BoardPosition(row + 1, col + 1);
    BoardPosition pos7 = new BoardPosition(row + 2, col + 2);
    BoardPosition pos8 = new BoardPosition(row + 3, col + 3);
    BoardPosition pos9 = new BoardPosition(row + 4, col + 4);
    BoardPosition pos10 = new BoardPosition(row - 4, col + 4);
    BoardPosition pos11 = new BoardPosition(row - 3, col + 3);
    BoardPosition pos12 = new BoardPosition(row - 2, col + 2);
    BoardPosition pos13 = new BoardPosition(row - 1, col + 1);
    BoardPosition pos14 = new BoardPosition(row + 1, col - 1);
    BoardPosition pos15 = new BoardPosition(row + 2, col - 2);
    BoardPosition pos16 = new BoardPosition(row + 3, col - 3);
    BoardPosition pos17 = new BoardPosition(row + 4, col - 4);
    if ((whatsAtPos(pos1) == p) && (whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos2) == p) && (whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos3) == p) && (whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p)) {
        return true;
    }
    else if ((whatsAtPos(pos4) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos5) == p) && (whatsAtPos(pos6) == p) && (whatsAtPos(pos7) == p) && (whatsAtPos(pos8) == p) && (whatsAtPos(pos9) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos10) == p) && (whatsAtPos(pos11) == p) && (whatsAtPos(pos12) == p) && (whatsAtPos(pos13) == p) && (whatsAtPos(pos5) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos11) == p) && (whatsAtPos(pos12) == p) && (whatsAtPos(pos13) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos14) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos12) == p) && (whatsAtPos(pos13) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos14) == p) && (whatsAtPos(pos15) == p)) {
        return true;
    }
    else if ((whatsAtPos(pos13) == p) && (whatsAtPos(pos5) == p) && (whatsAtPos(pos14) == p) && (whatsAtPos(pos15) == p) && (whatsAtPos(pos16) == p)) {
        return true;
    } 
    else if ((whatsAtPos(pos5) == p) && (whatsAtPos(pos14) == p) && (whatsAtPos(pos15) == p) && (whatsAtPos(pos16) == p) && (whatsAtPos(pos17) == p)) {
        return true;
    } 
    else {
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
