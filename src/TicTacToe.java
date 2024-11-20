import java.util.Scanner;

public class TicTacToe {

    //class variables - can be used by any method in the class
    static Scanner s = new Scanner(System.in);
    static String [][] board;
    static String [] name = new String [2];
    static String [] piece = {"x", "o"};

    public static void main(String [] args) {

        //setup - make the board and get names
        //print board
        //loop while game is not over:
        //-turn
        //-print board
        //-change players
        setup();
        printBoard();

        int currentPlayer = 0;
        while ( !gameOver(currentPlayer) ) {
            turn(currentPlayer);
            printBoard();
            currentPlayer = change(currentPlayer);
        }
    }

    public static void setup() {
        System.out.println("how big is the board?");
        //can use the scanner object bc it's a class variable
        int size = s.nextInt();
        while (size < 1) {
            System.out.println("enter a positive number");
            size = s.nextInt();
        }
        board = new String[size][size];

        //set initial board values otherwise all null
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }

        s.nextLine();
        System.out.println("Player 1 - enter your name:");
        name[0] = s.nextLine();
        System.out.println("Player 2 - enter your name:");
        name[1] = s.nextLine();
    }

    public static void printBoard() {
        //the size var from setup() only exists in that method
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //param will be 1 or 0
    public static boolean gameOver(int nextPlayer) {

        //the currentPlayer is switched before game over is checked
        //so check game over on the previous (opposite) player's piece
        String p = piece[0];
        if (nextPlayer == 0)
            p = piece[1];

        boolean tie = true;
        for (int i = 0; i < board.length; i++) {

            int rowCount = 0;
            int colCount = 0;
            int d1Count = 0;
            int d2Count = 0;

            for (int j = 0; j < board.length; j++) {
                if( board[i][j].equals(p))
                    rowCount++;
                if (board[j][i].equals(p))
                    colCount++;
                if (board[j][j].equals(p))
                    d1Count++;
                if (board[j][board.length-1-j].equals(p))
                    d2Count++;
                if (board[i][j].equals("_"))
                    tie = false;
            }

            //return true when there's a win so that the game loop will stop
            if (rowCount == board.length || colCount == board.length || d1Count == board.length || d2Count == board.length) {
                System.out.println("You win!");
                return true;
            }
        }

        //this won't be reached if a win scenario has already returned true
        if (tie) {
            System.out.println("tie game");
            return true;
        }

        //will return false when there's no win and no tie
        return false;
    }

    //index will be 0 or 1
    public static void turn(int index) {
        System.out.println( name[index] + " - it's your turn. Place your " + piece[index]);

        System.out.println("enter row:");
        int row = s.nextInt();
        System.out.println("enter col:");
        int col = s.nextInt();
        while(row < 0 || row >= board.length || col < 0 || col >= board.length || !board[row][col].equals("_")) {
            System.out.println("Invalid spot.");
            System.out.print("enter row:");
            row = s.nextInt();
            System.out.println("enter col:");
            col = s.nextInt();
        }
        board[row][col] = piece[index];
    }

    //current will be 0 or 1 - return the other value
    public static int change(int current) {
        if (current == 0)
            return 1;
        return 0; //only the first return statement reached will run, then the method stops
    }
}
