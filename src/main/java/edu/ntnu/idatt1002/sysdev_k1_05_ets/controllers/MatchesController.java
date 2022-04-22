package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class MatchesController {
    private Scene scene;
    private Stage stage;
    private NewTournament tournament;
    private static String nameOfTournament;

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
    @FXML RadioButton radio1Match;
    @FXML RadioButton radio2Match;
    @FXML RadioButton radio1Match1;
    @FXML RadioButton radio2Match1;
    @FXML RadioButton radio1Match2;
    @FXML RadioButton radio2Match2;
    @FXML RadioButton radio1Match3;
    @FXML RadioButton radio2Match3;
    @FXML RadioButton radio1Match4;
    @FXML RadioButton radio2Match4;
    @FXML RadioButton radio1Match5;
    @FXML RadioButton radio2Match5;
    @FXML RadioButton radio1Match6;
    @FXML RadioButton radio2Match6;
    @FXML RadioButton radio1Match7;
    @FXML RadioButton radio2Match7;
    @FXML RadioButton radio1Match8;
    @FXML RadioButton radio2Match8;
    @FXML RadioButton radio1Match9;
    @FXML RadioButton radio2Match9;
    @FXML RadioButton radio1Match10;
    @FXML RadioButton radio2Match10;
    @FXML RadioButton radio1Match11;
    @FXML RadioButton radio2Match11;
    @FXML RadioButton radio1Match12;
    @FXML RadioButton radio2Match12;
    @FXML RadioButton radio1Match13;
    @FXML RadioButton radio2Match13;
    @FXML RadioButton radio1Match14;
    @FXML RadioButton radio2Match14;
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

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

    @FXML private MenuBar menuBar;

    private static int n = 2;
    private ArrayList<HBox> matches;
    private ArrayList<Label> timeLabels;
    private ArrayList<Label> teamOnes;
    private ArrayList<Label> teamTwos;
    private ArrayList<TextField> teamOnesScore;
    private ArrayList<TextField> teamTwosScore;
    private ArrayList<RadioButton> radioOnes;
    private ArrayList<RadioButton> radioTwos;
    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<String> times = new ArrayList<>();

    @FXML
    protected void initialize(){
        try {
            tournament = TournamentReaderRework.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        timeLabels = new ArrayList<>(Arrays.asList(timematch, timematch1, timematch2, timematch3,
                timematch4, timematch5, timematch6, timematch7, timematch8, timematch9, timematch10, timematch11, timematch12,
                timematch13, timematch14));
        tournamentName.setText(nameOfTournament);
        setVisibleMatches();
    }

    @FXML
    public void winnerChosen(){
        ArrayList<ToggleGroup> winners = new ArrayList<>(Arrays.asList(winnerMatch,winnerMatch1,winnerMatch2,
                winnerMatch3,winnerMatch4,winnerMatch5,winnerMatch6,winnerMatch7,winnerMatch8,winnerMatch9,winnerMatch10
                ,winnerMatch11,winnerMatch12,winnerMatch13,winnerMatch14));
        teamOnesScore = new ArrayList<>(Arrays.asList(team1ScoreMatch,team1ScoreMatch1,team1ScoreMatch2,team1ScoreMatch3
                ,team1ScoreMatch4,team1ScoreMatch5,team1ScoreMatch6,team1ScoreMatch7,team1ScoreMatch8,team1ScoreMatch9,
                team1ScoreMatch10,team1ScoreMatch11,team1ScoreMatch12,team1ScoreMatch13,team1ScoreMatch14));
        teamTwosScore = new ArrayList<>(Arrays.asList(team2ScoreMatch,team2ScoreMatch1,team2ScoreMatch2,team2ScoreMatch3
                ,team2ScoreMatch4,team2ScoreMatch5,team2ScoreMatch6,team2ScoreMatch7,team2ScoreMatch8,team2ScoreMatch9,
                team2ScoreMatch10,team2ScoreMatch11,team2ScoreMatch12,team2ScoreMatch13,team2ScoreMatch14));
        for (int i = 0; i < winners.size(); i++){
            if (winners.get(i).getSelectedToggle() != null) {
                Team team1 = tournament.getTeamByName(teamOnes.get(i).getText());
                Team team2 = tournament.getTeamByName(teamTwos.get(i).getText());
                Match matchWithResults = new Match(team1, team2, Integer.parseInt(teamOnesScore.get(i).getText()),
                                Integer.parseInt(teamTwosScore.get(i).getText()),
                        LocalTime.parse(timeLabels.get(i).getText()), true);
                matches.get(i).setDisable(true);
                matches.get(i).setVisible(false);
                matches.get(i).setPrefHeight(0);
                try {
                    TournamentWriterRework.writeMatchScoreAndVictorToTournamentFile(tournament.getTournamentName()
                            ,matchWithResults);
                } catch (IOException exception){
                    exception.printStackTrace();
                }


                /*
                if (teams.size() > BracketController.bracketSize) {
                    matches.remove(matches.get(i));
                    teamOnes.remove(teamOnes.get(i));
                    teamTwos.remove(teamOnes.get(i));
                    teamOnesScore.remove(teamOnesScore.get(i));
                    teamTwosScore.remove(teamTwosScore.get(i));
                    winners.remove(winners.get(i));
                    timeLabels.remove(timeLabels.get(i));
                    times.remove(times.get(i));
                    radioOnes.remove(radioOnes.get(i));
                    radioTwos.remove(radioTwos.get(i));
                }
                */
                //advanceTeam(matchWithResults.getVictor());
            }
        }
    }

    @FXML
    public void setResultsScene(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.TOURNAMENT_RESULTS);
    }
    /*
    private void advanceTeam(Team team) {
        BracketController.getBracket().addTeam(team);
    }

     */

    @FXML
    public void setTimeScene(ActionEvent event) throws IOException {
        ViewSwitcher.switchTo(View.SET_TIME);
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

    public static void setTimeLabel(String hour, String minute){
        times.add(hour + ":" + minute);
    }

    public void setVisibleMatches(){
        int nrOfUnfinishedMatches = tournament.getNumberOfUnfinishedMatches();
        matches = new ArrayList<>(Arrays.asList(match, match1, match2, match3, match4, match5, match6,
                match7, match8, match9, match10, match11, match12, match13, match14));
        teamOnes = new ArrayList<>(Arrays.asList(team1match,team1match1,team1match2,team1match3,
                team1match4,team1match5,team1match6,team1match7,team1match8,team1match9,team1match10,team1match11,
                team1match12,team1match13,team1match14));
        teamTwos = new ArrayList<>(Arrays.asList(team2match,team2match1,team2match2,team2match3,
                team2match4,team2match5,team2match6,team2match7,team2match8,team2match9,team2match10,team2match11,
                team2match12,team2match13,team2match14));
        radioOnes = new ArrayList<>(Arrays.asList(radio1Match,radio1Match1,radio1Match2,
                radio1Match3,radio1Match4,radio1Match5, radio1Match6,radio1Match7,radio1Match8,radio1Match9,
                radio1Match10,radio1Match11,radio1Match12,radio1Match13,radio1Match14));
        radioTwos = new ArrayList<>(Arrays.asList(radio2Match,radio2Match1,radio2Match2,
                radio2Match3,radio2Match4,radio2Match5,radio2Match6,radio2Match7,radio2Match8,radio2Match9,radio2Match10
                ,radio2Match11,radio2Match12,radio2Match13,radio2Match14));

        for (int i = 0; i < nrOfUnfinishedMatches; i++) {
             matches.get(i).setVisible(true);
             matches.get(i).setPrefHeight(100);
             matches.get(i).setDisable(false);
             teamOnes.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam1().getNameOfTeam());
             radioOnes.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam1().getNameOfTeam());
             teamTwos.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam2().getNameOfTeam());
             radioTwos.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam2().getNameOfTeam());
             timeLabels.get(i).setText(tournament.getUnfinishedMatches().get(i).getTimeOfMatch().toString());
        }
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


    public static void setNameOfTournament(String nameOfTournament) {
        MatchesController.nameOfTournament = nameOfTournament;
    }
}
