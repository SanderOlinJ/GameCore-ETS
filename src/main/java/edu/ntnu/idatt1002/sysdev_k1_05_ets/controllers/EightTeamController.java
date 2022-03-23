package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Bracket;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EightTeamController {

    private static Bracket bracket = new Bracket("Bracket");

    @FXML
    private Label team1;
    @FXML
    private Label team2;
    @FXML
    private Label team3;
    @FXML
    private Label team4;
    @FXML
    private Label team5;
    @FXML
    private Label team6;
    @FXML
    private Label team7;
    @FXML
    private Label team8;
    @FXML
    private Label team9;
    @FXML
    private Label team10;
    @FXML
    private Label team11;
    @FXML
    private Label team12;
    @FXML
    private Label team13;
    @FXML
    private Label team14;
    @FXML
    private Label team15;




    public void randomize(){

        Bracket deepCopy = new Bracket("Deep Copy");
        for (Team team : bracket.getTeams()) {
            deepCopy.addTeam(new Team(team.getMembers(), team.getNameOfTeam()));
        }

        System.out.println(team1.getText());
        team1.setText("TBD");
        team2.setText("TBD");
        team3.setText("TBD");
        team4.setText("TBD");
        team5.setText("TBD");
        team6.setText("TBD");
        team7.setText("TBD");
        team8.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team9.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team10.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team11.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team12.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team13.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team14.setText(deepCopy.randomlyRemoveTeam().getNameOfTeam());
        team15.setText(deepCopy.getTeam(0).getNameOfTeam());
    }

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/MainPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void advanceTeam(ActionEvent event) {
        
    }

    public static Bracket getBracket(){
        return bracket;
    }



}
