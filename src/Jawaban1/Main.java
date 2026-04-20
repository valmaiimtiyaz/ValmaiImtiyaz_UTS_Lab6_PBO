package Jawaban1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {
    private Perusahaan perusahaan = new Perusahaan();

    // Komponen utama pada tampilan GUI
    private JFrame frame;
    private JTextField tfId, tfNama, tfPosisi, tfGaji;
    private JTextField tfCariId, tfFilterPosisi;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel labelTotalGaji;

    // Constructor untuk membangun tampilan aplikasi
    public Main() {
        frame = new JFrame("Manajemen Data Karyawan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(Color.decode("#DFD0B8"));

        // Panel kiri untuk form input data karyawan
        JPanel panelForm = new JPanel(new BorderLayout());
        panelForm.setBackground(Color.decode("#DFD0B8"));
        panelForm.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#393E46")));
        panelForm.setPreferredSize(new Dimension(320, 0));

        JPanel panelFormCenter = new JPanel(new GridBagLayout());
        panelFormCenter.setBackground(Color.decode("#DFD0B8"));

        JPanel panelIsiForm = new JPanel();
        panelIsiForm.setLayout(new BoxLayout(panelIsiForm, BoxLayout.Y_AXIS));
        panelIsiForm.setBackground(Color.decode("#DFD0B8"));

        JLabel lblJudulForm = new JLabel("Form Data Karyawan");
        lblJudulForm.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblJudulForm.setForeground(Color.decode("#393E46"));
        lblJudulForm.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblJudulForm.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel panelField = new JPanel(new GridLayout(4, 2, 5, 5));
        panelField.setBackground(Color.decode("#DFD0B8"));
        panelField.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));

        JLabel lblId = new JLabel("ID:");
        lblId.setHorizontalAlignment(SwingConstants.LEFT);
        lblId.setForeground(Color.decode("#393E46"));
        panelField.add(lblId);
        tfId = new JTextField(10);
        tfId.setForeground(Color.decode("#393E46"));
        panelField.add(tfId);

        JLabel lblNama = new JLabel("Nama:");
        lblNama.setHorizontalAlignment(SwingConstants.LEFT);
        lblNama.setForeground(Color.decode("#393E46"));
        panelField.add(lblNama);
        tfNama = new JTextField(10);
        tfNama.setForeground(Color.decode("#393E46"));
        panelField.add(tfNama);

        JLabel lblPosisi = new JLabel("Posisi:");
        lblPosisi.setHorizontalAlignment(SwingConstants.LEFT);
        lblPosisi.setForeground(Color.decode("#393E46"));
        panelField.add(lblPosisi);
        tfPosisi = new JTextField(10);
        tfPosisi.setForeground(Color.decode("#393E46"));
        panelField.add(tfPosisi);

        JLabel lblGaji = new JLabel("Gaji:");
        lblGaji.setHorizontalAlignment(SwingConstants.LEFT);
        lblGaji.setForeground(Color.decode("#393E46"));
        panelField.add(lblGaji);
        tfGaji = new JTextField(10);
        tfGaji.setForeground(Color.decode("#393E46"));
        panelField.add(tfGaji);

        // Tombol untuk simpan data dan hapus data
        JPanel panelCrud = new JPanel(new GridLayout(2, 1, 0, 5));
        panelCrud.setBackground(Color.decode("#DFD0B8"));
        JButton btnSimpan = new JButton("Simpan (Tambah/Update)");
        JButton btnHapus = new JButton("Hapus");
        btnSimpan.setBackground(Color.decode("#948979"));
        btnSimpan.setForeground(Color.decode("#222831"));
        btnHapus.setBackground(Color.decode("#948979"));
        btnHapus.setForeground(Color.decode("#222831"));
        panelCrud.add(btnSimpan);
        panelCrud.add(btnHapus);

        panelIsiForm.add(lblJudulForm);
        panelIsiForm.add(panelField);
        panelIsiForm.add(panelCrud);

        panelFormCenter.add(panelIsiForm);
        panelForm.add(panelFormCenter, BorderLayout.CENTER);
        frame.add(panelForm, BorderLayout.WEST);

        // Panel kanan atas untuk fitur cari dan filter
        JPanel panelCariFilter = new JPanel(new GridBagLayout());
        panelCariFilter.setBackground(Color.decode("#DFD0B8"));
        panelCariFilter.setBorder(BorderFactory.createTitledBorder("Cari & Filter"));
        ((javax.swing.border.TitledBorder) panelCariFilter.getBorder()).setTitleColor(Color.decode("#393E46"));

        JLabel lblCariId = new JLabel("Cari ID:");
        lblCariId.setForeground(Color.decode("#393E46"));
        panelCariFilter.add(lblCariId, createConstraints(0, 0, 0));

        tfCariId = new JTextField();
        tfCariId.setForeground(Color.decode("#393E46"));
        panelCariFilter.add(tfCariId, createConstraints(1, 0, 1.0));

        JButton btnCari = new JButton("Cari");
        btnCari.setBackground(Color.decode("#948979"));
        btnCari.setForeground(Color.decode("#222831"));
        panelCariFilter.add(btnCari, createConstraints(2, 0, 0));

        JLabel lblFilterPosisi = new JLabel("Filter Posisi:");
        lblFilterPosisi.setForeground(Color.decode("#393E46"));
        panelCariFilter.add(lblFilterPosisi, createConstraints(0, 1, 0));

        tfFilterPosisi = new JTextField();
        tfFilterPosisi.setForeground(Color.decode("#393E46"));
        panelCariFilter.add(tfFilterPosisi, createConstraints(1, 1, 1.0));

        JButton btnFilter = new JButton("Filter");
        btnFilter.setBackground(Color.decode("#948979"));
        btnFilter.setForeground(Color.decode("#222831"));
        panelCariFilter.add(btnFilter, createConstraints(2, 1, 0));

        JButton btnTampilSemua = new JButton("Tampilkan Semua");
        btnTampilSemua.setBackground(Color.decode("#948979"));
        btnTampilSemua.setForeground(Color.decode("#222831"));
        GridBagConstraints cfButton = createConstraints(0, 2, 0);
        cfButton.gridwidth = 3;
        panelCariFilter.add(btnTampilSemua, cfButton);

        // Panel tabel untuk menampilkan daftar karyawan
        JPanel panelTabel = new JPanel(new BorderLayout());
        panelTabel.setBackground(Color.decode("#DFD0B8"));
        panelTabel.setBorder(BorderFactory.createTitledBorder("Daftar Karyawan"));
        ((javax.swing.border.TitledBorder) panelTabel.getBorder()).setTitleColor(Color.decode("#393E46"));

        String[] kolom = {"ID", "Nama", "Posisi", "Gaji"};
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#222831"));
        table.setGridColor(Color.BLACK);
        table.setRowHeight(25);
        table.getTableHeader().setBackground(Color.decode("#948979"));
        table.getTableHeader().setForeground(Color.decode("#222831"));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        panelTabel.add(scrollPane, BorderLayout.CENTER);

        labelTotalGaji = new JLabel("Total Gaji Seluruh Karyawan: Rp0");
        labelTotalGaji.setForeground(Color.decode("#393E46"));
        panelTabel.add(labelTotalGaji, BorderLayout.SOUTH);

        JPanel panelKanan = new JPanel(new BorderLayout(5, 5));
        panelKanan.setBackground(Color.decode("#DFD0B8"));
        panelKanan.add(panelCariFilter, BorderLayout.NORTH);
        panelKanan.add(panelTabel, BorderLayout.CENTER);
        frame.add(panelKanan, BorderLayout.CENTER);

        // Menghubungkan tombol dengan method yang sesuai
        btnSimpan.addActionListener(e -> simpanData());
        btnHapus.addActionListener(e -> hapusData());
        btnCari.addActionListener(e -> cariData());
        btnFilter.addActionListener(e -> filterData());
        btnTampilSemua.addActionListener(e -> refreshTabel());

        // Menampilkan data awal dan menampilkan frame
        refreshTabel();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method untuk menyimpan data baru atau memperbarui data lama
    private void simpanData() {
        String id = tfId.getText().trim();
        String nama = tfNama.getText().trim();
        String posisi = tfPosisi.getText().trim();
        String gajiText = tfGaji.getText().trim();

        if (id.isEmpty()) {
            showMessage("Silakan isi ID terlebih dahulu.");
            return;
        }

        Karyawan existing = perusahaan.getKaryawanById(id);

        // Jika ID belum ada, data dianggap sebagai data baru
        if (existing == null) {
            if (nama.isEmpty() || posisi.isEmpty() || gajiText.isEmpty()) {
                showMessage("Untuk menambahkan data baru, nama, posisi, dan gaji harus diisi lengkap.");
                return;
            }

            try {
                double gaji = Double.parseDouble(gajiText);
                String pesan = perusahaan.tambahKaryawan(id, nama, posisi, gaji);
                showMessage(pesan);

                if (pesan.contains("berhasil")) {
                    refreshTabel();
                    clearForm();
                }
            } catch (NumberFormatException ex) {
                showMessage("Gaji harus diisi dalam format angka.");
            }
        } else {
            // Jika ID sudah ada, data dianggap sebagai update
            if (nama.isEmpty()) {
                nama = existing.getNama();
            }
            if (posisi.isEmpty() && gajiText.isEmpty()) {
                showMessage("Isi posisi atau gaji untuk memperbarui data karyawan.");
                return;
            }
            if (!nama.equals(existing.getNama())) {
                showMessage("Nama karyawan tidak dapat diubah.");
                return;
            }

            try {
                String pesanPosisi = "";
                String pesanGaji = "";

                if (!posisi.isEmpty()) {
                    pesanPosisi = perusahaan.ubahPosisi(id, posisi);
                }
                if (!gajiText.isEmpty()) {
                    double gajiBaru = Double.parseDouble(gajiText);
                    pesanGaji = perusahaan.ubahGaji(id, gajiBaru);
                }
                if ((pesanPosisi + pesanGaji).contains("berhasil")) {
                    showMessage("Data karyawan berhasil diperbarui.");
                    refreshTabel();
                    clearForm();
                } else {
                    String pesanGabungan = (pesanPosisi + "\n" + pesanGaji).trim();
                    showMessage(pesanGabungan);
                }
            } catch (NumberFormatException ex) {
                showMessage("Gaji harus diisi dalam format angka.");
            }
        }
    }

    // Method untuk menghapus data karyawan berdasarkan ID
    private void hapusData() {
        String id = tfId.getText().trim();

        if (id.isEmpty()) {
            showMessage("Masukkan ID karyawan yang ingin dihapus.");
            return;
        }
        String pesan = perusahaan.hapusKaryawan(id);
        showMessage(pesan);
        if (pesan.contains("berhasil")) {
            refreshTabel();
            clearForm();
        }
    }

    // Method untuk mencari satu karyawan berdasarkan ID
    private void cariData() {
        String id = tfCariId.getText().trim();

        if (id.isEmpty()) {
            showMessage("Masukkan ID yang ingin dicari.");
            return;
        }

        tableModel.setRowCount(0);
        Karyawan ditemukan = perusahaan.getKaryawanById(id);
        if (ditemukan == null) {
            showMessage("Data karyawan tidak ditemukan.");
        } else {
            tableModel.addRow(new Object[]{
                    ditemukan.getId(),
                    ditemukan.getNama(),
                    ditemukan.getPosisi(),
                    ditemukan.getGaji()
            });
        }
        labelTotalGaji.setText("Total Gaji Seluruh Karyawan: Rp" + perusahaan.totalGaji());
    }

    // Method untuk memfilter data karyawan berdasarkan posisi
    private void filterData() {
        String posisi = tfFilterPosisi.getText().trim();
        if (posisi.isEmpty()) {
            showMessage("Masukkan posisi yang ingin difilter.");
            return;
        }
        tableModel.setRowCount(0);

        for (Karyawan k : perusahaan.getDaftarKaryawan()) {
            if (k.getPosisi().equalsIgnoreCase(posisi)) {
                tableModel.addRow(new Object[]{
                        k.getId(),
                        k.getNama(),
                        k.getPosisi(),
                        k.getGaji()
                });
            }
        }
        labelTotalGaji.setText("Total Gaji Seluruh Karyawan: Rp" + perusahaan.totalGaji());
    }

    // Method bantuan untuk mengatur posisi komponen pada GridBagLayout
    private GridBagConstraints createConstraints(int x, int y, double weightx) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = weightx;
        return gbc;
    }

    // Method untuk menampilkan seluruh data karyawan ke tabel
    private void refreshTabel() {
        tableModel.setRowCount(0);
        for (Karyawan k : perusahaan.getDaftarKaryawan()) {
            tableModel.addRow(new Object[]{
                    k.getId(),
                    k.getNama(),
                    k.getPosisi(),
                    k.getGaji()
            });
        }
        labelTotalGaji.setText("Total Gaji Seluruh Karyawan: Rp" + perusahaan.totalGaji());
    }

    // Method untuk mengosongkan kembali field input
    private void clearForm() {
        tfId.setText("");
        tfNama.setText("");
        tfPosisi.setText("");
        tfGaji.setText("");
    }

    // Method untuk menampilkan pesan popup kepada pengguna
    private void showMessage(String message) {
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JOptionPane.showMessageDialog(frame, label, "Pesan", JOptionPane.PLAIN_MESSAGE);
    }

    // Method utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
