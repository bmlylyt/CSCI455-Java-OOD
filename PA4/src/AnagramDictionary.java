// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA4
// Fall 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {

   private Map<String, ArrayList<String>> map;
   private File file;
   private Scanner reader;


   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      map = new HashMap<>();
      file = new File(fileName);
      reader = new Scanner(file);
      buildDict(map, reader);
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      return map.containsKey(sorted) ? map.get(sorted) : null;
   }

   /**
    * build the dictionary we need to make the search, the dictionary is a map
    * whose key is the anagram sorted by alphabets， whose value is all the words
    * that have this anagram
    * @param map the dictionary we are going to build
    * @param reader the words in the file we read
    */
   private void buildDict(Map<String, ArrayList<String>> map, Scanner reader) {
      while (reader.hasNext()) {
         String curWord = reader.next();
         char[] arrWord = curWord.toCharArray();
         Arrays.sort(arrWord);
         String anagram = String.valueOf(arrWord);
         if (!map.containsKey(anagram)) {
            map.put(anagram, new ArrayList<>());
         }
         map.get(anagram).add(curWord);
      }
   }

   /**
    * print the dictionary
    */
   public void printDict() {
      for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
         String s = "";
         for (String word : entry.getValue()) {
            s += word + " ";
         }
         System.out.println(entry.getKey() + ": " + s);
      }
   }
   /**
    * test function
    */
   public static void main(String[] args) {
      try{
         AnagramDictionary ad = new AnagramDictionary("/Users/yuntaoliang/IdeaProjects/PA4/src/testFiles/tinyDictionary.txt");
         ad.printDict();
         System.out.println(ad.getAnagramsOf("dgo"));
      } catch (IOException e) {
         System.out.println("result:" + e.getMessage());
      }

   }
   
}
