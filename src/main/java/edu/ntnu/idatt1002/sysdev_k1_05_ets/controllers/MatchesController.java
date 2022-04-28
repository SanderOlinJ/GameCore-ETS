package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Controller class for the Matches page
 */
public class MatchesController {
    private Tournament tournament;
    private static String nameOfTournament;

    @FXML HBox hBoxWarning;
    @FXML HBox match;
    @FXML HBox match1;
    @FXML HBox match2;
    @FXML HBox match3;
    @FXML HBox match4;
    @FXML HBox match5;
    @FXML HBox match6;
    @FXML HBox match7;
    @FXML Label timeMatch;
    @FXML Label timeMatch1;
    @FXML Label timeMatch2;
    @FXML Label timeMatch3;
    @FXML Label timeMatch4;
    @FXML Label timeMatch5;
    @FXML Label timeMatch6;
    @FXML Label timeMatch7;
    @FXML Label team1match;
    @FXML Label team1match1;
    @FXML Label team1match2;
    @FXML Label team1match3;
    @FXML Label team1match4;
    @FXML Label team1match5;
    @FXML Label team1match6;
    @FXML Label team1match7;
    @FXML Label team2match;
    @FXML Label team2match1;
    @FXML Label team2match2;
    @FXML Label team2match3;
    @FXML Label team2match4;
    @FXML Label team2match5;
    @FXML Label team2match6;
    @FXML Label team2match7;
    @FXML TextField team1ScoreMatch;
    @FXML TextField team1ScoreMatch1;
    @FXML TextField team1ScoreMatch2;
    @FXML TextField team1ScoreMatch3;
    @FXML TextField team1ScoreMatch4;
    @FXML TextField team1ScoreMatch5;
    @FXML TextField team1ScoreMatch6;
    @FXML TextField team1ScoreMatch7;
    @FXML private TextField team2ScoreMatch;
    @FXML private TextField team2ScoreMatch1;
    @FXML private TextField team2ScoreMatch2;
    @FXML private TextField team2ScoreMatch3;
    @FXML private TextField team2ScoreMatch4;
    @FXML private TextField team2ScoreMatch5;
    @FXML private TextField team2ScoreMatch6;
    @FXML private TextField team2ScoreMatch7;
    @FXML private Label tournamentName;
    @FXML private ImageView imageView;
    @FXML private Label game;
    @FXML private Label host;
    @FXML private Label startDate;
    @FXML private Label startTime;
    @FXML private Label platform;
    @FXML private Label prizePool;
    @FXML private Label prizePoolCurrency;
    @FXML private Label entranceFee;
    @FXML private Label entranceFeeCurrency;
    @FXML private Label warningLabel;
    @FXML private Label team1Score;
    @FXML private Label team2Score;
    @FXML private Label team1Score1;
    @FXML private Label team2Score1;
    @FXML private Label team1Score2;
    @FXML private Label team2Score2;
    @FXML private Label team1Score3;
    @FXML private Label team2Score3;
    @FXML private Label team1Score4;
    @FXML private Label team2Score4;
    @FXML private Label team1Score5;
    @FXML private Label team2Score5;
    @FXML private Label team1Score6;
    @FXML private Label team2Score6;
    @FXML private Label team1Score7;
    @FXML private Label team2Score7;

    private int numberOfMatchesWithScoreSet;
    private ArrayList<HBox> matches;
    private ArrayList<Label> timeLabels;
    private ArrayList<Label> teamOnes;
    private ArrayList<Label> teamTwos;
    private ArrayList<Label> scoreTeam1;
    private ArrayList<Label> scoreTeam2;
    private ArrayList<TextField> teamOnesScore;
    private ArrayList<TextField> teamTwosScore;

