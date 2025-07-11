package com.example.karaoke_poprock;

import Master.Karyawan;
import Master.swalAlert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class DasLogin {

    swalAlert alert = new swalAlert();

    DBconnect connection = new DBconnect();

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;
    Karyawan usr = new Karyawan();

    int idkaryawan;
    String user, pass, role;


    @FXML
    protected void onBtnLogin() {
        user = txtUsername.getText();
        pass = txtPassword.getText();

//        // Validation checks
//        if (user.isEmpty() || pass.isEmpty()) {
//           alert.showAlert(Alert.AlertType.WARNING, "ERROR","Username dan Password tidak boleh kosong", false);
//            return;
//        }

        try {
            String sql = "EXEC sp_loginKaryawan @username = ?, @password = ?";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.pstat.setString(1, user);
            connection.pstat.setString(2, pass);

            ResultSet rs = connection.pstat.executeQuery();

            if (rs.next()) {
                alert.showAlert(Alert.AlertType.INFORMATION, "SUCCESS", "Login Success, welcome "+rs.getString("username"),false);
                     idkaryawan = rs.getInt("id_karyawan");
                     user = rs.getString("username");
                     role = rs.getString("role");
                     pindahHome(idkaryawan, user, role);
                     //connection.pstat.close();

            }

            connection.pstat.close();
        } catch (SQLException e) {
//            System.out.println("Error: " + e);
            //alert.showAlert(Alert.AlertType.ERROR, "ERROR",  "Data " + e, false);
            String errorMessage = e.getMessage();

            if (errorMessage.contains("Username tidak ditemukan")) {
                alert.showAlert(Alert.AlertType.ERROR, "LOGIN FAILED", "Username tidak ditemukan", false);
            } else if (errorMessage.contains("Password salah")) {
                alert.showAlert(Alert.AlertType.ERROR, "LOGIN FAILED", "Password salah", false);
            } else if (errorMessage.contains("Akun tidak aktif")) {
                alert.showAlert(Alert.AlertType.ERROR, "LOGIN FAILED", "Akun Anda tidak aktif", false);
            } else if (errorMessage.contains("Username tidak boleh kosong") ||
                    errorMessage.contains("Password tidak boleh kosong") ||
                    errorMessage.contains("Tidak boleh ada field yang kosong")) {
                alert.showAlert(Alert.AlertType.WARNING, "ERROR", errorMessage, false);
            } else {
                System.out.println("Error: " + e);
                alert.showAlert(Alert.AlertType.ERROR, "ERROR", "Terjadi kesalahan saat login: " + e.getMessage(), false);
            }

        }


    }

    public void pindahHome(int id, String username, String role) {
        try {
            FXMLLoader loader = null;
            System.out.println(role);

            if ("Admin".equals(role)) {
                loader = new FXMLLoader(getClass().getResource("DasHome.fxml"));
                Parent root = loader.load();

                DasHome controller = loader.getController();
                controller.setName(username);

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                Scene scene = new Scene(root, stage.getWidth(), stage.getHeight()); // supaya langsung matching
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
//                // Load halaman home
//                loader = new FXMLLoader(getClass().getResource("DasHome.fxml"));
//                Parent root = loader.load();
//
//                //Mendapatkan stage dari salah satu node di scene saat ini
//                Stage stage = (Stage) txtUsername.getScene().getWindow();
//
//                // Set scene baru
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setTitle("Admin Page");
//                stage.show();
            }else if("Kasir".equals(role)){
                // Load halaman home
                loader = new FXMLLoader(getClass().getResource("DasTransaksi.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                DasTransaksi controller = loader.getController();
                controller.setName(id,username);

                Scene scene = new Scene(root, stage.getWidth(), stage.getHeight()); // supaya langsung matching
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
            }else{
                // Load halaman home
                loader = new FXMLLoader(getClass().getResource("DasLaporan.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) txtUsername.getScene().getWindow();

                Scene scene = new Scene(root, stage.getWidth(), stage.getHeight()); // supaya langsung matching
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            alert.showAlert(Alert.AlertType.ERROR, "ERROR", e.getMessage(), false);
        }

    }


}
