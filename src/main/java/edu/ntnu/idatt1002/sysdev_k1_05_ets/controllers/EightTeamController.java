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

import static java.lang.Integer.parseInt;

public class EightTeamController {

    private static Bracket bracket = new Bracket("Bracket");


    @FXML
    ArrayList<Label> labels = new ArrayList<Label>();

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

    @FXML
    public void initialize(){
        labels.add(team1);
        labels.add(team2);
        labels.add(team3);
        labels.add(team4);
        labels.add(team5);
        labels.add(team6);
        labels.add(team7);
        labels.add(team8);
        labels.add(team9);
        labels.add(team10);
        labels.add(team11);
        labels.add(team12);
        labels.add(team13);
        labels.add(team14);
        labels.add(team15);

        for (Label label : labels) {
            label.setOnMouseClicked(mouseEvent -> {advanceTeam(label);});
        }
    }

    public void randomize(){

        Bracket deepCopy = new Bracket("Deep Copy");
        for (Team team : bracket.getTeams()) {
            deepCopy.addTeam(new Team(team.getMembers(), team.getNameOfTeam()));
        }

        for (int i = 0; i < 7; i++){
            labels.get(i).setText("TBD");
        }
        for (int i = 7; i < 15; i++) {
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

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/MainPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void advanceTeam(Label label) {
        String teamName = label.getText();
        int id = getLabelInt(label);
        labels.get((id/2)-1).setText(teamName);

    }

    public static Bracket getBracket(){
        return bracket;
    }

    public int getLabelInt(Label label){
        return Integer.parseInt(label.getId().substring(4));
    }



}
