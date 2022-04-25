package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class UpcomingTournamentsOverviewController {

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
    @FXML private Text startDate1;
    @FXML private Text startDate2;
    @FXML private Text startDate3;
    @FXML private Text startDate4;
    @FXML private Text startDate5;
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
    @FXML private Text vs1;
    @FXML private Text vs2;
    @FXML private Text vs3;
    @FXML private Text vs4;
    @FXML private Text vs5;
    @FXML private Button overviewButton1;
    @FXML private Button overviewButton2;
    @FXML private Button overviewButton3;
    @FXML private Button overviewButton4;
    @FXML private Button overviewButton5;

    private ArrayList<NewTournament> tournaments;

    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        tournaments = TournamentReaderRework.readAllUpcomingTournamentsToList(0);
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
            startDate1.setText(tournaments.get(0).getDate().toString());
            if (tournaments.get(0).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                String team11Name = tournaments.get(0).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                String team12Name = tournaments.get(0).findNextMatchToBePlayed().getTeam2().getNameAbbr();

                String match1Time = tournaments.get(0).findNextMatchToBePlayed().getTimeOfMatch().toString();
                team11.setText(team11Name);
                team12.setText(team12Name);
                time1.setText(match1Time);
            }else {
                vs1.setText("No matches set");
            }
            if (tournaments.get(0).getTeams().size() < tournaments.get(0).getNumberOfTeams()){
                overviewButton1.setText("Add teams");
            }
            box1.setDisable(false);
            box1.setVisible(true);

            if (tournaments.size() > 1) {
                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                        (tournaments.get(1).getGame()) + ".png"));
                name2.setText(tournaments.get(1).getTournamentName());
                game2.setText(tournaments.get(1).getGame());
                totalTeams2.setText(String.valueOf(tournaments.get(1).getNumberOfTeams()));
                startDate2.setText(tournaments.get(1).getDate().toString());
                if (tournaments.get(1).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                    String team21Name = tournaments.get(1).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                    String team22Name = tournaments.get(1).findNextMatchToBePlayed().getTeam2().getNameAbbr();
                    String match2Time = tournaments.get(1).findNextMatchToBePlayed().getTimeOfMatch().toString();
                    team21.setText(team21Name);
                    team22.setText(team22Name);
                    time2.setText(match2Time);
                } else {
                    vs2.setText("No matches set");
                }
                if (tournaments.get(1).getTeams().size() < tournaments.get(1).getNumberOfTeams()){
                    overviewButton2.setText("Add teams");
                }
                box2.setDisable(false);
                box2.setVisible(true);

                if (tournaments.size() > 2) {
                    imageView3.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                            "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                            (tournaments.get(2).getGame()) + ".png"));
                    name3.setText(tournaments.get(2).getTournamentName());
                    game3.setText(tournaments.get(2).getGame());
                    totalTeams3.setText(String.valueOf(tournaments.get(2).getNumberOfTeams()));
                    startDate3.setText(tournaments.get(2).getDate().toString());
                    if (tournaments.get(2).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                        String team31Name = tournaments.get(2).findNextMatchToBePlayed().getTeam1().getNameAbbr();
                        String team32Name = tournaments.get(2).findNextMatchToBePlayed().getTeam2().getNameAbbr();
                        String match3Time = tournaments.get(2).findNextMatchToBePlayed().getTimeOfMatch().toString();
                        team31.setText(team31Name);
                        team32.setText(team32Name);
                        time3.setText(match3Time);
                    } else {
                        vs3.setText("No matches set");
                    }
                    if (tournaments.get(2).getTeams().size() < tournaments.get(2).getNumberOfTeams()){
                        overviewButton3.setText("Add teams");
                    }
                    box3.setDisable(false);
                    box3.setVisible(true);

                    if (tournaments.size() > 3) {
                        imageView4.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(3).getGame()) + ".png"));
                        name4.setText(tournaments.get(3).getTournamentName());
                        game4.setText(tournaments.get(3).getGame());
                        totalTeams4.setText(String.valueOf(tournaments.get(3).getNumberOfTeams()));
                        startDate4.setText(tournaments.get(3).getDate().toString());
                        if (tournaments.get(3).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                            String team41Name = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTeam1().getNameAbbr();
                            String team42Name = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTeam2().getNameAbbr();
                            String match4Time = tournaments.get(3).findNextMatchToBePlayed()
                                    .getTimeOfMatch().toString();
                            team41.setText(team41Name);
                            team42.setText(team42Name);
                            time4.setText(match4Time);
                        } else {
                            vs4.setText("No matches set");
                        }
                        if (tournaments.get(3).getTeams().size() < tournaments.get(3).getNumberOfTeams()){
                            overviewButton4.setText("Add teams");
                        }
                        box4.setDisable(false);
                        box4.setVisible(true);

                        if (tournaments.size() > 4) {
                            imageView5.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                    "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                    (tournaments.get(4).getGame()) + ".png"));
                            name5.setText(tournaments.get(4).getTournamentName());
                            game5.setText(tournaments.get(4).getGame());
                            totalTeams5.setText(String.valueOf(tournaments.get(4).getNumberOfTeams()));
                            startDate5.setText(tournaments.get(4).getDate().toString());
                            if (tournaments.get(4).doesTournamentHaveAnUnfinishedAndSetMatch()) {
                                String team51Name = tournaments.get(4).findNextMatchToBePlayed().getTeam1()
                                        .getNameAbbr();
                                String team52Name = tournaments.get(4).findNextMatchToBePlayed().getTeam2()
                                        .getNameAbbr();
                                String match5Time = tournaments.get(4).findNextMatchToBePlayed().getTimeOfMatch()
                                        .toString();
                                team51.setText(team51Name);
                                team52.setText(team52Name);
                                time5.setText(match5Time);
                            } else {
                                vs5.setText("No matches set");
                            }
                            if (tournaments.get(4).getTeams().size() < tournaments.get(4).getNumberOfTeams()){
                                overviewButton5.setText("Add teams");
                            }
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

    @FXML void onPreviousTournamentsButtonClicked()
            throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
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
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(0));
    }
    @FXML void onOverviewButton2Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(1));
    }
    @FXML void onOverviewButton3Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(2));
    }
    @FXML void onOverviewButton4Clicked()
            throws IOException{
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(3));
    }
    @FXML void onOverviewButton5Clicked()
            throws IOException {
        Utilities.onTournamentOverviewButtonClicked(tournaments.get(4));
    }
}