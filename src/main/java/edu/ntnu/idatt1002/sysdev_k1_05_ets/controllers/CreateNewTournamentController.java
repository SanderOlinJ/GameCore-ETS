package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewTournamentController implements Initializable {

    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    TextField tournamentNameField;
    @FXML
    TextArea teamsNameFieldWithPlayerNames;
    @FXML
    ComboBox bracketFormat;
    @FXML
    Label warningLabel;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    bracketFormat.getItems().addAll("4","8","16");
    }
    @FXML
    public void onLoadTournamentClick(ActionEvent event) throws IOException {
        TeamReader TR = new TeamReader();
        String tournamentName = tournamentNameField.getText();
        teamsNameFieldWithPlayerNames.setText(TR.convertTournamentFileToText(tournamentName));
    }

    @FXML
    public void addTeamScene(ActionEvent event) throws IOException {
        //------ parse the current information of combobox to addTeamScene -----
        String bracketChoice = String.valueOf(bracketFormat.getValue());

        try {
           int formatNr = Integer.parseInt(bracketChoice);
        } catch (NumberFormatException nfe) {
            warningLabel.setText("You have to choose a tournament format");
            return;
        }

        AddTeamController.setMaxTeams(Integer.parseInt(bracketChoice));
        EightTeamController.setTournamentName(tournamentNameField.getText());

        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/add-team.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(780);
        stage.setMinHeight(600);
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/start-screen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
