package Jawaban2;

public class Kendaraan {
    private String jenisKendaraan;
    private int durasiParkir;

    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public double hitungBiayaParkir(int durasiParkir) {
        this.durasiParkir = durasiParkir;
        double totalBiaya = durasiParkir * biayaPerJam();

        if (durasiParkir > 5) {
            totalBiaya = totalBiaya - (totalBiaya * 0.10);
        }
        return totalBiaya;
    }

    public double hitungBiayaParkir(int jamMasuk, int jamKeluar) {
        this.durasiParkir = jamKeluar - jamMasuk;
        double totalBiaya = this.durasiParkir * biayaPerJam();

        if (this.durasiParkir > 5) {
            totalBiaya = totalBiaya - (totalBiaya * 0.10);
        }

        return totalBiaya;
    }

    public int biayaPerJam() {
        if (jenisKendaraan.equalsIgnoreCase("Motor")) {
            return 2000;
        } else if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
            return 5000;
        } else if (jenisKendaraan.equalsIgnoreCase("Truk")) {
            return 10000;
        } else {
            return 0;
        }
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getDurasiParkir() {
        return durasiParkir;
    }

    public void tampilkanRingkasan(double totalBiaya) {
        System.out.println("PARKING SUMMARY");
        System.out.println("Vehicle Type : " + jenisKendaraan);
        System.out.println("Parking Time : " + durasiParkir + " hour(s)");
        System.out.println("Total Fee    : Rp" + totalBiaya);
    }
}