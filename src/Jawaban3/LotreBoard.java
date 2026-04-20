package Jawaban3;

import java.util.Random;

public class LotreBoard {
    char[][] board;
    boolean[][] revealed;
    int[][] data;
    boolean gameOver;

    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        gameOver = false;
        generateBoard();
    }

    public void generateBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }

        Random random = new Random();
        int jumlahBom = 0;

        while (jumlahBom < 2) {
            int row = random.nextInt(4);
            int col = random.nextInt(5);

            if (data[row][col] == 0) {
                data[row][col] = 1;
                jumlahBom++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            gameOver = true;
            return false;
        } else {
            board[row][col] = 'O';
            return true;
        }
    }

    public boolean isGameOver() {
        if (gameOver) {
            return true;
        }

        int jumlahAmanTerbuka = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (data[i][j] == 0 && revealed[i][j]) {
                    jumlahAmanTerbuka++;
                }
            }
        }

        return jumlahAmanTerbuka == 18;
    }
}