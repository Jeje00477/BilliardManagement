package Model;

import java.sql.Timestamp;

public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private int noMeja;
    private Timestamp waktuMulai;
    private Timestamp waktuSelesai;
    private double totalBiaya;
    private int idKaryawan;
    private int idLayanan;
    private int idPembayaran;

    // Constructor
    public Transaksi() {}

    public Transaksi(int idTransaksi, int idPelanggan, int noMeja, Timestamp waktuMulai, Timestamp waktuSelesai, double totalBiaya, int idKaryawan, int idLayanan, int idPembayaran) {
        this.idTransaksi = idTransaksi;
        this.idPelanggan = idPelanggan;
        this.noMeja = noMeja;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.totalBiaya = totalBiaya;
        this.idKaryawan = idKaryawan;
        this.idLayanan = idLayanan;
        this.idPembayaran = idPembayaran;
    }

    // Getters and Setters
    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int idPelanggan) { this.idPelanggan = idPelanggan; }

    public int getNoMeja() { return noMeja; }
    public void setNoMeja(int noMeja) { this.noMeja = noMeja; }

    public Timestamp getWaktuMulai() { return waktuMulai; }
    public void setWaktuMulai(Timestamp waktuMulai) { this.waktuMulai = waktuMulai; }

    public Timestamp getWaktuSelesai() { return waktuSelesai; }
    public void setWaktuSelesai(Timestamp waktuSelesai) { this.waktuSelesai = waktuSelesai; }

    public double getTotalBiaya() { return totalBiaya; }
    public void setTotalBiaya(double totalBiaya) { this.totalBiaya = totalBiaya; }

    public int getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(int idKaryawan) { this.idKaryawan = idKaryawan; }

    public int getIdLayanan() { return idLayanan; }
    public void setIdLayanan(int idLayanan) { this.idLayanan = idLayanan; }

    public int getIdPembayaran() { return idPembayaran; }
    public void setIdPembayaran(int idPembayaran) { this.idPembayaran = idPembayaran; }
}
