package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BracketController {

    private static String tournamentName;
    private static Tournament tournament = new Tournament("tournamentName");
    static int bracketSize;
    int numberOfTeams;
    

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


    @FXML
    public void initialize(){
        if (bracketSize >= 4) {
            labels.add(team1);
            labels.add(team2);
            labels.add(team3);
            labels.add(team4);
            labels.add(team5);
            labels.add(team6);
            labels.add(team7);
        }
        if (bracketSize >= 8) {
            labels.add(team8);
            labels.add(team9);
            labels.add(team10);
            labels.add(team11);
            labels.add(team12);
            labels.add(team13);
            labels.add(team14);
            labels.add(team15);
        }
        if (bracketSize >= 16) {
            labels.add(team16);
            labels.add(team17);
            labels.add(team18);
            labels.add(team19);
            labels.add(team20);
            labels.add(team21);
            labels.add(team22);
            labels.add(team23);
            labels.add(team24);
            labels.add(team25);
            labels.add(team26);
            labels.add(team27);
            labels.add(team28);
            labels.add(team29);
            labels.add(team30);
            labels.add(team31);
        }

        for (Label label : labels) {
            label.setOnMouseClicked(mouseEvent -> advanceTeam(label));
        }

        randomize();
    }

    public void randomize(){

        Tournament deepCopy = new Tournament("Deep Copy");
        for (Team team : tournament.getTeams()) {
            deepCopy.addTeam(new Team(team.getMembers(), team.getNameOfTeam(), team.getNameAbbr()));
        }

        for (int i = 0; i < bracketSize - 1; i++){
            labels.get(i).setText("?");
        }
        for (int i = bracketSize-1; i < 2*bracketSize - 1; i++) {
            labels.get(i).setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        }

//        team1.setText("TBD");
//        team2.setText("TBD");
//        team3.setText("TBD");
//        team4.setText("TBD");
//        team5.setText("TBD");
//        team6.setText("TBD");
//        team7.setText("TBD");
//        team8.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team9.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team10.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team11.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team12.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team13.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team14.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
//        team15.setText(deepCopy.getTeam(0).getNameOfTeam());
    }


    static void setBracketSize(int n){
        bracketSize = n;
    }

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(GameCoreETSApplication.class.getResource("scenes/start-screen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        tournament.setNameOfTournament(tournamentName);
        if (tournament.isDone()) {
            TournamentWriter.writeFile(labels, tournament.getNameOfTournament(),"previousTournaments");
        }else {
            TournamentWriter.writeFile(labels, tournament.getNameOfTournament(),"ongoingTournaments");
        }
    }

    @FXML
    private void advanceTeam(Label label) {
        String teamName = label.getText();
        int id = getLabelInt(label);
        labels.get((id/2)-1).setText(teamName);
    }

    public static Tournament getBracket(){
        return tournament;
    }

    public int getLabelInt(Label label){
        return Integer.parseInt(label.getId().substring(4));
    }

    public static void setTournamentName(String name){
        tournamentName = name;
    }
}
