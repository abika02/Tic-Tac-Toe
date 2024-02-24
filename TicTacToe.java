import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("   ....Let's play Tic-Tac-Toe....");
    System.out.print("\n");
    char[][] board = {
      { '_', '_', '_' },
      { '_', '_', '_' },
      { '_', '_', '_' },
    };
    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int spot[] = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      } else {
        System.out.println("Turn: O");
        int spot[] = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);
      int count = checkWin(board);
      if (count == 3) {
        System.out.println("X Wins!");
        break;
      } else if (count == -3) {
        System.out.println("O Wins!");
        break;
      }
    }
  }

  public static int[] askUser(char[][] board) {
    System.out.print("pick a row and column number: ");
    int row = scan.nextInt();
    int col = scan.nextInt();
    while (board[row][col] == 'X' || board[row][col] == 'O') {
      System.out.print("\nSpot already taken!!  Choose another spot: ");
      row = scan.nextInt();
      col = scan.nextInt();
    }
    return new int[] { row, col };
  }

  public static int checkWin(char board[][]) {
    int rows = checkRows(board);

    if (Math.abs(rows) == 3) return rows;

    int columns = checkColumns(board);
    if (Math.abs(columns) == 3) return columns;

    int leftDiagonal = checkLeft(board);
    if (Math.abs(leftDiagonal) == 3) return leftDiagonal;

    int rightDiagonal = checkRight(board);
    if (Math.abs(rightDiagonal) == 3) return rightDiagonal;

    return 0;
  }

  public static int checkRows(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }
    return count;
  }

  public static int checkColumns(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        } else {
          count = 0;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }
    return count;
  }

  public static int checkLeft(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }
    return count;
  }

  public static int checkRight(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[2 - i][i] == 'X') {
        count++;
      } else if (board[2 - i][i] == 'O') {
        count--;
      }
    }
    return count;
  }

  public static void printBoard(char[][] board) {
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print("\t" + board[i][j]);
      }
      System.out.println("\n");
    }
  }
}
