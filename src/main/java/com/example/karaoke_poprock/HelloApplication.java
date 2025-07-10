package com.example.karaoke_poprock;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DasLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1550, 900);
        stage.setTitle("Karaoke PopRock");
        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");

        //setupAutoScreen(stage);

        stage.show();
    }

    private void setupAutoScreen(Stage stage) {
        // Mendapatkan ukuran layar utama
        Screen screen = Screen.getPrimary();
        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();

        // Jika ukuran layar cukup besar, atur ukuran window ke 80% dari layar
        if (screenWidth > 1024 && screenHeight > 768) {
            stage.setWidth(screenWidth * 0.8);
            stage.setHeight(screenHeight * 0.8);
            stage.centerOnScreen();
        } else {
            // Jika layar kecil, buka dalam mode fullscreen
            stage.setFullScreen(true);
        }

        // Menambahkan listener untuk perubahan ukuran layar
        Screen.getScreens().addListener((ListChangeListener.Change<? extends Screen> c) -> {
            // Jika layar berubah (misal: dipindahkan ke monitor lain)
            Screen currentScreen = Screen.getScreensForRectangle(
                    stage.getX(), stage.getY(),
                    stage.getWidth(), stage.getHeight()
            ).get(0);

            // Sesuaikan ukuran jika diperlukan
            if (!stage.isFullScreen()) {
                stage.setWidth(currentScreen.getBounds().getWidth() * 0.8);
                stage.setHeight(currentScreen.getBounds().getHeight() * 0.8);
                stage.centerOnScreen();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}