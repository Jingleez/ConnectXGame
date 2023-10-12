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
        // Initial check to see if the 'board' has rows and columns
        if (Board == null || Board.length == 0 || Board[0] == null) {
            return "The 'board' is either empty or doesn't have rows and columns.";
        }
        StringBuilder boardString = new StringBuilder(); // Create a StringBuilder for the string representation.
        // Before going to next row, adding a newline first
        boardString.append("|");
        for (int col=0; col <Board[0].length; col++) {
            boardString.append(col + "|");
        }
        boardString.append("\n");
        
        // This loop adds row labels and board contents
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[0].length; col++) {
                boardString.append("|" + Board[row][col]); // Appending contents of cell
            }
            boardString.append("|");
            // Before going to next row, adding a newline first
            boardString.append("\n");
        }
    
        // This converts the StringBuilder to a string and returns the final string representing the board.
       return boardString.toString();
    }
}
