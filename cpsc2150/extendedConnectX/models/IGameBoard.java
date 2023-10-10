package cpsc2150.extendedConnectX.models;

public interface IGameBoard {
    /**
     *
     * @param c
     * @return
     */
    public boolean checkIfFree(int c);

    /**
     *
     * @param p
     * @param c
     */
    public void dropToken(char p, int c);

    /**
     *
     * @param c
     * @return
     */
    public boolean checkForWin(int c);

    /**
     *
     * @return
     */
    public boolean checkTie();

    /**
     *
     * @param pos
     * @param p
     * @return
     */
    public boolean checkHorizWin(BoardPosition pos, char p);

    /**
     *
     * @param pos
     * @param p
     * @return
     */
    public boolean checkVertWin(BoardPosition pos, char p);

    /**
     *
     * @param pos
     * @param p
     * @return
     */
    public boolean checkDiagWin(BoardPosition pos, char p);

    /**
     *
     * @param pos
     * @return
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     *
     * @param pos
     * @param player
     * @return
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player);

    /**
     *
     * @return
     */
    public int getNumRows();

    /**
     *
     * @return
     */
    public int getNumColumns();

    /**
     *
     * @return
     */
    public int getNumToWin();
}
