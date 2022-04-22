package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BracketController {

    private static String nameOfTournament;
    private NewTournament newTournament;
    private static int bracketSize;


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
    @FXML Label tournamentName;

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

    @FXML private MenuBar menuBar;


    @FXML
    public void initialize(){

        try {
            newTournament = TournamentReaderRework.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }

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

        tournamentName.setText(nameOfTournament);
    }



    @FXML
    public void setMatchesScene(ActionEvent event) throws IOException {
        MatchesController.setNameOfTournament(nameOfTournament);
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/matches-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        //        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

//    @FXML
//    public void setResultsScene(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
//                "scenes/results-scene.fxml")));
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setMinWidth(1200);
//        stage.setMinHeight(800);
//        stage.show();
//    }


    @FXML
    public void setResultsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/results-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    @FXML
    public void setTimeScene(ActionEvent event) throws IOException {
        SetTimeController.setNameOfTournament(nameOfTournament);
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/set-time-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }




    public NewTournament getBracket(){
        return newTournament;
    }

    public int getLabelInt(Label label){
        return Integer.parseInt(label.getId().substring(4));
    }

    public static void setNameOfTournament(String name){
        nameOfTournament = name;
    }

    public static String getNameOfTournament(){return nameOfTournament;}
    public void switchToMatches(){}

    public static int getBracketSize() {
        return bracketSize;
    }

    public static void setBracketSize(int n){
        bracketSize = n;
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
