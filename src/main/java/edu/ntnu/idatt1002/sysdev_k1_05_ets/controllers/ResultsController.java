package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class ResultsController {

    @FXML Label tournamentName;
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
    @FXML Label timematch;
    @FXML Label timematch1;
    @FXML Label timematch2;
    @FXML Label timematch3;
    @FXML Label timematch4;
    @FXML Label timematch5;
    @FXML Label timematch6;
    @FXML Label timematch7;
    @FXML Label timematch8;
    @FXML Label timematch9;
    @FXML Label timematch10;
    @FXML Label timematch11;
    @FXML Label timematch12;
    @FXML Label timematch13;
    @FXML Label timematch14;
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
    @FXML Label team1ScoreMatch;
    @FXML Label team1ScoreMatch1;
    @FXML Label team1ScoreMatch2;
    @FXML Label team1ScoreMatch3;
    @FXML Label team1ScoreMatch4;
    @FXML Label team1ScoreMatch5;
    @FXML Label team1ScoreMatch6;
    @FXML Label team1ScoreMatch7;
    @FXML Label team1ScoreMatch8;
    @FXML Label team1ScoreMatch9;
    @FXML Label team1ScoreMatch10;
    @FXML Label team1ScoreMatch11;
    @FXML Label team1ScoreMatch12;
    @FXML Label team1ScoreMatch13;
    @FXML Label team1ScoreMatch14;
    @FXML Label team2ScoreMatch;
    @FXML Label team2ScoreMatch1;
    @FXML Label team2ScoreMatch2;
    @FXML Label team2ScoreMatch3;
    @FXML Label team2ScoreMatch4;
    @FXML Label team2ScoreMatch5;
    @FXML Label team2ScoreMatch6;
    @FXML Label team2ScoreMatch7;
    @FXML Label team2ScoreMatch8;
    @FXML Label team2ScoreMatch9;
    @FXML Label team2ScoreMatch10;
    @FXML Label team2ScoreMatch11;
    @FXML Label team2ScoreMatch12;
    @FXML Label team2ScoreMatch13;
    @FXML Label team2ScoreMatch14;
    @FXML ImageView team1WinnerMatch;
    @FXML ImageView team1WinnerMatch1;
    @FXML ImageView team1WinnerMatch2;
    @FXML ImageView team1WinnerMatch3;
    @FXML ImageView team1WinnerMatch4;
    @FXML ImageView team1WinnerMatch5;
    @FXML ImageView team1WinnerMatch6;
    @FXML ImageView team1WinnerMatch7;
    @FXML ImageView team1WinnerMatch8;
    @FXML ImageView team1WinnerMatch9;
    @FXML ImageView team1WinnerMatch10;
    @FXML ImageView team1WinnerMatch11;
    @FXML ImageView team1WinnerMatch12;
    @FXML ImageView team1WinnerMatch13;
    @FXML ImageView team1WinnerMatch14;
    @FXML ImageView team2WinnerMatch;
    @FXML ImageView team2WinnerMatch1;
    @FXML ImageView team2WinnerMatch2;
    @FXML ImageView team2WinnerMatch3;
    @FXML ImageView team2WinnerMatch4;
    @FXML ImageView team2WinnerMatch5;
    @FXML ImageView team2WinnerMatch6;
    @FXML ImageView team2WinnerMatch7;
    @FXML ImageView team2WinnerMatch8;
    @FXML ImageView team2WinnerMatch9;
    @FXML ImageView team2WinnerMatch10;
    @FXML ImageView team2WinnerMatch11;
    @FXML ImageView team2WinnerMatch12;
    @FXML ImageView team2WinnerMatch13;
    @FXML ImageView team2WinnerMatch14;

    private static final ArrayList<Match> matches = new ArrayList<>();

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

    @FXML private MenuBar menuBar;

    public void initialize(){
        ArrayList<HBox> matchBox = new ArrayList<>(Arrays.asList(match, match1, match2, match3, match4, match5, match6,
                match7, match8, match9,match10, match11, match12, match13, match14));
        ArrayList<Label> teamOnes = new ArrayList<>(Arrays.asList(team1match, team1match1, team1match2, team1match3,
                team1match4, team1match5, team1match6, team1match7, team1match8, team1match9, team1match10, team1match11
                ,team1match12, team1match13, team1match14));
        ArrayList<Label> teamTwos = new ArrayList<>(Arrays.asList(team2match, team2match1, team2match2, team2match3,
                team2match4, team2match5, team2match6, team2match7, team2match8, team2match9, team2match10, team2match11
                , team2match12, team2match13, team2match14));
        ArrayList<Label> times = new ArrayList<>(Arrays.asList(timematch, timematch1, timematch2, timematch3, timematch4
                , timematch5, timematch6, timematch7, timematch8, timematch9, timematch10, timematch11, timematch12,
                timematch13, timematch14));
        ArrayList<ImageView> team1Winner = new ArrayList<>(Arrays.asList(team1WinnerMatch, team1WinnerMatch1,
                team1WinnerMatch2, team1WinnerMatch3, team1WinnerMatch4, team1WinnerMatch5, team1WinnerMatch6,
                team1WinnerMatch7, team1WinnerMatch8, team1WinnerMatch9, team1WinnerMatch10, team1WinnerMatch11,
                team1WinnerMatch12, team1WinnerMatch13, team1WinnerMatch14));
        ArrayList<ImageView> team2Winner = new ArrayList<>(Arrays.asList(team2WinnerMatch, team2WinnerMatch1,
                team2WinnerMatch2, team2WinnerMatch3, team2WinnerMatch4, team2WinnerMatch5, team2WinnerMatch6,
                team2WinnerMatch7, team2WinnerMatch8, team2WinnerMatch9, team2WinnerMatch10, team2WinnerMatch11,
                team2WinnerMatch12, team2WinnerMatch13, team2WinnerMatch14));
        ArrayList<Label> teamOnesScore = new ArrayList<>(Arrays.asList(team1ScoreMatch, team1ScoreMatch1,
                team1ScoreMatch2, team1ScoreMatch3, team1ScoreMatch4, team1ScoreMatch5, team1ScoreMatch6,
                team1ScoreMatch7, team1ScoreMatch8, team1ScoreMatch9, team1ScoreMatch10, team1ScoreMatch11,
                team1ScoreMatch12, team1ScoreMatch13, team1ScoreMatch14));
        ArrayList<Label> teamTwosScore = new ArrayList<>(Arrays.asList(team2ScoreMatch, team2ScoreMatch1,
                team2ScoreMatch2, team2ScoreMatch3, team2ScoreMatch4, team2ScoreMatch5, team2ScoreMatch6,
                team2ScoreMatch7, team2ScoreMatch8, team2ScoreMatch9, team2ScoreMatch10, team2ScoreMatch11,
                team2ScoreMatch12, team2ScoreMatch13, team2ScoreMatch14));
        for (int i = 0; i < matches.size(); i++){
            matchBox.get(i).setDisable(false);
            matchBox.get(i).setVisible(true);
            matchBox.get(i).setPrefHeight(100);
            times.get(i).setText(String.valueOf(matches.get(i).getTimeOfMatch()));
            teamOnes.get(i).setText(matches.get(i).getTeam1().getNameOfTeam());
            teamTwos.get(i).setText(matches.get(i).getTeam2().getNameOfTeam());
            teamOnesScore.get(i).setText(String.valueOf(matches.get(i).getMatchScoreTeam1()));
            teamTwosScore.get(i).setText(String.valueOf(matches.get(i).getMatchScoreTeam2()));
            if (matches.get(i).getVictor().getNameOfTeam().equals(teamOnes.get(i).getText())){
                team1Winner.get(i).setVisible(true);
            }else {
                team2Winner.get(i).setVisible(true);
            }
        }
        tournamentName.setText(BracketController.getTournamentName());
    }

    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        if (BracketController.bracketSize == 4){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
        } else if (BracketController.bracketSize == 8){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
        } else if (BracketController.bracketSize == 16){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }

    @FXML
    public void setTimeScene(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.SET_TIME);
    }


    @FXML
    public void setMatchesScene(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.TOURNAMENT_MATCHES);
    }

    public static void addMatch(Match match){
        matches.add(match);
    }

    @FXML
    void onHomeButtonPressed(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    @FXML
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_TOURNAMENTS);
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
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event)
            throws IOException {
        ViewSwitcher.switchTo(View.PREVIOUS_TOURNAMENTS);
    }

}
