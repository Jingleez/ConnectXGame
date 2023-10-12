package cpsc2150.extendedConnectX.models;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

abstract class AbsGameBoard implements IGameBoard {
    /**
     * This function returns a string representing the entire gameboard, including row and column labels
     *
     * @pre None Required
     *
     * @post
     *
     *
     * @return The string representation of the entire gameboard
     */
    @Override
    public String toString(){
        /*This function returns a string representation of the entire game board, including labels for rows and columns,
         without altering the board's state. */
        BoardPosition pos;
        String board = "";
        for (int i = 0; i < getNumColumns(); i++) {
            board = board.concat("|" + i + "|");
        }
        board = board.concat("\n");
        for (int i = (getNumRows() - 1); i > -1; i--) {
            for (int j = 0; j < getNumColumns(); j++) {
                pos = new BoardPosition(i, j);
                board = board.concat("|" + whatsAtPos(pos) + "|");
            }
            board = board.concat("\n");
        }

        return board;
    }
}
