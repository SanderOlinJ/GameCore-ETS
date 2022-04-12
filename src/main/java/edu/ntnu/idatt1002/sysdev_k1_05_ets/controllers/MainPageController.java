package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainPageController {
    @FXML private Menu aboutButton;
    @FXML private Button createNewTournamentButton;
    @FXML private Menu homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem previousTournamentButton;
    @FXML private Menu tournamentButton;
    @FXML Stage stage;
    @FXML BorderPane startScreenPane;

    @FXML private TextArea ongoingTournaments;
    @FXML private TextArea previousTournaments;



    @FXML
    public void initialize() throws IOException {
        fillOngoingAndPreviousTournamentAreas();
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) {
    }

    @FXML
    void onCreateNewTournamentButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(GameCoreETSApplication.class.getResource("scenes/create-new-tournament-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    void onHomeButtonPressed(ActionEvent event) {
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) {
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event) {
    }

    //This uses the csv file previousTournaments so it looks kind of ugly and there
    //should also be links for each tournament. This was just to fill in the empty space
    public void fillOngoingAndPreviousTournamentAreas() throws IOException{
        String previousTournamentsText = "";
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/tournamentFiles/previousTournaments.csv");

        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                previousTournamentsText += line.toString() + "\n";
            }
            previousTournaments.setText(previousTournamentsText);
        }catch (IOException e) {
            throw new IOException("Unable to read data from file '" + file.getName() + "': " + e.getMessage());
        }

    }



}
