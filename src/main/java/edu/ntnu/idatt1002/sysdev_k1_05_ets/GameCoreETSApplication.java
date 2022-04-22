package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameCoreETSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START);
        stage.setMinHeight(800);
        stage.setMinWidth(1200);
        stage.getIcons()
                .add(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/ETSicon.png"));
        stage.setTitle("ETS GameCore");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}