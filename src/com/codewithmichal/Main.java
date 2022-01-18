package com.codewithmichal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] grid = new String[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.next();

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = String.valueOf(cells.charAt(k++));
            }
        }

        System.out.println("---------");
        for (String[] row : grid) {
            System.out.print("| ");
            for (String mark : row) {
                System.out.print(mark + " ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("---------");

    }
}
