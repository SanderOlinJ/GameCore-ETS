package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.*;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.controlsfx.control.textfield.TextFields;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A controller class for adding and modifying teams page.
 */
public class AddTeamController {

    private ArrayList<Team> existingTeams;
    private static Tournament tournament;
    private static String nameOfTournament;
    private static int maxTeams;
    private ArrayList<Team> teamsForTournament;

    @FXML private TextField teamNameField;
    @FXML private TextArea playersNameField;
    @FXML private Label warningLabel;
    @FXML private ScrollPane scrollPane;
    @FXML private VBox existingTeamsBox;
    @FXML private VBox enrolledTeamsBox;
    @FXML private TextField abbreviationField;
    @FXML private TextField searchTeams;
    @FXML private Label nrOfTeams;
    @FXML private Button noButton;
    @FXML private Button continueButton1;
    private boolean overWrite;

    /**
     * Used for initializing front-end values on add teams page, mainly loading existing teams from files for display
     * @throws IOException Thrown if something goes wrong when reading all_teams.csv file
     */
    @FXML
    public void initialize () throws IOException {
        overWrite = false;
        try {
            TournamentWriter.updateTournamentFileLocation();
        } catch (IOException exception){
            exception.printStackTrace();
        }
        try {
            tournament = TournamentReader.readTournamentFromFile(nameOfTournament);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        maxTeams = tournament.getNumberOfTeams();
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

    /**
     * Responsible for changing to next scene
     * Sets the scene to bracket scene if clicked on the continue button from add teams page
     * Checks total number of teams combobox field and redirects to a bracket page of the same size accordingly
     * @throws IOException if not enough teams are set, if teams or matches could not be written to file
     * or if scenes could not be switcehd.
     */
    @FXML
    public void setBracketScene() throws IOException {
        if (teamsForTournament.size() < maxTeams){
            int nrOfRemainingTeams = maxTeams - teamsForTournament.size();
            warningLabel.setText("Not enough teams set, missing: " + nrOfRemainingTeams + " team(s)");
            throw new IOException("Not enough teams set, missing: " + nrOfRemainingTeams + " team(s)");
        }
        Collections.shuffle(teamsForTournament);
        BracketController.setNameOfTournament(tournament.getTournamentName());
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        TournamentWriter.writeMatchesToTournament(tournament.getTournamentName(), null);

        if (tournament.getNumberOfTeams() == 4){
            ViewSwitcher.switchTo(View.BRACKET_4);
        } else if (tournament.getNumberOfTeams() == 8){
            ViewSwitcher.switchTo(View.BRACKET_8);
        } else if (tournament.getNumberOfTeams() == 16){
            ViewSwitcher.switchTo(View.BRACKET_16);
        }
    }

    /**
     * A method that gets called if an already existing team is selected for enrollment.
     * It is also responsible for controlling how many teams are added and that teams added do not exceed the maximum
     * amount of teams allowed for the given tournament
     * Also makes sure that an already enrolled team for the tournament cannot be added more than once
     * Initiates the process of displaying the newly added team to the stack of enrolled teams if it qualifies the
     * aforementioned restrictions
     * @param teamName name of team
     */
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

    /**
     * Displays the team members of a chosen team on the team members on each line text field box displayed in add teams
     * page
     * @param team  a team that ideally consists of members, team name, and team name abbreviation
     */
    public void teamMembersToLines(Team team) {
        for (int i = 0; i < team.getMembers().size(); i++) {
            if (i == team.getMembers().size() - 1) {
                playersNameField.appendText(team.getMembers().get(i));
                return;
            }
            playersNameField.appendText(team.getMembers().get(i) + "\n");
        }
    }

    /**
     * Responds when a user adds a team manually with the input fields
     * It parses team field inputs and converts them into a single Team object that is then enrolled for a tournament
     * It checks if the newly registered team already exists and if it does it then asks the user if they want to
     * overwrite the already existing team with the new one.
     * It identifies a team as already registered if one of these three criteria are met:
     *              1: if team name already exists
     *              2: if team name abbreviation already exists
     *              3: if all members are already registered in a different team
     * @throws IOException if any of the fields have values that are invalid.
     */
    public void addTeam() throws IOException {
        //setting it back to add team from yes
        continueButton1.setText("Add team");
        //Disabling no
        noButton.setVisible(false);
        noButton.setDisable(true);

        //check if max amount of teams has been exceeded
        if(teamsForTournament.size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
                    + "max teams: "+maxTeams);
            throw new IOException("You have reached the maximum number of teams for this tournament. \n"
                    + "max teams: "+maxTeams);
        }

        if (teamNameField.getText().strip().equals("")){
            warningLabel.setText("Team name required.");
            throw new IOException("Team name required.");
        }
        if (abbreviationField.getText().strip().equals("")){
            warningLabel.setText("Team name abbreviation required.");
            throw new IOException("Team name abbreviation required.");
        }
        if (abbreviationField.getText().strip().length() > 7){
            warningLabel.setText("Team name abbreviation cannot be longer than 7 characters");
            throw new IOException("Team name abbreviation cannot be longer than 7 characters");
        }
        if (playersNameField.getText().isBlank()){
            warningLabel.setText("Team players required.");
            throw new IOException("Team players required.");
        }

        if(isTeamAlreadyEnrolled(teamNameField.getText())){
            warningLabel.setText(teamNameField.getText() + " is already enrolled for the tournament");
            throw new IOException(teamNameField.getText() + " is already enrolled for the tournament");
        }



        //name of each member on new lines
        String[] players = playersNameField.getText().split("\n");
        List<String> returnList = Arrays.asList(players);
        ArrayList<String> teamMembersList = new ArrayList<>(returnList);

        //Creating team labels
        Team addedTeam = new Team(teamMembersList, teamNameField.getText(),abbreviationField.getText());
        if (!TeamReader.isThisANewTeam(addedTeam)){
            if (TeamReader.wasThereChangesMadeToTeam(addedTeam)){

                if (TeamReader.isThereAlreadyATeamWithSameTeamName(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Found a team with the same name, overwrite team?");
                        ifOverWriteMessage();
                        throw new IOException("Found a team with the same name, overwrite team?");
                    } else {
                        overWrite = false;
                    }
                }
                else if (TeamReader.isThereAlreadyATeamWithSameTeamNameAbbreviation(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Already team with same name abbreviation, overwrite team?");
                        ifOverWriteMessage();
                        throw new IOException("Already team with same name abbreviation, overwrite team?");
                    } else {
                        overWrite = false;
                    }
                }
                else if (TeamReader.isThereAlreadyATeamWithSameTeamMembers(addedTeam)){
                    if (!overWrite){
                        warningLabel.setText("Already team with same members, overwrite team?");
                        ifOverWriteMessage();
                        throw new IOException("Already team with same members, overwrite team?");
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
        TeamWriter.writeTeamsToFileAndOverwriteIfChanges(addedTeam);
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

    /**
     * Handles the front-end visibility of buttons when a team is already in the register and the user should be asked
     * if they want to overwrite the team
     * It makes it possible for the yes and no buttons to pop up and overwrite message to come up
     */
    private void ifOverWriteMessage(){
        noButton.setVisible(true);
        noButton.setDisable(false);
        teamNameField.setDisable(true);
        abbreviationField.setDisable(true);
        playersNameField.setDisable(true);
        overWrite = true;
        continueButton1.setText("Yes");
    }

    /**
     * Handles front-end visibility of what should be shown if the user chooses not to overwrite team
     * The no button is set to disappear and the normal add team button should return
     * All the input fields will be returned to enabled state
     */
    @FXML
    void onNoButtonClicked(){
        noButton.setDisable(true);
        noButton.setVisible(false);
        overWrite = false;
        teamNameField.setDisable(false);
        abbreviationField.setDisable(false);
        playersNameField.setDisable(false);
        continueButton1.setText("Add team");
    }


    /**
     * Deletes team from enrolled teams of the tournament
     * @param teamLabel  team label displayed in the UI, a visible text with a team name in the enrolled team box
     */
    public void deleteTeamFromTeams(Label teamLabel){
        for(int i = 0; i < enrolledTeamsBox.getChildren().size(); i++){
           if(enrolledTeamsBox.getChildren().get(i).equals(teamLabel)){

               Label label = (Label) enrolledTeamsBox.getChildren().get(i);
               enrolledTeamsBox.getChildren().remove(i);
               warningLabel.setText(label.getText() + " has been removed from enrolled teams.");
               teamsForTournament.remove(i);
               nrOfTeams.setText(String.valueOf(enrolledTeamsBox.getChildren().size()));
               break;
           }
        }
    }

    /**
     * Responsible for displaying enrolled teams inside the enrolled teams box in the UI.
     * Styles each member element (teams) using javafx styles
     */
    public void setCurrentTeams(){
        for (int i = 0; i < enrolledTeamsBox.getChildren().size(); i++) {
            Label teamLabel;
            teamLabel = (Label) enrolledTeamsBox.getChildren().get(i);
            enrolledTeamsBox.getChildren().get(i).setStyle("-fx-text-fill : white; -fx-font-size: 15pt");
            Label finalTeamLabel = teamLabel;
            enrolledTeamsBox.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> deleteTeamFromTeams(finalTeamLabel));
        }
        //styling of vbox for current teams
        enrolledTeamsBox.setAlignment(Pos.TOP_CENTER);
        enrolledTeamsBox.setPrefWidth(339);
    }

    /**
     * Responsible for parsing searched team from the search field and setting the teams proper values to the input
     * fields for the user
     */
    public void onSearchTeamSelect() {
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
     * @param teamName name of team
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

    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHomeButtonPressed()
    throws IOException {
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onAboutButtonPressed()
    throws IOException {
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHelpButtonPressed()
    throws IOException {
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.HELP);
    }

    /**
     * Redirects to ongoing tournaments page when clicked on ongoing tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }
    /**
     * Redirects to previous tournaments page when clicked on previous tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException {
        TournamentWriter.writeTeamsToTournamentFile(tournament.getTournamentName(),teamsForTournament);
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    /**
     * Used for setting the name of a tournament
     * @param nameOfTournament name of the tournament
     */
    public static void setNameOfTournament(String nameOfTournament) {
        AddTeamController.nameOfTournament = nameOfTournament;
    }
}
