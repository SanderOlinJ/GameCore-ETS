package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class ResultsController {

    @FXML private VBox resultBox;
    @FXML Label tournamentName;
    private static ArrayList<HBox> matches = new ArrayList<>();

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;

    public void initialize(){
        for (HBox match : matches) {
            resultBox.getChildren().add(match);
        }
        tournamentName.setText(BracketController.getTournamentName());
    }

    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        String link = "";
        if (BracketController.bracketSize == 4){
            link = "scenes/overview-scene-four.fxml";
        } else if (BracketController.bracketSize == 8){
            link = "scenes/overview-scene-eight.fxml";
        } else if (BracketController.bracketSize == 16){
            link = "scenes/overview-scene-sixteen.fxml";
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(link)));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    @FXML
    public void setTimeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/set-time-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }


    @FXML
    public void setMatchesScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/matches-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }



    public static void addMatch(HBox match){
        matches.add(match);
    }

    @FXML
    void onHomeButtonPressed(){}

    @FXML
    void onOngoingTournamentsButtonPressed(){}

    @FXML
    void onUpcomingTournamentsButtonPressed(){}

    @FXML
    void onPreviousTournamentsButtonPressed(){}

    @FXML
    void onAboutButtonPressed(){}

}
