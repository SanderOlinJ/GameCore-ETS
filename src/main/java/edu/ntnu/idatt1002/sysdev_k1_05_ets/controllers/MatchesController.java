package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchesController {
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
    @FXML Label timematch;
    @FXML Label timematch1;
    @FXML Label timematch2;
    @FXML Label timematch3;
    @FXML Label timematch4;
    @FXML Label timematch5;
    @FXML Label timematch6;
    @FXML Label timematch7;
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

    private ArrayList<HBox> matches;
    private ArrayList<Label> timeLabels;
    private ArrayList<Label> teamOnes;
    private ArrayList<Label> teamTwos;

    @FXML
    protected void initialize(){
        try {
            tournament = TournamentReaderRework.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        GameCoreETSApplication.showGameInfo(tournamentName, nameOfTournament, imageView, tournament, game,
                        host, startDate, startTime, platform, prizePool, entranceFee,
                        prizePoolCurrency, entranceFeeCurrency);
        timeLabels = new ArrayList<>(Arrays.asList(timematch,timematch1,timematch2,timematch3,timematch4,timematch5,timematch6,
                timematch7));

        tournamentName.setText(nameOfTournament);
        setVisibleMatches();
    }

    @FXML
    public void winnerChosen(){
        warningLabel.setText("");
        ArrayList<TextField> teamOnesScore = new ArrayList<>(Arrays.asList(team1ScoreMatch, team1ScoreMatch1,
                team1ScoreMatch2, team1ScoreMatch3, team1ScoreMatch4, team1ScoreMatch5, team1ScoreMatch6,
                team1ScoreMatch7));
        ArrayList<TextField> teamTwosScore = new ArrayList<>(Arrays.asList(team2ScoreMatch, team2ScoreMatch1,
                team2ScoreMatch2, team2ScoreMatch3, team2ScoreMatch4, team2ScoreMatch5, team2ScoreMatch6,
                team2ScoreMatch7));

        for (int i = 0; i < tournament.getNumberOfUnfinishedMatches(); i++){
            if (Utilities.areThereAnyOtherCharactersThanNumbers(teamOnesScore.get(i).getText()) ||
            Utilities.areThereAnyOtherCharactersThanNumbers(teamTwosScore.get(i).getText())){
                warningLabel.setText("Only numbers allowed in score");
                throw new IllegalArgumentException("Only numbers allowed in score");
            }

            else if (teamOnesScore.get(i).getText().equals(teamTwosScore.get(i).getText())){
                warningLabel.setText("Scores cannot be equal");
                throw new IllegalArgumentException("Scores cannot be equal");
            }

            else if (!(teamOnesScore.get(i).getText().isEmpty()) || !(teamTwosScore.get(i).getText().isEmpty())){
                Team team1 = tournament.getTeamByName(teamOnes.get(i).getText());
                Team team2 = tournament.getTeamByName(teamTwos.get(i).getText());
                Match matchWithResults = new Match(team1, team2, Integer.parseInt(teamOnesScore.get(i).getText()),
                        Integer.parseInt(teamTwosScore.get(i).getText()),
                        LocalTime.parse(timeLabels.get(i).getText()), true);
                matches.get(i).setDisable(true);
                matches.get(i).setVisible(false);
                matches.get(i).setPrefHeight(0);
                try {
                    TournamentWriterRework.writeMatchesToTournament(nameOfTournament, matchWithResults);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                break;
            }
        }
    }

    @FXML
    public void setResultsScene()
    throws IOException {
        ResultsController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.TOURNAMENT_RESULTS);
    }


    @FXML
    public void setTimeScene()
    throws IOException {
        SetTimeController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.SET_TIME);
    }

    @FXML
    public void setBracketScene()
    throws IOException {
        if (tournament.getNumberOfTeams() == 4){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
        } else if (tournament.getNumberOfTeams() == 8){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
        } else if (tournament.getNumberOfTeams() == 16){
            ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }

    }

    public void setVisibleMatches(){
        int nrOfUnfinishedMatches = tournament.getNumberOfUnfinishedMatches();
        matches = new ArrayList<>(Arrays.asList(match, match1, match2, match3, match4, match5, match6,
                match7));
        teamOnes = new ArrayList<>(Arrays.asList(team1match,team1match1,team1match2,team1match3,
                team1match4,team1match5,team1match6,team1match7));
        teamTwos = new ArrayList<>(Arrays.asList(team2match,team2match1,team2match2,team2match3,
                team2match4,team2match5,team2match6,team2match7));

        for (int i = 0; i < nrOfUnfinishedMatches; i++) {
            if (tournament.getUnfinishedMatches().get(i).getTeam1() != null
                    || tournament.getUnfinishedMatches().get(i).getTeam2() != null){
                matches.get(i).setVisible(true);
                matches.get(i).setPrefHeight(100);
                if (tournament.getUnfinishedMatches().get(i).getTeam1() != null){
                    teamOnes.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam1().getNameOfTeam());
                }
                if (tournament.getUnfinishedMatches().get(i).getTeam2() != null) {
                    teamTwos.get(i).setText(tournament.getUnfinishedMatches().get(i).getTeam2().getNameOfTeam());
                }
                if (tournament.getUnfinishedMatches().get(i).getTimeOfMatch() != null) {
                    timeLabels.get(i).setText(tournament.getUnfinishedMatches().get(i).getTimeOfMatch().toString());
                    matches.get(i).setDisable(false);
                }
            }
        }
    }

    @FXML
    void onHomeButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    @FXML
    void onAboutButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    @FXML
    void onHelpButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }


    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }


    public static void setNameOfTournament(String nameOfTournament) {
        MatchesController.nameOfTournament = nameOfTournament;
    }


}
