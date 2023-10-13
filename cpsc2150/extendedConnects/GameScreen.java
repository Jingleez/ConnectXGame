package cpsc2150.extendedConnects;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Terance Harrison (Teranceh)
Graham Frazier (Cgfrazi)
Kalyaan Narnamalpuram Srinivasan (Jingleez)
Rowan Froeschner (Rojofroe)
 */
//imports to use the created Interface (and scanner)
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;
import java.util.Scanner;

public class GameScreen {

    public static void main(String[] args) {
        //Scanner creation
        Scanner keyboard = new Scanner(System.in);

        //Variable Creation/Initialization
        boolean playAgain = true;

        //While loop for the option to play the game again
        while (playAgain) {
            //Variable start/reset to begin match
            IGameBoard newBoard = new GameBoard(); // Creates a game-board at start of match
            int userChoice = 0;
            char currentPlayer = 'X';
            //while loop that identifies if play again is true, and runs the game again if so
            while (true) {
                System.out.println(newBoard.toString()); //shows the first (empty) game-board
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
                if (newBoard.checkTie()) {
                    System.out.println(newBoard.toString());
                    System.out.println("Tie!");
                    break;
                }
                //ternary statement that is used to determine which player has the next turn
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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