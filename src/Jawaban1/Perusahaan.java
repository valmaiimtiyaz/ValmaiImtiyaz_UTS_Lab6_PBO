package Jawaban1;

import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    // Mengembalikan seluruh daftar karyawan
    public ArrayList<Karyawan> getDaftarKaryawan() {
        return daftarKaryawan;
    }

    // Mengambil data karyawan berdasarkan ID
    public Karyawan getKaryawanById(String id) {
        return cariKaryawanById(id);
    }

    // Menambahkan karyawan baru dengan validasi ID dan gaji
    public String tambahKaryawan(String id, String nama, String posisi, double gaji) {
        if (cariKaryawanById(id) != null) {
            return "ID karyawan sudah terdaftar.";
        }
        if (gaji < 0) {
            return "Gaji tidak boleh bernilai negatif.";
        }
        Karyawan k = new Karyawan(id, nama, posisi, gaji);
        daftarKaryawan.add(k);
        return "Data karyawan berhasil disimpan.";
    }

    // Menghapus data karyawan berdasarkan ID
    public String hapusKaryawan(String id) {
        Karyawan k = cariKaryawanById(id);
        if (k == null) {
            return "Data karyawan tidak ditemukan.";
        }
        daftarKaryawan.remove(k);
        return "Data karyawan berhasil dihapus.";
    }

    // Mengubah posisi karyawan berdasarkan ID
    public String ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawanById(id);
        if (k == null) {
            return "Data karyawan tidak ditemukan.";
        }
        k.setPosisi(posisiBaru);
        return "Posisi karyawan berhasil diperbarui.";
    }

    // Mengubah gaji karyawan berdasarkan ID dengan validasi gaji
    public String ubahGaji(String id, double gajiBaru) {
        Karyawan k = cariKaryawanById(id);
        if (k == null) {
            return "Data karyawan tidak ditemukan.";
        }
        if (gajiBaru < 0) {
            return "Gaji tidak boleh bernilai negatif.";
        }

        k.setGaji(gajiBaru);
        return "Gaji karyawan berhasil diperbarui.";
    }

    // Mencari data karyawan dan mengembalikannya dalam bentuk string
    public String cariKaryawan(String id) {
        Karyawan k = cariKaryawanById(id);
        if (k == null) {
            return "Data karyawan tidak ditemukan.";
        }
        return k.toString();
    }

    // Menghitung total seluruh gaji karyawan
    public double totalGaji() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.getGaji();
        }
        return total;
    }

    // Method private untuk mencari objek karyawan berdasarkan ID
    private Karyawan cariKaryawanById(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k;
            }
        }
        return null;
    }
}
