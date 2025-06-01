/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author jeje
 */

import java.sql.*;
import java.util.*;
import Model.Karyawan;
import DataBase.DataBaseConnection;

public class KaryawanDAO {
    
    private Connection conn;
    
    public KaryawanDAO(){
        this.conn = DataBaseConnection.getConnection();
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM Karyawan WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error logging in: " + e.getMessage());
            return false;
        }
    }
}
