/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jovanni
 */
public class DatabaseManager {
    private static Connection conn;
    
    public static void openConnection() throws SQLException {
        DatabaseManager.conn = DriverManager.getConnection("jdbc:sqlite:users.db");
    }
    
    public static void openSong() throws SQLException {
        DatabaseManager.conn = DriverManager.getConnection("jdbc:sqlite:songs.db");
    }
    
    public static boolean addUser(String username, String password) throws SQLException {
        openConnection();
        Statement st = conn.createStatement();
        
        if (usernameExists(username)) {
            return false;
        }
        
        String insertStatement = "INSERT INTO users (NAME, PASSWORD) " + 
                "VALUES ('" + username + "', '" + password + "');";
        st.execute(insertStatement);
        return true;
    }
    
    public static void addUserSong(String un, String tr, String ar, String al, String ge) throws SQLException {
        openSong();
        Statement st = conn.createStatement();
        
        String insertStatement = "INSERT INTO songs (USER, TRACK, ARTIST, ALBUM, GENRE) " + 
                "VALUES ('" + un + "', '" + tr + "', '" + ar + "', '" + al + "', '" + ge + "');";
        st.execute(insertStatement);
    }
    
    public static void createTableUser() throws SQLException {
        openConnection();
        Statement st = conn.createStatement();
        
        String createStatement = "CREATE TABLE IF NOT EXISTS users " + 
                "(ID INTEGER PRIMARY KEY autoincrement, " + 
                "NAME TEXT NOT NULL, " +
                "PASSWORD TEXT NOT NULL);";
        st.execute(createStatement);
    }
    
    public static void createTableSong() throws SQLException {
        openSong();
        Statement st = conn.createStatement();
        
        st = conn.createStatement();
        String createStatement = "CREATE TABLE IF NOT EXISTS songs " + 
                "(ID INTEGER PRIMARY KEY autoincrement, " + 
                "USER TEXT NOT NULL, " +
                "TRACK TEXT NOT NULL, " +
                "ARTIST TEXT NOT NULL, " +
                "ALBUM TEXT NOT NULL, " +
                "GENRE TEXT NOT NULL);";
        st.execute(createStatement);
    }
    
    public static boolean usernameExists(String username) throws SQLException {
        openConnection();
        Statement st = conn.createStatement();
        String getStatement = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(getStatement);
        
        while (rs.next()) {
            if ((username.toUpperCase()).equals(rs.getString(2).toUpperCase())) {
                return true;
            }
        }
        return false;
    }
    
    public static ObservableList<userSong> getAllSong(String user) throws SQLException {
        openSong();
        Statement st = conn.createStatement();
        String getStatement = "SELECT * FROM songs WHERE USER = '" + user + "';";
        ResultSet rs = st.executeQuery(getStatement);
        
        ObservableList<userSong> data = FXCollections.observableArrayList();
        while(rs.next()) {
            data.add(new userSong(new SimpleStringProperty(rs.getString(3)), 
                    new SimpleStringProperty(rs.getString(4)), 
                    new SimpleStringProperty(rs.getString(5)), 
                    new SimpleStringProperty(rs.getString(6))));
        }
        
        return data;
    }
    
    public static String getPassword(String username) throws SQLException {
        openConnection();
        Statement st = conn.createStatement();
        
        String getStatement = "SELECT * FROM users where NAME = '" + username + "';";
        ResultSet rs = st.executeQuery(getStatement);
        
        return rs.getString(3);
    }
    
    public static boolean login (String username, String password) throws SQLException {
        openConnection();
        if (usernameExists(username)) {
            String correctPassword = getPassword(username);
            if (correctPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
