package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

/**
 * Controller class for the Set Time page
 */
public class SetTimeController {

    private static String nameOfTournament;
    private Tournament tournament;
    @FXML ComboBox hoursMatch;

    @FXML Button setTimeButton;
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

    private ArrayList<ComboBox> hourBoxes;
    private ArrayList<ComboBox> minuteBoxes;
    ArrayList<Label> teamOnes;
    ArrayList<Label> teamTwos;
    private ArrayList<HBox> matches;

    /**
     Used for initializing front-end values on set time page
     */
    @FXML
    public void initialize(){
        try {
            tournament = TournamentReader.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        Utilities.showGameInfo(tournamentName, imageView, tournament, game,
                host, startDate, startTime, platform, prizePool, entranceFee,
                prizePoolCurrency, entranceFeeCurrency);

        initializeLists();

        for (ComboBox box : hourBoxes){
            setHoursToBox(box);
        }
        for (ComboBox box : minuteBoxes){
            setMinutesToBox(box);
        }
        tournamentName.setText(nameOfTournament);
        setVisibleMatches();
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
     * Used for redirecting current page to set matches page
     * @throws IOException if scenes could not be switched
     */
    @FXML
    public void setMatchesScene()
    throws IOException {
        /*
        Method sends the tournament name to the next Controller,
        so that the tournament may be read from file there.
         */
        MatchesController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.MATCHES);
    }


    @FXML
    public void setTime()  {
        for (int i = 0; i < hourBoxes.size(); i++) {
            if (hourBoxes.get(i).getValue() != null && minuteBoxes.get(i).getValue() != null &&
                !hourBoxes.get(i).isDisable() && !minuteBoxes.get(i).isDisable()){
                   matches.get(i).setPrefHeight(0);
                   matches.get(i).setDisable(true);
                   matches.get(i).setVisible(false);
                   matches.get(i).setDisable(true);
                   matches.get(i).setVisible(false);
                   matches.get(i).setPrefHeight(0);

                   try {
                       Team team1 = tournament.getTeamByName(teamOnes.get(i).getText());
                       Team team2 = tournament.getTeamByName(teamTwos.get(i).getText());
                       Match match = new Match(team1, team2);
                       LocalTime time = LocalTime.parse(hourBoxes.get(i).getValue() + ":" + minuteBoxes.get(i).getValue());
                       match.setTimeOfMatch(time);
                       TournamentWriter.writeMatchesToTournament(tournament
                               .getTournamentName(),match);
                       hourBoxes.get(i).setDisable(true);
                       minuteBoxes.get(i).setDisable(true);

                   } catch (IOException exception){
                       exception.printStackTrace();
                   }
            }
        }
    }

    /**
     Used for setting values to the combo boxes that contains hours.
     * @param box combobox in which you set hours
     */
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
    }

    /**
     Used for setting values to the combo boxes that contains minutes.
     * @param box combobox in which you set minutes
     */
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
    }

    public void setVisibleMatches(){
        int nrOfMatchesNoTimeSet = tournament.getNumberOfMatchesWithNoTimeSet();
        for (int i = 0; i < nrOfMatchesNoTimeSet; i++) {
            if (tournament.getMatchesWithNoTimeSet().get(i).getTeam1() != null &&
                    tournament.getMatchesWithNoTimeSet().get(i).getTeam2() != null){
                matches.get(i).setVisible(true);
                matches.get(i).setPrefHeight(100);
                matches.get(i).setDisable(false);
                teamOnes.get(i).setText(tournament.getMatchesWithNoTimeSet().get(i).getTeam1().getNameOfTeam());
                teamTwos.get(i).setText(tournament.getMatchesWithNoTimeSet().get(i).getTeam2().getNameOfTeam());
            }else {
                if (tournament.getMatchesWithNoTimeSet().get(i).getTeam1() != null){
                    teamOnes.get(i).setText(tournament.getMatchesWithNoTimeSet().get(i).getTeam1().getNameOfTeam());
                    matches.get(i).setVisible(true);
                    matches.get(i).setPrefHeight(100);
                }
                if (tournament.getMatchesWithNoTimeSet().get(i).getTeam2() != null) {
                    teamTwos.get(i).setText(tournament.getMatchesWithNoTimeSet().get(i).getTeam2().getNameOfTeam());
                    matches.get(i).setVisible(true);
                    matches.get(i).setPrefHeight(100);
                }
            }
        }
    }

    /**
     * Sets name for tournament
     * @param nameOfTournament
     */
    public static void setNameOfTournament(String nameOfTournament) {
        SetTimeController.nameOfTournament = nameOfTournament;
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
     * Used for initializing list containing labels.
     */
    private void initializeLists(){

        hourBoxes = new ArrayList<>(Arrays.asList(hoursMatch, hoursMatch1, hoursMatch2, hoursMatch3, hoursMatch4,
                hoursMatch5, hoursMatch6, hoursMatch7, hoursMatch8, hoursMatch9, hoursMatch10, hoursMatch11,
                minutesMatch12, minutesMatch13, minutesMatch14));
        minuteBoxes = new ArrayList<>(Arrays.asList(minutesMatch,minutesMatch1,minutesMatch2,minutesMatch3,minutesMatch4
                ,minutesMatch5,minutesMatch6,minutesMatch7,minutesMatch8,minutesMatch9,minutesMatch10,minutesMatch11,
                minutesMatch12,minutesMatch13,hoursMatch14));
        matches = new ArrayList<>(Arrays.asList(match,match1,match2,match3,match4,match5,match6,
                match7,match8,match9,match10,match11,match12,match13,match14));
        teamOnes = new ArrayList<>(Arrays.asList(team1match,team1match1,team1match2,team1match3,
                team1match4,team1match5,team1match6,team1match7,team1match8,team1match9,team1match10,team1match11,
                team1match12,team1match13,team1match14));
        teamTwos = new ArrayList<>(Arrays.asList(team2match,team2match1,team2match2,team2match3,
                team2match4,team2match5,team2match6,team2match7,team2match8,team2match9,team2match10,team2match11,
                team2match12,team2match13,team2match14));
    }
}
