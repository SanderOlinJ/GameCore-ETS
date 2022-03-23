package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateNewTournamentController {

    @FXML
    TextField tournamentNameField;
    @FXML
    TextArea teamsNameFieldWithPlayerNames;

    @FXML
    public void onLoadTournamentClick(ActionEvent event) throws IOException {
        TeamReader TR = new TeamReader();
        String tournamentName = tournamentNameField.getText();
        teamsNameFieldWithPlayerNames.setText(TR.convertTournamentFileToText(tournamentName));
    }



}
