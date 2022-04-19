package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class OverviewController {

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;
    @FXML private MenuBar menuBar;
    @FXML private HBox box1;
    @FXML private HBox box2;
    @FXML private HBox box3;
    @FXML private HBox box4;
    @FXML private HBox box5;
    @FXML private Text date1;
    @FXML private Text date2;
    @FXML private Text date3;
    @FXML private Text date4;
    @FXML private Text date5;
    @FXML private Text game1;
    @FXML private Text game2;
    @FXML private Text game3;
    @FXML private Text game4;
    @FXML private Text game5;
    @FXML private ImageView imageView1;
    @FXML private ImageView imageView2;
    @FXML private ImageView imageView3;
    @FXML private ImageView imageView4;
    @FXML private ImageView imageView5;
    @FXML private Text name1;
    @FXML private Text name2;
    @FXML private Text name3;
    @FXML private Text name4;
    @FXML private Text name5;
    @FXML private Button overviewButton1;
    @FXML private Button overviewButton2;
    @FXML private Button overviewButton3;
    @FXML private Button overviewButton4;
    @FXML private Button overviewButton5;
    @FXML private Text team11;
    @FXML private Text team21;
    @FXML private Text team31;
    @FXML private Text team41;
    @FXML private Text team51;
    @FXML private Text team12;
    @FXML private Text team22;
    @FXML private Text team32;
    @FXML private Text team42;
    @FXML private Text team52;
    @FXML private Text teamsLeft1;
    @FXML private Text teamsLeft2;
    @FXML private Text teamsLeft3;
    @FXML private Text teamsLeft4;
    @FXML private Text teamsLeft5;
    @FXML private Text time1;
    @FXML private Text time2;
    @FXML private Text time3;
    @FXML private Text time4;
    @FXML private Text time5;
    @FXML private Text totalTeams1;
    @FXML private Text totalTeams2;
    @FXML private Text totalTeams3;
    @FXML private Text totalTeams4;
    @FXML private Text totalTeams5;
    @FXML private Text overviewTitle;
    private ArrayList<NewTournament> tournaments;


    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        tournaments = new ArrayList<>();
        if (overviewTitle.getText().equals("Ongoing tournaments")){
            tournaments = TournamentReaderRework.readAllOngoingTournamentsToList(0);
        } else if (overviewTitle.getText().equals("Upcoming tournaments")){
            tournaments = TournamentReaderRework.readAllUpcomingTournamentsToList(0);
        } else if (overviewTitle.getText().equals("Previous tournaments")){
            tournaments = TournamentReaderRework.readAllPreviousTournamentsToList(0);
        }
        setMainPageWithTournaments();

    }

    private void setMainPageWithTournaments() {

        if (tournaments.size() > 0) {
            imageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                    (tournaments.get(0).getGame()) + ".png"));
            name1.setText(tournaments.get(0).getTournamentName());
            game1.setText(tournaments.get(0).getGame());
            totalTeams1.setText(tournaments.get(0).getNumberOfTeams());
            teamsLeft1.setText(tournaments.get(0).getNumberOfTeams());
            team11.setText("Bruh");
            team12.setText("Bruh");
            date1.setText(tournaments.get(0).getDate().toString());
            time1.setText(tournaments.get(0).getTime().toString());
            box1.setDisable(false);
            box1.setVisible(true);

            if (tournaments.size() > 1) {
                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                        (tournaments.get(1).getGame()) + ".png"));
                name2.setText(tournaments.get(1).getTournamentName());
                game2.setText(tournaments.get(1).getGame());
                totalTeams2.setText(tournaments.get(1).getNumberOfTeams());
                teamsLeft2.setText(tournaments.get(1).getNumberOfTeams());
                team21.setText("Bruh");
                team22.setText("Bruh");
                date2.setText(tournaments.get(1).getDate().toString());
                time2.setText(tournaments.get(1).getTime().toString());
                box2.setDisable(false);
                box2.setVisible(true);

                if (tournaments.size() > 2) {
                    imageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                            "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                            (tournaments.get(2).getGame()) + ".png"));
                    name3.setText(tournaments.get(2).getTournamentName());
                    game3.setText(tournaments.get(2).getGame());
                    totalTeams3.setText(tournaments.get(2).getNumberOfTeams());
                    teamsLeft3.setText(tournaments.get(2).getNumberOfTeams());
                    team31.setText("Bruh");
                    team32.setText("Bruh");
                    date3.setText(tournaments.get(2).getDate().toString());
                    time3.setText(tournaments.get(2).getTime().toString());
                    box3.setDisable(false);
                    box3.setVisible(true);

                    if (tournaments.size() > 3) {
                        imageView4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(3).getGame()) + ".png"));
                        name4.setText(tournaments.get(3).getTournamentName());
                        game4.setText(tournaments.get(3).getGame());
                        totalTeams4.setText(tournaments.get(3).getNumberOfTeams());
                        teamsLeft4.setText(tournaments.get(3).getNumberOfTeams());
                        team41.setText("Bruh");
                        team42.setText("Bruh");
                        date4.setText(tournaments.get(3).getDate().toString());
                        time4.setText(tournaments.get(3).getTime().toString());
                        box4.setDisable(false);
                        box4.setVisible(true);

                        if (tournaments.size() > 4) {
                            imageView5.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                    "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                    (tournaments.get(4).getGame()) + ".png"));
                            name5.setText(tournaments.get(4).getTournamentName());
                            game5.setText(tournaments.get(4).getGame());
                            totalTeams5.setText(tournaments.get(4).getNumberOfTeams());
                            teamsLeft5.setText(tournaments.get(4).getNumberOfTeams());
                            team51.setText("Bruh");
                            team52.setText("Bruh");
                            date5.setText(tournaments.get(4).getDate().toString());
                            time5.setText(tournaments.get(4).getTime().toString());
                            box5.setDisable(false);
                            box5.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        onTournamentMenuItemPressed(root);
    }

    private void onTournamentMenuItemPressed(Parent root) {
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
        onTournamentMenuItemPressed(root);
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event)
            throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        onTournamentMenuItemPressed(root);
    }


    @FXML
    void onHomeButtonPressed(ActionEvent event)
    throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/main-page.fxml")));
        onTournamentMenuItemPressed(root);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/about-page.fxml")));
        onTournamentMenuItemPressed(root);
    }

    @FXML
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/help-page.fxml")));
        onTournamentMenuItemPressed(root);
    }

}