    /**
     Method initializes the page with content.
     */
    @FXML
    private void initialize(){
        numberOfMatchesWithScoreSet = 0;
        try {
            tournament = TournamentReader.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        Utilities.showGameInfo(tournamentName, imageView, tournament, game,
                        host, startDate, startTime, platform, prizePool, entranceFee,
                        prizePoolCurrency, entranceFeeCurrency);
        initializeLists();
        tournamentName.setText(nameOfTournament);
        setVisibleMatches();
    }

    /**
     * Used for selecting winner, ensures no illegal inputs have been made.
     * Writes the match to the correct file, and removes the match from the scene
     */
    @FXML
    public void winnerChosen(){
        warningLabel.setText("");
        for (int i = 0; i < 8; i++) {
            if (!teamOnesScore.get(i).getText().isEmpty() || !teamTwosScore.get(i).getText().isEmpty()) {
                if (Utilities.areThereAnyOtherCharactersThanNumbers(teamOnesScore.get(i).getText()) ||
                        Utilities.areThereAnyOtherCharactersThanNumbers(teamTwosScore.get(i).getText())) {
                    warningLabel.setText("Only numbers allowed in score");
                    throw new IllegalArgumentException("Only numbers allowed in score");

                } else if (teamOnesScore.get(i).getText().equals(teamTwosScore.get(i).getText())) {
                    warningLabel.setText("Scores cannot be equal");
                    throw new IllegalArgumentException("Scores cannot be equal");

                } else {
                    tournament.getUnfinishedMatches().remove(tournament.getUnfinishedMatches().get(i));
                    Team team1 = tournament.getTeamByName(teamOnes.get(i).getText());
                    Team team2 = tournament.getTeamByName(teamTwos.get(i).getText());
                    Match matchWithResults = new Match(team1, team2, Integer.parseInt(teamOnesScore.get(i).getText()),
                            Integer.parseInt(teamTwosScore.get(i).getText()),
                            LocalTime.parse(timeLabels.get(i).getText()), true);
                    teamOnesScore.get(i).setText("");
                    teamTwosScore.get(i).setText("");
                    numberOfMatchesWithScoreSet++;
                    matches.get(i).setDisable(true);
                    matches.get(i).setVisible(false);
                    matches.get(i).setPrefHeight(0);
                    try {
                        TournamentWriter.writeMatchesToTournament(nameOfTournament, matchWithResults);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
        warningLabel.setText("Score was set for " + numberOfMatchesWithScoreSet + " match(es)");
    }

    /**
     * Used for redirecting current page to result page
     * @throws IOException if scenes could not be switched
     */
    @FXML
    public void setResultsScene()
    throws IOException {
        /*
        Method sends the tournament name to the next Controller,
        so that the tournament may be read from file there.
         */
        ResultsController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.RESULTS);
    }

    /**
     * Used for redirecting current page to set time page
     * @throws IOException if scenes could not be switched
     */
    @FXML
    public void setTimeScene()
    throws IOException {
        /*
        Method sends the tournament name to the next Controller,
        so that the tournament may be read from file there.
         */
        SetTimeController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.SET_TIME);
    }

    /**
     * Used for redirecting current page to bracket page
     * @throws IOException if scenes could not be switched
     */
    @FXML
    public void setBracketScene()
    throws IOException {
        /*
        Method sends the tournament name to the next Controller,
        so that the tournament may be read from file there.
         */
        BracketController.setNameOfTournament(nameOfTournament);
        if (tournament.getNumberOfTeams() == 4){
            ViewSwitcher.switchTo(View.BRACKET_4);
        } else if (tournament.getNumberOfTeams() == 8){
            ViewSwitcher.switchTo(View.BRACKET_8);
        } else if (tournament.getNumberOfTeams() == 16){
            ViewSwitcher.switchTo(View.BRACKET_16);
        }
    }

    /**
     * Used for showing correct matches on initialization.
     * Iterates through the FXML objects, making the matches visible,
     * setting either team names and time in the correct matches
     */
    public void setVisibleMatches(){
        int temp = 0;
        int nrOfUnfinishedMatches = tournament.getNumberOfUnfinishedMatches();
        for (int i = 0; i < nrOfUnfinishedMatches; i++) {
            if (tournament.getUnfinishedMatches().get(i).getTeam1() != null
                    || tournament.getUnfinishedMatches().get(i).getTeam2() != null){
                matches.get(i).setVisible(true);
                matches.get(i).setPrefHeight(100);
                temp++;
                if (tournament.getUnfinishedMatches().get(i).getTeam1() != null){
                    teamOnes.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam1().getNameOfTeam());
                    scoreTeam1.get(i).setText("Score " + tournament.getUnfinishedMatches().get(i).getTeam1()
                            .getNameAbbr());
                }
                if (tournament.getUnfinishedMatches().get(i).getTeam2() != null) {
                    teamTwos.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam2().getNameOfTeam());
                    scoreTeam2.get(i).setText("Score " + tournament.getUnfinishedMatches().get(i).getTeam2()
                            .getNameAbbr());
                }
                if (tournament.getUnfinishedMatches().get(i).getTimeOfMatch() != null) {
                    timeLabels.get(i).setText(tournament.getUnfinishedMatches().get(i).getTimeOfMatch().toString());
                    matches.get(i).setDisable(false);
                }
            }
        }
        if (temp == 0){
            Text text = new Text();
            text.setText("Time has been set for all available matches");
            hBoxWarning.setVisible(true);
            hBoxWarning.setDisable(false);
        }
    }

    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHomeButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onAboutButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHelpButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    /**
     * Redirects to ongoing tournaments page when clicked on ongoing tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }
    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }
    /**
     * Redirects to previous tournaments page when clicked on previous tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    /**
     * Used for setting the name of a tournament
     * @param nameOfTournament name of the tournament
     */
    public static void setNameOfTournament(String nameOfTournament) {
        MatchesController.nameOfTournament = nameOfTournament;
    }


    /**
     * Used for initializing list containing labels.
     */
    private void initializeLists(){
        timeLabels = new ArrayList<>(Arrays.asList(timeMatch, timeMatch1, timeMatch2, timeMatch3, timeMatch4, timeMatch5, timeMatch6,
                timeMatch7));
        matches = new ArrayList<>(Arrays.asList(match, match1, match2, match3, match4, match5, match6,
                match7));
        teamOnes = new ArrayList<>(Arrays.asList(team1match,team1match1,team1match2,team1match3,
                team1match4,team1match5,team1match6,team1match7));
        teamTwos = new ArrayList<>(Arrays.asList(team2match,team2match1,team2match2,team2match3,
                team2match4,team2match5,team2match6,team2match7));
        scoreTeam1 = new ArrayList<>(Arrays.asList(team1Score,team1Score1,team1Score2,team1Score3,team1Score4,
                team1Score5,team1Score6,team1Score7));
        scoreTeam2 = new ArrayList<>(Arrays.asList(team2Score,team2Score1,team2Score2,team2Score3,team2Score4,
                team2Score5,team2Score6,team2Score7));
        teamOnesScore = new ArrayList<>(Arrays.asList(team1ScoreMatch, team1ScoreMatch1,
                team1ScoreMatch2, team1ScoreMatch3, team1ScoreMatch4, team1ScoreMatch5, team1ScoreMatch6,
                team1ScoreMatch7));
        teamTwosScore = new ArrayList<>(Arrays.asList(team2ScoreMatch, team2ScoreMatch1,
                team2ScoreMatch2, team2ScoreMatch3, team2ScoreMatch4, team2ScoreMatch5, team2ScoreMatch6,
                team2ScoreMatch7));
    }

}
