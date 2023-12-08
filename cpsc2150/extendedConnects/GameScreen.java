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

        //While loop for the option to play the game again
        while (playAgain) {
            final int minPlayers = 2, maxPlayers = 10, minNum = 3, maxNum = 100, maxWin = 25;
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
                if (numPlay < minPlayers) {
                    System.out.println("Must be at least 2 players");
                }
                else if (numPlay > maxPlayers) {
                    System.out.println("Must be 10 players or fewer");
                }
            }while (numPlay < minPlayers || numPlay > maxPlayers);

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
                if (numRows < minNum) {
                    System.out.println("Must be at least " + minNum + " rows");
                }
                else if (numRows > maxNum) {
                    System.out.println("Must be " + maxNum + " or fewer rows");
                }
            } while(numRows < minNum || numRows > maxNum);

            do {
                System.out.println("How many columns would you like the board to have?");
                in = keyboard.nextLine();
                numCols = Integer.parseInt(in);
                if (numCols < minNum) {
                    System.out.println("Must be at least " + minNum + " columns");
                }
                else if (numCols > maxNum) {
                    System.out.println("Must be " + maxNum + " or fewer columns");
                }
            } while(numCols < minNum || numCols > maxNum);

            do {
                System.out.println("How many in a row needed to win?");
                in = keyboard.nextLine();
                numToWin = Integer.parseInt(in);
                if (numToWin < minNum) {
                    System.out.println("Must be at least " + minNum);
                }
                else if (numToWin > maxWin) {
                    System.out.println("Must be " + maxWin + " or fewer");
                }
                else if (numToWin > numCols || numToWin > numRows) {
                    System.out.println("must be fewer than the number of columns and rows");
                }
            } while (numToWin < minNum || numToWin > maxWin || numToWin > numCols || numToWin > numRows );

            do {
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                boardType = keyboard.nextLine().toLowerCase();
                if (boardType.equals("f")) {
                    // Creates a game-board at start of match
                    newBoard = new GameBoard(numRows, numCols, numToWin); 
                } else if (boardType.equals("m")) {
                    newBoard = new GameBoardMem(numRows, numCols, numToWin);
                }
            } while (!boardType.equals("f") && !boardType.equals("m"));

            char currentPlayer = players.get(0);
            //shows the first (empty) game-board
            System.out.println(newBoard.toString()); 
            //while loop that identifies if play again is true, and runs the game again if so
            while (true) {
                System.out.println("Player " + currentPlayer + ", what column do you want to place your marker in?");
                in = keyboard.nextLine();
                //user input
                userChoice = Integer.parseInt(in); 
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
                    //shows the game-board
                    System.out.println(newBoard.toString()); 
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
                } else {
                    System.out.println("Would you like to play again? Y/N");
                }
            } while (true);
        }
    }
}
