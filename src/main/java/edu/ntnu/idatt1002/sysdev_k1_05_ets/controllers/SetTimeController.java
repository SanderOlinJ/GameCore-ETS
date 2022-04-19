package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class SetTimeController {
    @FXML ChoiceBox hoursMatch;
    @FXML ChoiceBox minutesMatch;
    @FXML ChoiceBox hoursMatch1;
    @FXML ChoiceBox minutesMatch1;
    @FXML ChoiceBox hoursMatch2;
    @FXML ChoiceBox minutesMatch2;
    @FXML ChoiceBox hoursMatch3;
    @FXML ChoiceBox minutesMatch3;
    @FXML ChoiceBox hoursMatch4;
    @FXML ChoiceBox minutesMatch4;
    @FXML ChoiceBox hoursMatch5;
    @FXML ChoiceBox minutesMatch5;
    @FXML ChoiceBox hoursMatch6;
    @FXML ChoiceBox minutesMatch6;
    @FXML ChoiceBox hoursMatch7;
    @FXML ChoiceBox minutesMatch7;
    @FXML ChoiceBox hoursMatch8;
    @FXML ChoiceBox minutesMatch8;
    @FXML ChoiceBox hoursMatch9;
    @FXML ChoiceBox minutesMatch9;
    @FXML ChoiceBox hoursMatch10;
    @FXML ChoiceBox minutesMatch10;
    @FXML ChoiceBox hoursMatch11;
    @FXML ChoiceBox minutesMatch11;
    @FXML ChoiceBox hoursMatch12;
    @FXML ChoiceBox minutesMatch12;
    @FXML ChoiceBox hoursMatch13;
    @FXML ChoiceBox minutesMatch13;
    @FXML ChoiceBox hoursMatch14;
    @FXML ChoiceBox minutesMatch14;
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
    @FXML Label tournamentName;

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;

    private ArrayList<ChoiceBox> hourBoxes;
    private ArrayList<ChoiceBox> minuteBoxes;
    private ArrayList<HBox> matches;


    @FXML
    public void initialize(){
        hourBoxes = new ArrayList<>(Arrays.asList(hoursMatch, hoursMatch1, hoursMatch2, hoursMatch3, hoursMatch4,
                hoursMatch5, hoursMatch6, hoursMatch7, hoursMatch8, hoursMatch9, hoursMatch10, hoursMatch11,
                minutesMatch12, minutesMatch13, minutesMatch14));
        minuteBoxes = new ArrayList<>(Arrays.asList(minutesMatch,minutesMatch1,minutesMatch2,minutesMatch3,minutesMatch4
                ,minutesMatch5,minutesMatch6,minutesMatch7,minutesMatch8,minutesMatch9,minutesMatch10,minutesMatch11,
                minutesMatch12,minutesMatch13,hoursMatch14));
        for (ChoiceBox box : hourBoxes){
            setHours(box);
        }
        for (ChoiceBox box : minuteBoxes){
            setMinutes(box);
        }
        setVisibleMatches();
        tournamentName.setText(BracketController.getTournamentName());
    }

    @FXML
    public void setResultsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/results-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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

    @FXML
    public void setMatchesScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/matches-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    public void setTime()  {
        for (int i = 0; i < hourBoxes.size(); i++) {
            if (hourBoxes.get(i).getValue() != null && minuteBoxes.get(i).getValue() != null){
               MatchesController.setTimeLabel(hourBoxes.get(i).getValue().toString(),
                       minuteBoxes.get(i).getValue().toString());
            }
        }
    }
    public void setHours(ChoiceBox box){
        box.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23");
    }

    public void setMinutes(ChoiceBox box){
        box.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
    }



    public void setVisibleMatches(){
        matches = new ArrayList<>(Arrays.asList(match,match1,match2,match3,match4,match5,match6,
                match7,match8,match9,match10,match11,match12,match13,match14));
        int numberOfTeams = AddTeamController.getMaxTeams();
        for (int i = 0; i < numberOfTeams/2; i++){
            matches.get(i).setVisible(true);
            matches.get(i).setPrefHeight(100);
            matches.get(i).setDisable(false);
        }
    }

    @FXML
    void onHomeButtonPressed(){}

    @FXML
    void onOngoingTournamentsButtonPressed(){}

    @FXML
    void onUpcomingTournamentsButtonPressed(){}

    @FXML
    void onPreviousTournamentsButtonPressed(){}

    @FXML
    void onAboutButtonPressed(){}
}
