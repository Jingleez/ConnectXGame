package cpsc2150.extendedConnects;
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;
import cpsc2150.extendedConnectX.models.GameBoardMem;

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

        final int MIN_PLAYERS = 2, MAX_PLAYERS = 10, MIN_NUM = 3, MAX_NUM = 100, MAX_WIN = 25;

        //While loop for the option to play the game again
        while (playAgain) {
            
            int userChoice = 0;

            //Variable start/reset to begin match
            IGameBoard newBoard = null;
            int numRows, numCols, numPlay, numToWin;
            char player;
            List<Character> players = new ArrayList<>();
            String boardType, in;

            do {
                System.out.println("How many players would you like to have?");
                in = keyboard.nextLine();
                numPlay = Integer.parseInt(in);
                if (numPlay < MIN_PLAYERS) {
                    System.out.println("Must be at least 2 players");
                }
                else if (numPlay > MAX_PLAYERS) {
                    System.out.println("Must be 10 players or fewer");
                }
            }while (numPlay < MIN_PLAYERS || numPlay > MAX_PLAYERS);

            for (int i = 1; i <= numPlay; i++) {
                do {
                    System.out.println("Choose your character player " + i);
                    player = keyboard.nextLine().charAt(0);
                    if (players.contains(player)) {
                        System.out.println(player + " is already taken as a player token!");
                    }
                    else {
                        players.add(player);
                    }
                } while (players.size() < i);
            }

            do {
                System.out.println("How many rows would you like the board to have?");
                in = keyboard.nextLine();
                numRows = Integer.parseInt(in);
                if (numRows < MIN_NUM) {
                    System.out.println("Must be at least " + MIN_NUM + " rows");
                }
                else if (numRows > MAX_NUM) {
                    System.out.println("Must be " + MAX_NUM + " or fewer rows");
                }
            } while(numRows < MIN_NUM || numRows > MAX_NUM);

            do {
                System.out.println("How many columns would you like the board to have?");
                in = keyboard.nextLine();
                numCols = Integer.parseInt(in);
                if (numCols < MIN_NUM) {
                    System.out.println("Must be at least " + MIN_NUM + " columns");
                }
                else if (numCols > MAX_NUM) {
                    System.out.println("Must be " + MAX_NUM + " or fewer columns");
                }
            } while(numCols < MIN_NUM || numCols > MAX_NUM);

            do {
                System.out.println("How many in a row needed to win?");
                in = keyboard.nextLine();
                numToWin = Integer.parseInt(in);
                if (numToWin < MIN_NUM) {
                    System.out.println("Must be at least " + MIN_NUM);
                }
                else if (numToWin > MAX_WIN) {
                    System.out.println("Must be " + MAX_WIN + " or fewer");
                }
                else if (numToWin > numCols || numToWin > numRows) {
                    System.out.println("must be fewer than the number of columns and rows");
                }
            } while (numToWin < MIN_NUM || numToWin > MAX_WIN || numToWin > numCols || numToWin > numRows );

            do {
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                boardType = keyboard.nextLine().toLowerCase();
                if (boardType.equals("f")) {
                    newBoard = new GameBoard(numRows, numCols, numToWin); // Creates a game-board at start of match
                } else if (boardType.equals("m")) {
                    newBoard = new GameBoardMem(numRows, numCols, numToWin);
                }
            } while (!boardType.equals("f") && !boardType.equals("m"));

            char currentPlayer = players.get(0);
            System.out.println(newBoard.toString()); //shows the first (empty) game-board

            //while loop that identifies if play again is true, and runs the game again if so
            while (true) {
                System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                in = keyboard.nextLine();
                userChoice = Integer.parseInt(in); //user input
                //input verification
                if (userChoice < 0) {
                    System.out.println("Column cannot be less than 0");
                    continue;
                } else if (userChoice > (newBoard.getNumColumns() - 1)) {
                    System.out.println("Column cannot be greater than " + (newBoard.getNumColumns() - 1));
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
                String playAgainChoice = keyboard.nextLine().toLowerCase();

                if (playAgainChoice.equals("y")) {
                    playAgain = true;
                    break;
                } else if (playAgainChoice.equals("n")) {
                    playAgain = false;
                    break;
                }
            } while (true);
        }
    }
}
