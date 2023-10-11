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
        if (Board[maxRow][c] == ' ') { 
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
    }

    /**
     * This function checks if the game has resulted in a tie. A Game is considered tie if there are no free board
     * positions remaining. It returns true if the game is tied and false otherwise
     *
     * @return
     */
    default boolean checkTie() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                if (Board[i][j] != ' ') {
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
        if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row+1][pos.Col] == p) && (Board[pos.Row+2][pos.Col] == p) && (Board[pos.Row+3][pos.Col] == p)) {
            return true;
        }
        else if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row-1][pos.Col] == p) && (Board[pos.Row-2][pos.Col] == p) && (Board[pos.Row-3][pos.Col] == p)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This function checks if there are four identical pieces adjacent to the specified position in a vertical
     * direction
     *
     * @param pos
     * @param p
     * @return
     */
    default boolean checkVertWin(BoardPosition pos, char p) {
        if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row][pos.Col+1] == p) && (Board[pos.Row][pos.Col+2] == p) && (Board[pos.Row][pos.Col+3] == p)) {
            return true;
        }
        else if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row][pos.Col-1] == p) && (Board[pos.Row][pos.Col-2] == p) && (Board[pos.Row][pos.Col-3] == p)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This function checks if there are four identical pieces diagonally aligned with the specified position
     *
     * @param pos
     * @param p
     * @return
     */
    default boolean checkDiagWin(BoardPosition pos, char p) {
        if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row+1][pos.Col+1] == p) && (Board[pos.Row+2][pos.Col+2] == p) && (Board[pos.Row+3][pos.Col+3] == p)) {
            return true;
        }
        else if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row-1][pos.Col-1] == p) && (Board[pos.Row-2][pos.Col-2] == p) && (Board[pos.Row-3][pos.Col-3] == p)) {
            return true;
        }
        else if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row-1][pos.Col+1] == p) && (Board[pos.Row-2][pos.Col+2] == p) && (Board[pos.Row-3][pos.Col+3] == p)) {
            return true;
        }
        else if ((Board[pos.Row][pos.Col] == p) && (Board[pos.Row+1][pos.Col-1] == p) && (Board[pos.Row+2][pos.Col-2] == p) && (Board[pos.Row+3][pos.Col-3] == p)) {
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
