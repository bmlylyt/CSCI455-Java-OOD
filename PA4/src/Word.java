// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA4
// Fall 2018

/** A Word contains the String of this word
 *  and the score of this word which is the
 *  sum of score of every character in this
 *  word
 * */
public class Word {

   private int score;
   private String word;

   public Word(String word, int score) {
      this.score = score;
      this.word = word;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public String getWord() {
      return word;
   }

}
