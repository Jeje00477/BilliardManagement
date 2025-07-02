package DAO;

import DataBase.DataBaseConnection;
import Model.Pelanggan;
import java.sql.*;

public class PelangganDAO {
    private Connection conn;

    public PelangganDAO() {
        this.conn = DataBaseConnection.getConnection();
    }

    public int insertPelanggan(Pelanggan p) {
        String sql = "INSERT INTO Pelanggan (Nama, No_Telepon) OUTPUT INSERTED.ID_Pelanggan VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNama());
            stmt.setString(2, p.getNomorTelepon());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // ID Pelanggan yang baru diinsert
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
