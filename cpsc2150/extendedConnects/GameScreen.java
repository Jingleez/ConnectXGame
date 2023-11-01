package cpsc2150.extendedConnects;
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class GameScreen
{

    public static void main(String[] args)
    {
        //Scanner creation
        Scanner keyboard = new Scanner(System.in);

        //Variable Creation/Initialization
        boolean playAgain = true;

        //While loop for the option to play the game again
        while (playAgain) {
            int userChoice = 0;
            //Variable start/reset to begin match
            int numRows, numCols, numPlay, numToWin;
            char player;
            System.out.println("How many rows would you like the board to have?");
            numRows = keyboard.nextInt();
            System.out.println("How many columns would you like the board to have?");
            numCols = keyboard.nextInt();
            System.out.println("How many in a row needed to win?");
            numToWin = keyboard.nextInt();
            System.out.println("How many players would you like to have?");
            numPlay = keyboard.nextInt();
            List<Character> players = new ArrayList<>();
            for (int i = 1; i <= numPlay; i++) {
                System.out.println("Choose your character player " + i);
                player = keyboard.next().charAt(0);
                players.add(player);             
            }
            IGameBoard newBoard = new GameBoard(); // Creates a game-board at start of match
            char currentPlayer = players.get(0);
            System.out.println(newBoard.toString()); //shows the first (empty) game-board
            //while loop that identifies if play again is true, and runs the game again if so
            while (true) {
                System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                userChoice = keyboard.nextInt(); //user input
                //input verification
                if (userChoice < 0) {
                    System.out.println("Column cannot be less than 0");
                    continue;
                } else if (userChoice > newBoard.getNumColumns()) {
                    System.out.println("Column cannot be greater than " + newBoard.getNumColumns());
                    continue;

                } else if (!newBoard.checkIfFree(userChoice)) {
                    System.out.println("Column is full");
                    continue;

                }
                //token drop function
                newBoard.dropToken(currentPlayer, userChoice);
                //win statement that breaks to the previous while loop
                if (newBoard.checkForWin(userChoice)) {
                    System.out.println(newBoard.toString());
                    System.out.println("Player " + currentPlayer + " Won!");
                    break;
                }
                //tie statement that breaks to the previous while loop
                else if (newBoard.checkTie()) {
                    System.out.println(newBoard.toString());
                    System.out.println("Tie!");
                    break;
                }
                else {
                    System.out.println(newBoard.toString()); //shows the game-board
                }

                //ternary statement that is used to determine which player has the next turn
                currentPlayer = (currentPlayer == players.get(players.size() - 1)) ? players.get(0) : players.get(players.indexOf(currentPlayer) + 1);
            }
            //start of do while loop
            do {
                System.out.println("Would you like to play again? Y/N");
                String playAgainChoice = keyboard.next().toLowerCase();

                if (playAgainChoice.equals("y")) {
                    playAgain = true;
                    break;
                } else if (playAgainChoice.equals("n")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Would you like to play again? Y/N");
                }
            } while (true);
        }
    }
}
