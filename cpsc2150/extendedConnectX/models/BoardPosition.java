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
 * @invariant 6 > Row >= 0 AND 7 > Column >= 0
 */
public class BoardPosition
{
    private int Row;
    private int Column;

    /**
     * constructor for BoardPosition object. sets the instance variavle to values passed in by params.
     *
     * @param aRow value for Row to be set to
     * @param aColumn value for Column to be set to
     *
     * @pre 6 > aRow >= 0 AND 7 > aColumn >= 0
     *
     * @post Row = aRow AND Column = aColumn
     */
    public BoardPosition(int aRow, int aColumn)
    {
        //parameterized constructor for BoardPosition
    }

    /**
     * returns the value stored in the Row variable when called
     *
     * @return Row for this instance
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column
     */
    public int getRow()
    {
        //returns the row
    }

    /**
     * returns the value stored in the Column variable when called
     *
     * @return Column for this instance
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column
     */
    public int getColumn()
    {
        //returns the column
    }

    /**
     * checks if this BoardPosition and another BoardPosition are equal
     *
     * @param obj another BoardPosition object that is being checked if it is equal to this BoardPosition
     *
     * @return True if the two objects are equal OR False if the two object are not equal
     *
     * @pre obj is of type BoardPosition
     *
     * @post Row = #Row AND Column = #Column
     */
    @Override
    public boolean equals(Object obj)
    {

    }

    /**
     * returns the Row and Column of this instance in this format: <Row>,<Column>
     *
     * @return Row and Column in the format: <Row>,<Column>
     *
     * @pre none
     *
     * @post Row = #Row AND Column = #Column
     */
    @Override
    public String toString()
    {

    }
}