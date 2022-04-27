package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class ResultsController {

    private static Tournament tournament;
    private static String nameOfTournament;

    @FXML private Label tournamentName;
    @FXML private HBox match;
    @FXML private HBox match1;
    @FXML private HBox match2;
    @FXML private HBox match3;
    @FXML private HBox match4;
    @FXML private HBox match5;
    @FXML private HBox match6;
    @FXML private HBox match7;
    @FXML private HBox match8;
    @FXML private HBox match9;
    @FXML private HBox match10;
    @FXML private HBox match11;
    @FXML private HBox match12;
    @FXML private HBox match13;
    @FXML private HBox match14;
    @FXML private Label timeMatch;
    @FXML private Label timeMatch1;
    @FXML private Label timeMatch2;
    @FXML private Label timeMatch3;
    @FXML private Label timeMatch4;
    @FXML private Label timeMatch5;
    @FXML private Label timeMatch6;
    @FXML private Label timeMatch7;
    @FXML private Label timeMatch8;
    @FXML private Label timeMatch9;
    @FXML private Label timeMatch10;
    @FXML private Label timeMatch11;
    @FXML private Label timeMatch12;
    @FXML private Label timeMatch13;
    @FXML private Label timeMatch14;
    @FXML private Label team1match;
    @FXML private Label team1match1;
    @FXML private Label team1match2;
    @FXML private Label team1match3;
    @FXML private Label team1match4;
    @FXML private Label team1match5;
    @FXML private Label team1match6;
    @FXML private Label team1match7;
    @FXML private Label team1match8;
    @FXML private Label team1match9;
    @FXML private Label team1match10;
    @FXML private Label team1match11;
    @FXML private Label team1match12;
    @FXML private Label team1match13;
    @FXML private Label team1match14;
    @FXML private Label team2match;
    @FXML private Label team2match1;
    @FXML private Label team2match2;
    @FXML private Label team2match3;
    @FXML private Label team2match4;
    @FXML private Label team2match5;
    @FXML private Label team2match6;
    @FXML private Label team2match7;
    @FXML private Label team2match8;
    @FXML private Label team2match9;
    @FXML private Label team2match10;
    @FXML private Label team2match11;
    @FXML private Label team2match12;
    @FXML private Label team2match13;
    @FXML private Label team2match14;
    @FXML private Label team1ScoreMatch;
    @FXML private Label team1ScoreMatch1;
    @FXML private Label team1ScoreMatch2;
    @FXML private Label team1ScoreMatch3;
    @FXML private Label team1ScoreMatch4;
    @FXML private Label team1ScoreMatch5;
    @FXML private Label team1ScoreMatch6;
    @FXML private Label team1ScoreMatch7;
    @FXML private Label team1ScoreMatch8;
    @FXML private Label team1ScoreMatch9;
    @FXML private Label team1ScoreMatch10;
    @FXML private Label team1ScoreMatch11;
    @FXML private Label team1ScoreMatch12;
    @FXML private Label team1ScoreMatch13;
    @FXML private Label team1ScoreMatch14;
    @FXML private Label team2ScoreMatch;
    @FXML private Label team2ScoreMatch1;
    @FXML private Label team2ScoreMatch2;
    @FXML private Label team2ScoreMatch3;
    @FXML private Label team2ScoreMatch4;
    @FXML private Label team2ScoreMatch5;
    @FXML private Label team2ScoreMatch6;
    @FXML private Label team2ScoreMatch7;
    @FXML private Label team2ScoreMatch8;
    @FXML private Label team2ScoreMatch9;
    @FXML private Label team2ScoreMatch10;
    @FXML private Label team2ScoreMatch11;
    @FXML private Label team2ScoreMatch12;
    @FXML private Label team2ScoreMatch13;
    @FXML private Label team2ScoreMatch14;
    @FXML private ImageView team1WinnerMatch;
    @FXML private ImageView team1WinnerMatch1;
    @FXML private ImageView team1WinnerMatch2;
    @FXML private ImageView team1WinnerMatch3;
    @FXML private ImageView team1WinnerMatch4;
    @FXML private ImageView team1WinnerMatch5;
    @FXML private ImageView team1WinnerMatch6;
    @FXML private ImageView team1WinnerMatch7;
    @FXML private ImageView team1WinnerMatch8;
    @FXML private ImageView team1WinnerMatch9;
    @FXML private ImageView team1WinnerMatch10;
    @FXML private ImageView team1WinnerMatch11;
    @FXML private ImageView team1WinnerMatch12;
    @FXML private ImageView team1WinnerMatch13;
    @FXML private ImageView team1WinnerMatch14;
    @FXML private ImageView team2WinnerMatch;
    @FXML private ImageView team2WinnerMatch1;
    @FXML private ImageView team2WinnerMatch2;
    @FXML private ImageView team2WinnerMatch3;
    @FXML private ImageView team2WinnerMatch4;
    @FXML private ImageView team2WinnerMatch5;
    @FXML private ImageView team2WinnerMatch6;
    @FXML private ImageView team2WinnerMatch7;
    @FXML private ImageView team2WinnerMatch8;
    @FXML private ImageView team2WinnerMatch9;
    @FXML private ImageView team2WinnerMatch10;
    @FXML private ImageView team2WinnerMatch11;
    @FXML private ImageView team2WinnerMatch12;
    @FXML private ImageView team2WinnerMatch13;
    @FXML private ImageView team2WinnerMatch14;
    @FXML private ImageView imageView;
    @FXML private Label game;
    @FXML private Label host;
    @FXML private Label startDate;
    @FXML private Label startTime;
    @FXML private Label platform;
    @FXML private Label prizePool;
    @FXML private Label entranceFee;
    @FXML private Label prizePoolCurrency;
    @FXML private Label entranceFeeCurrency;

    private ArrayList<HBox> matchBox;
    private ArrayList<Label> teamOnes;
    private ArrayList<Label> teamTwos;
    private ArrayList<Label> times;
    private ArrayList<ImageView> team1Winner;
    private ArrayList<ImageView> team2Winner;
    private ArrayList<Label> teamOnesScore;
    private ArrayList<Label> teamTwosScore;

    public void initialize(){
        try {
            tournament = TournamentReader.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        ArrayList<Match> matches = tournament.getFinishedMatches();
        Utilities.showGameInfo(tournamentName, nameOfTournament, imageView, tournament, game,
                        host, startDate, startTime, platform, prizePool, entranceFee,
                        prizePoolCurrency, entranceFeeCurrency);
        initializeLists();

        for (int i = 0; i < matches.size(); i++){
            matchBox.get(i).setDisable(false);
            matchBox.get(i).setVisible(true);
            matchBox.get(i).setPrefHeight(100);
            times.get(i).setText(String.valueOf(matches.get(i).getTimeOfMatch()));
            teamOnes.get(i).setText(matches.get(i).getTeam1().getNameAbbr());
            teamTwos.get(i).setText(matches.get(i).getTeam2().getNameAbbr());
            teamOnesScore.get(i).setText(String.valueOf(matches.get(i).getMatchScoreTeam1()));
            teamTwosScore.get(i).setText(String.valueOf(matches.get(i).getMatchScoreTeam2()));
            if (matches.get(i).getVictor().equals(matches.get(i).getTeam1())){
                team1Winner.get(i).setVisible(true);
            } else {
                team2Winner.get(i).setVisible(true);
            }
        }
        tournamentName.setText(BracketController.getNameOfTournament());
    }

    /**
     * Used for redirecting current page to bracket page
     * @throws IOException
     */
    @FXML
    public void setBracketScene()
    throws IOException {
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
     * Used for redirecting current page to set time page
     * @throws IOException
     */
    @FXML
    public void setTimeScene()
    throws IOException {
        SetTimeController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.SET_TIME);
    }

    /**
     * Used for redirecting current page to set matches page
     * @throws IOException
     */
    @FXML
    public void setMatchesScene()
    throws IOException {
        MatchesController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.MATCHES);
    }

    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException
     */
    @FXML
    void onHomeButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException
     */
    @FXML
    void onAboutButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException
     */
    @FXML
    void onHelpButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    /**
     * Redirects to ongoing tournaments page when clicked on ongoing tournaments menu button
     * @throws IOException
     */
    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }
    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException
     */
    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }
    /**
     * Redirects to previous tournaments page when clicked on previous tournaments menu button
     * @throws IOException
     */
    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }
    /**
     * Used for setting the name of a tournament
     * @param nameOfTournament
     */
    public static void setNameOfTournament(String nameOfTournament) {
        ResultsController.nameOfTournament = nameOfTournament;
    }

    private void initializeLists(){
        matchBox = new ArrayList<>(Arrays.asList(match, match1, match2, match3, match4, match5, match6,
                match7, match8, match9,match10, match11, match12, match13, match14));
        teamOnes = new ArrayList<>(Arrays.asList(team1match, team1match1, team1match2, team1match3,
                team1match4, team1match5, team1match6, team1match7, team1match8, team1match9, team1match10, team1match11
                ,team1match12, team1match13, team1match14));
        teamTwos = new ArrayList<>(Arrays.asList(team2match, team2match1, team2match2, team2match3,
                team2match4, team2match5, team2match6, team2match7, team2match8, team2match9, team2match10, team2match11
                , team2match12, team2match13, team2match14));
        times = new ArrayList<>(Arrays.asList(timeMatch, timeMatch1, timeMatch2, timeMatch3, timeMatch4
                , timeMatch5, timeMatch6, timeMatch7, timeMatch8, timeMatch9, timeMatch10, timeMatch11, timeMatch12,
                timeMatch13, timeMatch14));
        team1Winner = new ArrayList<>(Arrays.asList(team1WinnerMatch, team1WinnerMatch1,
                team1WinnerMatch2, team1WinnerMatch3, team1WinnerMatch4, team1WinnerMatch5, team1WinnerMatch6,
                team1WinnerMatch7, team1WinnerMatch8, team1WinnerMatch9, team1WinnerMatch10, team1WinnerMatch11,
                team1WinnerMatch12, team1WinnerMatch13, team1WinnerMatch14));
        team2Winner = new ArrayList<>(Arrays.asList(team2WinnerMatch, team2WinnerMatch1,
                team2WinnerMatch2, team2WinnerMatch3, team2WinnerMatch4, team2WinnerMatch5, team2WinnerMatch6,
                team2WinnerMatch7, team2WinnerMatch8, team2WinnerMatch9, team2WinnerMatch10, team2WinnerMatch11,
                team2WinnerMatch12, team2WinnerMatch13, team2WinnerMatch14));
        teamOnesScore = new ArrayList<>(Arrays.asList(team1ScoreMatch, team1ScoreMatch1,
                team1ScoreMatch2, team1ScoreMatch3, team1ScoreMatch4, team1ScoreMatch5, team1ScoreMatch6,
                team1ScoreMatch7, team1ScoreMatch8, team1ScoreMatch9, team1ScoreMatch10, team1ScoreMatch11,
                team1ScoreMatch12, team1ScoreMatch13, team1ScoreMatch14));
        teamTwosScore = new ArrayList<>(Arrays.asList(team2ScoreMatch, team2ScoreMatch1,
                team2ScoreMatch2, team2ScoreMatch3, team2ScoreMatch4, team2ScoreMatch5, team2ScoreMatch6,
                team2ScoreMatch7, team2ScoreMatch8, team2ScoreMatch9, team2ScoreMatch10, team2ScoreMatch11,
                team2ScoreMatch12, team2ScoreMatch13, team2ScoreMatch14));
    }

}
