package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateNewTournamentController {

    @FXML
    TextField tournamentNameField;
    @FXML
    TextArea teamsNameFieldWithPlayerNames;

    @FXML
    public void onLoadTournamentClick(ActionEvent event){
    String tournamentName = tournamentNameField.getText();

    }


}
