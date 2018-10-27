// Name: Yuntao Liang
// USC NetID: 3462-6381-90
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/

/**
 * @author Yuntao
 * This is a SolitairBoard class, use new SilitaireBoard to use this class
 * The parameter could be a ArrayList and null
 * If the parameter is ArrayList, it will use this list generate its own array
 * otherwise it will randomly generate its own array
 * instance variable size stands for the valid number in array
 * instance variable ran is random number generater
 * instance variable checkDone is used to check whether is game is over
 *
 */

public class SolitaireBoard {

   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)

   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.


   /**
        Representation invariant:

        the position of i found in poles is 0 to size - 1
        total value must be 45
        elements in array cannot be 0
        elements in array cannot be negative
        the capacity of array larger equals to 45

   */
   private int[] array;
   private int size;
   private Random ran;
   private Set<Integer> checkDone;

   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      // initial the solitaire board
      array = new int[CARD_TOTAL + 1];
      for (int i = 0; i < piles.size(); i ++) {
         array[i] = piles.get(i);
         size ++;
      }

      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }

   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      array = new int[CARD_TOTAL];
      ran = new Random();
      int numberRange = CARD_TOTAL;
      int index = 0;
      while (numberRange > 0) {
         int randomNumber = 1 + ran.nextInt(numberRange);
         array[index ++] = randomNumber;
         numberRange -= randomNumber;
         size ++;
      }

      assert isValidSolitaireBoard();
   }

   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before,
      and the new pile will be at the end.
   */
   public void playRound() {
      int tailNum = size;
      for (int i = 0; i < size; i ++) {
         array[i] -= 1;
      }
      array[size] = tailNum;
      size ++;
      removeZero();

   }

   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
      O(n) time complexity
      O(n) space complexity
   */

   public boolean isDone() {
      initHashSet();
      for (int i = 0; i < size; i ++) {
         if (!checkDone.contains(array[i])) {
            return false;
         }
         checkDone.remove(array[i]);
      }
      return true;

   }

   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {
      String result = "";
      for (int i = 0; i < size; i ++) {
         if (i == 0) {
            result = result + array[i];
         } else {
            result = result + " " + array[i];
         }
      }
      assert isValidSolitaireBoard();
      return result;
   }

   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      int sum = 0;
      for (int i = 0; i < size; i ++) {
          if (array[i] <= 0) return false;
          sum = sum + array[i];
      }
      return sum == CARD_TOTAL ? true : false;

   }

   /**
    * Inital to HashSet to check whether the game is done
    * add 1 to 9 into HashSet
    */
   private void initHashSet() {
      checkDone = new HashSet<>();
      for (int i = 1; i <= 9; i ++) {
         checkDone.add(i);
      }
   }

   /**
    * Remove zero number in array after playround()
    * O(n) time complexity
    * O(1) space complexity
    */
   private void removeZero() {
      int slow = 0;
      int numOfZero = 0;
      for (int fast = 0; fast < size; fast ++) {
         if (array[fast] == 0) {
            numOfZero ++;
            continue;
         }
         array[slow ++] = array[fast];
      }
      size -= numOfZero;
   }

}
