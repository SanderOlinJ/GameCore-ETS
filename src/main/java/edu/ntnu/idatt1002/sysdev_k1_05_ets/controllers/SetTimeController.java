package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class SetTimeController {

    @FXML ComboBox hoursMatch;
    @FXML ComboBox minutesMatch;
    @FXML ComboBox hoursMatch1;
    @FXML ComboBox minutesMatch1;
    @FXML ComboBox hoursMatch2;
    @FXML ComboBox minutesMatch2;
    @FXML ComboBox hoursMatch3;
    @FXML ComboBox minutesMatch3;
    @FXML ComboBox hoursMatch4;
    @FXML ComboBox minutesMatch4;
    @FXML ComboBox hoursMatch5;
    @FXML ComboBox minutesMatch5;
    @FXML ComboBox hoursMatch6;
    @FXML ComboBox minutesMatch6;
    @FXML ComboBox hoursMatch7;
    @FXML ComboBox minutesMatch7;
    @FXML ComboBox hoursMatch8;
    @FXML ComboBox minutesMatch8;
    @FXML ComboBox hoursMatch9;
    @FXML ComboBox minutesMatch9;
    @FXML ComboBox hoursMatch10;
    @FXML ComboBox minutesMatch10;
    @FXML ComboBox hoursMatch11;
    @FXML ComboBox minutesMatch11;
    @FXML ComboBox hoursMatch12;
    @FXML ComboBox minutesMatch12;
    @FXML ComboBox hoursMatch13;
    @FXML ComboBox minutesMatch13;
    @FXML ComboBox hoursMatch14;
    @FXML ComboBox minutesMatch14;
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
    @FXML Label tournamentName;

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

    @FXML private MenuBar menuBar;

    private ArrayList<ComboBox> hourBoxes;
    private ArrayList<ComboBox> minuteBoxes;
    ArrayList<Label> teamOnes;
    ArrayList<Label> teamTwos;
    private ArrayList<HBox> matches;
    private static ArrayList<Team> teams = new ArrayList<>();


    @FXML
    public void initialize(){
        hourBoxes = new ArrayList<>(Arrays.asList(hoursMatch, hoursMatch1, hoursMatch2, hoursMatch3, hoursMatch4,
                hoursMatch5, hoursMatch6, hoursMatch7, hoursMatch8, hoursMatch9, hoursMatch10, hoursMatch11,
                minutesMatch12, minutesMatch13, minutesMatch14));
        minuteBoxes = new ArrayList<>(Arrays.asList(minutesMatch,minutesMatch1,minutesMatch2,minutesMatch3,minutesMatch4
                ,minutesMatch5,minutesMatch6,minutesMatch7,minutesMatch8,minutesMatch9,minutesMatch10,minutesMatch11,
                minutesMatch12,minutesMatch13,hoursMatch14));
        for (ComboBox box : hourBoxes){
            setHoursToBox(box);
        }
        for (ComboBox box : minuteBoxes){
            setMinutesToBox(box);
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
               matches.get(i).setPrefHeight(0);
               matches.get(i).setDisable(true);
               matches.get(i).setVisible(false);
               matches.get(i).setDisable(true);
               matches.get(i).setVisible(false);
               matches.get(i).setPrefHeight(0);
               /*
               matches.remove(matches.get(i));
               hourBoxes.remove(hourBoxes.get(i));
               minuteBoxes.remove(minuteBoxes.get(i));
               teamOnes.remove(teamOnes.get(i));
               teamTwos.remove(teamOnes.get(i));
                */
            }
        }
    }
    public void setHoursToBox(ComboBox box){
        box.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23");
        box.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            //This won't work for the first time but will be the one
                            //used in the next calls
                            getStyleClass().add("my-list-cell");
                            //size in px
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
    }

    public void setMinutesToBox(ComboBox box){
        box.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
        box.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            //This won't work for the first time but will be the one
                            //used in the next calls
                            getStyleClass().add("my-list-cell");
                            //size in px
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
    }



    public void setVisibleMatches(){
        matches = new ArrayList<>(Arrays.asList(match,match1,match2,match3,match4,match5,match6,
                match7,match8,match9,match10,match11,match12,match13,match14));
        teamOnes = new ArrayList<>(Arrays.asList(team1match,team1match1,team1match2,team1match3,
                team1match4,team1match5,team1match6,team1match7,team1match8,team1match9,team1match10,team1match11,
                team1match12,team1match13,team1match14));
        teamTwos = new ArrayList<>(Arrays.asList(team2match,team2match1,team2match2,team2match3,
                team2match4,team2match5,team2match6,team2match7,team2match8,team2match9,team2match10,team2match11,
                team2match12,team2match13,team2match14));
        teams = BracketController.getBracket().getTeams();
        int bracketSize = BracketController.bracketSize;
        int numberOfTeams = teams.size();
        if (numberOfTeams <= bracketSize) {
            for (int i = 0; i < numberOfTeams / 2; i++) {
                matches.get(i).setVisible(true);
                matches.get(i).setPrefHeight(100);
                matches.get(i).setDisable(false);
                teamOnes.get(i).setText(teams.get(2 * i).getNameOfTeam());
                teamTwos.get(i).setText(teams.get(2 * i + 1).getNameOfTeam());
            }
        }
        else if ((numberOfTeams - bracketSize) % 2 == 0){
            for (int i = 0; i < (numberOfTeams - bracketSize)/2; i++) {
                matches.get(i).setDisable(false);
                matches.get(i).setVisible(true);
                matches.get(i).setPrefHeight(100);
                teamOnes.get(i).setText(teams.get(2*i + bracketSize).getNameOfTeam());
                teamTwos.get(i).setText(teams.get(2*i + 1 + bracketSize).getNameOfTeam());
            }
        }
    }

    @FXML
    void onHomeButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/main-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/about-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/help-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    private void setNextWindowFromMenuBar(Parent root) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    void onUpcomingTournamentsButtonPressed(ActionEvent event)
            throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/upcoming-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event)
            throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }
}
