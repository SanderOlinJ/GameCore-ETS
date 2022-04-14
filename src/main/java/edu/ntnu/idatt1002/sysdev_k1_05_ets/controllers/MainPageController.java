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
import javafx.scene.text.Text;
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

    @FXML private VBox upcomingBox1;
    @FXML private ImageView upcomingImageView1;
    @FXML private Pane upcomingPane1;
    @FXML private TextArea upcomingText1;

    @FXML private VBox upcomingBox2;
    @FXML private ImageView upcomingImageView2;
    @FXML private Pane upcomingPane2;
    @FXML private TextArea upcomingText2;

    @FXML private VBox previousBox1;
    @FXML private ImageView previousImageView1;
    @FXML private Pane previousPane1;
    @FXML private TextArea previousText1;

    @FXML private VBox previousBox2;
    @FXML private ImageView previousImageView2;
    @FXML private Pane previousPane2;
    @FXML private TextArea previousText2;


    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        showOngoingTournaments();
        showUpcomingTournaments();
        showPreviousTournaments();
    }

    @FXML
    private void showOngoingTournaments()
    throws IOException{
        try {
            ArrayList<NewTournament> ongoingTournaments = TournamentReaderRework.showOngoingTournamentsAtMainPage();
            setMainPageWithTournaments(ongoingTournaments, ongoingImageView1, ongoingText1, ongoingBox1,
                    ongoingImageView2, ongoingText2, ongoingBox2);
        } catch (IOException exception){
            throw new IOException("Could not show ongoing tournaments: " + exception.getMessage());
        }
    }

    @FXML
    private void showUpcomingTournaments()
            throws IOException{
        try {
            ArrayList<NewTournament> upcomingTournaments = TournamentReaderRework.showUpcomingTournamentsAtMainPage();
            setMainPageWithTournaments(upcomingTournaments, upcomingImageView1, upcomingText1, upcomingBox1,
                    upcomingImageView2, upcomingText2, upcomingBox2);
        } catch (IOException exception){
            throw new IOException("Could not show upcoming tournaments: " + exception.getMessage());
        }
    }

    @FXML
    private void showPreviousTournaments()
            throws IOException{
        try {
            ArrayList<NewTournament> previousTournaments = TournamentReaderRework.showPreviousTournamentsAtMainPage();
            setMainPageWithTournaments(previousTournaments, previousImageView1, previousText1, previousBox1,
                    previousImageView2, previousText2, previousBox2);
        } catch (IOException exception){
            throw new IOException("Could not show upcoming tournaments: " + exception.getMessage());
        }
    }

    private void setMainPageWithTournaments(ArrayList<NewTournament> tournaments, ImageView imageView1,
                                            TextArea text1, VBox vBox1, ImageView imageView2,
                                            TextArea text2, VBox vBox2) {
        if (tournaments.size() > 0){
            imageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "Images/gameImages/"+ Utilities.shortenAndReplaceUnnecessarySymbolsInString
                    (tournaments.get(0).getGame()) + ".png"));
            text1.setText(tournaments.get(0).getTournamentName());
            vBox1.setVisible(true);

            if (tournaments.size() > 1){

                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                        "sysdev_k1_05_ets/Images/gameImages/"+
                        Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(1).getGame()) + ".png"));
                text2.setText(tournaments.get(1).getTournamentName());
                vBox2.setVisible(true);
            }
        }
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
