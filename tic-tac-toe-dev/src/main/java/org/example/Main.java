package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';  // Starting player
        boolean gameContinue = true; // Flag to control game continuation

        while (gameContinue) {
            System.out.println("Current board layout:");
            gameBoard.printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column numbers (0 to 2):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (gameBoard.makeMove(row, col, currentPlayer)) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                // Add check here if the game should end
                // gameContinue = false; // This would be set based on game logic (win or draw)
            } else {
                System.out.println("Invalid move, try again.");
            }

            // Temporary condition to prevent infinite loop for testing
            // You should replace this with actual game end check
            if (gameBoard.isBoardFull()) { // Assume isBoardFull() is a method to check if the board is full
                gameContinue = false;
                System.out.println("Game over! Board is full.");
            }
        }

        scanner.close(); // Now this is reachable
    }
}
