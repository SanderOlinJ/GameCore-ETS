package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.GeneralReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Controller class for the Bracket Overview page
 */
public class BracketController {

    private static String nameOfTournament;
    private Tournament tournament;

    @FXML ArrayList<Label> labels = new ArrayList<>();
    @FXML private Label team1;
    @FXML private Label team2;
    @FXML private Label team3;
    @FXML private Label team4;
    @FXML private Label team5;
    @FXML private Label team6;
    @FXML private Label team7;
    @FXML private Label team8;
    @FXML private Label team9;
    @FXML private Label team10;
    @FXML private Label team11;
    @FXML private Label team12;
    @FXML private Label team13;
    @FXML private Label team14;
    @FXML private Label team15;
    @FXML private Label team16;
    @FXML private Label team17;
    @FXML private Label team18;
    @FXML private Label team19;
    @FXML private Label team20;
    @FXML private Label team21;
    @FXML private Label team22;
    @FXML private Label team23;
    @FXML private Label team24;
    @FXML private Label team25;
    @FXML private Label team26;
    @FXML private Label team27;
    @FXML private Label team28;
    @FXML private Label team29;
    @FXML private Label team30;
    @FXML private Label team31;
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

    /**
     Method initializes the page with content.
     */
    @FXML
    public void initialize(){
        try {
            tournament = TournamentReader.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        Utilities.showGameInfo(tournamentName, imageView, tournament,
                game, host, startDate, startTime, platform, prizePool,
                entranceFee, prizePoolCurrency, entranceFeeCurrency);
        int bracketSize = tournament.getNumberOfTeams();

        if (bracketSize >= 4) {
            labels.addAll(Arrays.asList(team1,team2,team3,team4,team5,team6,team7));
        }
        if (bracketSize >= 8) {
            labels.addAll(Arrays.asList(team8,team9,team10,team11,team12,team13,team14,team15));
        }
        if (bracketSize >= 16) {
            labels.addAll(Arrays.asList(team16,team17,team18,team19,team20,team21,team22,team23,team24,team25,team26,
                    team27,team28,team29,team30,team31));
        }

        String[][] data = new String[bracketSize -1][2];

        try {
            File file = new File(TournamentWriter.getPathToTournamentFileAsString(nameOfTournament));
            for (int i = 0; i < bracketSize - 1; i++) {
                String str = GeneralReader.readSpecificLineInFile(file,14+i);
                String[] values = str.split(",");
                if (!values[3].equals("?")){
                    Team team1 = tournament.getTeamByName(values[3]);
                    Team team2 = tournament.getTeamByName(values[2]);
                    data[i][0] = team1.getNameAbbr();
                    data[i][1] = team2.getNameAbbr();
                } else {
                    data[i][0] = values[3];
                    data[i][1] = values[2];
                }
            }
            String winner = GeneralReader.readSpecificLineInFile(file, 12+ bracketSize);
            labels.get(0).setText(winner.split(",")[7]);
            for (int i = 1; i < 2* bracketSize - 1; i++) {
                int index = (i + 1) / 2;
                labels.get(i).setText(data[data.length-index][(i+1)%2]);
            }
        } catch (IOException exception){
            exception.printStackTrace();
        }
        tournamentName.setText(nameOfTournament);
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
     * Used for setting the name of a tournament
     * @param nameOfTournament name of tournament
     */
    public static void setNameOfTournament(String nameOfTournament){
        BracketController.nameOfTournament = nameOfTournament;
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

}
