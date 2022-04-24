package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BracketController {

    private static String nameOfTournament;
    private NewTournament newTournament;
    private int bracketSize;


    @FXML
    ArrayList<Label> labels = new ArrayList<>();
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

    @FXML
    public void initialize(){

        try {
            newTournament = TournamentReaderRework.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        GameCoreETSApplication.showGameInfo(tournamentName, nameOfTournament, imageView, newTournament,
                game, host, startDate, startTime, platform, prizePool,
                entranceFee, prizePoolCurrency, entranceFeeCurrency);
        bracketSize = newTournament.getNumberOfTeams();

        ArrayList<Team> teams = newTournament.getTeams();
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

        for (int i = 0; i < teams.size(); i++){
            int index = 0;
            if (bracketSize == 16){
                if (i > 29){index = 30;}
                else if (i > 27){index = 27;}
                else if (i > 23){index = 21;}
                else if (i > 15){index =  9;}
            }
            if (bracketSize == 8) {
                if (i > 13) {
                    index = 14;
                } else if (i > 11) {
                    index = 11;
                } else if (i > 7) {
                    index = 5;
                }
            }
            else if (bracketSize == 4){
                if (i > 5){index = 6;}
                else if (i > 3) {index = 3;}
            }
            if (i < bracketSize){
                labels.get(i + (bracketSize - 1)).setText(teams.get(i).getNameAbbr());
            }else{
                if (labels.get(0).getText().equals("?") || labels.get(0).getText().isEmpty()) {
                    labels.get(i - index).setText(teams.get(i).getNameAbbr());
                }else {
                    labels.get(0).setText(teams.get(i).getNameAbbr());
                }
            }
        }

        for (int i = 0; i < bracketSize - 1; i++){
            labels.get(i).setText("?");
        }
        for (int i = bracketSize-1; i < 2*bracketSize - 1; i++) {
            labels.get(i).setText(teams.get(i-(bracketSize-1)).getNameAbbr());
        }
    }



    @FXML
    public void setMatchesScene()
    throws IOException {
        MatchesController.setNameOfTournament(nameOfTournament);
        ViewSwitcher.switchTo(View.TOURNAMENT_MATCHES);
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


    public static void setNameOfTournament(String name){
        nameOfTournament = name;
    }

    public static String getNameOfTournament(){return nameOfTournament;}

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

}
