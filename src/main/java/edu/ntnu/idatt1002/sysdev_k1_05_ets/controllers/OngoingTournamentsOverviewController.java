package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Controller class for the Ongoing tournament Overview page
 */

public class OngoingTournamentsOverviewController {
    @FXML private HBox box;
    @FXML private HBox box1;
    @FXML private HBox box2;
    @FXML private HBox box3;
    @FXML private HBox box4;
    @FXML private Text game;
    @FXML private Text game1;
    @FXML private Text game2;
    @FXML private Text game3;
    @FXML private Text game4;
    @FXML private ImageView imageView;
    @FXML private ImageView imageView1;
    @FXML private ImageView imageView2;
    @FXML private ImageView imageView3;
    @FXML private ImageView imageView4;
    @FXML private Text name;
    @FXML private Text name1;
    @FXML private Text name2;
    @FXML private Text name3;
    @FXML private Text name4;
    @FXML private Text team11;
    @FXML private Text team12;
    @FXML private Text team21;
    @FXML private Text team22;
    @FXML private Text team31;
    @FXML private Text team32;
    @FXML private Text team41;
    @FXML private Text team42;
    @FXML private Text team51;
    @FXML private Text team52;
    @FXML private Text teamsLeft;
    @FXML private Text teamsLeft1;
    @FXML private Text teamsLeft2;
    @FXML private Text teamsLeft3;
    @FXML private Text teamsLeft4;
    @FXML private Text time;
    @FXML private Text time1;
    @FXML private Text time2;
    @FXML private Text time3;
    @FXML private Text time4;
    @FXML private Text totalTeams;
    @FXML private Text totalTeams1;
    @FXML private Text totalTeams2;
    @FXML private Text totalTeams3;
    @FXML private Text totalTeams4;
    @FXML private Text vs;
    @FXML private Text vs1;
    @FXML private Text vs2;
    @FXML private Text vs3;
    @FXML private Text vs4;
    @FXML private Button overviewButton;
    @FXML private Button overviewButton1;
    @FXML private Button overviewButton2;
    @FXML private Button overviewButton3;
    @FXML private Button overviewButton4;
    @FXML private ImageView deleteIcon;
    @FXML private ImageView deleteIcon1;
    @FXML private ImageView deleteIcon2;
    @FXML private ImageView deleteIcon3;
    @FXML private ImageView deleteIcon4;

    private ArrayList<Tournament> tournaments;

    /**
     Method initializes the page with content.
     * @throws IOException if tournaments location could not be updated or if tournaments could not be read.
     */
    @FXML
    public void initialize()
    throws IOException {
        /*First updates the location of each tournament,
        so that for example previous tournaments are not shown on this page.
         */
        TournamentWriter.updateTournamentFileLocation();

        //Then sets the page with upcoming tournaments
        tournaments = TournamentReader.readAllOngoingTournamentsToList(0);
        setMainPageWithTournaments();
    }

    /**
     Method parses through the ongoing tournaments and displays them on screen
     Sets each fxml value with data from the tournaments.
     */
    private void setMainPageWithTournaments() {
        if (tournaments.size() > 0) {
            imageView.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                    (tournaments.get(0).getGame()) + ".png"));
            name.setText(tournaments.get(0).getTournamentName());
            game.setText(tournaments.get(0).getGame());
            totalTeams.setText(String.valueOf(tournaments.get(0).getNumberOfTeams()));
            if (tournaments.get(0).getTeams().size() == Integer.parseInt(String.valueOf(tournaments.get(0).getNumberOfTeams()))) {
                teamsLeft.setText("" + tournaments.get(0).findNumberOfTeamsLeft());
            } else {
                teamsLeft.setText("Not all teams set");
                overviewButton.setText("Add teams");
            }
            if (tournaments.get(0).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                String team11Name = tournaments.get(0).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                String team12Name = tournaments.get(0).findNextMatchToBePlayed().getTeam2().getNameAbbr();

                String match1Time = tournaments.get(0).findNextMatchToBePlayed().getTimeOfMatch().toString();
                team11.setText(team11Name);
                team12.setText(team12Name);
                time.setText(match1Time);
            }else {
                vs.setText("No matches set");
                overviewButton.setText("Add teams");
            }
            deleteIcon.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/images/delete_icon.png"));
            box.setDisable(false);
            box.setVisible(true);

