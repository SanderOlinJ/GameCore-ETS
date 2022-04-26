package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.io.IOException;

/**
 * A controller class for the first page a user sees when launching ETS
 */
public class StartScreenController {

    @FXML private CheckBox firstTimeCheckBox;

    /**
     * Checks if the checkbox which asks the user if it is their first time, is checked
     * If "first time" check box is checked the page gets redirected to the help page of ETS
     * If "first time" checkbox is not checked the page gets redirected to the main page where you see upcoming, ongoing
     * and previous tournaments
     * @throws IOException
     */
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
