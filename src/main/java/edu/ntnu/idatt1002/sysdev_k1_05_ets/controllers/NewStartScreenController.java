package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStartScreenController implements Initializable {

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mediaPlayer = new MediaPlayer(new Media(new File("C:\\Users\\SanderOlin\\Desktop\\DATAING\\Systemutvikling\\sysdevprog\\" +
                    "sysdev_k1_05_ets\\src\\main\\resources\\edu\\ntnu\\idatt1002\\sysdev_k1_05_ets\\mp4andgifs\\Fortnite.mp4")
                    .toURI().toURL().toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(10);
    }


}
