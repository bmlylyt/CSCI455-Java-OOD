import java.util.Arrays;

public class MineFieldTester {
   public static void main(String[] args) {
      boolean[][] testerMatrix = {
              {false, false, false, false},
              {true, false, false, false},
              {false, true, true, false},
              {false, true, false, true}
         };
      int rows = testerMatrix.length;
      int cols = testerMatrix[0].length;

      MineField test = new MineField(testerMatrix);
      System.out.println("The mineData is: ");
      System.out.println(test);
      System.out.println();

      System.out.println("numRows Test : ");
      System.out.println(rows == test.numRows());
      System.out.println("numCols Test : ");
      System.out.println(cols == test.numCols());
      System.out.println();

      System.out.println("numAdjacentMines test:");
      int[][] matrix = new int[rows][cols];
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
            matrix[i][j] = test.numAdjacentMines(i, j);
         }
      }
      printNumAdjacentMinesTestResult(matrix);
      System.out.println();

      System.out.println("Inrange Test:");
      System.out.println("Result :" + test.inRange(0, 0) + " expected: true" );
      System.out.println("Result :" + test.inRange(-1, -1) + " expected: false" );
      System.out.println("Result :" + test.inRange(3, 3) + " expected: true" );
      System.out.println("Result :" + test.inRange(4, 4) + " expected: false" );
      System.out.println("Result :" + test.inRange(0, 3) + " expected: true" );
      System.out.println("Result :" + test.inRange(0, 4) + " expected: false" );
      System.out.println("Result :" + test.inRange(3, 0) + " expected: true" );
      System.out.println("Result :" + test.inRange(4, 0) + " expected: false" );
      System.out.println();

      System.out.println("hasMine Test: ");
      System.out.println("Result :" + test.hasMine(1, 0) + " expected: true" );
      System.out.println("Result :" + test.hasMine(2, 1) + " expected: true" );
      System.out.println("Result :" + test.hasMine(3, 3) + " expected: true" );
      System.out.println("Result :" + test.hasMine(0, 0) + " expected: false" );
      System.out.println("Result :" + test.hasMine(1, 2) + " expected: false" );
      System.out.println("Result :" + test.hasMine(3, 0) + " expected: false" );
      System.out.println();

      System.out.println("numOfMine Test: ");
      System.out.println("Result :" + test.numMines() + " expected: 5");
   }

   private static void printNumAdjacentMinesTestResult(int[][] matrix) {
      for (int i = 0; i < matrix.length; i ++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }
}