            if (tournaments.size() > 1) {
                imageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                        (tournaments.get(1).getGame()) + ".png"));
                name1.setText(tournaments.get(1).getTournamentName());
                game1.setText(tournaments.get(1).getGame());
                totalTeams1.setText(String.valueOf(tournaments.get(1).getNumberOfTeams()));
                if (tournaments.get(1).getTeams().size() == Integer
                        .parseInt(String.valueOf(tournaments.get(1).getNumberOfTeams()))){
                    teamsLeft1.setText("" + tournaments.get(1).findNumberOfTeamsLeft());
                } else {
                    teamsLeft1.setText("Not all teams set");
                    overviewButton1.setText("Add teams");
                }
                if (tournaments.get(1).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                    String team21Name = tournaments.get(1).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                    String team22Name = tournaments.get(1).findNextMatchToBePlayed().getTeam2().getNameAbbr();
                    String match2Time = tournaments.get(1).findNextMatchToBePlayed().getTimeOfMatch().toString();
                    team21.setText(team21Name);
                    team22.setText(team22Name);
                    time1.setText(match2Time);
                } else {
                    vs1.setText("No matches set");
                }
                deleteIcon1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                        "sysdev_k1_05_ets/images/delete_icon.png"));
                box1.setDisable(false);
                box1.setVisible(true);

                if (tournaments.size() > 2) {
                    imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                            "images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                            (tournaments.get(2).getGame()) + ".png"));
                    name2.setText(tournaments.get(2).getTournamentName());
                    game2.setText(tournaments.get(2).getGame());
                    totalTeams2.setText(String.valueOf(tournaments.get(2).getNumberOfTeams()));
                    if (tournaments.get(2).getTeams().size() == Integer.parseInt(String.valueOf(tournaments.get(2)
                            .getNumberOfTeams()))){
                        teamsLeft2.setText("" + tournaments.get(2).findNumberOfTeamsLeft());
                    } else {
                        teamsLeft2.setText("Not all teams set");
                        overviewButton2.setText("Add teams");
                    }
                    if (tournaments.get(2).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                        String team31Name = tournaments.get(2).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                        String team32Name = tournaments.get(2).findNextMatchToBePlayed().getTeam2().getNameAbbr();
                        String match3Time = tournaments.get(2).findNextMatchToBePlayed().getTimeOfMatch().toString();
                        team31.setText(team31Name);
                        team32.setText(team32Name);
                        time2.setText(match3Time);
                    } else {
                        vs2.setText("No matches set");
                    }
                    deleteIcon2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                            "sysdev_k1_05_ets/images/delete_icon.png"));
                    box2.setDisable(false);
                    box2.setVisible(true);

                    if (tournaments.size() > 3) {
                        imageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                "sysdev_k1_05_ets/images/gameImages/" +
                                Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(3).getGame()) + ".png"));
                        name3.setText(tournaments.get(3).getTournamentName());
                        game3.setText(tournaments.get(3).getGame());
                        totalTeams3.setText(String.valueOf(tournaments.get(3).getNumberOfTeams()));
                        if (tournaments.get(3).getTeams().size() == Integer.parseInt(String.valueOf(tournaments.get(3)
                                .getNumberOfTeams()))){
                            teamsLeft3.setText("" + tournaments.get(3).findNumberOfTeamsLeft());
                        } else {
                            teamsLeft3.setText("Not all teams set");
                            overviewButton3.setText("Add teams");
                        }
                        if (tournaments.get(3).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                            String team41Name = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTeam1().getNameAbbr();
                            String team42Name = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTeam2().getNameAbbr();
                            String match4Time = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTimeOfMatch().toString();
                            team41.setText(team41Name);
                            team42.setText(team42Name);
                            time3.setText(match4Time);
                        } else {
                            vs3.setText("No matches set");
                        }
                        deleteIcon3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                "sysdev_k1_05_ets/images/delete_icon.png"));
                        box3.setDisable(false);
                        box3.setVisible(true);

                        if (tournaments.size() > 4) {
                            imageView4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                    "sysdev_k1_05_ets/images/gameImages/" +
                                    Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                    (tournaments.get(4).getGame()) + ".png"));
                            name4.setText(tournaments.get(4).getTournamentName());
                            game4.setText(tournaments.get(4).getGame());
                            totalTeams4.setText(String.valueOf(tournaments.get(4).getNumberOfTeams()));
                            if (tournaments.get(4).getTeams().size() == Integer.parseInt(String.valueOf(tournaments.get(4)
                                    .getNumberOfTeams()))){
                                teamsLeft4.setText("" + tournaments.get(4).findNumberOfTeamsLeft());
                            } else {
                                teamsLeft4.setText("Not all teams set");
                                overviewButton4.setText("Add teams");
                            }
                            if (tournaments.get(4).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                                String team51Name = tournaments.get(4).findNextMatchToBePlayed().getTeam1()
                                        .getNameAbbr();
                                String team52Name = tournaments.get(4).findNextMatchToBePlayed().getTeam2()
                                        .getNameAbbr();
                                String match5Time = tournaments.get(4).findNextMatchToBePlayed().getTimeOfMatch()
                                        .toString();
                                team51.setText(team51Name);
                                team52.setText(team52Name);
                                time4.setText(match5Time);
                            } else {
                                vs4.setText("No matches set");
                            }
                            deleteIcon4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                    "sysdev_k1_05_ets/images/delete_icon.png"));
                            box4.setDisable(false);
                            box4.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onUpcomingTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    /**
     * Redirects to previous tournaments page when clicked on previous tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onPreviousTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHomeButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onAboutButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHelpButtonClicked()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }

    /**
     Used for redirecting current page to the create new tournament page
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onCreateNewTournamentButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.CREATE_NEW_TOURNAMENT);
    }

    /**
     Used for redirecting current page to the overview page the first tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButtonClicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(0));
    }

    /**
     Used for redirecting current page to the overview page the second tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton1Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(1));
    }

    /**
     Used for redirecting current page to the overview page the third tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton2Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(2));
    }

    /**
     Used for redirecting current page to the overview page the fourth tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton3Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(3));
    }

    /**
     Used for redirecting current page to the overview page the fifth tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton4Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(4));
    }

    /**
     Used for displaying alert box if the delete icon is clicked
     */
    @FXML void onDeleteIconClicked(){
        try {
            showAlertBox(tournaments.get(0));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Used for displaying alert box if the delete icon is clicked
     */
    @FXML void onDeleteIcon1Clicked(){
        try {
            showAlertBox(tournaments.get(1));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Used for displaying alert box if the delete icon is clicked
     */
    @FXML void onDeleteIcon2Clicked(){
        try {
            showAlertBox(tournaments.get(2));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Used for displaying alert box if the delete icon is clicked
     */
    @FXML void onDeleteIcon3Clicked(){
        try {
            showAlertBox(tournaments.get(3));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Used for displaying alert box if the delete icon is clicked
     */
    @FXML void onDeleteIcon4Clicked(){
        try {
            showAlertBox(tournaments.get(4));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     Method used for displaying the alert box and then deleting the tournament from overview as well as the file.
     * @param tournament tournament wished deleted
     * @throws IOException if tournament could not be removed from ongoing overview,
     * if path to file could be found or if scenes could not be switched
     */
    private void showAlertBox(Tournament tournament)
            throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete tournament");
        alert.setHeaderText("Deleting: " + tournament.getTournamentName());
        alert.setContentText("Are you sure you want to delete this tournament?");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(getClass()
                .getResource("/edu/ntnu/idatt1002/sysdev_k1_05_ets/css/style.css")).toString());
        dialogPane.getStyleClass().add("dialog-pane");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK){
            TournamentWriter.removeTournamentFromOngoingOverview(Utilities
                    .shortenAndReplaceUnnecessarySymbolsInString(tournament.getTournamentName()));
            File file = new File(TournamentWriter
                    .getPathToTournamentFileAsString(tournament.getTournamentName()));
            file.delete();
            ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
        }
    }
}