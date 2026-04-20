package Jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();

        while (!lotre.isGameOver()) {
            lotre.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom): ");
            int row = input.nextInt();
            int col = input.nextInt();

            boolean hasil = lotre.guess(row, col);

            if (!hasil) {
                System.out.println("BOOM!!!! Anda menemukan bom!! Permainan berakhir T-T");
                lotre.displayBoard();
                break;
            }

            if (lotre.isGameOver()) {
                System.out.println("Selamat anda menang.");
                lotre.displayBoard();
                break;
            }
        }

        input.close();
    }
}