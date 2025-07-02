package DAO;

import DataBase.DataBaseConnection;
import Model.Transaksi;
import java.sql.*;
import java.util.*;

public class TransaksiDAO {
    private Connection conn;

    public TransaksiDAO() {
        this.conn = DataBaseConnection.getConnection();
    }

    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM Transaksi";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaksi t = new Transaksi(
                    rs.getInt("ID_Transaksi"),
                    rs.getInt("ID_Pelanggan"),
                    rs.getInt("No_Meja"),
                    rs.getTimestamp("Waktu_Mulai"),
                    rs.getTimestamp("Waktu_Selesai"),
                    rs.getDouble("Total_Biaya"),
                    rs.getInt("ID_Karyawan"),
                    rs.getInt("ID_Layanan"),
                    rs.getInt("ID_Pembayaran")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertTransaksi(Transaksi t) {
        String sql = "INSERT INTO Transaksi (ID_Pelanggan, No_Meja, Waktu_Mulai, Waktu_Selesai, Total_Biaya, ID_Karyawan, ID_Layanan, ID_Pembayaran) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, t.getIdPelanggan());
            stmt.setInt(2, t.getNoMeja());
            stmt.setTimestamp(3, t.getWaktuMulai());
            stmt.setTimestamp(4, t.getWaktuSelesai());
            stmt.setDouble(5, t.getTotalBiaya());
            stmt.setInt(6, t.getIdKaryawan());
            stmt.setInt(7, t.getIdLayanan());
            stmt.setInt(8, t.getIdPembayaran());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

