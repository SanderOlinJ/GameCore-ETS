package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.*;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddTeamController {

    private Scene scene;
    private Stage stage;
    private ArrayList<Team> existingTeams;
    private Pane p = new Pane();
    private Pane pC = new Pane();
    private VBox scrollPaneTeam = new VBox();
    private static NewTournament tournament;

    private static int maxTeams;

    @FXML private TextField teamNameField;
    @FXML private TextArea playersNameField;
    @FXML private Label warningLabel;
    @FXML private ScrollPane scrollPane;
    @FXML private ScrollPane currentTeams;
    @FXML private VBox existingTeamsBox;
    @FXML private VBox enrolledTeamsBox;
    @FXML private TextField abbreviationField;
    @FXML private TextField searchTeams;
    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private Label nrOfTeams;

    private ArrayList<Team> teamsForTournament;


    @FXML
    public void initialize () throws IOException {
        //setting search box for teams selection

        ArrayList<Team> searchTeamNames = TeamReader.readTeamsFromAllTeamsFile();
        TextFields.bindAutoCompletion(searchTeams,
                searchTeamNames.stream().map(Team::getNameOfTeam).collect(Collectors.toList()));

        //loop through the existing teams and set their style and add them to vbox in scroll pane
        existingTeams = new ArrayList<>(TeamReader.readTeamsFromAllTeamsFile());

        for (int i = 0; i < existingTeams.size(); i++){
            Label teamLabel = new Label();
            teamLabel.setPrefWidth(200);
            teamLabel.setText(existingTeams.get(i).getNameOfTeam());
            existingTeamsBox.getChildren().add(teamLabel);
            existingTeamsBox.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> addTeamExisting(teamLabel.getText()));
            existingTeamsBox.getChildren().get(i).setStyle("-fx-text-fill : white; -fx-font-size: 15pt");
        }
        teamsForTournament = new ArrayList<>();
        existingTeamsBox.setAlignment(Pos.CENTER);
        scrollPane.setContent(existingTeamsBox);
    }


    @FXML
    public void setMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/start-screen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        String link = "";
        if (maxTeams <= 4) {
            link = "scenes/overview-scene-four.fxml";
        } else if (maxTeams <= 8) {
            link = "scenes/overview-scene-eight.fxml";
        } else if (maxTeams <= 16) {
            link = "scenes/overview-scene-sixteen.fxml";
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(link)));

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        TournamentWriterRework.writeTeamsToTournamentFile(Utilities
                .shortenAndReplaceUnnecessarySymbolsInString(tournament.getTournamentName()),getTeamsForTournament());
    }
    @FXML
    public void addTeamExisting(String teamName){
        boolean teamIsAlreadyEnrolled = isTeamAlreadyEnrolled(teamName);
        if(teamIsAlreadyEnrolled){
            warningLabel.setText(teamName + " is already enrolled for the tournament");
            return;
        }
        if(BracketController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("Reached maximum number of teams. \n"
                    + "max teams is set to "+maxTeams+" teams for this tournament");
        }



        else {
            for (Team team : existingTeams) {
                if (team.getNameOfTeam().equals(teamName)) {
                    /**BracketController.getBracket().addTeam(team);
                    Label newTeam = new Label(teamName);
                    newTeam.setPrefWidth(300);
                    newTeam.setAlignment(Pos.TOP_LEFT);
                    enrolledTeamsBox.getChildren().add(newTeam);
                    teamsForTournament.add(team);
                    nrOfTeams.setText("" + teamsForTournament.size());*/
                    teamNameField.setText(team.getNameOfTeam());
                    abbreviationField.setText(team.getNameAbbr());
                    playersNameField.setText("");
                    //showing team members in textarea
                    teamMembersToLines(team);

                }
            }

            setCurrentTeams();
        }
    }

    public void teamMembersToLines(Team team) {
        for (int i = 0; i < team.getMembers().size(); i++) {
            if (i == team.getMembers().size() - 1) {
                playersNameField.appendText(team.getMembers().get(i));
                return;
            }
            playersNameField.appendText(team.getMembers().get(i) + "\n");
        }
        return;
    }


    public void addTeam(ActionEvent actionEvent) throws IOException {
        if (teamNameField.getText().strip().equals("")){
            warningLabel.setText("Invalid team name.");
        }
        //check if max amount of teams has been exceeded
        if(BracketController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
            + "max teams: "+maxTeams);
        }

        boolean teamIsAlreadyEnrolled = isTeamAlreadyEnrolled(teamNameField.getText());
        if(teamIsAlreadyEnrolled){
            warningLabel.setText(teamNameField.getText() + " is already enrolled for the tournament");
        }

        // TODO: 19.04.2022: if a team was "selected" from registry and edited, remove previous instance of the team for the all_Teams.csv, and replace with new version
        else {
            warningLabel.setText("");
            if (playersNameField.getText().isBlank()){
                BracketController.getBracket().addTeam(new Team(teamNameField.getText()));
                teamNameField.setText("");
                Label newTeam = new Label(teamNameField.getText());
                enrolledTeamsBox.getChildren().add(newTeam);
            }
            else {
                //name of each members on new lines
                String[] players = playersNameField.getText().split("\n");
                List<String> returnList = Arrays.asList(players);
                ArrayList<String> teamMembersList = new ArrayList<>(returnList);

                //Creating team labels
                Team addedTeam = new Team(teamMembersList, teamNameField.getText(),abbreviationField.getText());
                this.teamsForTournament.add(addedTeam);
                Label newTeam = new Label(teamNameField.getText());
                newTeam.setPrefWidth(300);
                newTeam.setAlignment(Pos.TOP_LEFT);
                enrolledTeamsBox.getChildren().add(newTeam);
                nrOfTeams.setText("" + enrolledTeamsBox.getChildren().size());

                //add team to tournament bracket
                BracketController.getBracket().addTeam(addedTeam);
                ArrayList<Team> writeTeamList = new ArrayList<>();
                writeTeamList.add(addedTeam);
                //write teams to team file
                TeamWriter.writeFile(writeTeamList,"all_Teams");
                setCurrentTeams();

                //info to user
                warningLabel.setText(addedTeam.getNameOfTeam() + " has been added to your tournament");
                //reset fields after adding
                playersNameField.setText("");
                teamNameField.setText("");
                abbreviationField.setText("");
            }
        }
    }


    //it does not remove team from the list displaying the teams
    public void deleteTeam() {
        String teamName = teamNameField.getText();
        for (Team team : existingTeams) {
            if (team.getNameOfTeam().equals(teamName)) {
                teamsForTournament.remove(team);
                BracketController.getBracket().removeTeam(team);
                pC.getChildren().remove(team);

                teamsForTournament.remove(team);
                nrOfTeams.setText("" + teamsForTournament.size());
                setCurrentTeams();
                playersNameField.setText("");
                teamNameField.setText("");
                abbreviationField.setText("");
            }
        }
        warningLabel.setText(teamName + " has been removed from your tournament");
        setCurrentTeams();
    }


   public void deleteTeamFromTeams(Label teamLabel){
        boolean found = false;
       for(int i = 0; i < enrolledTeamsBox.getChildren().size(); i++){
           if(enrolledTeamsBox.getChildren().get(i).equals(teamLabel)){
               found = true;
               Label label = (Label) enrolledTeamsBox.getChildren().get(i);
               enrolledTeamsBox.getChildren().remove(i);
               warningLabel.setText(label.getText() + " has been removed from enrolled teams.");
               BracketController.getBracket().removeTeam(teamLabel.getText());
           }
           if(found){
               nrOfTeams.setText(String.valueOf(enrolledTeamsBox.getChildren().size()));
           }
       }

   }

    public void setCurrentTeams(){
        /*Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);
         */

        for (int i = 0; i < enrolledTeamsBox.getChildren().size(); i++) {
            Label teamLabel;
            teamLabel = (Label) enrolledTeamsBox.getChildren().get(i);
            enrolledTeamsBox.getChildren().get(i).setStyle("-fx-text-fill : white; -fx-font-size: 15pt");
            Label finalTeamLabel = teamLabel;
            enrolledTeamsBox.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> deleteTeamFromTeams(finalTeamLabel));
            //enrolledTeamsBox.getChildren().add(separator);
        }
        //styling of vbox for current teams
        enrolledTeamsBox.setAlignment(Pos.TOP_CENTER);
        enrolledTeamsBox.setPrefWidth(339);
    }

    public void onSearchTeamSelect(ActionEvent event) {
        String teamName = searchTeams.getText();
        Team selectedTeam = existingTeams.stream().filter(t -> t.getNameOfTeam().equals(teamName))
                .collect(Collectors.toList()).get(0);
        if (existingTeams.isEmpty()) return;

        teamNameField.setText(teamName);
        abbreviationField.setText(selectedTeam.getNameAbbr());

        teamMembersToLines(selectedTeam);
    }

    /**
     * checks if team is in the enrolled teams box
     * @param teamName
     * @return true/false, enrolled/not enrolled
     */
    public boolean isTeamAlreadyEnrolled(String teamName){
        for (int i = 0; i < enrolledTeamsBox.getChildren().size(); i++) {
            Label teamLabel = (Label) enrolledTeamsBox.getChildren().get(i);
            if(teamLabel.getText().equals(teamName)){
                return true;
            }
        }
        return false;
    }
    public static void setMaxTeams(int maxNrOfTeams) {
        maxTeams = maxNrOfTeams;
    }
    public ArrayList<Team> getTeamsForTournament(){
        return teamsForTournament;
    }
    public static void setTournament(NewTournament newTournament) {
        tournament = newTournament;
    }
    public static int getMaxTeams(){return maxTeams;}

    @FXML
    void onHomeButtonPressed(){}

    @FXML
    void onOngoingTournamentsButtonPressed(){}

    @FXML
    void onUpcomingTournamentsButtonPressed(){}

    @FXML
    void onPreviousTournamentsButtonPressed(){}

    @FXML
    void onAboutButtonPressed(){}
}
