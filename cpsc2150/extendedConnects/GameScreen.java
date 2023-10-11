package cpsc2150.extendedConnects;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */

import cpsc2150.extendedConnectX.models.GameBoard;

import java.util.Scanner;

/**
 *
 */
public class GameScreen
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        GameBoard newBoard = new GameBoard();
        int userChoice = 0;
        while (!newBoard.checkForWin(userChoice))
        {
            System.out.println(newBoard.toString());
            System.out.println("Player X, what column do you want to place your marker in?");
            userChoice = keyboard.nextInt();
            while (userChoice < 0 || userChoice > newBoard.getNumColumns() || !newBoard.checkIfFree(userChoice))
            {
                if (userChoice < 0)
                {
                    System.out.println("Column cannot be less than 0");
                }
                else if (userChoice > newBoard.getNumColumns())
                {
                    System.out.println("Column cannot be greater than " + newBoard.getNumColumns());
                }
                else if (!newBoard.checkIfFree(userChoice))
                {
                    System.out.println("Column is full");
                }
                System.out.println("Player X, what column do you want to place your marker in?");
                userChoice = keyboard.nextInt();
            }
            newBoard.dropToken('X',userChoice);
            System.out.println(newBoard.toString());
            System.out.println("Player O, what column do you want to place your marker in?");
            userChoice = keyboard.nextInt();
            while (userChoice < 0 || userChoice > newBoard.getNumColumns() || !newBoard.checkIfFree(userChoice))
            {
                if (userChoice < 0)
                {
                    System.out.println("Column cannot be less than 0");
                }
                else if (userChoice > newBoard.getNumColumns())
                {
                    System.out.println("Column cannot be greater than " + newBoard.getNumColumns());
                }
                else if (!newBoard.checkIfFree(userChoice))
                {
                    System.out.println("Column is full");
                }
                System.out.println("Player O, what column do you want to place your marker in?");
                userChoice = keyboard.nextInt();
            }
            newBoard.dropToken('X',userChoice);
        }
    }
}