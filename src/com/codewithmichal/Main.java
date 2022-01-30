package com.codewithmichal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = createBoard();

        game(board);

        System.out.println(result(board));

    }

    public static void game(String[][] board) {
        printingBoard(board);
        Scanner scanner = new Scanner(System.in);
        String player = "X";
        int first;
        int second;
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                first = Integer.parseInt(scanner.next());
                second = Integer.parseInt(scanner.next());
                if ((first > 3 || first < 1) || (second > 3 || second < 1)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (!board[first - 1][second - 1].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                makeMove(board, player, first, second);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            printingBoard(board);
            if ((isWinner(player, board))) {
               break;
            } else if ((!isWinner(player, board))){
                if (player.equals("O")) {
                    player = "X";
                } else {
                    player = "O";
                }
            }
        }
    }

    // Make a move
    public static void makeMove(String[][] board, String player, int row, int column) {
        board[row - 1][column - 1] = player;
    }

    // Creating the board
    public static String[][] createBoard() {
        String[][] grid = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }
        return grid;
    }

    // Printing the board
    public static void printingBoard(String[][] board) {
        System.out.println("---------");
        for (String[] row : board) {
            System.out.print("| ");
            for (String mark : row) {
                System.out.print(mark + " ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("---------");
    }

    // Printing result
    public static String result(String[][] board) {
        if (isWinner("X", board)) {
            return "X wins";
        } else if (isWinner("O", board)) {
            return "O wins";
        }
        return "Draw";
    }

    // Check for the winner
    public static boolean isWinner(String player, String[][] gameGrid) {
        for (int i = 0; i < gameGrid.length; i++) {
            int row = 0;
            int column = 0;
            for (int j = 0; j < gameGrid[i].length; j++) {
                if (gameGrid[i][j].equals(player)) {
                    row++; // check row
                }
                if (gameGrid[j][i].equals(player)) {
                    column++; // check column
                }
            }
            if ((row == 3) || (column == 3)) {
                return true;
            }
        }
        if (gameGrid[0][0].equals(player) && gameGrid[1][1].equals(player) && gameGrid[2][2].equals(player)) {
            return true;
        } else return gameGrid[0][2].equals(player) && gameGrid[1][1].equals(player) && gameGrid[2][0].equals(player);
    }

}
