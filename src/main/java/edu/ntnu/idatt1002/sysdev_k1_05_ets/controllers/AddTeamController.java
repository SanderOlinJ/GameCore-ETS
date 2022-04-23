package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.*;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
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
import java.util.*;
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
    @FXML private MenuItem helpButton;
    @FXML private MenuBar menuBar;
    @FXML private Label nrOfTeams;
    @FXML private Button noButton;
    private boolean overWrite;
    private ArrayList<Team> teamsForTournament;


    @FXML
    public void initialize () throws IOException {
        overWrite = false;
        try {
            TournamentWriterRework.updateTournamentFileLocation();
        } catch (IOException exception){
            exception.printStackTrace();
        }

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

        if (tournament.getTeams().size() > 0){
            for (int i = 0; i < tournament.getTeams().size(); i++) {
                Label alreadyRegisteredTeam = new Label(tournament.getTeams().get(i).getNameOfTeam());
                alreadyRegisteredTeam.setPrefWidth(300);
                alreadyRegisteredTeam.setAlignment(Pos.TOP_LEFT);
                enrolledTeamsBox.getChildren().add(alreadyRegisteredTeam);
                teamsForTournament.add(tournament.getTeams().get(i));
            }
            nrOfTeams.setText("" + tournament.getTeams().size());
            setCurrentTeams();
        }
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
        if (teamsForTournament.size() < maxTeams){
            int nrOfRemainingTeams = maxTeams - teamsForTournament.size();
            warningLabel.setText("Not enough teams set, missing: " + nrOfRemainingTeams + " team(s)");
            throw new IOException("Not enough teams set, missing: " + nrOfRemainingTeams + " team(s)");
        }
        Collections.shuffle(teamsForTournament);
        TournamentWriterRework.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        TournamentWriterRework.writeStartMatchesToTournamentFile(tournament.getTournamentName());
        BracketController.setBracketSize(Integer.parseInt(tournament.getNumberOfTeams()));
        BracketController.setNameOfTournament(tournament.getTournamentName());
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
    }
    @FXML
    public void addTeamExisting(String teamName){

        if(isTeamAlreadyEnrolled(teamName)){
            warningLabel.setText(teamName + " is already enrolled for the tournament");
            return;
        }
        if(teamsForTournament.size() >= maxTeams){
            warningLabel.setText("Reached maximum number of teams. \n"
                    + "max teams is set to "+maxTeams+" teams for this tournament");
        }

        else {
            for (Team team : existingTeams) {
                if (team.getNameOfTeam().equals(teamName)) {
                    /*BracketController.getBracket().addTeam(team);
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
    }


    public void addTeam(ActionEvent actionEvent) throws IOException {
        if (teamNameField.getText().strip().equals("")){
            warningLabel.setText("Team name required.");
            throw new IOException("Team name required.");
        }
        if (abbreviationField.getText().strip().equals("")){
            warningLabel.setText("Team name abbreviation required.");
            throw new IOException("Team name abbreviation required.");
        }
        if (playersNameField.getText().isBlank()){
            warningLabel.setText("Team players required.");
            throw new IOException("Team players required.");
        }
        //check if max amount of teams has been exceeded
        if(teamsForTournament.size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
            + "max teams: "+maxTeams);
            throw new IOException("You have reached the maximum number of teams for this tournament. \n"
                    + "max teams: "+maxTeams);
        }

        if(isTeamAlreadyEnrolled(teamNameField.getText())){
            warningLabel.setText(teamNameField.getText() + " is already enrolled for the tournament");
            throw new IOException(teamNameField.getText() + " is already enrolled for the tournament");
        }



        //name of each members on new lines
        String[] players = playersNameField.getText().split("\n");
        List<String> returnList = Arrays.asList(players);
        ArrayList<String> teamMembersList = new ArrayList<>(returnList);

        //Creating team labels
        Team addedTeam = new Team(teamMembersList, teamNameField.getText(),abbreviationField.getText());
        if (!TeamReader.isThisANewTeam(addedTeam)){

            if (TeamReader.wasThereChangesMadeToTeam(addedTeam)){

                if (TeamReader.isThereAlreadyATeamWithSameTeamName(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Already team with same name, want to overwrite?");
                        ifOverWriteMessage();
                        throw new IOException("Already team with same name, want to overwrite?");
                    } else {
                        overWrite = false;
                    }
                }
                else if (TeamReader.isThereAlreadyATeamWithSameTeamNameAbbreviation(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Already team with same name abbreviation, want to overwrite?");
                        ifOverWriteMessage();
                        throw new IOException("Already team with same name abbreviation, want to overwrite?");
                    } else {
                        overWrite = false;
                    }
                }
                else if (TeamReader.isThereAlreadyATeamWithSameTeamMembers(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Already team with same members, want to overwrite?");
                        ifOverWriteMessage();
                        throw new IOException("Already team with same members, want to overwrite?");
                    } else {
                        overWrite = false;
                    }
                }

            }
        }

        Label newTeam = new Label(teamNameField.getText());
        newTeam.setPrefWidth(300);
        newTeam.setAlignment(Pos.TOP_LEFT);
        enrolledTeamsBox.getChildren().add(newTeam);
        nrOfTeams.setText("" + enrolledTeamsBox.getChildren().size());

        //add team to tournament bracket
        teamsForTournament.add(addedTeam);
        /*ArrayList<Team> writeTeamList = new ArrayList<>();
        writeTeamList.add(addedTeam);
        //write teams to team file
        TeamWriter.writeFile(writeTeamList);

         */
        TeamWriter.removeInstanceOfTeam(addedTeam);
        setCurrentTeams();

        //info to user
        warningLabel.setText(addedTeam.getNameOfTeam() + " has been added to your tournament");
        //reset fields after adding
        playersNameField.setText("");
        teamNameField.setText("");
        abbreviationField.setText("");
        teamNameField.setDisable(false);
        abbreviationField.setDisable(false);
        playersNameField.setDisable(false);
    }
    private void ifOverWriteMessage(){
        noButton.setVisible(true);
        noButton.setDisable(false);
        teamNameField.setDisable(true);
        abbreviationField.setDisable(true);
        playersNameField.setDisable(true);
        overWrite = true;
    }
    @FXML
    void onNoButtonClicked(ActionEvent event){
        playersNameField.setText("");
        teamNameField.setText("");
        abbreviationField.setText("");
        warningLabel.setText("");
        noButton.setDisable(true);
        noButton.setVisible(false);
        overWrite = false;
        teamNameField.setDisable(false);
        abbreviationField.setDisable(false);
        playersNameField.setDisable(false);
    }



    public void deleteTeamFromTeams(Label teamLabel){
        boolean found = false;
        for(int i = 0; i < enrolledTeamsBox.getChildren().size(); i++){
           if(enrolledTeamsBox.getChildren().get(i).equals(teamLabel)){
               found = true;
               Label label = (Label) enrolledTeamsBox.getChildren().get(i);
               enrolledTeamsBox.getChildren().remove(i);
               warningLabel.setText(label.getText() + " has been removed from enrolled teams.");
               teamsForTournament.remove(i);
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
    void onHomeButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/main-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/about-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/help-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    private void setNextWindowFromMenuBar(Parent root) throws IOException{
        if (hasAllTeamsBeenAdded()){
            Collections.shuffle(teamsForTournament);
            TournamentWriterRework.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
            TournamentWriterRework.writeStartMatchesToTournamentFile(tournament.getTournamentName());
        }
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
            throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    private boolean hasAllTeamsBeenAdded(){
        return enrolledTeamsBox.getChildren().size() == maxTeams;
    }
}
