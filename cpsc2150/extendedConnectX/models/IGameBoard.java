package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

/**
 *
 *
 * @initialization Ensures: a board with a size of maxRows x maxColumns
 *
 * @defines: maxRows: z
 * @defines: maxCols: z
 * @defines: winNum: z
 *
 * @constraints: maxRows > 0 AND maxCols > 0 AND winNum > 0
 */
public interface IGameBoard {
    /**
     * This function checks if a specified column on the gameBoard is availble for placing a token
     *
     * @param c the column to check for free space
     * @return true if the column has space for a token or false if the column is full
     *
     * @pre none
     * @post board = #board and checkIfFree = [true if the column has space for a token or false if the column is full]
     */
    default boolean checkIfFree(int c) {
        BoardPosition check = new BoardPosition(getNumRows(), c);
        return whatsAtPos(check) == ' ';
    }

    /**
     * This function places a token in a specific column, allowing it to drop until it collides with amother token
     *
     * @param p the character of the token being dropped
     * @param c the column the token is being dropped in
     *
     * @pre none
     * @post board = [the lowest free spot in column c is filled in with the token just dropped]
     */
    public void dropToken(char p, int c);

    /**
     * checks if the last placed token wins the game, calls the other three check functions to do that
     *
     * @param c the column the last dropped token is in
     * @return true if someone has enough tokens in a row to win or false if there is not enough tokens in a row to win
     *
     * @pre [board is not empty
     * @post board = #board AND checkForWin = true [if there is enough of the same tokens in a row] OR false [if there
     * is not enough of the same tokens in a row]
     */
    default boolean checkForWin(int c) {
        BoardPosition win = new BoardPosition(getNumRows(), c);
        if (checkIfFree(c)) {
            for (int i = 0; i < getNumRows(); i++) {
                BoardPosition check = new BoardPosition(i, c);
                if (whatsAtPos(check) == ' ') {
                    win = new BoardPosition(i - 1,c);
                }
            }
        }

        if (checkHorizWin(win, whatsAtPos(win))) {
            return true;
        }
        else if (checkDiagWin(win, whatsAtPos(win))) {
            return true;
        }
        else if (checkVertWin(win, whatsAtPos(win))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This function checks if the game has resulted in a tie. A Game is considered tie if there are no free board
     * positions remaining. It returns true if the game is tied and false otherwise
     *
     * @return true if the board is full OR false if the board is not full
     *
     * @pre none
     * @post board = #board AND checkTie = true [if the board is full] OR false [if the board is not full]
     */
    default boolean checkTie() {
        for (int i = 0; i < getNumColumns(); i++) {
            if (checkIfFree(i)) {
                return false;
            }
        }
        return false;
    }

    /**
     * This function checks if there are enough identical pieces adjacent to the specified position in a horizontal
     * direction for a win
     *
     * @param pos the position of the last token dropped into the board
     * @param p the character of the player that dropped the token
     * @return true if there is enough token in a row horizontally to win OR false if there is not enough tokens in a
     * row horizontally to win
     *
     * @pre board is not empty
     * @post board = #board AND checkHorizWin = True [there is enough token in a row horizontally to win] OR false [if
     * there is not enough tokens in a row horizontally to win]
     */
    default boolean checkHorizWin(BoardPosition pos, char p) {

    }

    /**
     * This function checks if there are enough identical pieces adjacent to the specified position in a vertical
     *  direction for a win
     *
     * @param pos the position of the last token dropped into the board
     * @param p the character of the player that dropped the token
     * @return true if there is enough token in a row vertically to win OR false if there is not enough
     * tokens in a row vertically to win
     *
     * @pre board is not empty
     * @post board = #board AND checkHorizWin = True [there is enough tokens in a row vertically to win] OR false [if
     * there is not enough tokens in a row vertically to win]
     */
    default boolean checkVertWin(BoardPosition pos, char p) {

    }

    /**
     * This function checks if there are enough identical pieces diagonally aligned with the specified position for a
     * win
     *
     * @param pos the position of the last token dropped into the board
     * @param p the character of the player that dropped the token
     * @return true if there is enough token in a row diagonally to win OR false if there is not enough tokens in a row
     * diagonally to win
     *
     * @pre board is not empty
     * @post board = #board AND checkHorizWin = True [there is enough token in a row diagonally to win] OR false [if
     * there is not enough tokens in a row diagonally to win]
     */
    default boolean checkDiagWin(BoardPosition pos, char p) {

    }

    /**
     * This function retrieves a character from at a specified boardPosition on the game board
     *
     * @param pos the position on the board to be checked
     * @return the character of the token at pos
     *
     * @pre none
     * @post board = #board
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * This function decides whether the selected player's token ('X' or 'O') occupies the specified position on the
     * gameboard
     *
     * @param pos the position on the board to be checked
     * @param player the character of the player that we are checking pos for
     * @return true if the token at pos has the character player or false if the token at pos does not have character
     * player
     *
     * @pre none
     * @post board = #board AND isPlayerAtPos = true [if the token at pos has the character player] OR false [if the
     * token at pos does not have character player]
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player) {
        return whatsAtPos(pos) == player;
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the number of rows the board has
     *
     * @pre none
     * @post board = #board AND getNumRows = maxRows
     */
    public int getNumRows();

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the number of columns the board has
     *
     * @pre none
     * @post board = #board AND getNumColumns = maxCols
     */
    public int getNumColumns();

    /**
     * returns the number of tokens in a row needed to win the game
     *
     * @return the number of tokens needed to win
     *
     * @pre none
     * @post board= #board AND getNumToWin = winNum
     */
    public int getNumToWin();
}
