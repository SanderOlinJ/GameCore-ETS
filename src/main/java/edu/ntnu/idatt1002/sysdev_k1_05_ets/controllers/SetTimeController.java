package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SetTimeController {
    @FXML ChoiceBox hoursMatch;
    @FXML ChoiceBox minutesMatch;


    @FXML
    public void initialize(){
        setHours(hoursMatch);
        setMinutes(minutesMatch);
    }

    @FXML
    public void setResultsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/results-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
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

    public void setHours(ChoiceBox box){
        box.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23");
    }

    public void setMinutes(ChoiceBox box){
        box.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
    }
}
