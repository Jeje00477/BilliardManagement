/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DAO.KaryawanDAO;
import Model.Karyawan;
import java.sql.*;
/**
 *
 * @author jeje
 */
public class KaryawanService {
    private KaryawanDAO DAO;
    
    public KaryawanService() throws SQLException{
        DAO = new KaryawanDAO();
    }
    
    public boolean Login(String username, String password){
        return DAO.login(username, password);
    }
}
