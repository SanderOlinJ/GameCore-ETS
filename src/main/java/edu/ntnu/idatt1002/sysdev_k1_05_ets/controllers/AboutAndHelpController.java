package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import javafx.fxml.FXML;
import java.io.IOException;

/**
 * A controller class for both about and help page
 */
public class AboutAndHelpController {

    /**
     * Redirects to main page if home menu button is clicked
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHomeButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page if clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onAboutButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page if clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHelpButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    /**
     * Redirects to on going tournament page if clicked on ongoing  menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    /**
     * Redirects to ongoing tournament page if clicked on ongoing  menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    /**
     * Redirects to previous tournament page if clicked on previous tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    /**
     * Redirects to create new tournament page if clicked on create new tournament button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onCreateNewTournamentButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.CREATE_NEW_TOURNAMENT);
    }
}
