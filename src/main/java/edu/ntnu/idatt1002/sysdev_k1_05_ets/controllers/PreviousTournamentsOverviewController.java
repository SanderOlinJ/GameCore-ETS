package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class PreviousTournamentsOverviewController {

    @FXML private HBox box1;
    @FXML private HBox box2;
    @FXML private HBox box3;
    @FXML private HBox box4;
    @FXML private HBox box5;
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
    @FXML private Text date1;
    @FXML private Text date2;
    @FXML private Text date3;
    @FXML private Text date4;
    @FXML private Text date5;
    @FXML private Text totalTeams1;
    @FXML private Text totalTeams2;
    @FXML private Text totalTeams3;
    @FXML private Text totalTeams4;
    @FXML private Text totalTeams5;
    @FXML private Text firstPlace1;
    @FXML private Text firstPlace2;
    @FXML private Text firstPlace3;
    @FXML private Text firstPlace4;
    @FXML private Text firstPlace5;
    @FXML private Text secondPlace1;
    @FXML private Text secondPlace2;
    @FXML private Text secondPlace3;
    @FXML private Text secondPlace4;
    @FXML private Text secondPlace5;

    private ArrayList<NewTournament> tournaments;

    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        tournaments = TournamentReaderRework.readAllPreviousTournamentsToList(0);
        setMainPageWithTournaments();

    }

    private void setMainPageWithTournaments() {

        if (tournaments.size() > 0) {
            imageView1.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                    (tournaments.get(0).getGame()) + ".png"));
            name1.setText(tournaments.get(0).getTournamentName());
            game1.setText(tournaments.get(0).getGame());
            totalTeams1.setText(String.valueOf(tournaments.get(0).getNumberOfTeams()));
            date1.setText(tournaments.get(0).getDate().toString());
            firstPlace1.setText(tournaments.get(0).getFirstPlace().getNameAbbr());
            secondPlace1.setText(tournaments.get(0).getSecondPlace().getNameAbbr());
            box1.setDisable(false);
            box1.setVisible(true);

            if (tournaments.size() > 1) {
                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                        (tournaments.get(1).getGame()) + ".png"));
                name2.setText(tournaments.get(1).getTournamentName());
                game2.setText(tournaments.get(1).getGame());
                totalTeams2.setText(String.valueOf(tournaments.get(1).getNumberOfTeams()));
                date2.setText(tournaments.get(1).getDate().toString());
                firstPlace2.setText(tournaments.get(1).getFirstPlace().getNameAbbr());
                secondPlace2.setText(tournaments.get(1).getSecondPlace().getNameAbbr());
                box2.setDisable(false);
                box2.setVisible(true);

                if (tournaments.size() > 2) {
                    imageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                            "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                            (tournaments.get(2).getGame()) + ".png"));
                    name3.setText(tournaments.get(2).getTournamentName());
                    game3.setText(tournaments.get(2).getGame());
                    totalTeams3.setText(String.valueOf(tournaments.get(2).getNumberOfTeams()));
                    date3.setText(tournaments.get(2).getDate().toString());
                    firstPlace3.setText(tournaments.get(2).getFirstPlace().getNameAbbr());
                    secondPlace3.setText(tournaments.get(2).getSecondPlace().getNameAbbr());
                    box3.setDisable(false);
                    box3.setVisible(true);

                    if (tournaments.size() > 3) {
                        imageView4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(3).getGame()) + ".png"));
                        name4.setText(tournaments.get(3).getTournamentName());
                        game4.setText(tournaments.get(3).getGame());
                        totalTeams4.setText(String.valueOf(tournaments.get(3).getNumberOfTeams()));
                        date4.setText(tournaments.get(3).getDate().toString());
                        firstPlace4.setText(tournaments.get(3).getFirstPlace().getNameAbbr());
                        secondPlace4.setText(tournaments.get(3).getSecondPlace().getNameAbbr());
                        box4.setDisable(false);
                        box4.setVisible(true);

                        if (tournaments.size() > 4) {
                            imageView5.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                    "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                    (tournaments.get(4).getGame()) + ".png"));
                            name5.setText(tournaments.get(4).getTournamentName());
                            game5.setText(tournaments.get(4).getGame());
                            totalTeams5.setText(String.valueOf(tournaments.get(4).getNumberOfTeams()));
                            date5.setText(tournaments.get(4).getDate().toString());
                            firstPlace5.setText(tournaments.get(4).getFirstPlace().getNameAbbr());
                            secondPlace5.setText(tournaments.get(4).getSecondPlace().getNameOfTeam());
                            box5.setDisable(false);
                            box5.setVisible(true);

                        }

                    }
                }

            }
        }
    }


    @FXML void onCreateNewTournamentButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.CREATE_NEW_TOURNAMENT);
    }

    @FXML void onHomeButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.MAIN);
    }

    @FXML void onOngoingTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    @FXML void onUpcomingTournamentsButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    @FXML void onAboutButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.ABOUT);
    }

    @FXML void onHelpButtonClicked()
    throws IOException{
        ViewSwitcher.switchTo(View.HELP);
    }

    @FXML void onOverviewButton1Clicked()
    throws IOException{
        BracketController.setNameOfTournament(tournaments.get(0).getTournamentName());
        int numberOfTeams = tournaments.get(0).getNumberOfTeams();
        switch (numberOfTeams){
            case 4 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
            case 8 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
            case 16 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }
    @FXML void onOverviewButton2Clicked()
    throws IOException{
        BracketController.setNameOfTournament(tournaments.get(1).getTournamentName());
        int numberOfTeams = tournaments.get(1).getNumberOfTeams();
        switch (numberOfTeams){
            case 4 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
            case 8 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
            case 16 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }
    @FXML void onOverviewButton3Clicked()
    throws IOException{
        BracketController.setNameOfTournament(tournaments.get(2).getTournamentName());
        int numberOfTeams = tournaments.get(2).getNumberOfTeams();
        switch (numberOfTeams){
            case 4 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
            case 8 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
            case 16 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }
    @FXML void onOverviewButton4Clicked()
    throws IOException{
        BracketController.setNameOfTournament(tournaments.get(3).getTournamentName());
        int numberOfTeams = tournaments.get(3).getNumberOfTeams();
        switch (numberOfTeams){
            case 4 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
            case 8 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
            case 16 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }
    @FXML void onOverviewButton5Clicked()
    throws IOException{
        BracketController.setNameOfTournament(tournaments.get(4).getTournamentName());
        int numberOfTeams = tournaments.get(4).getNumberOfTeams();
        switch (numberOfTeams){
            case 4 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);
            case 8 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);
            case 16 -> ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);
        }
    }
}
