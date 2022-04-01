package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {

    @FXML private Button startButton;
    @FXML private MediaView startScreenMediaView1;
    @FXML private MediaView startScreenMediaView2;
    @FXML private MediaView startScreenMediaView3;
    @FXML private MediaView startScreenMediaView4;
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

        startScreenMediaView1.setMediaPlayer(mediaPlayer);
        startScreenMediaView2.setMediaPlayer(mediaPlayer);
        startScreenMediaView3.setMediaPlayer(mediaPlayer);
        startScreenMediaView4.setMediaPlayer(mediaPlayer);

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(10);
    }

    @FXML
    void onStartButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/main-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();

    }
}
