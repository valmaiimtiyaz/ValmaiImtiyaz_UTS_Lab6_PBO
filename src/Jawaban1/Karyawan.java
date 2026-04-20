package Jawaban1;

public class Karyawan {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;

    // Constructor untuk mengisi data awal karyawan
    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    // Getter digunakan untuk mengambil nilai atribut
    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getPosisi() {
        return posisi;
    }
    public double getGaji() {
        return gaji;
    }

    // Setter digunakan untuk mengubah nilai atribut yang diperlukan
    public void setNama (String nama){
        this.nama = nama;
    }
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    // Method toString digunakan untuk menampilkan data karyawan dalam bentuk teks
    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: Rp" + gaji;
    }
}
