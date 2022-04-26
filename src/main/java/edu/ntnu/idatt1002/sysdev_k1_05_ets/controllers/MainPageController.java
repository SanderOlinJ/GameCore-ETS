package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class MainPageController {

    @FXML private VBox ongoingBox1;
    @FXML private ImageView ongoingImageView1;
    @FXML private TextArea ongoingText1;
    @FXML private VBox ongoingBox2;
    @FXML private ImageView ongoingImageView2;
    @FXML private TextArea ongoingText2;
    @FXML private VBox upcomingBox1;
    @FXML private ImageView upcomingImageView1;
    @FXML private TextArea upcomingText1;
    @FXML private VBox upcomingBox2;
    @FXML private ImageView upcomingImageView2;
    @FXML private TextArea upcomingText2;
    @FXML private VBox previousBox1;
    @FXML private ImageView previousImageView1;
    @FXML private TextArea previousText1;
    @FXML private VBox previousBox2;
    @FXML private ImageView previousImageView2;
    @FXML private TextArea previousText2;
    @FXML private Text warningText1;
    @FXML private Text warningText2;
    @FXML private Text warningText3;
    @FXML private Text warningText4;
    @FXML private Text warningText5;
    @FXML private Text warningText6;

    private ArrayList<Tournament> ongoingTournaments;
    private ArrayList<Tournament> upcomingTournaments;
    private ArrayList<Tournament> previousTournaments;

    @FXML
    public void initialize()
    throws IOException {
        TournamentWriter.updateTournamentFileLocation();
        ongoingTournaments = new ArrayList<>();
        upcomingTournaments = new ArrayList<>();
        previousTournaments = new ArrayList<>();
        showOngoingTournaments();
        showUpcomingTournaments();
        showPreviousTournaments();
    }

    @FXML
    private void showOngoingTournaments()
    throws IOException{
        try {
            ongoingTournaments = TournamentReader.readAllOngoingTournamentsToList(2);
            setMainPageWithTournaments(ongoingTournaments, ongoingImageView1, ongoingText1, ongoingBox1,
                    ongoingImageView2, ongoingText2, ongoingBox2, warningText1, warningText2);
        } catch (IOException exception){
            throw new IOException(exception.getMessage());
        }
    }

    @FXML
    private void showUpcomingTournaments()
    throws IOException{
        try {
            upcomingTournaments = TournamentReader.readAllUpcomingTournamentsToList(2);
            setMainPageWithTournaments(upcomingTournaments, upcomingImageView1, upcomingText1, upcomingBox1,
                    upcomingImageView2, upcomingText2, upcomingBox2, warningText3, warningText4);
        } catch (IOException exception){
            throw new IOException("Could not show upcoming tournaments: " + exception.getMessage());
        }
    }

    @FXML
    private void showPreviousTournaments()
    throws IOException{
        try {
            previousTournaments = TournamentReader.readAllPreviousTournamentsToList(2);
            setMainPageWithTournaments(previousTournaments, previousImageView1, previousText1, previousBox1,
                    previousImageView2, previousText2, previousBox2, warningText5, warningText6);
        } catch (IOException exception){
            throw new IOException("Could not show upcoming tournaments: " + exception.getMessage());
        }
    }

    private void setMainPageWithTournaments(ArrayList<Tournament> tournaments, ImageView imageView1,
                                            TextArea text1, VBox vBox1, ImageView imageView2,
                                            TextArea text2, VBox vBox2, Text warningText1, Text warningText2) {
        if (tournaments.size() > 0){
            imageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "Images/gameImages/"+ Utilities.shortenAndReplaceUnnecessarySymbolsInString
                    (tournaments.get(0).getGame()) + ".png"));
            text1.setText(tournaments.get(0).getTournamentName());
            vBox1.setVisible(true);
            vBox1.setDisable(false);
            if (tournaments.get(0).getTeams().size() < tournaments.get(0).getNumberOfTeams()){
                warningText1.setVisible(true);
                imageView1.setOpacity(0.2);
            }

            if (tournaments.size() > 1){

                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                        "sysdev_k1_05_ets/Images/gameImages/"+
                        Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(1).getGame()) + ".png"));
                text2.setText(tournaments.get(1).getTournamentName());
                vBox2.setVisible(true);
                vBox2.setDisable(false);
                if (tournaments.get(1).getTeams().size() < tournaments.get(1).getNumberOfTeams()){
                    warningText2.setVisible(true);
                    imageView2.setOpacity(0.2);
                }
            }
        }
    }

    @FXML
    void onCreateNewTournamentButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.CREATE_NEW_TOURNAMENT);
    }

    @FXML
    void onHomeButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.MAIN);
    }

    @FXML
    void onHelpButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.HELP);
    }

    @FXML
    void onAboutButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.ABOUT);
    }

    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }


    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    @FXML
    void onViewMoreOngoingPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    @FXML
    void onViewMoreUpcomingPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML
    void onViewMorePreviousPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    @FXML
    void onOngoingBox1Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(ongoingTournaments.get(0));
    }

    @FXML
    void onOngoingBox2Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(ongoingTournaments.get(1));
    }

    @FXML
    void onUpcomingBox1Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(upcomingTournaments.get(0));
    }

    @FXML
    void onUpcomingBox2Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(upcomingTournaments.get(1));
    }

    @FXML
    void onPreviousBox1Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(previousTournaments.get(0));
    }

    @FXML
    void onPreviousBox2Clicked()
    throws IOException{
        Utilities.onTournamentOverviewButtonClicked(previousTournaments.get(1));
    }


}
