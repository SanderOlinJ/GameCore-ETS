package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class responsible for the first page of the program
 */
public class GameCoreETSApplication extends Application {


    /**
     * Displays the first screen the user should see with the ETS GameCore logo
     * @param stage input stage
     * @throws IOException if scenes cannot be switched
     */
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START);
        stage.getIcons()
                .add(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/images/ETSicon.png"));
        stage.setTitle("ETS GameCore");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Starts the application with the help of a method called launch() from its parents class Application which
     * ultimately initiates the program
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }


}