import java.util.*;

public class SudokuSolver {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    //dummy board for reference
    /* int board[][] = { 
        {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };*/
    int board[][] = new int[9][9];
    System.out.println("Hello player! @_@");
    System.out.println(
      "\nThis is a Sudoku board solver :)\nEnter below the numbers in sequence,\n<< donot use space between the numbers >> \n& <<enter 0 for blank spaces>> "
    );
    System.out.println("\nIf you see a row in your puzzle like : 9 23 5 7");
    System.out.println("Just Enter : 902300507 ");
    System.out.println("@_@ now go ahead and try it out >>> :)");

    //Taking inputs
    for (int i = 0; i < 9; i++) {
      System.out.println("\nEnter the numbers in row : " + (i + 1));
      String row;
      row = in.nextLine();
      for (int j = 0; j < row.length(); j++) {
        board[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
      }
    }

    //printing the orignal board entered by user
    System.out.println("\n The original board ");
    printnormalboard(board);

    //printing the solved board if it si successfull
    if (solveBoard(board)) System.out.println(
      "\n<< Here is the solved board for you! >>\n"
    ); else System.out.println(
      "Unsolvable board :( make sure you have entered the numbers correctly"
    );
    printSolvedBoard(board);
  }

  private static boolean solveBoard(int board[][]) {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == 0) {
          for (int n = 1; n <= 9; n++) {
            if (isValidPlace(board, n, row, col)) {
              board[row][col] = n;
              if (solveBoard(board)) {
                return true;
              } else {
                board[row][col] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isNumberInrow(int board[][], int N, int row) {
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == N) return true;
    }
    return false;
  }

  private static boolean isNumberIncolumn(int board[][], int N, int col) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == N) return true;
    }
    return false;
  }

  private static boolean isNumberInbox(int board[][], int N, int col, int row) {
    int localboxrow = row - row % 3;
    int localboxcol = col - col % 3;
    for (int i = localboxrow; i < localboxrow + 3; i++) {
      for (int j = localboxcol; j < localboxcol + 3; j++) {
        if (board[i][j] == N) return true;
      }
    }
    return false;
  }

  private static boolean isValidPlace(int board[][], int N, int row, int col) {
    return (
      !isNumberInrow(board, N, row) &&
      !isNumberIncolumn(board, N, col) &&
      !isNumberInbox(board, N, col, row)
    );
  }

  private static void printSolvedBoard(int board[][]) {
    for (int i = 0; i < 9; i++) {
      if (i % 1 == 0 && i != 0) System.out.println(
        "-------------------------------------"
      );

      for (int j = 0; j < 9; j++) {
        // if(j%3 ==0 && j!=0) System.out.print("|");

        System.out.print("| " + board[i][j] + " ");
      }
      System.out.print("|");
      System.out.println();
    }
  }

  private static void printnormalboard(int board[][]) {
    for (int i = 0; i < 9; i++) {
      if (i % 1 == 0 && i != 0) System.out.println(
        "-------------------------------------"
      );

      for (int j = 0; j < 9; j++) {
        // if(j%3 ==0 && j!=0) System.out.print("|");

        System.out.print("| " + board[i][j] + " ");
      }
      System.out.print("|");
      System.out.println();
    }
  }
}
