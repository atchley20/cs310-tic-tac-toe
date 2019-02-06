package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        TicTacToeMove NextMove;
        
        if(isXTurn)
        {
            System.out.println("Player 1 (X) Move:");
            System.out.println("Enter the row and column numbers, separated by a space: ");
            int row = keyboard.nextInt();
            int col = keyboard.nextInt();
            NextMove = new TicTacToeMove(row, col);
            return NextMove;
        }
        else
        {
            System.out.println("Player 2 (O) Move:");
            System.out.println("Enter the row and column numbers, separated by a space: ");
            int row = keyboard.nextInt();
            int col = keyboard.nextInt();
            NextMove = new TicTacToeMove(row, col);
            return NextMove;
        }

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
