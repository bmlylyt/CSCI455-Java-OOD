// Name: Yuntao Liang
// USC NetID: 3462-6381-90
// CSCI455 PA2
// Fall 2018


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yuntao
 * This class is a Bulgarian Solitaire Simulator which has 3 mode
 * Default Mode: Initial board is generated by random number and print out each board
 * during the game process
 * User Config Mode: Initial board is generated by input number from users and print print out each
 * board during the game process
 * Single Step Mode: Initial board is generated by random number and the game keeps going only
 * after user hit enter
 *
 * Users can type java -ea BulgarianSolitaireSimulator to turn on default mode
 * Users can type java -ea BulgarianSolitaireSimulator -u to turn on user config mode
 * Users can type java -ea BulgarianSolitaireSimulator -s to turn on single step mode
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;
      // set modes
      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
      // choose which mode get on according to users' input
      if (userConfig) {
         userConfigMode();
      } else if (singleStep) {
         singleStepMode();
      } else {
         defaultMode();
      }

   }

   /**
    * If users type in -u, program runs on userConfigMode, which is,
    * read in the input from user as initial board, print each board
    * during the process until the game is over
    */
   private static void userConfigMode() {
      ArrayList<Integer> inputList = new ArrayList<>();
      inputList = getListFromUser();
      SolitaireBoard userConfigModeBoard = new SolitaireBoard(inputList);
      gameStart(userConfigModeBoard);

   }

   /**
    * If user does not type in any mode, program runs on default mode,
    * which is, generate initial board by random number and print each
    * board during the process until the game is over
    */
   private static void defaultMode() {
      SolitaireBoard defaultModeBoard = new SolitaireBoard();
      gameStart(defaultModeBoard);
   }

   /**
    * If users type in -s, the program runs on singleSepMode, which is,
    * generate initial board with random number. Game keeps going only after
    * users hit enter
    */
   private static void singleStepMode() {
      SolitaireBoard singleStepMode = new SolitaireBoard();
      gameStartForSingleStepMode(singleStepMode);
   }

   /**
    * prompt for input from user
    * pick the number in users' input and assign it to a ArrayList
    * @return the ArrayList which only contains the number typed in by user
    */
   private static ArrayList getListFromUser() {
      ArrayList<Integer> numberInput = new ArrayList<>();
      Scanner readString = new Scanner(System.in);
      Scanner readNumber = null;

      System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
      System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");

      while (true) {
         System.out.println("Please enter a space-separated list of positive integers followed by newline:");
         String inputString = readString.nextLine();
         readNumber = new Scanner(inputString);
         int sum = 0;
         boolean correctInput = true;
         correctInput = isAllDigit(inputString);
         while (readNumber.hasNextInt()) {
            int temp = readNumber.nextInt();
            // check the number is larger than 0
            if (temp <= 0) {
               correctInput = false;
               break;
            }
            sum += temp;
            numberInput.add(temp);
         }
         if (correctInput && sum == SolitaireBoard.CARD_TOTAL) {
            break;
         }
         System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL);
         numberInput.clear();
      }
      return numberInput;
   }

   /**
    * start to play the game
    * called for default mode and user config mode
    * print the result after playRound() is called
    * @param modeBoard the board generated by different mode
    */
   private static void gameStart(SolitaireBoard modeBoard) {
      int counter = 1;
      System.out.println("Initial configuration: " + modeBoard.configString());
      while(!modeBoard.isDone()) {
         modeBoard.playRound();
         System.out.println("[" + counter + "]" + "Current configuration: " + modeBoard.configString());
         counter ++;
      }
      System.out.println("Done!");
   }

   /**
    * Start to play the game.
    * called for single step mode
    * The game keeps going only after users hit enter
    * @param singleStepMode Initial board generated by random number
    */
   private static void gameStartForSingleStepMode(SolitaireBoard singleStepMode) {
      Scanner hitEnter = new Scanner(System.in);
      int counter = 1;
      System.out.println("Initial configuration: " + singleStepMode.configString());
      while (!singleStepMode.isDone()) {
         singleStepMode.playRound();
         System.out.println("[" + counter + "]" + "Current configuration: " + singleStepMode.configString());
         counter ++;
         System.out.print(" <Type return to continue>");
         hitEnter.nextLine();
      }
      System.out.println("Done!");
   }

   private static boolean isAllDigit(String input) {
      for (String str : input.split("\\s+")) {
         for (Character c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
         }
      }
      return true;
   }
  
}
