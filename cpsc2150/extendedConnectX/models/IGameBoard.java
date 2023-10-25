package cpsc2150.extendedConnectX.models;
/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

/**
 * @initialization ensures: an empty board of size Row x Column
 *
 * @defines Row: z
 * @defines Col: z
 * @defines Win: z
 *
 * @constraints Row > 0 AND Col > 0 AND [no empty spaces below a player token]
 */
public interface IGameBoard {
    /**
     * This function checks if a specified column on the gameBoard is available for placing a token
     *
     * @param c the column to check
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND win = #Win AND checkifFree = (true [if
     * the column has space for another token] OR false [if the column is full])
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
     * @param p the character representing the player
     * @param c the column to drop the token in
     *
     * @pre [board is not full]
     * @post  Col = #Col AND Row = #Row AND Win = #Win AND board = #board + [the first free spot of column c gets set to
     * player p's token]
     */
    public void dropToken(char p, int c);

    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c the column of the last placed token
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND checkForWin = (true [if
     * the last token caused someone to win] OR false [if no one won so far])
     */
    default boolean checkForWin(int c) {
        BoardPosition insert = new BoardPosition(0, c);
        char piece = ' ';
        int row = 0;
        for (int i = 0; i < getNumRows(); i++) {
            row = insert.getRow();
            if (whatsAtPos(insert) != ' ') {
                row++;
                insert = new BoardPosition(row, insert.getColumn());
            }
            else {
                insert = new BoardPosition((row - 1), insert.getColumn());
                piece = whatsAtPos(insert);
                break;
            }
            /*
            if (whatsAtPos(insert) == 'O') {
                row++;
                insert = new BoardPosition(row, insert.getColumn());
            }
            else if (whatsAtPos(insert) == 'X') {
                row++;
                insert = new BoardPosition(row, insert.getColumn());
            }
            else {
                insert = new BoardPosition(row - 1, insert.getColumn());
                piece = whatsAtPos(insert);
                break;
            }*/
        }
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
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND checkTie = (true [if the
     * board is full] OR False [if board is not full])
     */
    default boolean checkTie() {
        for (int i = 0; i < getNumColumns(); i++) {
            if (checkIfFree(i)) {
                return false;
            }
        }
        return true;
        /*
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                BoardPosition pos = new BoardPosition(i, j);
                if (whatsAtPos(pos) == ' ') {
                    return false;
                }
            }
        }
        return true;
         */
    }

    /**
     * This function checks if there are five identical pieces adjacent to the specified position in a horizontal
     * direction
     *
     * @param pos the spot of the last token dropped
     * @param p the character for the player who dropped the token
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win and checkHorizWin = (true
     * [if there are Win of the same tokens in a row horizontally] OR false [if there is not Win tokens in a row
     * horizontally])
     */
    default boolean checkHorizWin(BoardPosition pos, char p) {
        int row = pos.getRow();
        int col = pos.getColumn();
        if (row < 0 || row + 4 >= getNumRows() || col < 0 || col >= getNumColumns()) {
            return false;
        }

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

    /**
     * This function checks if there are five identical pieces adjacent to the specified position in a horizontal
     * direction
     *
     * @param pos the spot of the last token dropped
     * @param p the character for the player who dropped the token
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win and checkVertWin = (true
     * [if there are Win of the same tokens in a row vertically] OR false [if there is not Win tokens in a row
     * vertically])
     */
    default boolean checkVertWin(BoardPosition pos, char p) {
        int row = pos.getRow();
        int col = pos.getColumn();
        if (row < 0 || row + 4 >= getNumRows() || col < 0 || col >= getNumColumns()) {
            return false;
        }

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

    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a horizontal
     * direction
     *
     * @param pos the spot of the last token dropped
     * @param p the character for the player who dropped the token
     * @return true or false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win and checkHorizWin = (true
     * [if there are Win of the same tokens in a row diagonally] OR false [if there is not Win tokens in a row
     * diagonally])
     */
    default boolean checkDiagWin(BoardPosition pos, char p) {
        int row = pos.getRow();
        int col = pos.getColumn();
        if (row < 0 || row >= getNumRows() || col < 0 || col >= getNumColumns()) {
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
     * @param pos the position to check
     * @return what is at the board position pos
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND whatsAtPos = board[pos]
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * This function shows whether the selected player's token ('X' or 'O') occupies the specified position on the
     * gameboard
     *
     * @param pos the position to check for which player
     * @param player the character co check for
     * @return true OR false
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND isPlayerAtPos = (true
     * [if player matches the token in board[pos]] OR false [if the two don't match])
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player) {
        return whatsAtPos(pos) == player;
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the number of rows in the board
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumRows = Row
     */
    public int getNumRows();

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the number of cols in the board
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumColumns = Col
     */
    public int getNumColumns();

    /**
     * returns the number of tokens in a row needed to win the game
     *
     * @return the number of tokens in a row required to win
     *
     * @pre none
     * @post board = #board  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumToWin = Win
     */
    public int getNumToWin();
}
