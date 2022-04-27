package edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;

public class ViewSwitcher {

    private static Scene scene;

    public static void setScene(Scene scene) {ViewSwitcher.scene = scene;}

    public static void switchTo(View view) throws IOException {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(ViewSwitcher.class.getResource(view.getFileName())));
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
