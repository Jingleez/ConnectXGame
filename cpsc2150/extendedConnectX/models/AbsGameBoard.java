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
     * @post str accurately represents the arrangement of tokens on the board, with the row and column labels, without
     * altering the game board's state (self = #self).
     *
     * @return The string representation of the entire gameboard
     */
    @Override
    public String toString(){
        /*This function returns a string representation of the entire game board, including labels for rows and columns,
         without altering the board's state. */
        // Initial check to see if the 'board' has rows and column
        StringBuilder boardString = new StringBuilder(); // Create a StringBuilder for the string representation.
        // Before going to next row, adding a newline first
        boardString.append("|");
        for (int col=0; col < getNumColumns(); col++) { boardString.append(col + "|"); }
        boardString.append("\n");
        // This loop adds row labels and board contents
        for (int row = getNumRows() - 1; row > -1; row--) {
            for (int col = 0; col < getNumColumns(); col++) {
                BoardPosition pos = new BoardPosition(row, col);
                boardString.append("|" + whatsAtPos(pos)); // Appending contents of cell
            }
            boardString.append("|");
            // Before going to next row, adding a newline first
            boardString.append("\n");
        }
        // This converts the StringBuilder to a string and returns the final string representing the board.
        return boardString.toString();
    }
}
