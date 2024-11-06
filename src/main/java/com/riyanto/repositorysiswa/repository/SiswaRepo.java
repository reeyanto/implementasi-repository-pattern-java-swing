package com.riyanto.repositorysiswa.repository;

import com.riyanto.repositorysiswa.helper.Database;
import com.riyanto.repositorysiswa.model.Siswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SiswaRepo {

    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public SiswaRepo() {
        connection = Database.getConnection();
    }
    
    
    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();
        
        String sql = "SELECT * FROM siswa";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                siswaList.add(new Siswa(
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("jk"),
                    rs.getString("alamat")
                ));
            }
            
            return siswaList;
            
        } catch (SQLException ex) {
            Logger.getLogger(SiswaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public boolean addSiswa(Siswa siswa) {
        String sql = "INSERT INTO siswa VALUES (?, ?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, siswa.getNis());
            ps.setString(2, siswa.getNama());
            ps.setString(3, siswa.getJk());
            ps.setString(4, siswa.getAlamat());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SiswaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    public boolean updateSiswa(Siswa siswa) {
        String sql = "UPDATE siswa SET nama = ?, jk = ?, alamat = ? WHERE nis = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, siswa.getNama());
            ps.setString(2, siswa.getJk());
            ps.setString(3, siswa.getAlamat());
            ps.setString(4, siswa.getNis());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SiswaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    public boolean deleteSiswa(Siswa siswa) {
        String sql = "DELETE FROM siswa WHERE nis = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, siswa.getNis());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SiswaRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
