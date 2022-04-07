package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TeamWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    public void setMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/start-screen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/overview-scene-eight.fxml")));

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addTeamExisting(String teamName){
        if(BracketController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
                    + "max teams: "+maxTeams);
        }else {
            for (Team team : existingTeams) {
                if (team.getNameOfTeam().equals(teamName)) {
                    BracketController.getBracket().addTeam(team);
                    Label newTeam = new Label(teamName);
                    pC.getChildren().add(newTeam);
                }
            }
            existingTeamsAdd.setText(teamName + " has been added to your tournament");
            setCurrentTeams();
        }
    }


    @FXML
    public void initialize () throws IOException {
        scrollPane.setContent(null);
        TeamReader readExistingTeams = new TeamReader();
        existingTeams = new ArrayList<>(readExistingTeams.readFile(
                new File("src/main/resources/edu/ntnu/idatt1002" +
                        "/sysdev_k1_05_ets/teamFiles/all_Teams.csv")));
        for (int i = 0; i < existingTeams.size(); i++){
            Label teamLabel = new Label();
            teamLabel.setText(existingTeams.get(i).getNameOfTeam());
            scrollPaneTeam.getChildren().add(teamLabel);
            scrollPaneTeam.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> addTeamExisting(teamLabel.getText()));
            scrollPaneTeam.getChildren().get(i).setLayoutY(20 * i);

        }
        scrollPaneTeam.setAlignment(Pos.CENTER);
        scrollPaneTeam.setPrefWidth(310);
        scrollPane.setContent(scrollPaneTeam);
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

        else {
            warningLabel.setText("");
            if (playersNameField.getText().isBlank()){
                BracketController.getBracket().addTeam(new Team(teamNameField.getText()));
                teamNameField.setText("");
                Label newTeam = new Label(teamNameField.getText());
                pC.getChildren().add(newTeam);
            }
            else {
                //name of each members on new lines
                String[] players = playersNameField.getText().split("\n");
                List<String> returnList = Arrays.asList(players);
                ArrayList<String> teamMembersList = new ArrayList<>(returnList);

                //Creating team labels
                Team addedTeam = new Team(teamMembersList, teamNameField.getText());
                Label newTeam = new Label(teamNameField.getText());
                pC.getChildren().add(newTeam);

                //add team to tournament bracket
                BracketController.getBracket().addTeam(addedTeam);
                ArrayList<Team> writeTeamList = new ArrayList<>();
                writeTeamList.add(addedTeam);
                //write teams to team file
                TeamWriter.writeFile(writeTeamList,"all_Teams");
                setCurrentTeams();
                playersNameField.setText("");
                teamNameField.setText("");

            }
        }
    }

    public void setCurrentTeams(){
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0f);
        ds.setColor(Color.color(0.1f, 0.1f, 0.1f));
        for (int i = 0; i < pC.getChildren().size(); i++) {
            pC.getChildren().get(i).setLayoutY(20 * i);
            pC.getChildren().get(i).setEffect(ds);
            pC.getChildren().get(i).setCache(true);

            //scaling
            pC.getChildren().get(i).setScaleY(1);
            pC.getChildren().get(i).setScaleX(1);
        }
        currentTeams.setContent(pC);
    }

    public static void setMaxTeams(int maxNrOfTeams) {
        maxTeams = maxNrOfTeams;
    }

}
