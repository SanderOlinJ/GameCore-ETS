package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.fxml.FXML;
import java.io.IOException;

public class StartScreenController {
    @FXML
    void onStartButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }
}
