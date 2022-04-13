package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
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

    @FXML private VBox ongoingBox1;
    @FXML private ImageView ongoingImageView1;
    @FXML private Pane ongoingPane1;
    @FXML private TextArea ongoingText1;

    @FXML private VBox ongoingBox2;
    @FXML private ImageView ongoingImageView2;
    @FXML private Pane ongoingPane2;
    @FXML private TextArea ongoingText2;


    @FXML private VBox ongoingBox3;
    @FXML private ImageView ongoingImageView3;
    @FXML private Pane ongoingPane3;
    @FXML private TextArea ongoingText3;


    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        showOngoingTournaments();
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(TeamReader.findAndReturnTeamUsingTeamName("Phase"));
        teams.add(TeamReader.findAndReturnTeamUsingTeamName("Astralis"));
        TournamentWriterRework.writeTeamsToTournamentFile("testFile5",teams);
    }

    @FXML
    private void showOngoingTournaments()
    throws IOException{
        try {
            ArrayList<NewTournament> ongoingTournaments = TournamentReaderRework.showOngoingTournamentsAtMainPage();
            if (ongoingTournaments.size() > 0){
                ongoingImageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "Images/gameImages/"+ Utilities.shortenAndReplaceUnnecessarySymbolsInString
                        (ongoingTournaments.get(0).getGame()) + ".png"));
                ongoingText1.setText(ongoingTournaments.get(0).getTournamentName());
                ongoingBox1.setVisible(true);

                if (ongoingTournaments.size() > 1){

                    ongoingImageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                            "sysdev_k1_05_ets/Images/gameImages/"+
                            Utilities.shortenAndReplaceUnnecessarySymbolsInString
                            (ongoingTournaments.get(1).getGame()) + ".png"));
                    ongoingText2.setText(ongoingTournaments.get(1).getTournamentName());
                    ongoingBox2.setVisible(true);

                    if (ongoingTournaments.size() == 3){
                        ongoingImageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                "sysdev_k1_05_ets/Images/gameImages/"+
                                Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (ongoingTournaments.get(2).getGame()) + ".png"));
                        ongoingText3.setText(ongoingTournaments.get(2).getTournamentName());
                        ongoingBox3.setVisible(true);
                    }
                }
            }
        } catch (IOException exception){
            throw new IOException("Could not show ongoing tournaments: " + exception.getMessage());
        }
    }

    private void showUpcomingTournaments(){

    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) {
    }

    @FXML
    void onCreateNewTournamentButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/create-new-tournament-page.fxml")));
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


}
