package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentReaderRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainPageController {

    @FXML private MenuBar menuBar;
    @FXML private Button createNewTournamentButton;
    @FXML private Button viewMoreOngoing;
    @FXML private Button viewMoreUpcoming;
    @FXML private Button viewMorePrevious;
    @FXML Stage stage;
    @FXML BorderPane startScreenPane;

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

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

    private ArrayList<NewTournament> ongoingTournaments;
    private ArrayList<NewTournament> upcomingTournaments;
    private ArrayList<NewTournament> previousTournaments;

    @FXML
    public void initialize() throws IOException {
        TournamentWriterRework.updateTournamentFileLocation();
        ongoingTournaments = new ArrayList<>();
        upcomingTournaments = new ArrayList<>();
        previousTournaments = new ArrayList<>();
        showOngoingTournaments();
        showUpcomingTournaments();
        showPreviousTournaments();

        ongoingBox1.setOnMouseClicked(mouseEvent -> onOngoingTournamentOneClicked());

    }

    @FXML
    private void onOngoingTournamentOneClicked(){
        System.out.println("Yo");

    }

    @FXML
    private void showOngoingTournaments()
    throws IOException{
        try {
            ongoingTournaments = TournamentReaderRework.readAllOngoingTournamentsToList(2);
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
            upcomingTournaments = TournamentReaderRework.readAllUpcomingTournamentsToList(2);
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
            previousTournaments = TournamentReaderRework.readAllPreviousTournamentsToList(2);
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
            vBox1.setDisable(false);

            if (tournaments.size() > 1){

                imageView2.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/" +
                        "sysdev_k1_05_ets/Images/gameImages/"+
                        Utilities.shortenAndReplaceUnnecessarySymbolsInString
                                (tournaments.get(1).getGame()) + ".png"));
                text2.setText(tournaments.get(1).getTournamentName());
                vBox2.setVisible(true);
                vBox2.setDisable(false);
            }
        }
    }

    @FXML
    void onCreateNewTournamentButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/create-new-tournament-page.fxml")));
        setNextWindow(event, root);
    }

    private void setNextWindow(ActionEvent event, Parent root) {
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
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/help-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/about-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    private void setNextWindowFromMenuBar(Parent root) {
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
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event)
    throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onViewMoreOngoingPressed(ActionEvent event)
    throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        setNextWindow(event, root);
    }

    @FXML
    void onViewMoreUpcomingPressed(ActionEvent event)
    throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/upcoming-overview.fxml")));
        setNextWindow(event, root);
    }

    @FXML
    void onViewMorePreviousPressed(ActionEvent event)
    throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        setNextWindow(event, root);
    }

    @FXML
    void onOngoingBox1Clicked(MouseEvent event){}

    @FXML
    void onOngoingBox2Clicked(MouseEvent event){}

    @FXML
    void onUpcomingBox1Clicked(MouseEvent event){}

    @FXML
    void onUpcomingBox2Clicked(MouseEvent event){}

    @FXML
    void onPreviousBox1Clicked(MouseEvent event){}

    @FXML
    void onPreviousBox2Clicked(MouseEvent event){}

}
