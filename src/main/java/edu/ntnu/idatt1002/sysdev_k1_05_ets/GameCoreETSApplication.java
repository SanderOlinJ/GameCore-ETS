package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameCoreETSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameCoreETSApplication.class.getResource("scenes/start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinHeight(800);
        stage.setMinWidth(1200);
        stage.setTitle("ETS Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}