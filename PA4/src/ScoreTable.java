// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA4
// Fall 2018

/**
 * Table class that stores the score of every character
 * including lower-case and upper-case.
 * The table is hard-code to store the score of every character
 */
public class ScoreTable {
   // the range of lower-case and upper-case is from
   // 65 to 122, which is 58 in total
   private static final int DEFAULT_LENTH = 58;

   private int[] ScoreTable;

   public ScoreTable() {
      ScoreTable = new int[DEFAULT_LENTH];
      initTable();
   }

   public int[] getScoreTable() {
      return ScoreTable;
   }

   private void initTable() {
      ScoreTable['A' - 'A'] = 1;
      ScoreTable['E' - 'A'] = 1;
      ScoreTable['I' - 'A'] = 1;
      ScoreTable['O' - 'A'] = 1;
      ScoreTable['U' - 'A'] = 1;
      ScoreTable['L' - 'A'] = 1;
      ScoreTable['N' - 'A'] = 1;
      ScoreTable['S' - 'A'] = 1;
      ScoreTable['T' - 'A'] = 1;
      ScoreTable['R' - 'A'] = 1;
      ScoreTable['D' - 'A'] = 2;
      ScoreTable['G' - 'A'] = 2;
      ScoreTable['B' - 'A'] = 3;
      ScoreTable['C' - 'A'] = 3;
      ScoreTable['M' - 'A'] = 3;
      ScoreTable['P' - 'A'] = 3;
      ScoreTable['F' - 'A'] = 4;
      ScoreTable['H' - 'A'] = 4;
      ScoreTable['V' - 'A'] = 4;
      ScoreTable['W' - 'A'] = 4;
      ScoreTable['Y' - 'A'] = 4;
      ScoreTable['K' - 'A'] = 5;
      ScoreTable['J' - 'A'] = 8;
      ScoreTable['X' - 'A'] = 8;
      ScoreTable['Q' - 'A'] = 10;
      ScoreTable['Z' - 'A'] = 10;

      ScoreTable['a' - 'A'] = 1;
      ScoreTable['e' - 'A'] = 1;
      ScoreTable['i' - 'A'] = 1;
      ScoreTable['o' - 'A'] = 1;
      ScoreTable['u' - 'A'] = 1;
      ScoreTable['l' - 'A'] = 1;
      ScoreTable['n' - 'A'] = 1;
      ScoreTable['s' - 'A'] = 1;
      ScoreTable['t' - 'A'] = 1;
      ScoreTable['r' - 'A'] = 1;
      ScoreTable['d' - 'A'] = 2;
      ScoreTable['g' - 'A'] = 2;
      ScoreTable['b' - 'A'] = 3;
      ScoreTable['c' - 'A'] = 3;
      ScoreTable['m' - 'A'] = 3;
      ScoreTable['p' - 'A'] = 3;
      ScoreTable['f' - 'A'] = 4;
      ScoreTable['h' - 'A'] = 4;
      ScoreTable['v' - 'A'] = 4;
      ScoreTable['w' - 'A'] = 4;
      ScoreTable['y' - 'A'] = 4;
      ScoreTable['k' - 'A'] = 5;
      ScoreTable['j' - 'A'] = 8;
      ScoreTable['x' - 'A'] = 8;
      ScoreTable['q' - 'A'] = 10;
      ScoreTable['z' - 'A'] = 10;
   }
}

/**
 * class that used to read a word and calculate the total
 * score according to each character in this word
 */
class ScoreReader {

   private ScoreTable scoreTable;
   private int[] table;

   public ScoreReader() {
      scoreTable = new ScoreTable();
      this.table = scoreTable.getScoreTable();
   }

   public int getScore(String word) {
      int sum = 0;
      for (int i = 0; i < word.length(); i ++) {
         sum += table[word.charAt(i) - 'A'];
      }
      return sum;
   }
}