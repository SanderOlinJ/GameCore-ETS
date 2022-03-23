package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateNewTournamentController {

    private Scene scene;
    private Parent root;
    private Stage stage;

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

    @FXML
    public void addTeamScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/add-team-scene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
