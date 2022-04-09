package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.TeamWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.File;
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


    private static int maxTeams;

    @FXML
    TextField teamNameField;

    @FXML
    TextArea playersNameField;

    @FXML
    Label warningLabel;

    @FXML
    Label existingTeamsAdd;

    @FXML
    ScrollPane scrollPane;

    @FXML
    ScrollPane currentTeams;

    @FXML
    VBox existingTeamsBox;

    @FXML
    VBox enrolledTeamsBox;

    @FXML
    TextField abbreviationField;

    @FXML
    TextField searchTeams;



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
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("brackets/eight_team_bracket.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addTeamExisting(String teamName){
        if(EightTeamController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
                    + "max teams: "+maxTeams);
        }else {
            for (Team team : existingTeams) {
                if (team.getNameOfTeam().equals(teamName)) {
                    EightTeamController.getBracket().addTeam(team);
                    Label newTeam = new Label(teamName);
                    enrolledTeamsBox.getChildren().add(newTeam);
                }
            }
            existingTeamsAdd.setText(teamName + " has been added to your tournament");
            setCurrentTeams();
        }
    }


    @FXML
    public void initialize () throws IOException {
        //setting search box for teams selection
        edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.TeamReader readExistingTeams = new TeamReader();
        ArrayList<Team> searchTeamNames = new ArrayList<>();
        searchTeamNames = readExistingTeams.readFile
                (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/teamFiles/all_Teams.csv"));
        TextFields.bindAutoCompletion(searchTeams,
                searchTeamNames.stream().map(Team::getNameOfTeam).collect(Collectors.toList()));

        //loop through the existing teams and set their style and add them to vbox in scrollpane
        existingTeams = new ArrayList<>(readExistingTeams.readFile(
                new File("src/main/resources/edu/ntnu/idatt1002" +
                        "/sysdev_k1_05_ets/teamFiles/all_Teams.csv")));
        for (int i = 0; i < existingTeams.size(); i++){
            Label teamLabel = new Label();
            teamLabel.setText(existingTeams.get(i).getNameOfTeam());
            existingTeamsBox.getChildren().add(teamLabel);
            existingTeamsBox.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> addTeamExisting(teamLabel.getText()));
            existingTeamsBox.getChildren().get(i).setStyle("-fx-text-fill : white; -fx-font-size: 15pt");
        }

        existingTeamsBox.setAlignment(Pos.CENTER);
        existingTeamsBox.setPrefWidth(310);
        scrollPane.setContent(existingTeamsBox);
    }



    public void addTeam(ActionEvent actionEvent) throws IOException {
        if (teamNameField.getText().strip().equals("")){
            warningLabel.setText("Invalid team name.");
        }
        //check if max amount of teams has been exceeded
        if(EightTeamController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
            + "max teams: "+maxTeams);
        }

        else {
            warningLabel.setText("");
            if (playersNameField.getText().isBlank()){
                EightTeamController.getBracket().addTeam(new Team(teamNameField.getText()));
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

                Label newTeam = new Label(teamNameField.getText());
                enrolledTeamsBox.getChildren().add(newTeam);

                //add team to tournament bracket
                EightTeamController.getBracket().addTeam(addedTeam);
                ArrayList<Team> writeTeamList = new ArrayList<>();
                writeTeamList.add(addedTeam);
                //write teams to team file
                TeamWriter.writeFile(writeTeamList,"all_Teams");
                setCurrentTeams();
                //reset fields after adding
                playersNameField.setText("");
                teamNameField.setText("");
                abbreviationField.setText("");
            }
        }
    }

    public void setCurrentTeams(){
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        for (int i = 0; i < enrolledTeamsBox.getChildren().size(); i++) {
            enrolledTeamsBox.getChildren().get(i).setStyle("-fx-text-fill : white; -fx-font-size: 15pt");

            //enrolledTeamsBox.getChildren().add(separator);
        }
        //styling of vbox for current teams
        enrolledTeamsBox.setAlignment(Pos.TOP_CENTER);
        enrolledTeamsBox.setPrefWidth(339);
    }

    public static void setMaxTeams(int maxNrOfTeams) {
        maxTeams = maxNrOfTeams;
    }
    

}
