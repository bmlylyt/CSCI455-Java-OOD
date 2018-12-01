// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA4
// Fall 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class is the entry of program. User can entry
 * a word, and then the program will print out all anagram
 * of the subsets of this word in the file we use and theirs scores.
 * Usage: java WordFinder [fileName]
 * If fileName is empty, it will use default file, sowpods.txt
 * If the file you enter is not exist, it will end this program
 * If you want to manually end the program, type in .
 */
public class WordFinder {
   public static void main(String[] args) {
      //the dicitonary we are going to build
      AnagramDictionary dictionary = null;
      //the score reader we use to get the score of each word
      ScoreReader scoreReader = new ScoreReader();
      try {
         if (args == null || args.length == 0 || args[0] == null || args[0].length() == 0) {
            dictionary = new AnagramDictionary("/Users/yuntaoliang/IdeaProjects/PA4/src/sowpods.txt");
         } else {
            dictionary = new AnagramDictionary(args[0]);
         }
      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
         System.exit(0);
      }
      Scanner wordReader = new Scanner(System.in);
      System.out.println("Type . to quit.");
      while (true) {
         System.out.print("Rack?");
         String inputWord = wordReader.nextLine();
         //we remove all the character except the lower-case and upper-case letters
         String trimWord = trim(inputWord);
         if (inputWord.equals(".")) {
            break;
         }
         List<Word> wordWithScoreList = getWordWithScoreList(trimWord, scoreReader, dictionary);
         printResult(wordWithScoreList, trimWord);
      }

   }

   /**
    * Get all the Word which contains String of word and its score
    * and store them in a List
    * @param word the word after remove the unrelated characters
    * @param scoreReader the object we use to get sum of score of each word
    * @param dictionary the dictionary we use to search the word and its anagram
    * @return the list which contains the object of class Word
    */
   private static List<Word> getWordWithScoreList(String word, ScoreReader scoreReader, AnagramDictionary dictionary) {
      // visited is used to check the output of subset
      // in case the function getSubset doesn't work correctly
      Set<String> visited = new HashSet<>();
      List<Word> wordWithScoreList = new ArrayList<>();
      Rack rack = new Rack(word);
      List<String> subsets = rack.getAllSubsets();
      for (String ele : subsets) {
         ArrayList<String> anagrams = dictionary.getAnagramsOf(ele);
         if (anagrams == null) continue;
         for (String anagram : anagrams) {
            if (visited.add(anagram)) {
               Word wordWithScore = new Word(anagram, scoreReader.getScore(anagram));
               wordWithScoreList.add(wordWithScore);
            }
         }
      }
      return wordWithScoreList;
   }

   /**
    * print out the result containing the score and corresponding word
    * @param wordWithScoreList the list that contains the object of class Word
    * @param inputWord the word after removing the unrelated characters
    */
   private static void printResult(List<Word> wordWithScoreList, String inputWord) {
      int numberOfWord = wordWithScoreList.size();

      System.out.println(" We can make " + numberOfWord + " words from " + "\"" +inputWord+"\"");
      if (numberOfWord > 0) {
         System.out.println("All of the words with their scores (sorted by score):");
      }

      Collections.sort(wordWithScoreList, new Comparator<Word>() {
         @Override
         public int compare(Word o1, Word o2) {
            if (o1.getScore() != o2.getScore()) {
               return o2.getScore() - o1.getScore();
            } else if (o1.getWord().length() != o2.getWord().length()) {
               return o2.getWord().length() - o1.getWord().length();
            } else {
               return o1.getWord().compareTo(o2.getWord());
            }
         }
      });
      for (Word wordWithScore : wordWithScoreList) {
         System.out.println(wordWithScore.getScore() + ":" + wordWithScore.getWord());
      }
   }

   /**
    * Remove all the unrelated characters in input word.
    * only leave the lower-case and upper-case characters
    * @param input the word we read from concole
    * @return the word after making the removal
    */
   private static String trim(String input) {
      char[] chars = input.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < chars.length; i ++) {
         if ((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
            sb.append(chars[i]);
         }
      }
      return sb.toString();
   }
}
