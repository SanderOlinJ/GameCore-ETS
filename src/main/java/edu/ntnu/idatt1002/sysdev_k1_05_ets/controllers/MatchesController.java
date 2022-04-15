package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MatchesController {
    private Scene scene;
    private Stage stage;

    @FXML HBox match;
    @FXML HBox match1;
    @FXML HBox match2;
    @FXML HBox match3;
    @FXML HBox match4;
    @FXML HBox match5;
    @FXML HBox match6;
    @FXML HBox match7;
    @FXML HBox match8;
    @FXML HBox match9;
    @FXML HBox match10;
    @FXML HBox match11;
    @FXML HBox match12;
    @FXML HBox match13;
    @FXML HBox match14;
    @FXML Label team1match;
    @FXML Label team1match1;
    @FXML Label team1match2;
    @FXML Label team1match3;
    @FXML Label team1match4;
    @FXML Label team1match5;
    @FXML Label team1match6;
    @FXML Label team1match7;
    @FXML Label team1match8;
    @FXML Label team1match9;
    @FXML Label team1match10;
    @FXML Label team1match11;
    @FXML Label team1match12;
    @FXML Label team1match13;
    @FXML Label team1match14;
    @FXML Label team2match;
    @FXML Label team2match1;
    @FXML Label team2match2;
    @FXML Label team2match3;
    @FXML Label team2match4;
    @FXML Label team2match5;
    @FXML Label team2match6;
    @FXML Label team2match7;
    @FXML Label team2match8;
    @FXML Label team2match9;
    @FXML Label team2match10;
    @FXML Label team2match11;
    @FXML Label team2match12;
    @FXML Label team2match13;
    @FXML Label team2match14;
    @FXML ToggleGroup winnerMatch;
    @FXML ToggleGroup winnerMatch1;
    @FXML ToggleGroup winnerMatch2;
    @FXML ToggleGroup winnerMatch3;
    @FXML ToggleGroup winnerMatch4;
    @FXML ToggleGroup winnerMatch5;
    @FXML ToggleGroup winnerMatch6;
    @FXML ToggleGroup winnerMatch7;
    @FXML ToggleGroup winnerMatch8;
    @FXML ToggleGroup winnerMatch9;
    @FXML ToggleGroup winnerMatch10;
    @FXML ToggleGroup winnerMatch11;
    @FXML ToggleGroup winnerMatch12;
    @FXML ToggleGroup winnerMatch13;
    @FXML ToggleGroup winnerMatch14;
    @FXML TextField team1ScoreMatch;
    @FXML TextField team1ScoreMatch1;
    @FXML TextField team1ScoreMatch2;
    @FXML TextField team1ScoreMatch3;
    @FXML TextField team1ScoreMatch4;
    @FXML TextField team1ScoreMatch5;
    @FXML TextField team1ScoreMatch6;
    @FXML TextField team1ScoreMatch7;
    @FXML TextField team1ScoreMatch8;
    @FXML TextField team1ScoreMatch9;
    @FXML TextField team1ScoreMatch10;
    @FXML TextField team1ScoreMatch11;
    @FXML TextField team1ScoreMatch12;
    @FXML TextField team1ScoreMatch13;
    @FXML TextField team1ScoreMatch14;
    @FXML TextField team2ScoreMatch;
    @FXML TextField team2ScoreMatch1;
    @FXML TextField team2ScoreMatch2;
    @FXML TextField team2ScoreMatch3;
    @FXML TextField team2ScoreMatch4;
    @FXML TextField team2ScoreMatch5;
    @FXML TextField team2ScoreMatch6;
    @FXML TextField team2ScoreMatch7;
    @FXML TextField team2ScoreMatch8;
    @FXML TextField team2ScoreMatch9;
    @FXML TextField team2ScoreMatch10;
    @FXML TextField team2ScoreMatch11;
    @FXML TextField team2ScoreMatch12;
    @FXML TextField team2ScoreMatch13;
    @FXML TextField team2ScoreMatch14;
    @FXML Label tournamentName;

    @FXML
    protected void initialize(){
        setVisibleMatches();
        tournamentName.setText(BracketController.getTournamentName());
    }

    @FXML
    public void winnerChosen(){
        ResultsController.addMatch(match1);
    }

    @FXML
    public void setResultsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/results-scene.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    public void setTimeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/set-time-scene.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        String link = "";
        if (BracketController.bracketSize == 4){
            link = "scenes/overview-scene-four.fxml";
        } else if (BracketController.bracketSize == 8){
            link = "scenes/overview-scene-eight.fxml";
        } else if (BracketController.bracketSize == 16){
            link = "scenes/overview-scene-sixteen.fxml";
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(link)));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    public void setVisibleMatches(){
        if (AddTeamController.getMaxTeams() == 4){
            ArrayList<Team>  teams = (ArrayList<Team>) BracketController.getBracket().getTeams().stream().
                    filter(p -> !(p.getNameOfTeam().equals("?"))).collect(Collectors.toList());
            team1match.setText(teams.get(0).getNameOfTeam());
            team2match.setText(teams.get(2).getNameOfTeam());
            team1match1.setText(teams.get(1).getNameOfTeam());
            team2match1.setText(teams.get(3).getNameOfTeam());
        }

        else if (AddTeamController.getMaxTeams() == 8){
            match2.setDisable(false);
            match2.setVisible(true);
            match2.setPrefHeight(100);
            match3.setDisable(false);
            match3.setVisible(true);
            match3.setPrefHeight(100);

        }
        else if (AddTeamController.getMaxTeams() == 16){
            match2.setDisable(false);
            match2.setVisible(true);
            match2.setPrefHeight(100);
            match3.setDisable(false);
            match3.setVisible(true);
            match3.setPrefHeight(100);
            match4.setDisable(false);
            match4.setVisible(true);
            match4.setPrefHeight(100);
            match5.setDisable(false);
            match5.setVisible(true);
            match5.setPrefHeight(100);
            match6.setDisable(false);
            match6.setVisible(true);
            match6.setPrefHeight(100);
            match7.setDisable(false);
            match7.setVisible(true);
            match7.setPrefHeight(100);
        }
    }

}
