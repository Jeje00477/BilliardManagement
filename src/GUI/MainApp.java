package GUI;

import Model.Booking;
import Model.Pelanggan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class MainApp extends JFrame {
    private JTextField tfNama, tfNomorTelepon, tfCari;
    private JSpinner spTanggal;
    private JComboBox<Integer> cbNomorMeja;
    private JComboBox<String> cbTipeMeja;
    private JTextArea taOutput;
    private java.util.List<Booking> bookings = new ArrayList<>();

    public MainApp() {
        setTitle("Sistem Booking Meja Billiard");
        setSize(1080, 1350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(245, 248, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;
        JLabel judul = new JLabel("\uD83C\uDFB1 Booking Meja Billiard");
        judul.setFont(new Font("Segoe UI", Font.BOLD, 28));
        judul.setForeground(new Color(30, 30, 60));
        gbc.gridx = 0; gbc.gridy = y++; gbc.gridwidth = 3; gbc.anchor = GridBagConstraints.CENTER;
        add(judul, gbc);
        gbc.anchor = GridBagConstraints.WEST; gbc.gridwidth = 1;

        // Input Form
        tfNama = new JTextField(20);
        tfNomorTelepon = new JTextField(15);
        spTanggal = new JSpinner(new SpinnerDateModel());
        spTanggal.setEditor(new JSpinner.DateEditor(spTanggal, "yyyy-MM-dd HH:mm"));

        Integer[] nomorMeja = new Integer[15];
        for (int i = 0; i < 15; i++) nomorMeja[i] = i + 1;
        cbNomorMeja = new JComboBox<>(nomorMeja);
        cbTipeMeja = new JComboBox<>(new String[]{"Normal", "VIP"});

        JButton btnSimpan = new JButton("Simpan Booking");

        addToPanel(gbc, 0, y, new JLabel("\uD83D\uDC64 Nama Pelanggan:"));
        addToPanel(gbc, 1, y++, tfNama);
        addToPanel(gbc, 0, y, new JLabel("\u260E\uFE0F Nomor Telepon:"));
        addToPanel(gbc, 1, y++, tfNomorTelepon);
        addToPanel(gbc, 0, y, new JLabel("\uD83D\uDCC5 Tanggal & Jam Booking:"));
        addToPanel(gbc, 1, y++, spTanggal);
        addToPanel(gbc, 0, y, new JLabel("\uD83D\uDC49 Nomor Meja:"));
        addToPanel(gbc, 1, y++, cbNomorMeja);
        addToPanel(gbc, 0, y, new JLabel("\u2728 Tipe Meja:"));
        addToPanel(gbc, 1, y++, cbTipeMeja);
        gbc.gridx = 1; gbc.gridy = y++;
        add(btnSimpan, gbc);

        // Separator
        gbc.gridx = 0; gbc.gridy = y++; gbc.gridwidth = 3;
        add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
        gbc.gridwidth = 1;

        // Area pencarian dan hasil
        tfCari = new JTextField(20);
        JButton btnCari = new JButton("Cari Booking");
        addToPanel(gbc, 0, y, new JLabel("\uD83D\uDD0D Cari Nama Pelanggan:"));
        addToPanel(gbc, 1, y++, tfCari);
        gbc.gridx = 1; gbc.gridy = y++;
        add(btnCari, gbc);

        taOutput = new JTextArea(15, 40);
        taOutput.setEditable(false);
        taOutput.setFont(new Font("Consolas", Font.PLAIN, 14));
        taOutput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scroll = new JScrollPane(taOutput);
        gbc.gridx = 0; gbc.gridy = y++; gbc.gridwidth = 3;
        add(scroll, gbc);
        gbc.gridwidth = 1;

        btnSimpan.addActionListener(e -> simpanBooking());
        btnCari.addActionListener(e -> cariBooking());
    }

    private void addToPanel(GridBagConstraints gbc, int x, int y, Component comp) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp, gbc);
    }

    private void simpanBooking() {
        String nama = tfNama.getText().trim();
        String telepon = tfNomorTelepon.getText().trim();
        Date date = (Date) spTanggal.getValue();
        LocalDateTime tanggal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        int nomorMeja = (int) cbNomorMeja.getSelectedItem();
        String tipeMeja = (String) cbTipeMeja.getSelectedItem();

        if (nama.isEmpty() || telepon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan telepon wajib diisi!");
            return;
        }

        Pelanggan pelanggan = new Pelanggan(nama, telepon);
        Booking booking = new Booking(pelanggan, tanggal, nomorMeja, tipeMeja);
        bookings.add(booking);
        JOptionPane.showMessageDialog(this, "Booking berhasil disimpan untuk " + nama);
        tfNama.setText("");
        tfNomorTelepon.setText("");
    }

    private void cariBooking() {
        String keyword = tfCari.getText().trim().toLowerCase();
        taOutput.setText("");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Booking b : bookings) {
            if (b.getPelanggan().getNama().toLowerCase().contains(keyword)) {
                taOutput.append("Nama: " + b.getPelanggan().getNama() +
                        " | Telepon: " + b.getPelanggan().getNomorTelepon() +
                        " | Meja: " + b.getNomorMeja() + " (" + b.getTipeMeja() + ")" +
                        " | Tanggal: " + b.getTanggalBooking().format(formatter) + "\n");
            }
        }
        if (taOutput.getText().isEmpty()) {
            taOutput.setText("Tidak ditemukan booking untuk kata kunci: " + keyword);
        }
    }

    
}
