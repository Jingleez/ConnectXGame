package cpsc2150.extendedConnectX.models;
/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

/**
 * This class is a position on the board. It is the row, and column position on the board.
 *
 * @invariant maxRows < Row >= 0 and maxColumns < Column >= 0
 */
public class BoardPosition
{
    private int maxRows = 100;
    private int maxColumns = 100;
    private int Row;
    private int Column;

    /**
     * constructor for BoardPosition object. sets the instance variable to values passed in by params.
     *
     * @param aRow value for Row to be set to
     * @param aColumn value for Column to be set to
     *
     * @pre maxRows < Rows >= 0 and maxColumns < column >= 0
     *
     * @post Row = aRow AND Column = aColumn
     */
    public BoardPosition(int aRow, int aColumn)
    {
        Row = aRow;
        Column = aColumn;
        //parameterized constructor for BoardPosition
    }

    /**
     * returns the value stored in the Row variable when called
     *
     * @return Row for this instance
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column AND getRow = Row
     */
    public int getRow()
    {
        return Row;
        //returns the row
    }

    /**
     * returns the value stored in the Column variable when called
     *
     * @return Column for this instance
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column AND getColumn = Column
     */
    public int getColumn()
    {
        return Column;
        //returns the column
    }

   /**
     * checks if this BoardPosition and another BoardPosition are equal
     *
     * @param obj another BoardPosition object that is being checked if it is equal to this BoardPosition
     *
     * @return True if the two objects are equal OR False if the two object are not equal
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column AND [returns true if the the two BoardPositions have the same value in Row
     * and Column or false if the two are not the same]
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass() ) { return false; }
        BoardPosition other = (BoardPosition) obj;
        return this.getRow() == other.getRow() && this.getColumn() == other.getColumn();

    }

    /**
     * returns the Row and Column of this instance in this format: <Row>,<Column>
     *
     * @return Row and Column in the format: <Row>,<Column>
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column AND toString = <Row>,<Column>
     */
    @Override
    public String toString() {
        return this.getRow() + "," + this.getColumn();
    }
}
