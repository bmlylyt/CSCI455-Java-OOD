// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
   A Rack of Scrabble tiles
 */

public class Rack {

   private String originalWord;
   private String unique;
   private int[] mult;

   /**
    * the constructor of the class Rack. It generate the
    * unique word and mult array to find all subsets of this
    * word we read
    * @param word read from dictionary
    */
   public Rack(String word) {
      this.originalWord = word;

      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);
      unique = removeDuplicate(sortedWord);
      mult = initMult(sortedWord, unique);
   }

   /**
    * find all the subset of the original word
    * @return list of word that contains all subset of the
    * original word
    */
   public List<String> getAllSubsets() {
      List<String> subsets = Rack.allSubsets(unique, mult, 0);
      return subsets;
   }

   /**
    * remove the duplicate character and leave one
    * @param word original word which read from dictionary
    * @return the deduplicated word from original word
    */
   private String removeDuplicate(String word) {
      char[] letters = word.toCharArray();
      int slow = 1;
      int fast = 1;
      for (;fast < letters.length; fast ++) {
         if (letters[fast] != letters[slow - 1]) {
            letters[slow ++] = letters[fast];
         }
      }
      return new String(letters, 0, slow);
   }

   /**
    * generate the array that work for subset function
    * each element in mult array represents the frequency
    * each character appear
    * @param originalWord the word we read from dictionary
    * @param unique the word after been deduplicated
    * @return the mult array
    */
   private int[] initMult(String originalWord, String unique) {
      int[] mult = new int[unique.length()];
      int len = originalWord.length();
      int index = 0;
      int count = 0;
      for (int i = 0; i < len; i ++) {
         if (i < len - 1 && originalWord.charAt(i) == originalWord.charAt(i + 1)) {
            count ++;
         }
         if (i == len - 1 || originalWord.charAt(i) != originalWord.charAt(i + 1)) {
            count ++;
            mult[index ++] = count;
            count = 0;
         }
      }
      return mult;
   }

   private void printUnique() {
      System.out.println(unique);
   }

   private void printMult() {
      System.out.println(Arrays.toString(mult));
   }
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   /**
    * test function
    * @param args
    */
   public static void main (String[] args) {
      Rack rack = new Rack("dotwgoo");
      List<String> test = rack.getAllSubsets();
      System.out.println(test);
   }
   
}
