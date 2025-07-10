package com.example.karaoke_poprock;

import java.sql.*;

import static javafx.scene.input.DataFormat.URL;

public class DBconnect {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Db_karaoke_poprock";
//    private static final String USER = "bone";
//    private static final String PASS = "RassBar290";
    private static final String USER = "Wyzord";
    private static final String PASS = "wyzord2006";

    public Connection conn;
    public Statement stat;
    public ResultSet result;
    public PreparedStatement pstat;

    public DBconnect() {
        try{
//            String url = "jdbc:sqlserver://localhost;database=Db_karaoke_poprock;user=bone;password=RassBar290";
            String url = "jdbc:sqlserver://localhost;database=Db_karaoke_poprock;user=Wyzord;password=wyzord2006";
            conn = DriverManager.getConnection(url);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error saat connect database: "+e);
        }
    }

    public static int getLastId() throws SQLException {
        String sql = "SELECT MAX(id_ruangan) FROM Ruangan";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0; // Jika tabel kosong
        }
    }

//    public ResultSet getRuangan() throws SQLException {
//        Statement statement;
//        ResultSet rs = null;
//        try{
//            statement = conn.createStatement();
//            rs = statement.executeQuery("SELECT * FROM master_Ruangan");
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return rs;
//    }



}
