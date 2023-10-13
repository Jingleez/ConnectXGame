/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
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
            while (userChoice < 0 || userChoice > newBoard.getNumColumns())
            {
                if (userChoice < 0)
                {
                    System.out.println("Column cannot be less than 0");
                }
                else if (userChoice > newBoard.getNumColumns())
                {
                    System.out.println("Column cannot be greater than ");
                }
                else if (!newBoard.checkIfFree(userChoice))
                {
                    System.out.println("Column is full");
                }
                System.out.println("Player X, what column do you want to place your marker in?");
                userChoice = keyboard.nextInt();
            }
            newBoard.dropToken('X', userChoice);
            System.out.println("c" + newBoard.Board[8][userChoice] + "c");
            System.out.println(newBoard.toString());
            System.out.println("Player O, what column do you want to place your marker in?");
            userChoice = keyboard.nextInt();
            while (userChoice < 0 || userChoice > newBoard.getNumColumns())
            {
                if (userChoice < 0)
                {
                    System.out.println("Column cannot be less than 0");
                }
                else if (userChoice > newBoard.getNumColumns())
                {
                    System.out.println("Column cannot be greater than ");
                }
                else if (!newBoard.checkIfFree(userChoice))
                {
                    System.out.println("Column is full");
                }
                System.out.println("Player X, what column do you want to place your marker in?");
                userChoice = keyboard.nextInt();
            }
            newBoard.dropToken('O', userChoice);
        }
    }
}
