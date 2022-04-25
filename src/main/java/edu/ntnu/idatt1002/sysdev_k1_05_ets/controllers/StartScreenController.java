package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.io.IOException;

public class StartScreenController {

    @FXML private CheckBox firstTimeCheckBox;

    @FXML
    void onStartButtonPressed()
    throws IOException {
        if (firstTimeCheckBox.isSelected()){
            ViewSwitcher.switchTo(View.HELP);
        } else {
            ViewSwitcher.switchTo(View.MAIN);
        }
    }
}
