package com.riyanto.repositorysiswa.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost/repository_siswa_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static synchronized Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
