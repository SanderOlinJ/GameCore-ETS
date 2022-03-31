package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("scenes/start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //stage.setMinHeight(600);
        //stage.setMinWidth(780);
        stage.setTitle("ETS Application");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}