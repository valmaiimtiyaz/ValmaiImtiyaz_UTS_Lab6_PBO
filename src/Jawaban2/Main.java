package Jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;
        String lanjut;

        System.out.println("==== Welcome to ParkingChan ========");

        do {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = scanner.nextLine();
            Kendaraan kendaraan = new Kendaraan(jenis);
            double biaya;

            System.out.print("Enter Duration (Manual/Time) : ");
            String pilihan = scanner.nextLine();

            if (pilihan.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour) : ");
                int durasi = scanner.nextInt();
                scanner.nextLine();
                biaya = kendaraan.hitungBiayaParkir(durasi);
            } else {
                System.out.print("Enter entry time : ");
                int jamMasuk = scanner.nextInt();
                System.out.print("Enter exit time  : ");
                int jamKeluar = scanner.nextInt();
                scanner.nextLine();
                biaya = kendaraan.hitungBiayaParkir(jamMasuk, jamKeluar);
            }

            System.out.println();
            kendaraan.tampilkanRingkasan(biaya);
            System.out.println();

            totalKendaraan++;
            totalSemuaBiaya+= biaya;

            System.out.print("Add another vehicle? (y/n): ");
            lanjut = scanner.nextLine();
            System.out.println();

        } while (lanjut.equalsIgnoreCase("y"));

        System.out.println("======== FINAL REPORT ========");
        System.out.println("Total Vehicle            : " + totalKendaraan);
        System.out.println("Final Total Parking Fees : " + totalSemuaBiaya);
        System.out.println("Thank You.....");

        scanner.close();
    }
}