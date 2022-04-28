package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
 * Controller class for the Previous tournament Overview page
 */

public class PreviousTournamentsOverviewController {

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
    @FXML private Text date;
    @FXML private Text date1;
    @FXML private Text date2;
    @FXML private Text date3;
    @FXML private Text date4;
    @FXML private Text totalTeams;
    @FXML private Text totalTeams1;
    @FXML private Text totalTeams2;
    @FXML private Text totalTeams3;
    @FXML private Text totalTeams4;
    @FXML private Text firstPlace;
    @FXML private Text firstPlace1;
    @FXML private Text firstPlace2;
    @FXML private Text firstPlace3;
    @FXML private Text firstPlace4;
    @FXML private Text secondPlace;
    @FXML private Text secondPlace1;
    @FXML private Text secondPlace2;
    @FXML private Text secondPlace3;
    @FXML private Text secondPlace4;
    @FXML private ImageView deleteIcon;
    @FXML private ImageView deleteIcon1;
    @FXML private ImageView deleteIcon2;
    @FXML private ImageView deleteIcon3;
    @FXML private ImageView deleteIcon4;

    private ArrayList<Tournament> tournaments;

    /**
     Method initializes the page with content.
     * @throws IOException if tournaments could not be read.
     */
    @FXML
    public void initialize() throws IOException {
        //Sets the page with upcoming tournaments
        tournaments = TournamentReader.readAllPreviousTournamentsToList(0);
        setMainPageWithTournaments();
    }

    /**
     Method parses through the previous tournaments and displays them on screen
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
            date.setText(tournaments.get(0).getDate().toString());
            firstPlace.setText(tournaments.get(0).getFirstPlace().getNameAbbr());
            secondPlace.setText(tournaments.get(0).getSecondPlace().getNameAbbr());
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
                date1.setText(tournaments.get(1).getDate().toString());
                firstPlace1.setText(tournaments.get(1).getFirstPlace().getNameAbbr());
                secondPlace1.setText(tournaments.get(1).getSecondPlace().getNameAbbr());
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
                    date2.setText(tournaments.get(2).getDate().toString());
                    firstPlace2.setText(tournaments.get(2).getFirstPlace().getNameAbbr());
                    secondPlace2.setText(tournaments.get(2).getSecondPlace().getNameAbbr());
                    deleteIcon2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                            "sysdev_k1_05_ets/images/delete_icon.png"));
                    box2.setDisable(false);
                    box2.setVisible(true);

                    if (tournaments.size() > 3) {
                        imageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(3).getGame()) + ".png"));
                        name3.setText(tournaments.get(3).getTournamentName());
                        game3.setText(tournaments.get(3).getGame());
                        totalTeams3.setText(String.valueOf(tournaments.get(3).getNumberOfTeams()));
                        date3.setText(tournaments.get(3).getDate().toString());
                        firstPlace3.setText(tournaments.get(3).getFirstPlace().getNameAbbr());
                        secondPlace3.setText(tournaments.get(3).getSecondPlace().getNameAbbr());
                        deleteIcon3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                                "sysdev_k1_05_ets/images/delete_icon.png"));
                        box3.setDisable(false);
                        box3.setVisible(true);

                        if (tournaments.size() > 4) {
                            imageView4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                    "images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                    (tournaments.get(4).getGame()) + ".png"));
                            name4.setText(tournaments.get(4).getTournamentName());
                            game4.setText(tournaments.get(4).getGame());
                            totalTeams4.setText(String.valueOf(tournaments.get(4).getNumberOfTeams()));
                            date4.setText(tournaments.get(4).getDate().toString());
                            firstPlace4.setText(tournaments.get(4).getFirstPlace().getNameAbbr());
                            secondPlace4.setText(tournaments.get(4).getSecondPlace().getNameOfTeam());
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
     Used for redirecting current page to the create new tournament page
     * @throws IOException if scenes could not be switched
     */
    @FXML void onCreateNewTournamentButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.CREATE_NEW_TOURNAMENT);
    }

    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML void onHomeButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to ongoing tournaments page when clicked on ongoing tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOngoingTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML void onUpcomingTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML void onAboutButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML void onHelpButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.HELP);
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
     Used for redirecting current page to the overview page the first tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton1Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(1));
    }

    /**
     Used for redirecting current page to the overview page the first tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton2Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(2));
    }

    /**
     Used for redirecting current page to the overview page the first tournament in the list
     * @throws IOException if scenes could not be switched
     */
    @FXML void onOverviewButton3Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(3));
    }

    /**
     Used for redirecting current page to the overview page the first tournament in the list
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
     * @throws IOException if tournament could not be removed from previous overview,
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
            TournamentWriter.removeTournamentFromPreviousOverview(Utilities
                    .shortenAndReplaceUnnecessarySymbolsInString(tournament.getTournamentName()));
            File file = new File(TournamentWriter
                    .getPathToTournamentFileAsString(tournament.getTournamentName()));
            file.delete();
            ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
        }
    }
}
