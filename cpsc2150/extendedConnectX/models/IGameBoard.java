package cpsc2150.extendedConnectX.models;
/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

/**
 * @initialization ensures: a game board of size Row x Column initialized to empty characters
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND win = #Win AND
     * [checkIfFree calls function whatsAtPos(BoardPosition)] AND checkIfFree = (true [if
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
     * This function places a token in a specific column, allowing it to drop until it collides with another token
     *
     * @param p the character representing the player
     * @param c the column to drop the token in
     *
     * @pre ["column" c is not "full"]
     * @post  Col = #Col AND Row = #Row AND Win = #Win AND self = #self + [the first free spot of "column" c gets set to
     * player p's token]
     */
    public void dropToken(char p, int c);

    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c the column of the last placed token
     * @return true or false
     *
     * @pre [the game board can not be empty]
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND checkForWin = (true [if
     * the last token caused someone to win] OR false [if no one won so far])
     */
    default boolean checkForWin(int c) {
        BoardPosition insert = new BoardPosition(0, c);
        char piece = ' ';
        int row = 0;
        if (checkIfFree(c)) {
            for (int i = 0; i < getNumRows(); i++) {
                row = insert.getRow();
                if (whatsAtPos(insert) != ' ') {
                    row++;
                    insert = new BoardPosition(row, insert.getColumn());
                } else {
                    insert = new BoardPosition((row - 1), insert.getColumn());
                    piece = whatsAtPos(insert);
                    break;
                }
            }
        }
        else {
            insert = new BoardPosition((getNumRows() - 1), c);
            piece = whatsAtPos(insert);
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND checkTie = (true [if the game board is full]
     * OR False [if game board is not full])
     */
    default boolean checkTie() {
        for (int i = 0; i < getNumColumns(); i++) {
            if (checkIfFree(i)) {
                return false;
            }
        }
        return true;
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win and checkHorizWin = (true
     * [if there are Win of the same tokens consecutively horizontally] OR false [if there are not Win tokens
     * consecutively horizontally])
     */
    default boolean checkHorizWin(BoardPosition pos, char p) {
        boolean won = false;
        int win = getNumToWin() - 1;
        BoardPosition check = new BoardPosition(pos.getRow(), pos.getColumn());
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getColumn() - win) + i) >= 0 && (pos.getColumn() + i) < getNumColumns()) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(pos.getRow(), ((pos.getColumn() - win) + i + j));
                    if ((check.getColumn() + 1) > getNumColumns() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                break;
            }
        }

        return won;
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win and checkVertWin = (true
     * [if there are Win of the same tokens consecutively vertically] OR false [if there is not Win tokens consecutively
     * vertically])
     */
    default boolean checkVertWin(BoardPosition pos, char p) {
        boolean won = true;
        int win = getNumToWin() - 1;
        BoardPosition check = new BoardPosition(pos.getRow(), pos.getColumn());
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getRow() - win) + i) >= 0 && (pos.getRow() + i) < getNumRows()) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(((pos.getRow() - win) + i + j), pos.getColumn());
                    if ((check.getRow() + 1) > getNumRows() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                break;
            }
        }
        return won;
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win and checkHorizWin = (true
     * [if there are Win of the same tokens consecutively diagonally] OR false [if there is not Win tokens consecutively
     * diagonally])
     */
    default boolean checkDiagWin(BoardPosition pos, char p) {
        boolean won = true;
        int win = getNumToWin() - 1;
        BoardPosition check = new BoardPosition(pos.getRow(), pos.getColumn());
        // checks down and to the left
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getRow() - win) + i) >= 0 && (pos.getRow() + i) < getNumRows() && ((pos.getColumn() - win) + i) >= 0 && (pos.getColumn() + i) < getNumColumns()) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(((pos.getRow() - win) + i + j), ((pos.getColumn() - win) + i + j));
                    if ((check.getRow() + 1) > getNumRows() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                return true;
            }
        }

        // checks down and to the right
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getRow() - win) + i) >= 0 && (pos.getRow() + i) < getNumRows() && ((pos.getColumn() + win) - i) <getNumColumns() && (pos.getColumn() - i) >= 0) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(((pos.getRow() - win) + i + j), ((pos.getColumn() + win) - i - j));
                    if ((check.getRow() + 1) > getNumRows() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                return true;
            }
        }

        //checks up to the left
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getRow() + win) - i) < getNumRows() && (pos.getRow() - i) >= 0 && ((pos.getColumn() - win) + i) >= 0 && (pos.getColumn() + i) < getNumColumns()) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(((pos.getRow() + win) - i - j), ((pos.getColumn() - win) + i + j));
                    if ((check.getRow() + 1) > getNumRows() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                return true;
            }
        }

        //checks up to the right
        for (int i = 0; i < getNumToWin(); i++) {
            won = true;
            check = new BoardPosition(pos.getRow(), pos.getColumn());
            if (((pos.getRow() + win) - i) < getNumRows() && (pos.getRow() - i) >= 0 && ((pos.getColumn() + win) - i) <getNumColumns() && (pos.getColumn() - i) >= 0) {
                for (int j = 0; j < getNumToWin(); j++) {
                    check = new BoardPosition(((pos.getRow() + win) - i - j), ((pos.getColumn() + win) - i - j));
                    if ((check.getRow() + 1) > getNumRows() || !isPlayerAtPos(check, p)) {
                        won = false;
                        break;
                    }
                }
            }
            else { won = false; }
            if (won) {
                return true;
            }
        }

        return won;
    }

    /**
     * This function retrieves a character from at a specified boardPosition on the game board
     *
     * @param pos the position to check
     * @return what is at the board position pos
     *
     * @pre none
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND whatsAtPos = [what is at position pos]
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
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND isPlayerAtPos = (true
     * [if player matches the token in position pos] OR false [if the two don't match])
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player) {
        return whatsAtPos(pos) == player;
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the number of rows in the game board
     *
     * @pre none
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumRows = Row
     */
    public int getNumRows();

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the number of cols in the game board
     *
     * @pre none
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumColumns = Col
     */
    public int getNumColumns();

    /**
     * returns the number of tokens needed consecutively to win the game
     *
     * @return the number of tokens required consecutively to win
     *
     * @pre none
     * @post self = #self  AND Col = #Col AND Row = #Row AND Win = #Win AND getNumToWin = Win
     */
    public int getNumToWin();
}
