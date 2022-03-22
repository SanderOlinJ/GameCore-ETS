package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Bracket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EightTeamController {

    private Bracket bracket;

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
    private Label welcomeText;


    public void initialize(){
        System.out.println(team1.getText());
        team1.setText("TBD");
        team2.setText("TBD");
        team3.setText("TBD");
        team4.setText("TBD");
        team5.setText("TBD");
        team6.setText("TBD");
        team7.setText("TBD");
        team8.setText(bracket.getTeam(8).getNameOfTeam());
        team9.setText(bracket.getTeam(9).getNameOfTeam());
        team10.setText(bracket.getTeam(10).getNameOfTeam());
        team11.setText(bracket.getTeam(11).getNameOfTeam());
        team12.setText(bracket.getTeam(12).getNameOfTeam());
        team13.setText(bracket.getTeam(13).getNameOfTeam());
        team14.setText(bracket.getTeam(14).getNameOfTeam());
        team14.setText(bracket.getTeam(15).getNameOfTeam());
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("eight_team_bracket.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void addTeam(ActionEvent event) throws IOException {

    }

}
