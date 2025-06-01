import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;

public class MainApp extends JFrame {
    private JTextField tfNama, tfNomorTelepon, tfCari;
    private JSpinner spTanggal, spJamMulai, spJamSelesai;
    private JComboBox<Integer> cbNomorMeja;
    private JComboBox<String> cbTipeMeja;
    private JTextArea taOutput;

    private java.util.List<Booking> daftarBooking = new ArrayList<>();

    public MainApp() {
        setTitle("Sistem Booking Billiard");
        setSize(1080, 1350); // Resolusi 4:5
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Inisialisasi komponen
        tfNama = new JTextField(20);
        tfNomorTelepon = new JTextField(15);
        spTanggal = new JSpinner(new SpinnerDateModel());
        spTanggal.setEditor(new JSpinner.DateEditor(spTanggal, "dd-MM-yyyy"));

        spJamMulai = new JSpinner(new SpinnerDateModel());
        spJamMulai.setEditor(new JSpinner.DateEditor(spJamMulai, "HH:mm"));

        spJamSelesai = new JSpinner(new SpinnerDateModel());
        spJamSelesai.setEditor(new JSpinner.DateEditor(spJamSelesai, "HH:mm"));

        cbTipeMeja = new JComboBox<>(new String[]{"Normal", "VIP"});
        cbNomorMeja = new JComboBox<>();
        for (int i = 1; i <= 15; i++) cbNomorMeja.addItem(i);

        JButton btnSimpan = new JButton("Simpan Booking");
        JButton btnCari = new JButton("Cari Booking");
        tfCari = new JTextField(15);
        taOutput = new JTextArea(8, 40);
        taOutput.setEditable(false);

        // Tambah action listener
        btnSimpan.addActionListener(e -> simpanBooking());
        btnCari.addActionListener(e -> cariBooking());

        // Layout komponen
        int y = 0;
        addToPanel(gbc, 0, y, new JLabel("Nama Pelanggan:"));
        addToPanel(gbc, 1, y++, tfNama);
        addToPanel(gbc, 0, y, new JLabel("Nomor Telepon:"));
        addToPanel(gbc, 1, y++, tfNomorTelepon);
        addToPanel(gbc, 0, y, new JLabel("Tanggal Booking:"));
        addToPanel(gbc, 1, y++, spTanggal);
        addToPanel(gbc, 0, y, new JLabel("Jam Mulai:"));
        addToPanel(gbc, 1, y++, spJamMulai);
        addToPanel(gbc, 0, y, new JLabel("Jam Selesai:"));
        addToPanel(gbc, 1, y++, spJamSelesai);
        addToPanel(gbc, 0, y, new JLabel("Tipe Meja:"));
        addToPanel(gbc, 1, y++, cbTipeMeja);
        addToPanel(gbc, 0, y, new JLabel("Nomor Meja:"));
        addToPanel(gbc, 1, y++, cbNomorMeja);
        addToPanel(gbc, 0, y, btnSimpan);

        addToPanel(gbc, 0, ++y, new JLabel("Cari berdasarkan nama:"));
        addToPanel(gbc, 1, y, tfCari);
        addToPanel(gbc, 2, y++, btnCari);

        gbc.gridx = 0;
        gbc.gridy = ++y;
        gbc.gridwidth = 3;
        add(taOutput, gbc);
    }

    private void addToPanel(GridBagConstraints gbc, int x, int y, Component comp) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        add(comp, gbc);
    }

    private void simpanBooking() {
        String nama = tfNama.getText().trim();
        String telepon = tfNomorTelepon.getText().trim();
        if (nama.isEmpty() || telepon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan telepon tidak boleh kosong.");
            return;
        }

        Date tanggal = (Date) spTanggal.getValue();
        Date jamMulai = (Date) spJamMulai.getValue();
        LocalTime timeMulai = LocalDateTime.ofInstant(jamMulai.toInstant(), ZoneId.systemDefault()).toLocalTime();

        LocalDate localDate = LocalDateTime.ofInstant(tanggal.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDateTime waktuBooking = LocalDateTime.of(localDate, timeMulai);

        int nomorMeja = (int) cbNomorMeja.getSelectedItem();
        String tipeMeja = (String) cbTipeMeja.getSelectedItem();

        Pelanggan pelanggan = new Pelanggan(nama, telepon);
        Booking booking = new Booking(pelanggan, waktuBooking, nomorMeja, tipeMeja);
        daftarBooking.add(booking);

        JOptionPane.showMessageDialog(this, "Booking berhasil disimpan!");
    }

    private void cariBooking() {
        String keyword = tfCari.getText().trim().toLowerCase();
        taOutput.setText("");

        for (Booking b : daftarBooking) {
            if (b.getPelanggan().getNama().toLowerCase().contains(keyword)) {
                taOutput.append("Nama: " + b.getPelanggan().getNama() +
                        "\nTelepon: " + b.getPelanggan().getNomorTelepon() +
                        "\nTanggal: " + b.getTanggalBooking().toLocalDate() +
                        "\nJam: " + b.getTanggalBooking().toLocalTime() +
                        "\nMeja: " + b.getNomorMeja() + " (" + b.getTipeMeja() + ")\n\n");
            }
        }

        if (taOutput.getText().isEmpty()) {
            taOutput.setText("Tidak ada booking ditemukan.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
