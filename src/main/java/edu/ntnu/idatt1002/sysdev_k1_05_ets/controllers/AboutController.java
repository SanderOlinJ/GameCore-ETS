package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.fxml.FXML;
import java.io.IOException;


public class AboutController {

    @FXML
    void onHomeButtonPressed() throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    @FXML
    void onAboutButtonPressed() throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    @FXML
    void onHelpButtonPressed() throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    @FXML
    void onOngoingTournamentsButtonPressed() throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_TOURNAMENTS);
    }

    @FXML
    void onUpcomingTournamentsButtonPressed()
            throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML
    void onPreviousTournamentsButtonPressed()
            throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_TOURNAMENTS);
    }
}
